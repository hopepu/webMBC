package kr.co.mbc.bank.service;

import java.util.Scanner;

import kr.co.mbc.bank.dto.MemberDTO;

public class MemberSV {

	public static MemberDTO login(Scanner input, MemberDTO loginDTO, MemberDTO[] memberDTOs) {
		// 로그인 담당 메서드
		System.out.println("아이디를 입력해주세요");
		System.out.print(">>>");
		String id = input.next();
		loginDTO.setId(id);
		System.out.println("비밀번호를 입력해주세요");
		System.out.print(">>>");
		String pw = input.next();
		loginDTO.setPw(pw);
		//id와 pw 무결점 검사?
		
		for(int i = 0 ; i<memberDTOs.length; i++) {//아이디와 패스워드 일치 여부 확인
			if(memberDTOs[i]!=null&&memberDTOs[i].getId().equals(loginDTO.getId())&&memberDTOs[i].getPw().equals(loginDTO.getPw())) {
				loginDTO = memberDTOs[i];
				loginDTO.islStatus(true);
				System.out.println(loginDTO.getName()+"님 환영합니다.");
				break;
			}else {
				System.out.println("일치하는 아이디와 패스워드가 없습니다. 다시 확인해주시기 바랍니다.");
				break;
			}// if close
		} // for close		
		return loginDTO;
	} //login close

	public static void create(Scanner input, MemberDTO loginDTO, MemberDTO[] memberDTOs) {
		// 계정 생성 메서드
		MemberDTO memberDTO = new MemberDTO();
		System.out.println("계정을 생성합니다.");
		System.out.println("사용하실 id를 입력해주세요");
		System.out.print(">>>");
		String id = input.next();
		memberDTO.setId(id);		
		System.out.println("사용하실 pw를 입력해주세요");
		System.out.print(">>>");
		String pw = input.next();
		memberDTO.setPw(pw);
		System.out.println("본인의 이름을 입력해주세요");
		System.out.print(">>>");
		String name = input.next();
		memberDTO.setName(name);
		System.out.println("전화번호를 입력해주세요");
		System.out.print(">>>");
		int pNo = input.nextInt();
		memberDTO.setPhoneNo(pNo);
		
		System.out.println(memberDTO.toString());
		System.out.println("이 정보로 계정을 만드시겠습니까?");
		System.out.println("1. 네 | 2. 아니오");
		int select = input.next().charAt(0);
		switch(select) {
		case 49 :
			for(int i = 0; i < memberDTOs.length; i++) {
				if(memberDTOs[i]==null) {
					memberDTOs[i]=memberDTO;
					System.out.println(memberDTOs[i].getName()+"님 회원이 되신것을 환영합니다.");
					break;
				}//if close
			}//for close
		case 50 :
			break;
		default :
			System.out.println("1~2를 선택해주세요");
		}//siwtch close
			
	} //create close

	public static MemberDTO menu(Scanner input, MemberDTO loginDTO, MemberDTO[] memberDTOs) {
		// 
		
		boolean run = true;
		while (run) {
			
			System.out.println("1. 로그인하기 | 2. 계정생성하기 | 3. 종료하기 |");
			System.out.print(">>>");
			int select = input.next().charAt(0);
			switch (select) {
			case 49:
				System.out.println("로그인메서드에 입장합니다.");
				loginDTO = MemberSV.login(input, loginDTO, memberDTOs);
				if (loginDTO.getlStatus() == true) {
					run = false;
				}
				break;
			case 50:
				System.out.println("계정생성 메서드에 입장합니다.");
				MemberSV.create(input, loginDTO, memberDTOs);
				break;
			case 51:
				System.out.println("시스템을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("1~2를 입력해주세요");

			}// switch close
		} // while close 로그인 메뉴 종료
		return loginDTO;
		
	}//menu close

} // class close
