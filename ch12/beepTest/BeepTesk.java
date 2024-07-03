package ch12.beepTest;

import java.awt.Toolkit;

public class BeepTesk implements Runnable{

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 10; i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			} // 1초 동안 대기 상태
		}
		
	}

}
