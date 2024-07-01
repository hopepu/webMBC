package ch08.extended.calculator;

public class CalExam {

	public static void main(String[] args) {
		
		System.out.println("구형 계산기(부모용)");
		Calculator calculator = new Calculator();
		double result = calculator.areaCircle(10.5);
		System.out.println("10.5의 원면적은 : " + result);
		
		
		System.out.println("신형 계산기(자식용)");
		Computer computer = new Computer();
		double result2 = computer.areaCircle(10.5);
		System.out.println("10.5의 원면적은 : " + result2);
		
		
		
	}
}
