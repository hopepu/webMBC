package ch05;

public class ArrayCreateExam {

	public static void main(String[] args) {
		// 배열은 표형식의 참조형
		// 타입[]변수; -> 객체 생성
		// 변수 = {값1, 값2, 값3,} ; 값 삽입
		// 타입[] 변수 = {값1, 값2, 값3}
		
		int[] scores = {83, 90, 87}; 	// int형 타입의 배열을 생성하고 값을 삽입
		//				[0] [1] [2] : index
		System.out.println(scores[0]);	// index 0번인 값을 출력
		System.out.println(scores[1]);	// index 1번인 값을 출력
		System.out.println(scores[2]);	// index 2번인 값을 출력
				
		scores[0] = 100;
		System.out.println(scores[0]); 	// index 0번에 값을 100으로 수정(덮어씌움)
		
		scores = null; 					// 배열에 연결한 객체 삭제
		scores = new int[30];			// 새로운 배열 생성 [30칸]해서 연결
		scores[0] = 100;				// 새로만든 index 0번에 값 삽입
		System.out.println(scores[0]); 	// 출력
		
		
	}

}
