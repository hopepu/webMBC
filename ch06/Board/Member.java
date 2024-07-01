package ch06.Board;

import java.util.Scanner;

public class Member {// 회원에 대한 CRUD
	// 필드 -> 멤버변수
	String id;
	String pw;
	String nickName;
	String email;

	// 생성자 -> new로 객체 생성시 사용(생략시 기본생성자가 자동으로 생성)
	// Member[] member = new Member[]();

	// 메서드 -> CRUD
	public Member register(Scanner input) {
		// 새로운 Member 객체를 생성하여 키보드로 넣은 필드값을 삽입하고
		// 객체로 리턴한다.

		Member newMember = new Member();
		System.out.println("아이디를 입력하세요");
		newMember.id = input.next();
		System.out.println("암호를 입력하세요");
		newMember.pw = input.next();
		System.out.println("닉네임을 입력하세요");
		newMember.nickName = input.next();
		System.out.println("이메일을 입력하세요");
		newMember.email = input.next();

		return newMember;

	} // 가입 메서드 종료

	public Member login(Scanner input, Member[] members) {
		// 매개값 키보드 입력, 회원 배열

		Member loginMember = new Member(); // 키보드로 입력한 객체 생성

		System.out.println("아이디를 입력하세요");
		System.out.print(">>>");
		loginMember.id = input.next(); // 키보드로 입력받은 id를 새로만든 객체에 넣음

		System.out.println("암호를 입력하세요");
		System.out.print(">>>");
		loginMember.pw = input.next(); // 키보드로 입력받은 pw를 새로만든 객체에 넣음

		// 배열에 있는 객체와 새로만든 객체 비교 시작

		for (int i = 0; i < members.length; i++) {
			if (members[i] != null) { // 배열에 빈칸이 아니면!
				if (members[i].id.equals(loginMember.id) && members[i].pw.equals(loginMember.pw)) {
					// 배열에 있는 id가 키보드로 입력한 id와 같고,
					// 배열에 있는 pw가 키보드로 입력한 pw와 같다.
					// loginMember는 2개의 값
					// members[i]는 4개의 값을 가지고 있다.
					loginMember = members[i]; // 교체
					break;
				} // if문 종료(id, pw 비교 -> 객체 치환)
			} else {
				System.out.println("회원 정보가 없습니다.");
				System.out.println("id/pw를 확인해주세요.");
				break;

			} // if문 종료
		} // for 종료
		return loginMember;
	} // 로그인 메서드 종료

	public void modify(Scanner input, Member[] members, LoginStatus lSt) {
		boolean run = true;
		while (run) {
			System.out.println("현재 회원님의 정보는 아래와 같습니다. 무엇을 변경하시겠습니까?");
			System.out.println("1. 아이디 : " + lSt.id);
			System.out.println("2. 패스워드 : " + lSt.pw);
			System.out.println("3. 닉네임 : " + lSt.nickName);
			System.out.println("4. 이메일 : " + lSt.email);
			System.out.println("5.  종료하기");
			System.out.print(">>>");
			int select = input.nextInt();
			switch (select) {
			case 1:
				for (int i = 0; i < members.length; i++) {
					if (members[i].id.equals(lSt.id)) {
						System.out.println("바꿀 아이디 : ");
						String modId = input.next();
						members[i].id = modId;
						lSt.id = modId;
						break;
					} // if close
				} // for close
				break;

			case 2:
				for (int i = 0; i < members.length; i++) {
					if (members[i].pw.equals(lSt.pw)) {
						System.out.println("바꿀 패스워드 : ");
						String modId = input.next();
						members[i].pw = modId;
						lSt.pw = modId;
						break;
					} // if close
				} // for close
				break;

			case 3:
				for (int i = 0; i < members.length; i++) {
					if (members[i].nickName.equals(lSt.nickName)) {
						System.out.println("바꿀 닉네임 : ");
						String modId = input.next();
						members[i].nickName = modId;
						lSt.nickName = modId;
						break;
					} // if close
				} // for close
				break;

			case 4:
				for (int i = 0; i < members.length; i++) {
					if (members[i].email.equals(lSt.email)) {
						System.out.println("바꿀 이메일 : ");
						String modId = input.next();
						members[i].email = modId;
						lSt.email = modId;
						break;
					} // if close
				} // for close
				break;
			case 5:
				System.out.println("회원관리 메뉴로 돌아갑니다.");
				run = false;
				break;

			default:
				System.out.println("1~5사이의 번호를 입력하시기 바랍니다.");

				break;

			} // switch 종료
		} // whle 종료

	} // 회원정보 수정 메서드를 종료

