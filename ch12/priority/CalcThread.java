package ch12.priority;

import java.util.Iterator;

public class CalcThread extends Thread{
	// 스레드 객체
	
	public CalcThread(String name) {
		setName(name);
	} // CalcThread calcThread = new CalcThread("스레드이름");
	
	@Override
	public void run() {
		for(int i=0;i<2000000000;i++) {
		}
		System.out.println(getName());
	
	} // 0~2000000000 까지 반복 후에 이름 출력
	
}


