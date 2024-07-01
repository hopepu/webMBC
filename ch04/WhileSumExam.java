package ch04;

public class WhileSumExam {

	public static void main(String[] args) {
		// 1~100까지의 합을 구하시오
		int i = 1;		// 합을 구하는 상자
		int sum = 0;    // 반복용 상자
		while(i<=100) {//1~100까지 반복
			sum = sum + i; //i 값이 1~100까지 나오니까 sum누적 합
			i++; // i = i + 1 -> 1~100까지 증가
		} // while 문 종료
		System.out.println("프로그램 종료");
		System.out.println("1~100까지의 합 : " + sum);

	}

}
