package kr.co.mbc.board.DTO;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BoardDTO {
	//필드
	private int no;
	private String title;
	private String contents;
	private LocalDateTime date;

	AccountDTO accountDTO;
	//메서드
	public int getNo() {
		return no;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		
		this.date = date;
		
	}

	

}
