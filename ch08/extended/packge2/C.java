package ch08.extended.packge2;

import ch08.extended.packge1.A;

public class C extends A{
	
	//필드
	
	//생성자 -> 다른 클래스에서는 생성자로 부모객체를 연결해야함
	public C() {
	super();
	this.field = "java";
	this.method();
	}
	
	//메서드
	public void methodC() {
		
//		super();
//		A a = new A();
//		a.field = "김기원";
		
		
	}

}
