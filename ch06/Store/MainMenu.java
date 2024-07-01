package ch06.Store;
import java.util.Scanner;
public class MainMenu {
	
	public static Scanner input = new Scanner(System.in);
	public static Member[] members = new Member[100];//회원수 100명의 테이블 생성
	public static LoginStatus[] lSt = new LoginStatus[1];//사용자의 로그인 정보를 저장하고 있는 클래스
	public static ProductList[] lists = new ProductList[100];
	public static ShopingList[] sLists = new ShopingList[100];
	public static Review[] reviews = new Review[1000];
	
	public static void main(String[] args) {
		Member.tester(members);
		ProductList.tester(lists);
		Review.tester(reviews);
		ShopingList.tester(sLists);
		
		System.out.println("=========MBC 청과 판매점=========");
		System.out.println("판매시스템에 오신것을 환영합니다.");
		Member member = new Member();
		LoginStatus lSt = new LoginStatus();
		lSt = member.menu(input, members, lSt);
		
		if(lSt.id != null) {
		if(lSt.admin == true) {
			System.out.println("관리자 모드로 접속합니다.");
			AdminMenu.menu(input, lSt, lists, reviews, members, sLists);
		} else {
			System.out.println("MBC 판매 몰에 어서오세요." + lSt.name + "님");
			GuestMenu.menu(input, lSt, lists, reviews, members, sLists);
			
		}}else {
			System.out.println("프로그램을 종료합니다.");
		}
		System.out.println("안녕히 가세요.");
		
		
		
	}

}
