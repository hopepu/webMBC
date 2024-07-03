package ch12.beepTest;

import java.awt.Toolkit;

public class BeepExam2 {

	public static void main(String[] args) {
		// 소리와 자막이 동시에 나오고 싶은 프로그램

		Runnable beepTask = new BeepTesk();
		// 스레드 run용 객체 생성
		Thread th1 = new Thread(beepTask);
		// run메서드가 들어있는 객체를 스레드에 넣음.
		th1.start();
		// 스레드 시작

		for (int i = 0; i < 10; i++) {
			System.out.println("띠리링~~~~!");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			} // 1초 동안 대기 상태
		} // for close

	}
}
