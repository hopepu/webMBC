package ch15.functional;

public class MyFunctionExam {

	public static void main(String[] args) {
		// 원래는 인터페이스를 사용하기 위해서는 구현 클래스가 필요하다.
		// 하지만, 익명의 구현 객체를 사용하기도 한다.
		
		MyFunction myFunction; // 인터페이스를 변수에 타입으로 설정
			
//		myFunction.method(10); // 실행문이 2개인 메서드 실행
		
		myFunction = (x, y) -> {
//			String str = "method call 1"; 	// 실행문 1
//			System.out.println(str);		// 실행문 2
			int result = x * y;
			return result;
		}; //익명의 구현 객체 -> 동작에 실행코드를 주입
		
		int result = myFunction.method(10, 20); // 실행문이 2개인 메서드 실행
		System.out.println(result);
		System.out.println("======================");
		
		System.out.println(myFunction.method(10, 20));
		
//		myFunction = () -> System.out.println("method call 2"); // 실행문 1
		myFunction = (x, y) -> x*y;
		
		// 익명의 구현 객체 -> 동작에 실행코드를 주입
		System.out.println(myFunction.method(30, 20));
				
		myFunction = (x, y) -> sum(x,y);
		System.out.println(myFunction.method(30, 20));
	}//main close
	
	public static int sum(int x, int y) {
		return (x * y);
	}
}
