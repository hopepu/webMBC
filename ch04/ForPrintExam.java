package ch04;

public class ForPrintExam {

	public static void main(String[] args) {
//		for문은 횟수가 정해진 반복문이다.
//		for(초기값; 조건식; 증감식) {실행문1; 실행문2; }실행블록
		
		for(int i = 1 ;		//초기값
				i <= 10 ;	//조건식
				i++ 		//증감식
				) {
			// 실행문
//			System.out.println("1~10까지 출력 : " +i);
			
			if(i%2==0) {
				System.out.println("1~100까지 짝수결과만 출력 : " + i);
			}
		} //for 종료
			
		System.out.println("============================================");
		
		for(int i2 = 0;
				i2 <= 10;
				i2+=2) {
			System.out.println("1~10까지 짝수결과만 출력 : " +i2);
		
		} //for 종료

		System.out.println("============================================");
		for(int i3=0, j=100;
				i3<=10 && j >=90;
				i3++, j--) {
			System.out.println("i값의 증가 : " + i3 + "//j값의 감소 : " + j);
		} //for 종료
			
		
	} //main 종료

} //class 종료
