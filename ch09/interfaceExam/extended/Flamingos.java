package ch09.interfaceExam.extended;

public class Flamingos implements Bird{

	@Override
	public void land() {
		System.out.println("홍학이 착륙한다.");
		
	}

	@Override
	public void flying() {
		System.out.println("홍학이 난다.");		
	}

	@Override
	public void takeOff() {
		System.out.println("홍학이 이륙한다.");		
	}

	@Override
	public void eat() {
		System.out.println("홍학이 먹는다.");
		
	}

	@Override
	public void breath() {
		System.out.println("홍학이 숨을 쉰다.");
		
	}

	@Override
	public void dispose() {
		System.out.println("홍학이 배출한다.");
		
	}

	@Override
	public void sound() {
		System.out.println("홍학이 소리를 낸다.");
		
	}

}
