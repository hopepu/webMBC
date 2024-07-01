package ch04;

import java.util.Scanner;

import java.util.StringTokenizer;

public class CalExam3 {

	public static void main(String[] args) {

		System.out.println("계산식을 기입해주세요");

		Scanner input = new Scanner(System.in);
		String in = input.nextLine();
		StringTokenizer tokenizer = new StringTokenizer(in, "+-*/%", true);

		int x = Integer.parseInt(tokenizer.nextToken());
//		System.out.println(x);

		String cal = tokenizer.nextToken();
//		System.out.println(cal);

		int y = Integer.parseInt(tokenizer.nextToken());
//		System.out.println(y);

		int z = 0;

		switch (cal) {
		case "+" -> z=plus(x, y);
		case "-" -> z=minus(x, y);
		case "*" -> z=multiple(x, y);
		case "/" -> z=divide(x, y);
		case "%" -> z=left(x, y);
		default -> System.out.println("케이스 값이 안들어와");
		}

		System.out.printf("%s %s %s = %s", x, cal, y, z);

	}// 메인 메서드 종료

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

}
