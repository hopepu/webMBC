package ch03;

import java.util.Scanner;

public class ConditionalExam {

	public static void main(String[] args) {
		//  3항 연산자는 if를 간단히 처리하기 위해 활용된다.
		//(조건식) ? 참 : 거짓 ;
		
		int score = 85 ; 
		char grade = (score > 90) ? 'A' : 'B' ;
		System.out.println(score + "점은 " + grade + "등급 입니다.");
		
		int score2 =50 ;
		char grade2 = (score2 >=90) ? 'A' : ((score2 >= 80)? 'B' : ((score2 >=70) ? 'C' : ((score2 >= 60) ? 'D' : 'F') )) ;
		System.out.println(score2 + "점은 " + grade2 + "등급 입니다.");
		
		int score3 = 0;
		Scanner input = new Scanner(System.in) ;
		System.out.println("점수를 입력하세요 : ");
		score3 = input.nextInt();
		char grade3 = (score3 >= 90) ? 'A' : (score3 >= 80) ? 'B' : (score3 >= 70) ? 'C' : (score3 >= 60) ? 'D' : 'F' ; 
		System.out.println(score3 + "점은\n" + grade + "등급입니다.");
		

	}

}
