package ch08.lineage.DTO;

public class AccountDTO {
	//필드
	private String id;
	private String pw;
	private String nickname;
//	private ElfDTO elfDTO; //요정객체
//	private KnightDTO knightDTO; //기사객체
	private HumanDTO humanDTO;
	
	//생성자
	
	//메서드

	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getNickname() {
		return nickname;
	}
//	public ElfDTO getElfDTO() {
//		return elfDTO;
//	}
//	public KnightDTO getKnightDTO() {
//		return knightDTO;
//	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
//	public void setElfDTO(ElfDTO elfDTO) {
//		this.elfDTO = elfDTO;
//	}
//	public void setKnightDTO(KnightDTO knightDTO) {
//		this.knightDTO = knightDTO;
//	}
	public HumanDTO getHumanDTO() {
		return humanDTO;
	}
	public void setHumanDTO(HumanDTO humanDTO) {
		this.humanDTO = humanDTO;
	}

}
