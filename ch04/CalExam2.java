package ch04;

import java.util.Scanner;

public class CalExam2 {

	static int plus(int x, int y) {
		int z = 0;
		z = x + y;
		return z;
	}

	static int minus(int x, int y) {
		int z = 0;
		z = x - y;
		return z;
	}

	static int multiple(int x, int y) {
		int z = 0;
		z = x * y;
		return z;
	}

	static int divide(int x, int y) {
		int z = 0;
		z = x / y;
		return z;
	}

	static int left(int x, int y) {
		int z = 0;
		z = x % y;
		return z;
	}

	static char result(int cal) {
		char cal1 = 0;
		switch (cal) {
		case 1 -> cal1 = '+';
		case 2 -> cal1 = '-';
		case 3 -> cal1 = 'X';
		case 4 -> cal1 = '/';
		case 5 -> cal1 = '%';
		}
		return cal1;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean system = true;

		while(system) {
		System.out.println("=========계산기=========");
		System.out.println("연산대상 x를 입력하세요 >>>");
		int x = input.nextInt();
		
		System.out.println("연산대상 Y를 입력하세요 >>>");
		int y = input.nextInt();
		
		System.out.println("연산 종류를 입력하시오");
		System.out.println("1. 더하기   4. 나누기");
		System.out.println("2. 빼기    5. 나머지");
		System.out.println("3. 곱하기");
		int z = 0;	
		
		int cal = input.nextInt();
		char cal1 = result(cal);
		
		switch(cal) {
		case 1 -> z = plus(x,y);
		case 2 -> z = minus(x,y);
		case 3 -> z = multiple(x,y);
		case 4 -> z = divide(x,y);
		case 5 -> z = left(x,y);					
		}
		
				
		System.out.printf("%s %s %s = %s", x, cal1, y, z);
		
		System.out.println("추가계산이 필요하십니까?");
		System.out.println("1. 다시하기   2. 종료");
		int select = input.nextInt();
		if(select == 2) {break;}
		
		}

	}

}
