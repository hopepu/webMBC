package ch06.car;

public class Car {
	//자동차 객체용 클래스
	
	//필드(멤버 변수)
	
	//교유 데이터
	String company 	; 	// 제작회사
	String model	;	// 모델명
	String color 	;	// 색상
	int maxSpeed 	;	// 최고 속도
	//상태
	int speed		;	// 현재 속도
	int rpm			;	// 현재 엔진 회전수
	boolean start	;	// 시동유무
	//부품
	Body body;
	Engine engine;
	Tire tire;
	
	
	//생성자(new)
	public Car() {
		
	} // 기본 생성자
	public Car(String company, String model, String color, int maxSpeed, boolean start) {
		super();//상속 관련 메서드
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.start = start;
	}
	@Override //재정의 코드(객체를 문자열로 출력)
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed
				+ ", speed=" + speed + ", rpm=" + rpm + ", start=" + start + "]";
	}
		
	//메서드(동작)
	
	

}
