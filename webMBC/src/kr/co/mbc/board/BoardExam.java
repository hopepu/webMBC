package kr.co.mbc.board;

import java.time.LocalDateTime;
import java.util.Scanner;

import kr.co.mbc.board.DTO.AccountDTO;
import kr.co.mbc.board.DTO.BoardDTO;
import kr.co.mbc.board.DTO.ComentDTO;
import kr.co.mbc.board.DTO.FileBoardDTO;
import kr.co.mbc.board.DTO.FileComentDTO;
import kr.co.mbc.board.DTO.FreeBoardDTO;
import kr.co.mbc.board.DTO.FreeComentDTO;
import kr.co.mbc.board.DTO.ItemBoardDTO;
import kr.co.mbc.board.DTO.ItemComentDTO;
import kr.co.mbc.board.DTO.MovieBoardDTO;
import kr.co.mbc.board.DTO.MovieComentDTO;
import kr.co.mbc.board.SV.AccountSV;
import kr.co.mbc.board.SV.BoardSV;

public class BoardExam {

	public static Scanner input = new Scanner(System.in);
	public static AccountDTO[] accountDTOs = new AccountDTO[100];
	public static FileBoardDTO[] fileDTOs = new FileBoardDTO[1000];
	public static FreeBoardDTO[] freeDTOs = new FreeBoardDTO[1000];
	public static ItemBoardDTO[] itemDTOs = new ItemBoardDTO[1000];
	public static MovieBoardDTO[] movieDTOs = new MovieBoardDTO[1000];
	public static FileComentDTO[] fileComents = new FileComentDTO[10000];
	public static FreeComentDTO[] freeComents = new FreeComentDTO[10000];
	public static ItemComentDTO[] itemComents = new ItemComentDTO[10000];
	public static MovieComentDTO[] movieComents = new MovieComentDTO[10000];
	public static ComentDTO[] comentDTOs = new ComentDTO[10000];
	public static BoardDTO[] boardDTOs = new BoardDTO[1000];
	public static AccountDTO lSt = new AccountDTO();
	
