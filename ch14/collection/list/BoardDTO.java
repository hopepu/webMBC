package ch14.collection.list;

public class BoardDTO {
	// 필드
	private String subject; // 제목
	private String Contents; // 내용
	private String writer; // 작성자

	// 생성자 -> 기본생성자 없음
	public BoardDTO(){
		
	};

	public BoardDTO(String subject, String contents, String writer) {
		super();
		this.subject = subject;
		Contents = contents;
		this.writer = writer;
	}

	// 메서드

	public String getSubject() {
		return subject;
	}

	@Override
	public String toString() {
		return "BoardDTO [subject=" + subject + ", Contents=" + Contents + ", writer=" + writer + "]";
	}

	public String getContents() {
		return Contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContents(String contents) {
		Contents = contents;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

}
