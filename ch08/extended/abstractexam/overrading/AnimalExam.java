package ch08.extended.abstractexam.overrading;

public class AnimalExam {
	
	public static void main(String[] args) {
		//  추상 메서드 활용
		
//		Animal animal = new Animal() {//추상이라 쓸수 없음
//			
//			@Override
//			public void sound() {
//				// TODO Auto-generated method stub
//				
//			}
//		};() {
//			
//		}
		
		Dog dog = new Dog();
		dog.breathe();
		dog.kind = "포유류";
		dog.sound();
		System.out.println("kind : " + dog.kind);
		
		System.out.println(" -- 자식 객체(구현클래스) -- ");
		Cat cat = new Cat();
		cat.kind = "포유류";
		cat.breathe();
		cat.sound();
		System.out.println("kind : " + cat.kind);
		
		System.out.println(" -- 자식 객체(구현클래스) -- ");
		
		System.out.println("변수의 자동타입 변환 테스트");
		Animal animal = null;
		animal = new Dog();//자동타입변환
		animal.sound();
		
		animal = new Cat();//자동타입변환
		animal.sound();
		//객체의 다형성
		
		//매개변수 다형성 실행
		animalSound(new Dog());
		
	} // main close
	
	// 메서드의 매개변수 다형성
	public static void animalSound(Animal animal) {
		animal.sound();
	}
	
	
	

}
