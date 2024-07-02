package ch09.interfaceExam;

public class Television implements RemoteControl{
	// 리모컨 인터페이스를 사용하는 구현체
	// 필드
	private int volume; //숫자로 된 볼륨 값
	
	//기본 생성자 : Television tel = new Television();
	
	//메서드

	@Override //재정의(위에서 만든 메서드를 동작시킨다)
	public void turnOn() {
		// 전원을 켠다
		System.out.println("tv의 전원을 켭니다.");
		
	}

	@Override
	public void turnOff() {
		// 전원을 끈다.
		System.out.println("tv의 전원을 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		// 볼륨 조절용.
		if(volume > MAX_VOLUME) {
			this.volume = MAX_VOLUME;
		} else if (volume < MIN_VOLUME) {
			this.volume = MIN_VOLUME;
		} else {
			this.volume = volume;
		} // if close
		
		System.out.println("현재 티비의 볼륨은 " + volume  + "입니다.");
	} // setVolume close
	// 리모컨 인터페이스를 사용하는 구현체

	@Override
	public void setMute(boolean mute) {
		RemoteControl.super.setMute(mute);
		if(mute) {
			System.out.println("TV를 무음처리 합니다.");
		} else {
			System.out.println("TV의 무음처리를 해제 합니다.");
		} // if close
	}
	

}
