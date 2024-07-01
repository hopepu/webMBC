package ch06.CarRun;

import java.util.Scanner;

import ch06.Store.AdminMenu;

public class CarRunExam {

	public static Scanner input = new Scanner(System.in);
	public static Member[] members = new Member[100];
	public static CarSetting[] cSet = new CarSetting[100];
	public static Multimedea[] mMedea = new Multimedea[100];
	public static Oil[]	oil = new Oil[100];
	public static Road[] road = new Road[100];

	public static void main(String[] args) {
		Member member = new Member(); 

		System.out.println("자동차 체험 시스템에 오신것을 환영합니다.");
		boolean run = true;
		System.out.println("로그인해주시길 바랍니다.");
		while (run) {
			System.out.println("1. 로그인하기");
			System.out.println("2. 회원가입하기");
			System.out.println("3. 종료하기");
			System.out.print(">>>");
			int select = input.nextInt();
			switch (select) {
			case 1:
				System.out.println("로그인을 진행합니다.");
				member=member.logins(members, input);
				if(member.loginS==true) {
					System.out.println("운행 시스템에 진입합니다.");
					run = false;
					if(member.admin==false) {
						GuestMenu.menu(input, oil, mMedea, cSet, road);
					} else {
						AdminMenus.menu(input, oil, mMedea, cSet, road);
					}//if close - 로그인 성공 후 관리자 메뉴와 손님 메뉴 분기점
					
				}				
				break;
			case 2:
				System.out.println("회원가입을 진행합니다.");
				member = member.newMember(members, input);
				System.out.println(member.toString());
				member.register(member, members);
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("1~3을 골라주세요");
				
		
				
			}// switch close

		} // while close

	} // main close

} // class close
