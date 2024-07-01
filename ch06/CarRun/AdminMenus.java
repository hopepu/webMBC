package ch06.CarRun;

import java.util.Scanner;

public class AdminMenus {

	public static void menu(Scanner input, Oil[] oil, Multimedea[] mMedea, CarSetting[] cSet, Road[] road) {
		System.out.println("1. 차량 설정 조회 및 변경하기");
		System.out.println("2. 주행코스 거리 조회 및 변경하기");
		System.out.println("3. 차량별 멀티미디어 기능 조회 및 변경하기");
		System.out.println("4. 테스트 주행");
		System.out.println("5. 종료하기");
	}

}
