package ch08.extended.tire;

import java.util.Scanner;

public class CarExam {
	

	public static void main(String[] args) {
		// 자동차 주행 테스트
		// 결론 Tire tire = new Tire();
		// 결론 Tire tire = new HankookTire();
		// 결론 Tire tire = new KumhoTire(); -> 다형성
		
		Car car = new Car(); // 서비스객체
		Scanner scanner = new Scanner(System.in);

		for (int i = 1; i <= 30; i++) {
			// 30번 주행
			int problemLocation = car.run();
			// 0이면 정상 1~4는 고장(위치정보)
			String location;
			int select;			
			

			switch (problemLocation) {
			case 1:
				location = "앞왼";
				System.out.println(location + "타이어 펑크");
				System.out.println("1. 한국 | 2. 금호 | 3. oem");
				System.out.print(">>>");
				select = scanner.nextInt();				
				if(select == 1) {
					car.fl = new HankookTire(90, location);
					System.out.println("한국타이어 교체 성공");
				} else if(select == 2) {
					car.fl = new KumhoTire(90, location);
					System.out.println("금호타이어 교체 성공");
				} else {
					car.fl = new Tire(90, location);
					System.out.println("oem 타이어 교체 성공");
				} // if close
				System.out.println("======================");
				break;
			case 2:
				location = "앞오";
				System.out.println(location + "타이어 펑크");
				System.out.println("1. 한국 | 2. 금호 | 3. oem");
				System.out.print(">>>");
				select = scanner.nextInt();				
				if(select == 1) {
					car.fr = new HankookTire(90, location);
					System.out.println("한국타이어 교체 성공");
				} else if(select == 2) {
					car.fr = new KumhoTire(90, location);
					System.out.println("금호타이어 교체 성공");
				} else {
					car.fr = new Tire(90, location);
					System.out.println("oem 타이어 교체 성공");
				} // if close
				System.out.println("======================");
				break;
			case 3:
				location = "왼뒤";
				System.out.println(location + "타이어 펑크");
				System.out.println("1. 한국 | 2. 금호 | 3. oem");
				System.out.print(">>>");
				select = scanner.nextInt();				
				if(select == 1) {
					car.bl = new HankookTire(90, location);
					System.out.println("한국타이어 교체 성공");
				} else if(select == 2) {
					car.bl = new KumhoTire(90, location);
					System.out.println("금호타이어 교체 성공");
				} else {
					car.bl = new Tire(90, location);
					System.out.println("oem 타이어 교체 성공");
				} // if close
				System.out.println("======================");
				break;
			case 4:
				location = "뒤오";
				System.out.println(location + "타이어 펑크");
				System.out.println("1. 한국 | 2. 금호 | 3. oem");
				System.out.print(">>>");
				select = scanner.nextInt();				
				if(select == 1) {
					car.br = new HankookTire(90, location);
					System.out.println("한국타이어 교체 성공");
				} else if(select == 2) {
					car.br = new KumhoTire(90, location);
					System.out.println("금호타이어 교체 성공");
				} else {
					car.br = new Tire(90, location);
					System.out.println("oem 타이어 교체 성공");
				} // if close
				System.out.println("======================");
				break;
			default:
				System.out.println("오류 발생");

			} // switch close
			System.out.println("=======정상 주행======");

		} // for close

	} // main close

} // class close
