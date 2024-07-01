package kr.co.mbc.board.DTO;

import java.sql.Date;

public class AccountDTO {
	
	private String id;
	private String pw;
	private String name;
	private String ssn;
	private String pNo;
	private String address;
	private boolean lStatus;
	private boolean adminLisence;
	
	
	
	public boolean isAdminLisence() {
		return adminLisence;
	}
	public void setAdminLisence(boolean adminLisence) {
		this.adminLisence = adminLisence;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getName() {
		return name;
	}
	public String getSsn() {
		return ssn;
	}
	public String getpNo() {
		return pNo;
	}
	public String getAddress() {
		return address;
	}
	public boolean islStatus() {
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
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setlStatus(boolean lStatus) {
		this.lStatus = lStatus;
	}

}
