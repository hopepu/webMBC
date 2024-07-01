package ch04;
import java.util.Scanner;
public class CalExam {

	public static void main(String[] args) {
		System.out.println("========계산기=========");
		System.out.println("1. 더하기");
		System.out.println("2. 빼기");
		System.out.println("3. 곱하기");
		System.out.println("4. 나누기");
		System.out.println("5. 나머지");
		Scanner input = new Scanner(System.in);
		System.out.print("행하고 싶은 연산을 고르세요(1~5) >>> ");
		int cal = input.nextInt();
		System.out.print("행하고 싶은 연산의 대상 a를 입력하세요 >>> ");
		int a = input.nextInt();
		System.out.print("행하고 싶은 연산의 대상 b를 입력하세요 >>> ");
		int b = input.nextInt();
		result(cal, a, b);
		char cal1 = result2(cal);
		int z = result(cal, a, b);
		System.out.printf("%s %s %s = %s", a , cal1 , b , z);
	}// 메인 종료
	static int result(int cal, int a, int b) {
		int z = '0';
		switch (cal) {
		case 1 -> z = a + b;
		case 2 -> z = a - b;
		case 3 -> z = a * b;
		case 4 -> z = a / b;
		case 5 -> z = a % b;
		}
		return z;
	}
	static char result2(int cal) {
		char cal1 = 0;
		switch (cal) {
		case 1 -> cal1 = '+';
		case 2 -> cal1 = '-';
		case 3 -> cal1 = '*';
		case 4 -> cal1 = '/';
		case 5 -> cal1 = '%';
		}
		return cal1;
	}
}

