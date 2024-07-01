package ch05;

public class ArraySortDESCExam {

	public static void main(String[] args) {
//		버블 정렬 내림차순으로 구현
//		내림차순은 큰 값부터 작은 값으로 재배열함
//		필수 항목 : temp 임시방이 필요.
		
		int[] scores = new int[] {79,88,91,33,100,55,95};
//		scores 변수에 int 배열 7칸 생성 하며 정수가 들어있음.
		
		System.out.println("==== 배열초기값 출력 ====");		
		for(int i = 0; i < scores.length; i++) {
			System.out.print(scores[i] + " ");
		}//for close
		
		System.out.println();
		System.out.println("=====================");
		
		System.out.println("=== 내림차순 정렬 시작 ===");
		
		for(int j = 0; j<scores.length-1; j++ ) {
			for(int k= 0; k<scores.length-1-j; k++) {
				if(scores[k] < scores[k+1]) { //방끼리 비교 함수(크다 작다 스위치로 오름차순 내림차순 정렬 가능)
					int temp = scores[k];
					scores[k] = scores[k+1];
					scores[k+1] = temp;							
				} //옆자리와 비교해서 큰지 확인 if close
				
				System.out.println("=== 배열 정렬 중 출력 ===");
				for(int i = 0; i < scores.length; i++) {
					System.out.print(scores[i] + " ");}
				System.out.println();
				System.out.println("=====================");
			}// cycle1(0~6), cycle 2(0~5), cycle 3 (0~4) ... for for close
			System.out.println("싸이클 종료");
		}// j = 0~6 repeat(cycle) for close
		System.out.println("=== 배열 내림차순 결과 ===");
		for(int i = 0; i < scores.length; i++) {
			System.out.print(scores[i] + " ");
		}//for close
		
		System.out.println();
		System.out.println("=====================");
		
		
		
				

	}//main close

}//class close
