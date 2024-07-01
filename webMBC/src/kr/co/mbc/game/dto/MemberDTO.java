package kr.co.mbc.game.dto;

public class MemberDTO {
	// 필드
	public String id;
	public String pw;
	public String nickName;
	public String email;
//	int ranking;
	public boolean loginStatus;
//	CartDTO cartDTO;
	public CharacterDTO characterDTO;//사용자가 선택한 캐릭터 연결용
	public CartDTO cartDTO;//사용자가 선택한 차량 연결용
	public GliderDTO gliderDTO;
	public ItemDTO itemDTO;
	public TireDTO tireDTO;
	// 생성자(자동 -> 기본생성자)
//	public MemberDTO(){
//		this.loginStatus = false;
//	}
	// 메서드 -> 서비스에 위임
	@Override
	public String toString() {
		return nickName + "님의 캐릭터는 " + characterDTO + "이고 \n 카트구성은 " + cartDTO+"\n 글라이더는 "
				+ gliderDTO+"\n 사용 아이템은 " + itemDTO+"\n 사용 타이어는 " + tireDTO+"\n" + "입니다.";
	}

}
