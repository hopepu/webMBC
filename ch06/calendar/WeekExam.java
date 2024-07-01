package ch06.calendar;

import java.util.Calendar;

public class WeekExam {

	public static void main(String[] args) {
		// Calandar 객체를 이용해서 날짜를 처리함

		Calendar cal = Calendar.getInstance();
		// gitInstance()는 내장된 객체를 가져옴(new X)

		int year = cal.get(Calendar.YEAR);
		// Calendar.YEAR 매개값으로 년도를 신청함
		int month = cal.get(Calendar.MONTH) + 1;
		// Calendar.MONTH는 0부터 시작하기 때문에 +1 필수
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "년 " + month + "월 " + day + "일 ");
		
		Week today = null;
		int week = cal.get(Calendar.DAY_OF_WEEK);
		switch (week) {
		case 1:
			today = Week.SUNDAY;//일요일
			break;
		case 2:
			today = Week.MONDAY; // 월요일
			break;
		case 3:
			today = Week.TUESDAY; // 화요일
			break;
		case 4: 
			today = Week.WEDNESDAY; // 수요일
			break;
		case 5:
			today = Week.THURSDAY; // 목요일
			break;
		case 6:
			today = Week.FRIDAY; // 금요일
			break;
		case 7:
			today = Week.SATURDAY; // 토요일
			break;
		default:
			System.out.println("버그 생성 : 작성자에게 문의하세요.");
		}
		System.out.println("현재 요일 : " + today );

		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.println(hour + " : " + minute + " : " + second);

		// get()메서드는 객체의 값을 가져오는 동작
		// 내부 메서드 사용시 내부 데이터 변경이 있을수 있으므로 결과값 대조가 필요.
		// 컴퓨터 시간 영향을 받는다.

	}

}
