package kr.co.mbc.board.DTO;

public class ItemBoardDTO extends BoardDTO{
	private int price;
	private String ad;
	
	public int getPrice() {
		return price;
	}
	public String getAd() {
		return ad;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}

}
