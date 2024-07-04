package ch13.generic;

public class Box<T> {// <T> 제네릭 코드로 타입을 정하고 시작한다.
	// 위에 명시된 T가 Strng 이면???
	// 필드
	private T t; // 최상위 객체를 필드로 사용

	// 기본 생성자

	// 메서드

	public T getT() { // 게터
		return t;
	}

	public void setT(T t) { //세터
		this.t = t;
	}

}
