package ch06.Store;

public class ProductList {
	String productName;
	String productContent;
	int productPrice;
	int productNo;
	int productEa;

public static void tester(ProductList[] lists) {
		
		ProductList lists1 = new ProductList();
		lists1.productName = "밤";
		lists1.productPrice = 500;
		lists1.productContent = "달고달고달딘 밤";
		lists1.productEa = 30;
		lists[0]=lists1;
		
		ProductList lists2 = new ProductList();
		lists2.productName = "수박";
		lists2.productPrice = 20000;
		lists2.productContent = "시원시원시원 수박";
		lists2.productEa = 30;
		lists[1]=lists2;
		}
	
	
}
