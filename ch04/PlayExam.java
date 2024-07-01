package ch04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PlayExam {

	public static void main(String[] args) {
		// 하루 일정 스케쥴러 비서 
		Scanner input = new Scanner(System.in);
		// 입력기반 생성
		String time6 = "기상";
		String time7 = "세면 및 도시락 챙기기";
		String time8 = "운동";
		String time9 = "교육 1교시";
		String time10 = "교육 2교시";
		String time11 = "교육 3교시";
		String time12 = "교육 4교시";
		String time13 = "점심시간";
		String time14 = "교육 5교시";
		String time15 = "교육 6교시";
		String time16 = "교육 7교시";
		String time17 = "교육 8교시";
		String time18 = "수업 종료";
		String time19 = "저녁식사";
		String time20 = "일정이 없습니다.";
		String time21 = "일정이 없습니다.";
		String time22 = "취침";	

		int Choice = 0;
		while(Choice < 3){

			System.out.println("메뉴를 골라주세요.(1~3)");
			System.out.println("1. 전체일정 확인하기");
			System.out.println("2. 남은일정 확인하기");
			System.out.println("3. 종료하기");
			Choice = input.nextInt();
			switch(Choice){
			case 1 :
				System.out.println("하루 일과는 6시부터 22시까지 구성되어있습니다.");
				System.out.println("6시 : " + time6);
				System.out.println("7시 : " + time7);
				System.out.println("8시 : " + time8);
				System.out.println("9시 : " + time9);
				System.out.println("10시 : " + time10);
				System.out.println("11시 : " + time11);
				System.out.println("12시 : " + time12);
				System.out.println("13시 : " + time13);
				System.out.println("14시 : " + time14);
				System.out.println("15시 : " + time15);
				System.out.println("16시 : " + time16);
				System.out.println("17시 : " + time17);
				System.out.println("18시 : " + time18);
				System.out.println("19시 : " + time19);
				System.out.println("20시 : " + time20);
				System.out.println("21시 : " + time21);
				System.out.println("22시 : " + time22);
				break;

			case 2: 
				SimpleDateFormat sdf1 = new SimpleDateFormat("HH");
				Date now = new Date();
				String nowTime1 = sdf1.format(now);
				System.out.println("현재 " + nowTime1 + "시 입니다.");
				System.out.println("이후 남은 일정은 아래와 같습니다.");

				String timeChoice = nowTime1;
				int nowTime = Integer.parseInt(timeChoice);
				switch(nowTime + 1) {
				case 6 : 
					System.out.println("6시" + time6);
				case 7 : 
					System.out.println("7시" + time7);
				case 8 : 
					System.out.println("8시" + time8);
				case 9 : 
					System.out.println("9시" + time9);
				case 10 : 
					System.out.println("10시" + time10);
				case 11 : 
					System.out.println("11시" + time11);
				case 12 : 
					System.out.println("12시" + time12);
				case 13 :
					System.out.println("13시" + time13);
				case 14 : 
					System.out.println("14시" + time14);
				case 15 : 
					System.out.println("15시" + time15);
				case 16 : 
					System.out.println("16시" + time16);
				case 17 : 
					System.out.println("17시" + time17);
				case 18 : 
					System.out.println("18시" + time18);
				case 19 : 
					System.out.println("19시" + time19);
				case 20 : 
					System.out.println("20시" + time20);
				case 21 : 
					System.out.println("21시" + time21);

					break;
				} // 남은일정 스위치문 종료


			} // switch문 종료

		}//while 종료
		System.out.println("오늘 하루도 힘내시기 바랍니다.");
	} // 메인 종료

} // 클래스 종료