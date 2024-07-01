package kr.co.mbc.board.DTO;

public class FileBoardDTO extends BoardDTO{
	private String kind;
	private String os;
	
	
	public String getKind() {
		return kind;
	}
	public String getOs() {
		return os;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setOs(String os) {
		this.os = os;
	}

}