	static {
		AccountDTO adDTO = new AccountDTO();//관리자 객체
		adDTO.setId("999");
		adDTO.setPw("999");
		adDTO.setName("master");
		adDTO.setlStatus(false);
		adDTO.setAdminLisence(true);//관리권한
		accountDTOs[99] = adDTO;
		
		AccountDTO acDTO0 = new AccountDTO();//테스터 1
		acDTO0.setId("1");
		acDTO0.setPw("1");
		acDTO0.setName("tester1");
		acDTO0.setSsn("1");
		acDTO0.setAddress("수원");
		acDTO0.setlStatus(false);
		accountDTOs[0] = acDTO0;
		
		AccountDTO acDTO1 = new AccountDTO();//테스터 2
		acDTO1.setId("2");
		acDTO1.setPw("2");
		acDTO1.setName("tester2");
		acDTO1.setSsn("2");
		acDTO1.setAddress("수원");
		acDTO1.setlStatus(false);
		accountDTOs[1] = acDTO1;
		
		FileBoardDTO fiDTO0 = new FileBoardDTO();//파일게시판 1
		fiDTO0.setAccountDTO(acDTO1);
		fiDTO0.setNo(1);
		fiDTO0.setDate(LocalDateTime.now());
		fiDTO0.setKind("자바");
		fiDTO0.setOs("윈도우");
		fiDTO0.setTitle("게시판");
		fiDTO0.setContents("파일");
		fileDTOs[0]=fiDTO0;
		
		FileBoardDTO fiDTO1 = new FileBoardDTO();//파일게시판 2
		fiDTO1.setAccountDTO(acDTO1);
		fiDTO1.setNo(2);
		fiDTO1.setDate(LocalDateTime.now());
		fiDTO1.setKind("자바");
		fiDTO1.setOs("linux");
		fiDTO1.setTitle("게시판");
		fiDTO1.setContents("파일");
		fileDTOs[1]=fiDTO1;
		
		FreeBoardDTO feDTO0 = new FreeBoardDTO();//자유게시판 1
		feDTO0.setAccountDTO(acDTO1);
		feDTO0.setNo(1);
		feDTO0.setDate(LocalDateTime.now());
		feDTO0.setPurpose("잡담");
		feDTO0.setTitle("잡담");
		feDTO0.setContents("MBC학원의 김기원 선생님은 짱이다!");
		freeDTOs[0]=feDTO0;
		
		FreeBoardDTO feDTO1 = new FreeBoardDTO();//자유게시판 2
		feDTO1.setAccountDTO(acDTO1);
		feDTO1.setNo(2);
		feDTO1.setDate(LocalDateTime.now());
		feDTO1.setPurpose("공지");
		feDTO1.setTitle("공지");
		feDTO1.setContents("7월부터 팀짜서 공부합니다!");
		freeDTOs[1]=feDTO1;
		
		ItemBoardDTO itemDTO0 = new ItemBoardDTO();//중고거래게시판 1
		itemDTO0.setAccountDTO(acDTO1);
		itemDTO0.setNo(1);
		itemDTO0.setDate(LocalDateTime.now());
		itemDTO0.setTitle("아이폰");
		itemDTO0.setContents("리퍼상태인 아이폰 팝니다 급처!");
		itemDTO0.setAd("서울");
		itemDTO0.setPrice(5000000);
		itemDTOs[0]=itemDTO0;
		
		ItemBoardDTO itemDTO1 = new ItemBoardDTO();//중고거래판
		itemDTO1.setAccountDTO(acDTO1);
		itemDTO1.setNo(2);
		itemDTO1.setDate(LocalDateTime.now());
		itemDTO1.setTitle("교재");
		itemDTO1.setContents("공부하고 싶은 아이들 여기서 사라!");
		itemDTO1.setAd("수원");
		itemDTO1.setPrice(5000);
		itemDTOs[1]=itemDTO1;
		
		MovieBoardDTO movieDTO0 = new MovieBoardDTO();
		movieDTO0.setAccountDTO(acDTO1);
		movieDTO0.setNo(1);
		movieDTO0.setDate(LocalDateTime.now());
		movieDTO0.setTitle("MBC 아카데미아");
		movieDTO0.setContents("아무것도 모르는 학생이 전설의 프로그래머가 되기까지의 여정");
		movieDTO0.setCategory("판타지");
		movieDTO0.setDirector("김기원");
		movieDTO0.setActor("학생1, 학생2, 학생3");
		movieDTOs[0]=movieDTO0;
		
		MovieBoardDTO movieDTO1 = new MovieBoardDTO();
		movieDTO1.setAccountDTO(acDTO1);
		movieDTO1.setNo(2);
		movieDTO1.setDate(LocalDateTime.now());
		movieDTO1.setTitle("파묘");
		movieDTO1.setContents("무덤에 얽힌 진실");
		movieDTO1.setCategory("판타지");
		movieDTO1.setDirector("ㅇㅇ");
		movieDTO1.setActor("배우1, 배우2, 배우3");
		movieDTOs[1]=movieDTO1;
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		System.out.println("===========MBC 게시판============");
		boolean run = true;
		while (run) {
			System.out.println("메뉴를 골라주세요!");
			System.out.println("1. 회원관리 | 2. 게시판 | 3. 종료");
			int select = input.next().charAt(0);
			switch (select) {
			case 49:
				System.out.println("회원관리 메뉴로 이동합니다.");
				lSt=AccountSV.menu(input, accountDTOs, lSt);

				break;
			case 50:
				if(lSt.islStatus()==true) {
				System.out.println("게시판 메뉴로 이동합니다.");
				BoardSV.menu(input, lSt, fileDTOs, freeDTOs, itemDTOs, movieDTOs, boardDTOs, fileComents, freeComents, itemComents, movieComents, comentDTOs);
				} else {
					System.out.println("로그인이 필요합니다.");
				}
					
				break;
			case 51:
				System.out.println("프로그램을 종료합니다.");
				run=false;
				break;
			default:
				System.out.println("1~3을 입력해주시기 바랍니다.");
				
			}// switch close

		} // while close

	} // main close

} // class close