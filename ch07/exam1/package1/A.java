package ch07.exam1.package1;

public class A { 


	// 접근 제한자를 생략하면 default 처리
	//필드
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	//생성자
	public A(boolean b) {
		// public : 어디서나 사용가능
	}
	A(int b){//new 에서 인트 값을 받는 클래스
		// default 접근제한
	}
	private A(String s) {
		//private 개인적인
	}
	
	//메서드

}
