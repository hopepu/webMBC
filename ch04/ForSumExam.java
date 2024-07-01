package ch04;

import java.util.Scanner;

public class ForSumExam {

	public static void main(String[] args) {
		// 1부터 100까지의 총합
		
		int sum = 0;
		for(int i = 1;
				i <= 100;
				i++) {
			sum += i;
		}//for close
		
		System.out.println("1~100까지 출력 :" + sum);
		System.out.println("============================================");
		
		//키보드로 입력 받은 값을 반복 더해주는 코드
		
		Scanner inputInt = new Scanner(System.in);
		
		int sum2 = 0; //반복 더해주는 결과값
		int x1 = 0; //초기 값
		int x2 = 0;
		int y = 0; //종료 값
		System.out.print("더할 처음값을 입력하세요 : ");
		x1 = inputInt.nextInt(); // 키보드로 입력한 초기값 저장
		
		System.out.print("더할 마지막 값을 입력하세요 : ");
		y = inputInt.nextInt();
		
		for(x2=x1; x1<=y; x1++) {
			sum2 = sum2 + x1;
		}//for close
		
		System.out.println(x2 + "~" + y + "까지의 누적 합계 값은 : " + sum2);
		
	
		
		
		
		
		
		
		
	}// main close
	

} //class close
