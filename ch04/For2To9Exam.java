package ch04;

public class For2To9Exam {

	public static void main(String[] args) {
		//2단에서 9단까지 구구단을 찍어보자.
		//for문 안쪽에 for를 또 작성하면 바깥쪽에 for가 돌면서 안쪽 for문이 돈다.
		// 블럭 for{for}를 조심할것
		System.out.println("======구구단 시작======");
		for(int x = 2; x<=9 ; x++) {
			System.out.println("=========" + x + "단=========");
				for(int y = 1; y<=9; y++) {
					System.out.println("     " + x + " X " + y + " = " + (x*y));
				}//for 종료
			
		}//for 종료

	}//main 종료

}//class 종료
