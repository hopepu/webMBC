package ch09.interfaceExam;

public class RemoteAnonymusExam {
	// 인터페이스를 구현클래스로 사용하지 않고 인터페이스만으로 실행한다.
	public static void main(String[] args) {

		RemoteControl remoteControl = new RemoteControl() {
			int volume;

			@Override
			public void turnOn() {
				System.out.println("익명으로 전원을 켭니다.");

			}

			@Override
			public void turnOff() {
				System.out.println("익명으로 전원을 끕니다.");
			}

			@Override
			public void setVolume(int volume) {
				if (volume > MAX_VOLUME) {
					this.volume = MAX_VOLUME;
				} else if (volume < MIN_VOLUME) {
					this.volume = MIN_VOLUME;
				} else {
					this.volume = volume;
				} // if close
				System.out.println("현재 익명객체의 볼륨");

			} // setVolume close
		};// -> 이름이 없는 일회용 클래스
	} // main close
} // class close
