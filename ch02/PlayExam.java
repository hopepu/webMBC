package ch02;

import java.util.Scanner;

public class PlayExam {

	public static void main(String[] args) {
//		과일의 갯수를 입력하여 총 금액을 산출하는 프로그램
		
			
		int 사과 = 0;
		int 배 = 0;
		int 수박 = 0;
		int 감 = 0;
		
		int 사과값 = 2000;
		int 배값 = 2500;
		int 수박값 = 10000;
		int 감값 = 1500;
		
	    int 구매 = 1;	
		
		while(구매 == 1) {
		System.out.println("1. 사과 : " + 사과값 + "원");
		System.out.println("2. 배 : " + 배값 + "원");
		System.out.println("3. 수박 : " + 수박값 + "원");
		System.out.println("4. 감 : " + 감값 + "원" );
		System.out.println("5. 계산하기" );
					
		Scanner input = new Scanner(System.in);
		
		System.out.println("구입하실 과일의 번호를 골라주세요.");
		int fruitNumber = input.nextInt();
			switch(fruitNumber){
				case 1 :
					System.out.println("사과를 고르셨습니다. 몇개를 구매하시겠습니까?");
					사과 = input.nextInt();
			
					System.out.println("1. 사과 : " + 사과 + "개");
					System.out.println("2. 배 : " + 배 + "개");
					System.out.println("3. 수박 : " + 수박 + "개");
					System.out.println("4. 감 : " + 감 + "개" );
					System.out.println("더 구매하시겠습니까(1.Y/2.N)");
					구매 = input.nextInt();
						
						if(구매 == 1) {break;} else {break;}	
			
				case 2 :
					System.out.println("배를 고르셨습니다. 몇개를 구매하시겠습니까?");
					배 = input.nextInt();
					
					System.out.println("1. 사과 : " + 사과 + "개");
					System.out.println("2. 배 : " + 배 + "개");
					System.out.println("3. 수박 : " + 수박 + "개");
					System.out.println("4. 감 : " + 감 + "개" );
					System.out.println("더 구매하시겠습니까(1.Y/2.N)");
					구매 = input.nextInt();
						
						if(구매 == 1) {break;} else {break;}	
			
				case 3 :
					System.out.println("수박을 고르셨습니다. 몇개를 구매하시겠습니까?");
					수박 = input.nextInt();
					
					System.out.println("1. 사과 : " + 사과 + "개");
					System.out.println("2. 배 : " + 배 + "개");
					System.out.println("3. 수박 : " + 수박 + "개");
					System.out.println("4. 감 : " + 감 + "개" );
					System.out.println("더 구매하시겠습니까(1.Y/2.N)");
					구매 = input.nextInt();
						
						if(구매 == 1) {break;} else {break;}	
			
				case 4 :
					System.out.println("감을 고르셨습니다. 몇개를 구매하시겠습니까?");
					감 = input.nextInt();
					System.out.println("1. 사과 : " + 사과 + "개");
					System.out.println("2. 배 : " + 배 + "개");
					System.out.println("3. 수박 : " + 수박 + "개");
					System.out.println("4. 감 : " + 감 + "개" );
					System.out.println("더 구매하시겠습니까(1.Y/2.N)");
					구매 = input.nextInt();
						
						if(구매 == 1) {break;} else {break;}
						
				case 5 :
					구매++;
			}
				if(구매 ==2) {

					System.out.println("======계산서=====");
					System.out.println("1. 사과 : " + 사과값 * 사과 + "원");
					System.out.println("2. 배 : " + 배값 * 배 + "원");
					System.out.println("3. 수박 : " + 수박값 * 수박 + "원");
					System.out.println("4. 감 : " + 감값 * 감 + "원" );
					System.out.println("=====TOTAL=====");
					System.out.println(감값*감 +사과값*사과 + 배값*배 +수박값*수박 + "원" );
			
				}
					
		}

		
	}
		
		
		

}
