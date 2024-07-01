package ch08.extended.vehicle;

public class Bus extends Vehicle{
	//필드
	String type;
	
	//생성자
	
	//메서드
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	} // 탈것의 자식
	
	public void busCard() {
		System.out.println("승차권으로 판단합니다.");
	}
	

}
