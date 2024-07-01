package ch06.Store;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GuestMenu {

	public static void menu(Scanner input, LoginStatus lSt, ProductList[] lists, Review[] reviews, Member[] members,
			ShopingList[] sLists) {
		// 손님 메뉴판
		boolean run = true;
		while (run) {

			System.out.println("1. 상품조회 및 구매");
			System.out.println("2. 장바구니");
			System.out.println("3. 주문상품 배송조회");
			System.out.println("4. 리뷰작성");
			System.out.println("4. 프로그램 종료");
			System.out.print(">>>");
			int select = input.nextInt();
			switch (select) {
			case 1:
				System.out.println("판매상품 리스트를 엽니다.");
				Sell(input, lists, lSt, sLists, reviews);
				break;
			case 2:
				System.out.println("장바구니를 확인합니다.");
				Kart(input, lists, lSt, sLists);
				break;
			case 3:
				System.out.println("주문하신 상품의 배송상태를 조회합니다.");
				System.out.println("--------------장바구니 항목 -------------");
				searchShopingList(input, lists, lSt, sLists);
				break;

			case 4:
				System.out.println("리뷰작성에 진입합니다.");
				writeReview(input, lists, lSt, sLists, reviews);
				break;

			case 5:
				run = false;
				break;
			default:
				System.out.println("1~5사이의 메뉴를 선택해주시기바랍니다.");
			} // switch 종료

		} // while 종료

	} // 메서드 종료

	private static void writeReview(Scanner input, ProductList[] lists, LoginStatus lSt, ShopingList[] sLists,
			Review[] reviews) {
		// 리뷰작성(배송완료 대상으로 리뷰 작성)
		System.out.println("--------------구매 항목 -------------");
		searchShopingList(input, lists, lSt, sLists);
		System.out.println("리뷰 쓰실 번호를 골라주세요.");
		System.out.print(">>>");
		int i = input.nextInt();
		System.out.print("별점은 몇개인가요(1~5)로 입력해주세요");
		int star = input.nextInt();
		System.out.println("사유는 어떻게 되나요 입력해주세요");
		String why = input.next();
		System.out.println("소중한 의견 감사드립니다.");
		Review review = new Review();
		review.productName = sLists[i - 1].productName;
		review.revewPoint = star;
		review.review = why;
		review.reviewDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

		for (int s = 0; s < reviews.length; s++) {
			if (reviews[s] == null) {
				reviews[s] = review;
				break;
			} // if close
		} // for close

	}// writeReview close

	private static void searchShopingList(Scanner input, ProductList[] lists, LoginStatus lSt, ShopingList[] sLists) {
		// 주문하신 항목을 조회
		for (int i = 0; i < sLists.length; i++) {
			if (sLists[i] != null) {
				if (sLists[i].buyer.equals(lSt.id)) {
					System.out.println((i + 1) + ". " + sLists[i].productName + "      " + sLists[i].productEa
							+ "      " + sLists[i].deliveryStatus + "      " + sLists[i].shopingNum);

				} // if close
			} // if close
		} // for close
	}// searchShopinlist close

	private static void Kart(Scanner input, ProductList[] lists, LoginStatus lSt, ShopingList[] sLists) {
		// 장바구니 확인 및 수정
		boolean kartRun = true;
		while (kartRun) {
			int sum = 0;
			sum = shopingList(input, lists, lSt, sLists, sum);
			System.out.println("--------------장바구니 합계 -------------");
			System.out.println(sum + "원");
			System.out.println("1. 이대로 구매하시겠습니까?");
			System.out.println("2. 수정하시겠습니까?");
			int select = input.nextInt();
			switch (select) {
			case 1:
				random(input, sLists);
				buyafter(sLists);
				kartRun = false;
				break;
			case 2:
				System.out.println("몇번 상품의 개수를 수정하시겠습니까?");
				shopingList(input, lists, lSt, sLists, sum);
				System.out.print(">>>");
				int kartNum = input.nextInt();
				modify(kartNum, sLists, input);
				break;

			default:
				System.out.println("1~2사이에서 골라주세요.");
			}
		} // while close
	}// kart close

	private static void modify(int kartNum, ShopingList[] sLists, Scanner input) {
		//
		System.out.print(sLists[kartNum - 1].productName + "를 몇개로 수정하시겠습니까?");
		sLists[kartNum - 1].productEa = input.nextInt();

	}

	private static void buyafter(ShopingList[] sLists) {
		// 구매확정후 처리
		System.out.println("구매에 감사드립니다. 빠른시일내에 배송해드리겠습니다.");
		for (int i = 0; i < sLists.length; i++) {
			if (sLists[i] != null) {
				sLists[i].deliveryStatus = "물품준비중";

			} // if close
		} // for close

	}// buyafter close

	private static int shopingList(Scanner input, ProductList[] lists, LoginStatus lSt, ShopingList[] sLists, int sum) {
		// 장바구니 확인
		System.out.println("--------------장바구니 항목 -------------");
		for (int i = 0; i < sLists.length; i++) {
			if (sLists[i] != null) {
				System.out.println(sLists[i].productName + "    " + sLists[i].productPrice + "원   "
						+ sLists[i].productEa + "개   ");
				sum = sum + (sLists[i].productPrice * sLists[i].productEa);
			} // if close
		} // for close
		return sum;
	} // shopingList close

	private static void random(Scanner input, ShopingList[] sLists) {
		// 구매 확정시 랜덤숫자를 부여함으로, 본인이 구매한 물품 확인시 사용 가능
		int shopingNo = (int) (Math.random() * 100000);
//		System.out.println(shopingNo);
		for (int i = 0; i < sLists.length; i++) {
			if (sLists[i] != null) {
				sLists[i].shopingNum = shopingNo;
//				System.out.println(sLists[i].shopingNum);
			}
		}
	}

	private static void Sell(Scanner input, ProductList[] lists, LoginStatus lSt, ShopingList[] sLists,
			Review[] reviews) {
		// 판매 게시판
		boolean run = true;
		while (run) {

			System.out.println("0. 메뉴로 돌아가기.");
			System.out.println("  상품이름  상품가격  재고상태");
			searchProductlist(lists);
			System.out.println("조회하실 상품의 번호를 입력해주세요. 메뉴로 돌아가시려면 0번을 입력해주세요");
			System.out.print(">>>");
			int i = 0;
			int insertNum = input.nextInt();
			if (insertNum != 0) {
				i = checkProductList(input, lists, reviews, insertNum);
				buy(input, sLists, lists, i, lSt);
			} else {
				run = false;
			}

		} // while close

	}// Sell close

	private static void buy(Scanner input, ShopingList[] sLists, ProductList[] lists, int i, LoginStatus lSt) {
		// 물품 구매 ㅔ서드
		System.out.println("구매를 진행하시겠습니까?");
		System.out.println("1. 네 | 2. 아니오");
		int buySelect = input.nextInt();
		switch (buySelect) {
		case 1:
			System.out.println("몇개를 장바구니에 담겠습니까?");
			System.out.println(">>>");
			int buySelect2 = input.nextInt();
			ShopingList sList = new ShopingList();
			sList.productName = lists[i].productName;
			sList.productEa = buySelect2;
			sList.productPrice = lists[i].productPrice;
			sList.buyer = lSt.id;
			lists[i].productEa = lists[i].productEa - sList.productEa;
//							System.out.println(sList.productName);

			for (i = 0; i < sLists.length; i++) {
				if (sLists[i] == null) {
					sLists[i] = sList;
					break;
				} // if close
			} // for close

		case 2:
			System.out.println("상품 목록으로 돌아갑니다.");
			break;

		default:
			System.out.println("1~2중에 골라주시기 바랍니다.");
		} // switch 종료
	}// buy close

	private static void searchProductlist(ProductList[] lists) {
		// 현재 판매 물품 현황 게시판
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				lists[i].productNo = (int) (i + 1);
				System.out.print(lists[i].productNo + "    " + lists[i].productName + "    " + lists[i].productPrice
						+ "    " + lists[i].productEa);
				System.out.println("");

			} else {
				System.out.println("-----이하로는 상품이 존재하지 않습니다.----");
				break;
			} // if close
		} // for 종료
	}// searchProductList close

	private static void review(Review[] reviews, String productName) {
		// 상품에 대한 리뷰 출력
		for (int i = 0; i < reviews.length; i++) {
			if (reviews[i] != null) {
				if (reviews[i].productName.equals(productName)) {
					System.out.println("별점 : " + reviews[i].revewPoint + "구매일 : " + reviews[i].reviewDate);
					System.out.println("리뷰 : " + reviews[i].review);
				} // if close

			} // if close
		} // for close

	}// review close

	private static int checkProductList(Scanner input, ProductList[] lists, Review[] reviews, int insertNum) {
		// 개별 상품 확인 메서드
		int i = 0;
		for (i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				if (lists[i].productNo == insertNum) {
					System.out.println("상품 이름 : " + lists[i].productName + "상품 가격 : " + lists[i].productPrice);
					System.out.println("상세 설명 : " + lists[i].productContent);
					System.out.println("현재 재고 상태 : " + lists[i].productEa);
					review(reviews, lists[i].productName);
					break;
				} // if close
			} else {
				System.out.println("해당 항목이 없습니다. 다시 골라주시기 바랍니다.");
				break;// if 종료
			} // for close
		} // for close
		return i;
	}// checkProductlist close
} // 클래스 종료
