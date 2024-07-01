package ch04;

import java.util.Scanner;

public class SSNExam {

	public static void main(String[] args) {
//		주민번호 7번째 글자를 입력받아 남여 파악용
		Scanner input = new Scanner(System.in);
		
		System.out.print("주민번호7번째 숫자 입력 : ");
		int ssn = input.nextInt();
		if(ssn >=9 || ssn < 1) {
			System.out.println("입력오류입니다. 입력오류 이유 -> 1이상 9미만으로 입력해주세요.");
		} else {
			if(ssn%2==1) {
				System.out.println("성별은 남성입니다.");
			} else {
				System.out.println("성별은 여성입니다.");
			} 

		}
		
		//주민번호의 7번째 숫자를 추출하여 주민번호 입력시 남자와 여자를 판별
		System.out.println("주민번호 입력(-는 제외하고 입력하세요) : ");
		String ssn2 = input.next();
		System.out.println( ssn2.charAt(6) );
		if(ssn2.charAt(6)%2==1) {
			System.out.println("성별은 남성입니다.");
			} else {
			System.out.println("성별은 여성입니다.");
			}
		
	}

}
