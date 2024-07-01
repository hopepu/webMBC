package ch06.CarRun;

import java.util.Scanner;

public class GuestMenu {

	public static void menu(Scanner input, Oil[] oil, Multimedea[] mMedea, CarSetting[] cSet, Road[] road) {
		System.out.println("1. 차량 선택하기");
		System.out.println("2. 주행 거리 선택하기");
		System.out.println("3. 주행 시작하기");
		System.out.println("4. 부가기능 살펴보기");
		System.out.println("5. 종료하기");
	}

}
