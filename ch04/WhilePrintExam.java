package ch04;

public class WhilePrintExam {

	public static void main(String[] args) {
//		while문은 ()안에 값이 true일때 무한 반복한다.
//		while(true) -> 반복 -> while(false) -> 종료
//		대부분 최대값이 없는 반복문일 때 활용 -> 메유용으로 활용(관리자에 의한 종료)
		
		int i = 1;
		while(i<=10) { //1부터 10까지는 true -> 11은 false(while문 종료)
			// 반복실행문
			System.out.println(i);
			i++;
		} // while문 종료
		System.out.println("프로그램 종료");
		
		
		

	}

}
