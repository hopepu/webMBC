package ch13.nongeneric;

public class Box /* extends object */{
	// 필드
	private Object object; //최상위 객체를 필드로 사용
	
	// 생성자
	
	// 메서드


	public Object getObject() { // 게터
		return object;
	}

	public void setObject(Object object) { // 세터
		this.object = object;
	}

}
