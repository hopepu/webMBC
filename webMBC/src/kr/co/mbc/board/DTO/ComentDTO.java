package kr.co.mbc.board.DTO;

import java.time.LocalDateTime;

public class ComentDTO {
	private String coment;
	private LocalDateTime date;
	private String title;
	
	AccountDTO accountDTO;
	BoardDTO boardDTO;
	
	
	
	
	public AccountDTO getAccountDTO() {
		return accountDTO;
	}
	public BoardDTO getBoardDTO() {
		return boardDTO;
	}
	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}
	public void setBoardDTO(BoardDTO boardDTO) {
		this.boardDTO = boardDTO;
	}
	
	public String getComent() {
		return coment;
	}
	public LocalDateTime getDate() {
		return date;
	}
	
	public void setComent(String coment) {
		this.coment = coment;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	

}
