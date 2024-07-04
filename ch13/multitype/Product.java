package ch13.multitype;

public class Product <T,M>{
	//필드
	private T kind; // Car, Tv
	private M model;
	
	//생성자
	
	//메서드

	public T getKind() {
		return kind;
	}
	public M getModel() {
		return model;
	}
	public void setKind(T kind) {
		this.kind = kind;
	}
	public void setModel(M model) {
		this.model = model;
	}
	

}
