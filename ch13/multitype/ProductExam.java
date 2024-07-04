package ch13.multitype;

public class ProductExam {

	public static void main(String[] args) {
		//2개의 파라미터를 제네릭으로 연결한다.
		
		Product<Car, String> product1  = new Product<Car, String>();
		product1.setKind(new Car()); // Car 클래스만 들어옴
		product1.setModel("제네실수"); // 스트링 클래스만 들어옴
		
		Car car = product1.getKind();
		String carModel = product1.getModel();
		System.out.println(car);
		System.out.println(carModel);
		
		
		 Product<Tv, Integer> product2 = new Product<Tv, Integer>();
		 product2.setKind(new Tv());
		 product2.setModel(11);
		 Tv tv = product2.getKind();
		 Integer channel = product2.getModel();
		 System.out.println(tv);
		 System.out.println(channel);
				
		
		
	}
}
