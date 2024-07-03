package ch12.threadName;

public class ThreadNameExam {

	public static void main(String[] args) {
		
		Thread mainThread = Thread.currentThread();
		// 사용중인 스레드 객체 얻기
		
		for (int i = 0; i < 2; i++) {
			System.out.println(mainThread.getName());
			//메인 스레드의 객체를 가져와 이름을 출력하는 메서드 실험
		}
				
		Thread thB = new ThreadB(); // 스레드B를 객체로 만듬
		System.out.println("new ThreadB().getName : "+ thB.getName());
		thB.start();//스레드 시작
		
		Thread thA = new ThreadA(); // 스레드A를 객체로 만듬
		System.out.println("new ThreadA().getName : "+ thA.getName());
		thA.start();//스레드 시작
	}
}
