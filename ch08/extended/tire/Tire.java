package ch08.extended.tire;

public class Tire {// oem tire(내장)
	// 부모 객체
	// 필드
	public int maxRotation; // 타이어 최대 회전수(0 터짐)
	public int accRotation; // 타이어 주행 거리(5씩 증가)
	public String location; // 타이어의 위치(왼앞, 왼뒤, 오앞, 오뒤)

	// 생성자
	public Tire(int maxRotation, String location) {
		super();
		this.maxRotation = maxRotation;
		this.location = location;
	}// Tire tire = new Tire(10, "왼오"); -> 기본생성자 없음

	// 메서드
	public boolean roll() {// 달리면서 마일리지 소모
		accRotation += 5;
		if (accRotation < maxRotation) {// 타이어 소모 측정
			System.out.println(location + " 위치에 타이어 수명 : " + (maxRotation - accRotation));
			return true;
		} else {
			System.out.println("******경고******");
			System.out.println(location + " 위치에 타이어가 펑크 되었습니다.");
			return false;
		}
	}

}
