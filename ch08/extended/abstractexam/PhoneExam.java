package ch08.extended.abstractexam;

public class PhoneExam {

	public static void main(String[] args) {
		
//		Phone phone = new Phone("김기원");
		// Phone class에 abstract가 되어 있어 객체로 사용할 수 없다.
		// 사용하려면 구현 클래스(조원)이 상속받아 활용해야 한다.(강제)
		
		SmartPhone smp = new SmartPhone("김기원");
		smp.turnOn(); // 부모
		System.out.println(smp.owner); // 부모
		smp.internetSearch(); //자식
		smp.turnOff();// 부모

	}
}
