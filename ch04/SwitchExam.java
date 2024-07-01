package ch04;

public class SwitchExam {

	public static void main(String[] args) {
		//		switch는 동등비교문으로 같은 값을 찾아 처리를 한다.
		//		동등비교값이 많은 경우에 활용.

		int num = (int)(Math.random()*6)+1;
		//1에서 6까지 임의 값을 정수로 강제타입 변환하여 num에 넣는다.

		switch(num) {
		case 1 :
			System.out.println("1번 주사위가 나왔습니다.");
			break; // 동등값이 나왔을 때 switch문을 나온다.

		case 2 :
			System.out.println("2번 주사위가 나왔습니다.");
			break;

		case 3 :
			System.out.println("3번 주사위가 나왔습니다.");
			break;
			
		case 4 :
			 System.out.println("4번 주사위가 나왔습니다.");
			 break;
			 
		case 5 :
			 System.out.println("5번 주사위가 나왔습니다.");
			 break;
			 
		case 6 :
			 System.out.println("6번 주사위가 나왔습니다.");
			 break;
			 
		default : //위에 해당값이 없을 때
			System.out.println("프로그램 오류로 주사위가 고장남. 수리요망");
			System.out.println("개발자 이메일 : whdydwo2@gmail.com");
			System.out.println("버그 제공시 기프티콘을 쏴드립니다.");
			break;

		}// 스위치문 종료		
		System.out.println("검증 코드 : " + num);
	}//메인 메서드 종료

}//class문 종료
