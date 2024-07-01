package kr.co.mbc.bank.dto;

public class MemberDTO {
	// 필드
	private String id;
	private String pw;
	private String name;
	private int phoneNo;
	private boolean lStatus;

	// 생성자

	// 메서드
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public int getPhoneNo() {
		return phoneNo;
	}
	
	public boolean getlStatus() {
		return lStatus;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;

	}

	public void islStatus(boolean lStatus) {
		this.lStatus = lStatus;
	}

	@Override
	public String toString() {
		return "귀하가 입력하신 정보는 다음과 같습니다."+"\n"
				+"아이디 :"+ id+"\n"
				+"패스워드 :" + pw+"\n"
				+"이름 :" + name+"\n"
				+"전화번호 :" + phoneNo+"\n";
	}

}
