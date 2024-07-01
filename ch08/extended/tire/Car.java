package ch08.extended.tire;

public class Car {
	// 필드
	Tire fl = new Tire(30, "왼앞");
	Tire fr = new Tire(26, "오앞");
	Tire bl = new Tire(20, "왼뒤");
	Tire br = new Tire(15, "오뒤");

	// 생성자

	// 메서드
	// roll 메서드를 호출하여 마일리지 소모

	int run() { // 달리고 고장 판단
		if (fl.roll() == false) {
			stop();
			return 1; // 왼앞 고장
		}
		if (fr.roll() == false) {
			stop();
			return 2; // 오앞 고장
		}
		if (bl.roll() == false) {
			stop();
			return 3; // 왼뒤 고장
		}
		if (br.roll() == false) {
			stop();
			return 4; // 오뒤 고장
		}
		return 0; // 정상 주행

	}

	void stop() {
		

	}

}
