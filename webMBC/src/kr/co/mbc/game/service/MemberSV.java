package kr.co.mbc.game.service;

import java.util.Scanner;

import kr.co.mbc.game.dto.MemberDTO;

public class MemberSV {
	// 회원 관리용 클래스
	// 회원 관리에 해당하는 모든 서비스를 제공한다.
	// 필도
//	MemberDTO memberDTO; // new MemberDTO(); -> 안써도 됨

	// 생성자 -> new 객체 생성(생략시 기본 생성자 만들어짐);

	// 메서드
	public MemberDTO menu(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) { // 부메뉴
		System.out.println("-------회원관리 메뉴에 진입 하였습니다.------");
		
		boolean run = true;
		while (run) {
			System.out.println("1. 가입 | 2. 로그인 | 3. 수정 | 4. 삭제 | 5. 메인메뉴");
			System.out.print(">>>");
			int select = input.next().charAt(0);// menu 메서드 호출 시 Scanner 객체 필수

			switch (select) {
			case 49:
//				System.out.println("가입 메서드로 진입합니다.");
				create(input, memberDTOs);
				break;

			case 50:
//				System.out.println("로그인 메서드로 진입합니다.");
				loginState = login(input, memberDTOs, loginState);
				break;

			case 51:
//				System.out.println("수정 메서드로 진입합니다.");
				loginState = modify(input, memberDTOs, loginState);
				break;

			case 52:
//				System.out.println("삭제 메서드로 진입합니다.");
				loginState = delete(input, memberDTOs, loginState);
				break;

			case 53:
				System.out.println("메인메뉴로 돌아갑니다.");
				run = false;
				break;

			default:
				System.out.println("1~5를 입력해주시기 바랍니다.");

			} // select close

		} // while close
		return loginState; // 멤버서비스의 리턴은 로그인 상태 정보(MemberDTO)

	} // menu close

	public MemberDTO create(Scanner input, MemberDTO[] memberDTOs) { // 계정 생성
		System.out.println("회원가입을 진행합니다.");
		System.out.print("사용할 ID를 입력하세요 >>>");
		String id = input.next();
		System.out.print("사용할 PW를 입력하세요 >>>");
		String pw = input.next();
		System.out.print("사용할 닉네임를 입력하세요 >>>");
		String nickName = input.next();
		System.out.println("사용할 이메일을 입력하세요 >>>");
		String email = input.next(); // 입력받은 값을 객체에 삽입
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.id = id;
		memberDTO.pw = pw;
		memberDTO.nickName = nickName;
		memberDTO.email = email;
		memberDTO.loginStatus = false;

		for (int i = 0; i < memberDTOs.length; i++) {
			if (memberDTOs[i] == null) { // null이면 값이 없으므로, 값을 입력
				memberDTOs[i] = memberDTO;
				System.out.println(memberDTOs[i].nickName + "님 가입이 완료되었습니다.");
				break;
			} // if close
		} // for close
		return memberDTO;
	} // create close

	public MemberDTO login(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) { // 로그인
		if (loginState.loginStatus == true) {
			System.out.println("이미 로그인 되어있습니다.");
		} else {
			System.out.println("로그인을 진행합니다.");
			System.out.print("ID를 입력하세요 >>>");
			String id = input.next();
			System.out.print("PW를 입력하세요 >>>");
			String pw = input.next();
			loginState.id = id;
			loginState.pw = pw;

			for (int i = 0; i < memberDTOs.length; i++) {
				if (memberDTOs[i] != null) {
					if (memberDTOs[i].id.equals(loginState.id) && memberDTOs[i].pw.equals(loginState.pw)) {
						loginState = memberDTOs[i];
						loginState.loginStatus = true;
						System.out.println(loginState.nickName + "님 환영합니다.");
//						System.out.println(loginState.loginStatus + "상태");
						break;
						} else {
						System.out.println("입력하신 id와 pw를 확인해주시기 바랍니다.");
					} // if close
				} else {
					System.out.println("가입되어있는 회원이 없습니다.");
					break;
				}// if close			
			} // for close
		} // if close
		return loginState;
	} // login close

	public MemberDTO modify(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) { // 수정
		if (loginState.loginStatus == true) {
			System.out.println("회원정보를 수정합니다.");
			System.out.println("수정하실 회원정보를 선택해주세요.");
			System.out.println("1. 비밀번호 | 2. 닉네임 | 3. 이메일 | 4. 수정종료");
			System.out.println(">>>");
			int select = input.next().charAt(0);
			boolean run = true;
			switch (select) {
			case 49:
				System.out.println("비밀번호를 수정합니다.");
				System.out.print(">>>");
				loginState.pw = input.next();
				break;
			case 50:
				System.out.println("닉네임을 수정합니다.");
				System.out.print(">>>");
				loginState.nickName = input.next();
				break;
			case 51:
				System.out.println("이메일을 수정합니다.");
				System.out.print(">>>");
				loginState.email = input.next();
				break;
			case 52:
				System.out.println("로그인관리 메뉴로 갑니다.");
				System.out.print(">>>");
				run = false;
				break;
			default:
				System.out.println("1~4를 골라주세요.");

			} // switch close

			for (int i = 0; i < memberDTOs.length; i++) {
				if (memberDTOs[i] != null) {
					if (memberDTOs[i].id.equals(loginState.id)) {
						memberDTOs[i] = loginState;
						System.out.println(memberDTOs[i].nickName + "님 정보가 변경되었습니다.");
					} // if close
				} // if close
			} // for close
		} else {
			System.out.println("로그인이 필요한 메뉴입니다. 로그인을 해주세요");
		} // if close
		return loginState;
	} // modify close

	public MemberDTO delete(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) { // 삭제
		if (loginState.loginStatus == true) {
			System.out.println("회원탈퇴를 진행하겠습니다.");
			System.out.println("정말로 탈퇴하시겠습니까?");
			System.out.println("1. YES | 2. NO");
			int select = input.next().charAt(0);
			switch (select) {
			case 49:
				for (int i = 0; i < memberDTOs.length; i++) {
					if (memberDTOs[i] != null) {
						if (memberDTOs[i].id.equals(loginState.id)) {
							memberDTOs[i] = null;
							loginState = null;
							loginState = new MemberDTO();
							System.out.println("삭제가 완료되었습니다.");
						} // if close
					} // if close
				} // for close

				break;
			case 50:
				System.out.println("메뉴로 돌아갑니다.");
				break;
			default:
				System.out.println("1~2f를 선택해주세요.");

			}// switch close

		} else {
			System.out.println("로그인이 필요합니다.");			
		}// if close
		return loginState;
	} // delete close

} // MemberSV class close
