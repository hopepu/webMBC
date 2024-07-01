package ch06.Store;

import java.util.Scanner;

public class AdminMenu {

	public static void menu(Scanner input, LoginStatus lSt, ProductList[] lists, Review[] reviews, Member[] members,
			ShopingList[] sLists) {
		// 관리자 메뉴
		boolean run = true;
		while (run) {
			System.out.println("어떤 항목을 관리하시겠습니까?");
			System.out.println("1. 판매물품");
			System.out.println("2. 배송물품");
			System.out.println("3. 종료");
			System.out.println(">>>");
			int select = input.nextInt();
			switch (select) {
			case 1:
				productLists(input, lists);
				break;
			case 2:
				sellLists(input, lists, sLists);
				break;
			case 3:
				run = false;
				break;
			default:
				System.out.println("1~4를 골라주세요");

			}//switch close

		}//while close

	}//menu close

	private static void sellLists(Scanner input, ProductList[] lists, ShopingList[] sLists) {
		// 판매 리스트 확인
		boolean run = true;
		while(run) {
		System.out.println("--------------판매 진행 중 물품 -------------");
		for (int i = 0; i < sLists.length; i++) {
			if (sLists[i] != null) {
				System.out.println((i + 1) + ". " + sLists[i].productName + "         " + sLists[i].productEa
						+ "         " + sLists[i].shopingNum + "         " + sLists[i].deliveryStatus);
			}//if close
		}//for close
		run = deliveryStatus(input, lists, sLists, run);
		}
	}//sellLsits close

	private static boolean deliveryStatus(Scanner input, ProductList[] lists, ShopingList[] sLists, boolean run) {
		// 배송상태 변경
		System.out.println("1. 배송 시작으로 상태 변경");
		System.out.println("2. 배송 완료로 상태 변경");
		System.out.println("3. 메뉴로 돌아가기");
		System.out.print(">>>");
		int select = input.nextInt();
		switch(select) {
		case 1:
			
			String status = "배송시작";
			statusChange(status, sLists, input);
			break;
		case 2:
			status = "배송완료";
			statusChange(status, sLists, input);
			break;
			
		case 3:
			run = false;
			break;
		default:
			System.out.println("1~3만 입력해주오");
				
		}
		
		return run;
	}

	private static void statusChange(String status, ShopingList[] sLists, Scanner input) {
		// 배송 시작 및 완료 변경
		System.out.println("배송상태를 변경할 주문번호를 입력해주세요");
		int shopingNum = input.nextInt();
		for(int i = 0; i <sLists.length; i++ ) {
			if(sLists[i]!=null) {
				if(sLists[i].shopingNum==shopingNum) {
					sLists[i].deliveryStatus=status;
				}//if close
			}//if close
		}//for close
	}//statusChange close

	private static void productLists(Scanner input, ProductList[] lists) {
		// 물품 관리
		boolean kartRun = true;
		while (kartRun) {
			searchSellingProduct(lists);

			System.out.println("---------------------------");
			System.out.println("1. 품목을 수정하시겠습니까?");
			System.out.println("2. 품목을 추가하시겠습니까?");
			System.out.println("3. 종료하기");
			int select = input.nextInt();
			switch (select) {
			case 1:
				modify(input, lists);
				break;

			case 2:
				add(input, lists);
				break;

			case 3:
				kartRun = false;
				break;
			
			default:
				System.out.println("1~2사이에서 입력해주세요.");
			}//switch close
		} // while close
	} //method close

	private static void add(Scanner input, ProductList[] lists) {
		// 물품 추가 메서드
		System.out.println("품목을 추가합니다.");
		ProductList newlist = new ProductList();
		System.out.println("품명 : ");
		newlist.productName = input.next();
		System.out.println("설명 : ");
		newlist.productContent = input.next();
		System.out.println("판매가격 : ");
		newlist.productPrice = input.nextInt();
		System.out.println("재고 : ");
		newlist.productEa = input.nextInt();
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] == null) {
				newlist.productNo = i+1;
				lists[i] = newlist;
				break;
			}//if close
		}//for close

	}

	private static void searchSellingProduct(ProductList[] lists) {
		// 판매중 항목 조회하기
		System.out.println("--------------상품 항목 -------------");
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				System.out.println((i + 1) + ". " + lists[i].productName + lists[i].productPrice
						+ lists[i].productContent + lists[i].productEa);
				lists[i].productNo = i + 1;
			} // if close
		} // for close
	}// method close

	private static void modify(Scanner input, ProductList[] lists) {
		// 픔목 수정하기
		System.out.println("어떤 품목을 수정하시겠습니까?");
		System.out.println(">>>");
		int number = input.nextInt();
		System.out.println("어떤 항목을 수정하시겠습니까?");
		System.out.println("1. 품명");
		System.out.println("2. 가격");
		System.out.println("3. 내용");
		System.out.println("4. 재고");
		System.out.println("5. 종료하기");
		System.out.println(">>>");
		int choice = input.nextInt();

		switch (choice) {
		case 1:
			System.out.println("바꿀 이름을 적어주세요");
			String insert = input.next();
			System.out.println(lists[number - 1].productName = insert);
			break;
		case 2:
			System.out.println("바꿀 가격을 적어주세요");
			int insert2 = input.nextInt();
			System.out.println(lists[number - 1].productPrice = insert2);
			break;
		case 3:
			System.out.println("바꿀 내용을 적어주세요");
			String insert3 = input.next();
			System.out.println(lists[number - 1].productContent = insert3);
			break;
		case 4:
			System.out.println("재고상태를 적어주세요");
			int insert4 = input.nextInt();
			System.out.println(lists[number - 1].productEa = insert4);
			break;
		case 5:
			break;

		default:
			System.out.println("1~5사이를 골라주세요");

		}

	}

}
