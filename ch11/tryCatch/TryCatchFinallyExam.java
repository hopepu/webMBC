package ch11.tryCatch;

import java.util.Scanner;

public class TryCatchFinallyExam {

	public static void main(String[] args) {
		//문자로 입력받은 숫자를 정수로 변환
		
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		while (num < 3) {
			System.out.println("첫번째 숫자를 입력하세요.");
			System.out.print(">>>");
			String data1 = scanner.next();
			System.out.println("두번째 숫자를 입력하세요.");
			System.out.print(">>>");
			String data2 = scanner.next();
			System.out.println("두개의 숫자를 더하겠습니다.");
			try {
				int value1 = Integer.parseInt(data1); //문자로된 숫자를 정수로 변환
				int value2 = Integer.parseInt(data2); //문자로된 숫자를 정수로 변환
				int result = value1 + value2;
				System.out.println(data1 + " + " + data2 + " = " + result);
				num = 0;
			} catch (NumberFormatException e) {
				System.out.println("입력이 잘못되었습니다.");
				//			e.printStackTrace();
				num++;
				System.out.println("입력기회가" + (3-num) + "번 남았습니다.");
			} 
		}
		System.out.println("시스템을 종료하겠습니다.");
		
		
		
		
		
		
		
	}
}
