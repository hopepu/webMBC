package kr.co.mbc.board.DTO;

public class MovieBoardDTO extends BoardDTO{
	private String category;
	private String director;
	private String actor;
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public String getActor() {
		return actor;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}

}
