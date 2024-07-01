package kr.co.mbc.game.dto;

public class ItemDTO {
	// 필드
	public String name; // 캐릭터명
	public String effect; // 효과섦명
	public int use;
	
	// 생성자
	
	public ItemDTO(String name, String effect, int use) {
		super();
		this.name = name;
		this.effect = effect;
		this.use = use;
	}

	@Override
	public String toString() {
		return name + " : " + effect + "사용횟수 " + use;
	}

	// 매서드
	
	

}