	public void delete(Scanner input, Member[] members, LoginStatus lSt) {
		System.out.println("탈퇴를 위해 본인인증을 시작합니다.");
		System.out.println("계정의 비밀번호를 입력해주시기 바랍니다.");
		String deletePw = input.next();
		if (lSt.pw.equals(deletePw)) {
			System.out.println("본인 인증이 완료되었습니다. 정말로 삭제하시겠습니까?");
			System.out.println("1.Y | 2.N");
			int deleteSwitch = input.nextInt();
			switch (deleteSwitch) {
			case 1:
				for (int i = 0; i < members.length; i++) {
					if (members[i].id.equals(lSt.id)) {
						members[i] = null;
						lSt.lstatus = false;
						System.out.println("귀하의 계정 정보가 삭제되었습니다.");
						System.out.println("그동안 이용해주셔서 감사합니다.");
						break; // for문이 끝나야 됨
					}
				}

			case 2:
				System.out.println("회원관리 메뉴로 돌아갑니다.");
				break;

			default:
				System.out.println("1~2에서 선택해주시기 바랍니다.");

			}

		} else {
			System.out.println("비밀번호가 일치하지 않습니다. 삭제메서드를 종료합니다.");
		} // if close

	} // 회원탈퇴 메서드를 종료

	public void menu(Scanner input, Member[] members, LoginStatus lSt) {
//		        매개값	스캐너			맴버배열

		boolean run = true;
		System.out.println("---- 회원 전용 메뉴 입니다. ----");
		while (run) {
			System.out.println("1. 가입 | 2. 로그인 | 3. 수정 | 4. 탈퇴 | 5. 종료");
			System.out.print(">>>");
			int select = input.nextInt();
			switch (select) {
			case 1:
				System.out.println("회원가입을 진행합니다.");
				// 키보드로 입력받을 필드 완성후 객체로 받음
				Member newMember = register(input);
				// 맴버배열 null 찾아 삽입
				for (int i = 0; i < members.length; i++) {
					if (members[i] == null) {
						members[i] = newMember;
						System.out.println(newMember.nickName + "객체가 배열에 저장됨");
						break; // for문이 끝나야 됨
					} // if문 종료
				} // for문 종료(null을 찾아 객체를 삽입)

				break;

			case 2:
				if (lSt.lstatus == false) {
					System.out.println("로그인을 진행합니다.");
					Member loginMember = login(input, members);// 호출시 스캐너와 배열 객체 전달
					if (loginMember.nickName != null) {
						System.out.println(loginMember.nickName + "님 환영합니다.");
						lSt.id = loginMember.id;
						lSt.pw = loginMember.pw;
						lSt.nickName = loginMember.nickName;
						lSt.email = loginMember.email;
						lSt.lstatus = true;
					} // if 종료
				} else {
					System.out.println("이미 로그인이 되어있습니다.");
				}
				break;

			case 3:
				if (lSt.lstatus == true) {
					System.out.println("수정을 진행합니다.");
					modify(input, members, lSt);
				} else {
					System.out.println("로그인이 필요합니다.");
				}

				break;

			case 4:
				if (lSt.lstatus == true) {
					System.out.println("탈퇴를 진행합니다.");
					delete(input, members, lSt);
				} else {
					System.out.println("로그인이 필요합니다.");
				}

				break;

			case 5:
				System.out.println("회원전용 메뉴를 종료 합니다.");
				run = false;
				break;

			default:
				System.out.println("1~4의 값을 입력해주세요");

			}// switch 종료

		} // while 종료

	}// 메뉴 메서드 종료

} // 멤버 클레스 종료
