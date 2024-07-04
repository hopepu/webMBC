package ch13.genericMethod;

public class Box<T> /* extends Object */{
	private T t;
	
	public T get() {
		return t;
	} // 게터
	
	public void set(T t) {
		this.t = t;
	} // 세터

}
