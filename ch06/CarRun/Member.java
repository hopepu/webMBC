package ch06.CarRun;

import java.util.Scanner;

public class Member {
	String id;
	String pw;
	boolean loginS;
	boolean admin;
	

	public Member logins(Member[] members, Scanner input) {
		Member memberL = new Member();
		System.out.print("ID : ");
		memberL.id = input.next();
		System.out.println("");
		System.out.print("PW : ");
		memberL.pw = input.next();
		System.out.println("");
		memberL=find(members, input, memberL);
		return memberL;
	}//logins close


	private Member find(Member[] members, Scanner input, Member memberL) {
		for(int i=0; i<members.length; i++) {
			if(members[i]!=null) {
				if(memberL.id.equals(members[i].id)&&memberL.pw.equals(members[i].pw)) {
					memberL = members[i];
					memberL.loginS = true;
					break;
				} else {
					System.out.println("아이디와 패스워드를 다시 확인해주식 바랍니다.");
				}//if close
			}//if close
		}//for close
		return memberL;
	}//find close


	public Member newMember(Member[] members, Scanner input) {
		// TODO Auto-generated method stub
		Member newMember = new Member();
		System.out.println("아이디를 입력하세요");
		System.out.print(">>>");
		newMember.id = input.next();
		System.out.println("패스워드를 입력하세요");
		System.out.print(">>>");
		newMember.pw = input.next();
		System.out.println("관리자 코드를 입력하세요, 모르시면 아무키나 누르세요");
		System.out.print(">>>");
		if(input.nextInt()==1234) {
			System.out.println("관리자 계정으로 생성되었습니다.");
			newMember.admin = true;
		}else {
			System.out.println("일반계정으로 생성되었습니다.");
		}
//		System.out.println(newMember.toString());
		return newMember;
	}//newMember close


	public void register(Member newMember, Member[] members) {
		// 객체정보 등록하기
		for(int i = 0; i < members.length; i++) {
			if(members[i]==null) {
			members[i] = newMember;
//			System.out.println(members[i].toString());
//			System.out.println("객체 등록에 성곡했습니다.");
			break;
			}//if close
		}//for close
		
	}//register method close


	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", loginS=" + loginS + ", admin=" + admin + "]";
	}
}
