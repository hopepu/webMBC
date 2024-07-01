package ch06.Store;


public class ShopingList {
	String productName;
	int productEa;
	int productPrice;
	int shopingNum;
	String deliveryStatus;
	String buyer;
	
public static void tester(ShopingList[] sLists) {
		
		ShopingList lists1 = new ShopingList();
		lists1.productName = "밤";
		lists1.productEa = 5;
		lists1.productPrice = 500;
		lists1.buyer = "1";
		lists1.deliveryStatus = "상품 준비 중";
		lists1.shopingNum = 1111;
		sLists[0]=lists1;
		
		ShopingList lists2 = new ShopingList();
		lists2.productName = "수박";
		lists2.productEa = 5;
		lists2.productPrice = 200000;
		lists2.buyer = "1";
		lists2.deliveryStatus = "상품 준비 중";
		lists2.shopingNum = 1111;
		sLists[1]=lists2;
		}
	

}
