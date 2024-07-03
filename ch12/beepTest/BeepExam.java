package ch12.beepTest;

import java.awt.Toolkit;

public class BeepExam {

	public static void main(String[] args) {
		//소리와 자막이 동시에 나오고 싶은 프로그램
		
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // 객체화
		for(int i = 0 ; i<10 ; i++) {
			toolkit.beep();//사운드로 경고음이 출력됨
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			} // 1초 동안 대기 상태
		} // for close
		
		for(int i = 0; i<10; i++) {
			System.out.println("띠리링~~~~!");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			} // 1초 동안 대기 상태
		} // for close
					
	}
}
