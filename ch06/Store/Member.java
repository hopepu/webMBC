package ch06.Store;

import java.util.Scanner;

public class Member {
	// 필드
	String id;
	String pw;
	String name;
	int age;
	int phoneNum;
	String address;
	String sex;
	boolean admin = false;

	// 메서드

	public LoginStatus menu(Scanner input, Member[] members, LoginStatus lSt) {
		boolean run = true;
		while (run) {	
			System.out.println("===================");
			System.out.println("아래 항목에서 선택해주세요.");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 가입정보찾기");
			System.out.println("4. 종료하기");
			System.out.println(">>>");
			int login = input.nextInt();
			switch (login) {
			case 1:
				Member loginMember = new Member();// 임시 빈 배열 하나 생성
				System.out.print("ID : ");
				loginMember.id = input.next();// 입력된 아이디 빈 배열에 삽입
				System.out.print("PW : ");
				loginMember.pw = input.next();// 입력된 패스워드 빈 배열에 삽입
				loginMember = login(input, members, loginMember, run);// 로그인 메서드, 참조는 스캐너 멤버 배열과 임시 로그인 멤버 배열
				loginStatus(loginMember, lSt);//상시 유지 로그인 상태에 정보 입력
				if(lSt.name!=null) {//로그인 상태 확인
					run = false;//로그인 화면 종료후 가게로 진입시킴	
				}					
				break;

			case 2:
				System.out.println("회원가입을 실행합니다.");
				Member newMember = register(input);
				for (int i = 0; i < members.length; i++) {
					if (members[i] == null) {
						members[i] = newMember;
//						System.out.println("객체가 배열에 저장됨.");
						break;
					} // if close
				} // for close
				break;

			case 3:
				System.out.println("가입 정보를 찾습니다.");
				find(input, members);
				break;

			case 4:
				run=false;
				break;
				
			default:
				System.out.println("1~4를 입력해주세요.");
			} // switch close
		} // while close
		return lSt;
	}//menu close
	
	private void loginStatus(Member loginMember, LoginStatus lSt) {
		// TODO Auto-generated method stub
		lSt.address = loginMember.address;
		lSt.admin = loginMember.admin;
		lSt.age = loginMember.age;
		lSt.id = loginMember.id;
		lSt.name = loginMember.name;
		lSt.phoneNum = loginMember.phoneNum;
		lSt.pw = loginMember.pw;
		lSt.sex = loginMember.sex;
	}// menu close

	private void find(Scanner input, Member[] members) {
		// 회원 아이디와 비밀번호 찾기
		System.out.println("회원정보를 검색합니다. 아래 사항을 입력해주세요");
		System.out.print("이름 : ");
		String searchName = input.next();
		System.out.print("전화번호 : ");
		int searchNum = input.nextInt();
		System.out.print("성별 : ");
		String searchSex = input.next();
		for (int i = 0; i < members.length; i++) {
			if (members[i] != null) {
				if (members[i].name.equals(searchName) && members[i].phoneNum == searchNum
						&& members[i].sex.equals(searchSex)) {
					System.out.println("귀하의 아이디는 " + members[i].id);
					System.out.println("비밀번호는 관리자에게 문의하세요.");
					break;

				} // if close
			} // if close
		} // for close
	}//find close

	private Member register(Scanner input) {
		// 회원가입 회원 정보를 받아 배열에 저장
		Member newMember = new Member();
		System.out.println("");
		System.out.print("아이디 : ");
		newMember.id = input.next();
		System.out.println("");
		System.out.print("암호 : ");
		newMember.pw = input.next();
		System.out.println("");
		System.out.print("이름 :");
		newMember.name = input.next();
		System.out.println("");
		System.out.print("나이 : ");
		newMember.age = input.nextInt();
		System.out.println("");
		System.out.print("성별 :");
		newMember.sex = input.next();
		System.out.println("");
		System.out.print("전화번호(-는 생략해주세요) : ");
		newMember.phoneNum = input.nextInt();
		System.out.println("");
		System.out.println("관리자이신 경우 관리자 코드를 입력해주세요");
		System.out.println("모르시는 경우 아무 숫자나 눌러주세요");
		int adminCode = input.nextInt();
		if (adminCode == 1234) {
			newMember.admin = true;
			System.out.println("관리자 계정으로 생성되었습니다.");
		} else {
			System.out.println("회원가입에 성공하셨습니다.");
		}//if close

		return newMember;

	}//register close

	private static Member login(Scanner input, Member[] members, Member loginMember, boolean run) {
		// 로그인 처리 메서드
		for (int i = 0; i < members.length; i++) {// 배열 내부 전체 대조를 위한
			if (members[i] != null) {// 배열의 빈칸이 아니면
				if (members[i].id.equals(loginMember.id) && members[i].pw.equals(loginMember.pw)) {// 멤버 배열과 임시 로그인멤버
					loginMember = members[i];
					break;

				} // if close
			} else {
				System.out.println("회원 정보가 없습니다.");
				System.out.println("id/pw를 확인해주세요.");
				break;
			} // if close
		} // for close
		return loginMember;
	}//login close;
	
	public static void tester(Member[] members) {
		
		Member member1 = new Member();
		member1.id = "1";
		member1.pw = "1";
		member1.name = "tester";
		member1.age = 1;
		member1.phoneNum = 1;
		member1.address = "1";
		member1.sex = "1";
		member1.admin = false;
		members[0]=member1;
		
		Member member2 = new Member();
		member2.id = "2";
		member2.pw = "2";
		member2.name = "2";
		member2.age = 2;
		member2.phoneNum = 2;
		member2.address = "2";
		member2.sex = "2";
		member2.admin = true;
		members[1]=member2;
		
		}

}// class close
