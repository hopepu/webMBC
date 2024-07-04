package ch13.generic;

public class BoxExam{
	
	public static void main(String[] args) {
		// 제네릭은 <String> 문자열만 처리함.
		//  <Integer> 정수만 처리, <Apple> 객체만 처리
		Box<String> boxS = new Box<String>();
		boxS.setT("김기원");
		String name = boxS.getT();
		System.out.println(boxS.getT());
		
		Box<Integer> boxI = new Box<Integer>();
		boxI.setT(1234);
		Integer age = boxI.getT();
		System.out.println(age);
		
		
		
	}

}
