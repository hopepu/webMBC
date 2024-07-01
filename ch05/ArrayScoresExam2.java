package ch05;

import java.util.Scanner;

public class ArrayScoresExam2 {
	

	public static void main(String[] args) {
		int count = 0;//학생수
		int[] scores = new int[count];
		int select = 0; // 메뉴 선택
		Scanner input = new Scanner(System.in);
		
		
		// 성적표 프로그램 메뉴
		while(select != 4){
			System.out.println("============성적표============");
			System.out.println("1. 학생수 입력");
			System.out.println("2. 점수 입력 및 수정");	
			System.out.println("3. 총점수 및 평균");
			System.out.println("4. 프로그램 종료");
			System.out.print(">>>");
//		} // 메뉴 while문 종료
		   select = input.nextInt();
				
			switch(select) {
			case 1 -> scores = scoresTabling(scores, count);
			case 2 -> scores = scoresInserting(scores);
			case 3 -> scoresAddAve(scores);
			case 4 -> {break;}
			
			}//와일 스위치 종료
		}//와일 종료
	
		
	} // 메인 메서드 종료
	static void scoresAddAve(int[] scores) {
				
		System.out.println("=======점수 합계 및 평균=======");
		int sum = total(scores);
		System.out.println("총점수 : " + sum + "점");
		double ave = average(sum, scores);
		System.out.println("평균 : " + ave + "점");

	} //scoresInserting 메서드 종료
	
	static int total(int[] scores) {
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];// scores의 모든 값을 sum에 누적
		} //for 종료
		return sum;
	} // 총점 종료

	static double average(int sum, int[] scores ) {
		double ave = 0;
		ave = sum / scores.length;
		return ave;

	} // 평균 종료
	
	
	static int[] scoresTabling(int[] scores, int count) {
		System.out.print("학생 수 입력 >>>");
		Scanner input = new Scanner(System.in);
		count = input.nextInt();
		scores = new int[count]; // 키보드로 입력받은 값을 토대로 배열길이 생성
		System.out.println("배열의 길이 : " + scores.length);
		
		return scores;
		
	} // scoresTabling 메서드 종료
	
	static int[] scoresInserting(int[] scores) {
		Scanner input = new Scanner(System.in);
		int select=0;
		while(select != 4) {
		System.out.println("=======점수 입력 및 수정=======");
		System.out.println("1. 점수 입력");
		System.out.println("2. 점수 수정");
		System.out.println("3. 점수 확인");
		System.out.println("4. 메인 메뉴");
		System.out.print(">>>");
		select = input.nextInt();
			switch(select) {
			case 1 -> scores = scoresInserting2(scores);
			case 2 -> scores = scoresInserting3(scores);
			case 3 -> scoresSearch(scores);
			case 4 -> {break;}
			} // 스위치 종료
		}
		return scores;
		
	} //scoresInserting 메서드 종료
	static int[] scoresInserting2(int[] scores) {
		Scanner input = new Scanner(System.in);
		System.out.println("==========점수 입력==========");
		for (int i = 0; i < scores.length; i++) { // scores.length(배열길이) =은 안쓴다.
			System.out.println((i + 1) + "번째 학생의 점수를 입력하세요");
			scores[i] = input.nextInt();}
		
		return scores;
	} // scoresInserting2 점수 입력 메서드 종료
	static int[] scoresInserting3(int[] scores) {
		Scanner input = new Scanner(System.in);
		System.out.println("============점수 수정===========");
		System.out.println("");
		System.out.println("=========수정할 번호 확인=========");
		int select = input.nextInt();
		System.out.println("=========수정할 점수 확인=========");
		int score = input.nextInt();

		scores[select - 1] = score;
		System.out.println("수정한 결과 확인");
		System.out.println(select + "의 점수는 " + score + "로 변경되었습니다.");
		
		return scores;
	} //  scoresInserting3 점수 수정 메서드 종료
	static void scoresSearch(int[] scores) {
		System.out.println("=========입력된 점수 확인=========");
		for (int i = 0; i < scores.length; i++) {
			System.out.print(scores[i] + " ");
		System.out.println("");}
	
	} // 점수확인 메서드 종료s
	
	

} // 클래스 종료
