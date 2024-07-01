package ch02;

public class CastingExam {

	public static void main(String[] args) {
//		Casting은 강제 타입 변환으로 큰타입을 작은타입으로 강제 주입할 때 사용
//		단, 손실이 발생할 수 있다. -> 2진법에 영향
//		int 변수명 = (int) double값;
		
	
		int intvalue = 12345678;
		byte bytevalue = (byte) intvalue;
		
		System.out.println("intvalue : " + intvalue);
		System.out.println("bytevalue : " + bytevalue);
		
		System.out.println("===================");
		int intValue1 = 10;
		double doubleValue1 = 5.5;
		double result1 = intValue1 + doubleValue1;
		
		
		System.out.println("int10 + doubleValue1 = " + result1);
		System.out.println("====정수로 결과를 봄====");
				
		int result2 = (int)(intValue1 + doubleValue1);
//		강제타입 변환
		System.out.println("int10 + (int)doublevalue1 = " + result2);
	}

}
