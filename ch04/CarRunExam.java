package ch04;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CarRunExam {

	public static void main(String[] args) {
		// 자동차 주행 프로그램 만들기!!!!
		// C -> 시동을 건다(Start)
		// R -> 계기판 정보 출력(Read)
		// U -> 주행
		// D -> 시동을 끈다.(End)

		Scanner input = new Scanner(System.in);

		boolean power = true; // 시동을 켠다
		int select;
		int speed = 0;
		int accel = 20;
		int decel = 5;
		float oil = 300;
		float totalOil = oil;
		float Ause = 2; // 속도 1km/h 증가하는데 드는 기름L
		float Duse = 50; // 속도 1km/h 감속하는데 드는 기름 L
		float insert = 300;
		int time = 0;
		final int MAXSPEED = 250;
		final int MINSPEED = 0;
		int i = 0;
		int j = 0;
		boolean navigation = true;
		boolean option = true;
		float radio = 0;
		int pw = 0000;
		int password;
		String place;

		while (power) {
			System.out.println("프로그램 구동 비밀번호를 입력하십시오");
			System.out.print(">>>>>>");
			password = input.nextInt();
			if (password == pw) {
				System.out.println("자동차 체험 시스템에 오신것을 환영합니다.");

				while (power) {
					System.out.println("========================");
					System.out.println("0. 시동 종료");
					System.out.println("1. 엑셀");
					System.out.println("2. 브레이크");
					System.out.println("3. 멀티미디어");
					System.out.println("4. 주유");
					System.out.println("5. 설정");
					System.out.println("========================");
					System.out.print("(0~5 메뉴 선택)>>>>>>");
					select = input.nextInt();

					switch (select) {
					case 0:
						if (speed == 0) {
							System.out.println("시동을 종료합니다.");
							System.out.println("남은 기름양은 " + oil + "입니다.");
							power = !power;
							break;
						} else {
							System.out.println("현재속도 : " + speed + "km/h");
							System.out.println("브레이크합니다.");
							oil = (oil - (speed) / Duse);
							time = (speed / decel) + 1;
							System.out.println("정지까지 걸리는 시간은 " + time + "초입니다.");
							while (i <= (int) time - 1) {
								System.out.print((time - i) + "초 ");
								System.out.println("현재 속도 : " + (speed - (i * decel)) + "km/h");
								try {
									TimeUnit.SECONDS.sleep(1);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								i++;

							}
							System.out.println("현재 속도 : 0km/h");
							System.out.println("총 사용한 기름양은 " + (totalOil - oil) + "L입니다.");
							System.out.println("남은 기름양은 " + oil + "L입니다.");
							System.out.println("시스템을 이용해주셔서 감사합니다.");
							power = !power;
							break;
						} // case0 if close

					case 1:
						if (oil >= 0 && oil <= (accel / Ause)) {
							System.out.println("기름이 부족합니다. 주유가 필요합니다.");
							System.out.println("가속이 불가합니다.");
							break;
						} else {
							if (speed >= MAXSPEED) {
								System.out.println("속도가 너무 높습니다. 더이상 가속할 수 없습니다.");
								speed = MAXSPEED;
								break;
							} else {
								speed = speed + accel;
								oil = (oil - (accel / Ause));
								if (speed >= MAXSPEED) {
									System.out.println("현재속도 : " + speed + "km/h");
									System.out.println("속도가 너무 높습니다. 속도를 제한합니다.");
									oil = (oil - ((MAXSPEED - speed) / Duse));
									speed = MAXSPEED;
									System.out.println("제한된 속도 : " + speed + "km/h");
									System.out.println("남은 기름양은 " + oil + "L입니다.");
									break;
								} else {
									System.out.println("현재 속도는 " + speed + "km/h 입니다.");
									if (oil < 5) {
										System.out.println("기름이 부족합니다. 주유가 필요합니다");
										System.out.println("현재 기름양은 " + oil + "L입니다.");
									} // if문 종료
									break;

								} // case1 - if - if - if close

							} // case1 - if -if close
						} // case1 - if close

					case 2:
						if (oil >= 0 && oil <= (decel / Duse)) {
							System.out.println("기름이 부족합니다. 주유가 필요합니다.");
							System.out.println("브레이크가 불가합니다.");
							break;
						} else {
							if (speed > MINSPEED) {
								speed = speed - decel;
								oil = (oil - (decel / Duse));
								System.out.println("현재 속도는 " + speed + "km/h 입니다.");
								if (oil < (decel / Duse)) {
									System.out.println("기름이 부족합니다. 주유가 필요합니다");
									System.out.println("현재 기름양은 " + oil + "입니다.");
								} // if문 종료
								break;

							} else {
								System.out.println("시동이 꺼집니다 프로그램을 종료합니다.");
								System.out.println("총 사용한 기름양은 " + (totalOil - oil) + "L입니다.");
								System.out.println("남은 기름양은 " + oil + "입니다.");
								power = !power;
								break;
							} // case2-if-if close
						} // case2-if close

					case 3:
						option = true;
						while (option) {
							System.out.println("부가기능을 선택해주세요.");
							System.out.println("========================");
							System.out.println("1. 내비게이션");
							System.out.println("2. 블루투스");
							System.out.println("3. 라디오");
							System.out.println("4. 차량 주행으로 돌아가기");
							System.out.println("========================");
							System.out.print("(1~4 메뉴 선택)>>>>>>");
							select = input.nextInt();

							switch (select) {
							case 1:
								if (navigation == true) {
									System.out.println("내비게이션을 시작합니다. 목적지를 입력해주세요.");
									System.out.print(">>>>>>");
									place = input.next();

									System.out.println(place + "까지의 최적된 경로를 표시합니다.");
									navigation = !navigation;
									break;
								} else {
									System.out.println("내비게이션을 종료합니다. 안전운전을 기원합니다.");
									navigation = !navigation;
									break;
								}

							case 2:
								System.out.println("연결가능한 블루투스기기를 찾고있습니다.");
								try {
									TimeUnit.SECONDS.sleep(3);
								} catch (InterruptedException e) {
									e.printStackTrace();}
								System.out.println("연결가능한 블루투스기기가 존재하지 않습니다.");
								break;
									
							case 3:
								
								System.out.print("채널 입력 : ");
								radio = input.nextInt();
								System.out.println("FM" + radio + "를 수신합니다.");
								break;

							case 4:
								option = !option;
								break;

							default:
								System.out.println("잘못 입력하셨습니다. 다시 입력해주시기 바랍니다");

							}
						} // case3 - if close

					case 4:
						oil = oil + insert;
						totalOil = totalOil + insert;
						System.out.println("기름을 충전하였습니다.");
						System.out.println("현재 기름양은 " + oil + "입니다.");
						break;

					case 5:
						option = true;
						while (option) {
							System.out.println("차량 설정을 변경합니다.");
							System.out.println("========================");
							System.out.println("1. 엑셀시 가속도 : +" + accel + "km/h");
							System.out.println("2. 브레이크시 감속도 : -" + decel + "km/h");
							System.out.println("3. 주유량 : " + insert + "L");
							System.out.println("4. 차량 주행으로 돌아가기");
							System.out.println("========================");
							System.out.print("(1~4 메뉴 선택)>>>>>>");
							select = input.nextInt();
							switch (select) {
							case 1:
								System.out.print("변경할 가속도 : ");
								accel = input.nextInt();
								System.out.println(accel + "km/h");
								break;

							case 2:
								System.out.print("변경할 감속도 : ");
								decel = input.nextInt();
								System.out.println(decel + "km/h");
								break;

							case 3:
								System.out.print("변경할 주유량 : ");
								insert = input.nextInt();
								System.out.println(insert + "L");
								break;

							case 4:
								option = !option;
								break;

							default:
								System.out.println("잘못 입력하셨습니다. 다시 입력해주시기 바랍니다.");

							} // case5-while-switch close

						} // case5-while close

					default:
						System.out.println("잘못 입력하셨습니다. 다시 입력해주시기 바랍니다.");

					} // switch close

				} // while close
			} // pw if close
			else {
				if (j == 2) {
					System.out.println("3회 이상 틀렸습니다. 본사에 문의해주시기 바랍니다..");
					break;
				} else {
					System.out.println("패스워드가 틀렸습니다. 다시 확인해주시기 바랍니다.");
					j++;
				} // 패스워드 if else else close
			} // 패스워드 if else close
		} // 패스워드 while close
	} // main close

} // class close
