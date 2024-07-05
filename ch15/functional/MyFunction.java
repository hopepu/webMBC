package ch15.functional;

@FunctionalInterface // 람다식용인지 검증하는 코드
public interface MyFunction {
	// 인터페이스는 원래 자신을 객체로 사용할 수 없다.
	// 기본적인 상수와 메서드만으로 동작
	// 메서드는 추상 메서드가 기본(구현클래스에게 강제로 주입)
	// 추상 메서드는 실행문{} 없고 ; 로 끝낸다.
	// 지금 테스트할 람다식은 추상메서드가 1개만 있어야한다.
	// MyFunction myFunction = () -> {실행문}
	
	// 추상메서드
	public /*abstract*/ int method(int x, int y);
	// public abstract void otherMethod();
	//람다식용은 메서드 1개만 허용
	
}
