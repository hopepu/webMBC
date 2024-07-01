package ch08.extended.calculator;

public class Computer extends Calculator{
	//자식 클래스(최신형 컴퓨터)

	@Override // 재정의 함
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle()메서드 결과");
		return Math.PI*r*r;
	} 
	
	
	
	
	
	

}
