package ch06.ranking;

import java.util.Scanner;

public class RangkingExam {

	public static void main(String[] args) {
		// 열거 타입을 사용하려면 객체를 생성하여 활용함(new 사용 안됨)
		// 사용 안됨 Ranking rk = new Ranking(); 
		Ranking rk = Ranking.GUEST;
		String rkString = rk.name();//enum 타입의 상수값을 문자열로 변환
		System.out.println("enum값 : " + rk);
		
		Ranking rk1 = Ranking.GUEST;
		Ranking rk2 = Ranking.GUEST;
		
		System.out.println(rk1 == rk2);
		
		// Scanner 입력 값과 enum의 ㅂ교는 안된다.
//		Scanner input = new Scanner(System.in);
//		System.out.println("키보드 입력 : ");
//		System.out.print(">>>");
//		String rank = input.next();

		//System.out.println("값 비교 " + (rk == rank));
		//Incompatible operand types Ranking and String
		
		Scanner input = new Scanner(System.in);
		System.out.println("키보드 입력 : ");
		System.out.print(">>>");
		String rank = input.next();
		
		System.out.println("값 비교 " + (rkString == rank));
		System.out.println("equals 비교 " + rkString.equals(rank));
		
		int enumIndex = rk.ordinal();
		System.out.println("열거 순서 파악 : " + enumIndex);

	}

}
