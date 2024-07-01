package ch06.circle;

public class Circle2Exam {

	public static void main(String[] args) {
		// 생성자 오버로딩으로 구현
		Circle circle = new Circle(30);
		circle.name = "김기원";
		
		double result = circle.getArea();
		System.out.println("원의 반지름 : " + circle.radius);
		System.out.println("작성자 : " + circle.name);
		System.out.println("동작결과 : " + result);
		
	}
}
