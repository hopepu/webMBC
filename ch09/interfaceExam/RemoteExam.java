package ch09.interfaceExam;

import java.util.Scanner;

public class RemoteExam {
	
	public static Scanner scanner = new Scanner(System.in);
	public static RemoteControl rc = null; // 인터페이스를 변수에 연결
	
	public static void main(String[] args) {
		
		RemoteControl.changeBattery();
		// 인터페이스를 사용한 구현클래스를 이용해본다.

		System.out.println("리모컨 인터페이스를 사용합니다.");
		

		
		boolean run = true;
		while (run) {
			System.out.println("------------------------");
			System.out.println("1.TV | 2.Audio | 3.스마트tv | 4.종료");
			System.out.println("------------------------");
			System.out.print(">>>");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				System.out.println("TV에 연결되었습니다.");
				rc = new Television(); // RemoteControl rc = new Television();
//				rc.turnOff();
//				rc.turnOn();
				turn();
				rc.setMute(true);
				rc.setMute(false);
				break;
			case 2:
				System.out.println("오디오에 연결되었습니다.");
				rc = new Audio(); // RemoteControl rc = new Audio();
//				rc.turnOff();
//				rc.turnOn();
				turn();
				break;
			case 3 :
				System.out.println("스마트 tv에 연결되었습니다.");
				rc = new SmartTelevision();
				rc.turnOn();
				Searchable se = new SmartTelevision();
				System.out.println("인터넷 검색을 시작합니다.");
				System.out.print(">>>");
				se.search(scanner.next());
				rc.turnOff();
				break;
			case 4 :
				System.out.println("리모컨을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("1~2 안에서 골라주세요");		

			} // switch close
//			rc.turnOff();
//			rc.turnOn();
		} // while close
	} // main close
	static void turn() {
		rc.turnOff();
		rc.turnOn();
	}
	static void mute() {
		rc.setMute(true);
		rc.setMute(false);
	}
	
	} // class close
