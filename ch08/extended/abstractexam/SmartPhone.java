package ch08.extended.abstractexam;

public class SmartPhone extends Phone{//구현클래스(추상메서드를 상속받음)

	public SmartPhone(String owner) {
		super(owner);
		//추상메서드에서 만든 생성자를 강제로 주입 받음.
	
	}
	
	// 메서드
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}
	

}