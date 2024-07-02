package ch09.interfaceExam.extended;

public class BirdExam {

	public static void main(String[] args) {
		// 다중 상속 인터페이스 테스트
		Flamingos flamingos = new Flamingos();
		flamingos.eat();
		flamingos.flying();
		flamingos.sound();
		
		System.out.println("----------------------");
		
		Fly fly = flamingos; // 업캐스팅
		fly.flying();
		//부모가 다름 fly.eat();
	
		Animal animal = flamingos;
		animal.eat();
		animal.breath();
		animal.dispose();
		
		
		
	}
}
