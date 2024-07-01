package kr.co.mbc.board.SV;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.time.LocalDate;
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

public class BoardSV {
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH : mm");

	public static void menu(Scanner input, AccountDTO lSt, FileBoardDTO[] fileDTOs, FreeBoardDTO[] freeDTOs,
			ItemBoardDTO[] itemDTOs, MovieBoardDTO[] movieDTOs, BoardDTO[] boardDTOs, FileComentDTO[] fileComents,
			FreeComentDTO[] freeComents, ItemComentDTO[] itemComents, MovieComentDTO[] movieComents,
			ComentDTO[] comentDTOs) {
		System.out.println("MBC 게시판에 어서오세요! 접속하실 게시판을 선택해주세요");
		boolean run = true;
		while (run) {
			System.out.println("1. 자유게시판");
			System.out.println("2. 프로그램게시판");
			System.out.println("3. 중고거래게시판");
			System.out.println("4. 영화게시판");
			System.out.println("5. 종료하기");
			System.out.print(">>>");
			int select = input.next().charAt(0);
			switch (select) {
			case 49:
				System.out.println("자유게시판입니다.");
				free(input, freeDTOs, boardDTOs, lSt, freeComents, comentDTOs);
				break;
			case 50:
				System.out.println("프로그램게시판입니다.");
				file(input, fileDTOs, boardDTOs, lSt, fileComents, comentDTOs);
				break;
			case 51:
				System.out.println("중거거래게시판입니다.");
				item(input, itemDTOs, boardDTOs, lSt, itemComents, comentDTOs);
				break;
			case 52:
				System.out.println("영화게시판입니다.");
				movie(input, movieDTOs, boardDTOs, lSt, movieComents, comentDTOs);
				break;
			case 53:
				System.out.println("메인메뉴로 돌아갑니다.");
				run = false;
				break;
			default:
				System.out.println("1~5 사이에서 골라주세요");

			}// switch close

		} // while close

	}// menu close

	private static void movie(Scanner input, MovieBoardDTO[] movieDTOs, BoardDTO[] boardDTOs, AccountDTO lSt,
			ComentDTO[] movieComents, ComentDTO[] comentDTOs) {
		// TODO Auto-generated method stub
		System.out.println("영화정보를 공유하는 게시판입니다.");
		boardDTOs = movieDTOs; // 보드 배열에 무비 배열을 연결 -> 무비배열의 객체를 보드배열의 객체로 출력가능 메서드의 범용화
		comentDTOs = movieComents;
		sort(boardDTOs); // 배열의 시간 오름차순으로 정렬
		find(boardDTOs); // 배열 리스트 출력
		System.out.println("글을 작성하고 싶으시면 0을 입력해주세요");
		System.out.println(">>>");

		int i = choice(input, 0); // 조회할 데이터 번호 입력하여 i값으로 유지.

		if (i == -1) {// i 값은 배열에 맞게 출력하였기에 0부터 시작, -1은 입력값으로 0을 넣었을때 choice 메서드를 통해서 도출되는 값
			movieWrite(input, movieDTOs, lSt);// 새로운 글 작성 코드
		} else {
			System.out.println("감독 이름 : " + movieDTOs[i].getDirector()); // 자식 배열만 가지고 있는 요소
			System.out.println("출연 배우 : " + movieDTOs[i].getActor());// 자식 배열만 가지고 있는 요소
			read(boardDTOs, i); // 부모 배열의 요소를 통하여 자식 배열의 값을 출력
			System.out.println("=========================");
			coments(comentDTOs, i, boardDTOs);
			if (lSt.getName() == boardDTOs[i].getAccountDTO().getName()) {// 작성자와 로그인 이름 정보가 같을 경우 실행
				readAfter(input, boardDTOs, i); // 수정과 삭제의 메서드
			} else {
				if (lSt.isAdminLisence() == true) { // 작성자의 이름이 같지 않더라도 관리자 권한이 존재할경우 진행
					adDelete(input, boardDTOs, i); // 게시글 삭제 메서드
				} else {
					movieComentsWrite(input, lSt, movieComents, boardDTOs, i);}
					// if close
			} // if close 작성자와 로그인이 같을 경우 열리는 선택지 글의 수정과 삭제 관련

		} // if close 입력값이 0일 경우 새로운 글 입력 글의 번호 입력시 내부 내용 조회 가능

	}

	private static void movieComentsWrite(Scanner input, AccountDTO lSt, ComentDTO[] movieComents, BoardDTO[] boardDTOs,
			int i) {
		MovieComentDTO comentDTO = new MovieComentDTO();
		System.out.println("댓글을 다시겠습니까?");
		System.out.println("1. 네 | 2. 아니오");
		int select = input.next().charAt(0);
		switch (select) {
		case 49:

			System.out.print("댓글 : ");
			comentDTO.setComent(input.next());
			comentDTO.setDate(LocalDateTime.now()); // 작성 시간 추출하여 date 값에 입력
			comentDTO.setAccountDTO(lSt);// 작성자의 계정 정보 입력
			comentDTO.setTitle(boardDTOs[i].getTitle());

			for (int j = 0; j < movieComents.length; j++) { // 빈칸에 객체 삽입
				if (movieComents[j] == null) {
					movieComents[j] = comentDTO;
					break;
				} // if close
			} // for close
			break;
		case 50:
			break;
		default:
			System.out.println("1~2를 입력해주세요");
		}

		
		
	}

	private static void movieWrite(Scanner input, MovieBoardDTO[] movieDTOs, AccountDTO lSt) {
		MovieBoardDTO movieDTO = new MovieBoardDTO();
		System.out.print("감독이름 : ");
		movieDTO.setDirector(input.next());
		System.out.print("출연배우 : ");
		movieDTO.setActor(input.next());
		System.out.print("영화종류 : ");
		movieDTO.setCategory(input.next());
		System.out.print("타이틀 : ");
		movieDTO.setTitle(input.next());
		System.out.print("컨텐츠 : ");
		movieDTO.setContents(input.next());
		movieDTO.setDate(LocalDateTime.now()); // 작성 시간 추출하여 date 값에 입력
		movieDTO.setAccountDTO(lSt); // 작성자의 계정 정보 입력

		for (int i = 0; i < movieDTOs.length; i++) { // 빈 배열에 객체 생성
			if (movieDTOs[i] == null) {
				movieDTOs[i] = movieDTO;
				break;
			} // if close
		} // for close

	}

	private static void item(Scanner input, ItemBoardDTO[] itemDTOs, BoardDTO[] boardDTOs, AccountDTO lSt,
			ComentDTO[] itemComents, ComentDTO[] comentDTOs) {
		// TODO Auto-generated method stub
		System.out.println("파일을 공유하는 게시판입니다.");
		boardDTOs = itemDTOs; // 보드 부모 객체에 아이템 자식 객체 연결
		comentDTOs = itemComents;
		sort(boardDTOs); // 시간오름차순으로 비교하여 배열 정렬
		find(boardDTOs); // 리스트 출력

		System.out.println("글을 작성하고 싶으시면 0을 입력해주세요");
		System.out.println(">>>");

		int i = choice(input, 0); // 입력값을 choice 메서드를 통하여 i에 입력
		if (i == -1) {// i 값은 배열에 맞게 출력하였기에 0부터 시작, -1은 입력값으로 0을 넣었을때 choice 메서드를 통해서 도출되는 값
			itemWrite(input, itemDTOs, lSt);// 새로운 글 작성 코드
			
		} else {
			System.out.println("거래 지역 : " + itemDTOs[i].getAd());// 자식 배열만 가지고 있는 요소
			System.out.println("거래 가격 : " + itemDTOs[i].getPrice());// 자식 배열만 가지고 있는 요소
			read(boardDTOs, i); // 부모 배열의 요소를 통하여 자식 배열의 값을 출력
			System.out.println("=========================");
			coments(comentDTOs, i, boardDTOs);
			if (lSt.getName() == boardDTOs[i].getAccountDTO().getName()) {// 작성자와 로그인 이름 정보가 같을 경우 실행
				readAfter(input, boardDTOs, i);// 수정과 삭제의 메서드
			} else {
				if (lSt.isAdminLisence() == true) {// 작성자의 이름이 같지 않더라도 관리자 권한이 존재할경우 진행
					adDelete(input, boardDTOs, i);// 삭제 메서드
				} else {
					itemComentsWrite(input, lSt, itemComents, boardDTOs, i);//댓글 달고 데이터 삽입 메서드
				} // if close
			} // if close 작성자와 로그인이 같을 경우 열리는 선택지 글의 수정과 삭제 관련

		} // if close 입력값이 0일 경우 새로운 글 입력 글의 번호 입력시 내부 내용 조회 가능

	}

	private static void itemComentsWrite(Scanner input, AccountDTO lSt, ComentDTO[] itemComents, BoardDTO[] boardDTOs,
			int i) {
		ItemComentDTO comentDTO = new ItemComentDTO();
		System.out.println("댓글을 다시겠습니까?");
		System.out.println("1. 네 | 2. 아니오");
		int select = input.next().charAt(0);
		switch (select) {
		case 49:

			System.out.print("댓글 : ");
			comentDTO.setComent(input.next());
			comentDTO.setDate(LocalDateTime.now()); // 작성 시간 추출하여 date 값에 입력
			comentDTO.setAccountDTO(lSt);// 작성자의 계정 정보 입력
			comentDTO.setTitle(boardDTOs[i].getTitle());

			for (int j = 0; j < itemComents.length; j++) { // 빈칸에 객체 삽입
				if (itemComents[j] == null) {
					itemComents[j] = comentDTO;
					break;
				} // if close
			} // for close
			break;
		case 50:
			break;
		default:
			System.out.println("1~2를 입력해주세요");
		}
		
	}

	private static void itemWrite(Scanner input, ItemBoardDTO[] itemDTOs, AccountDTO lSt) {
		ItemBoardDTO itemDTO = new ItemBoardDTO();
		System.out.print("거래지역 : ");
		itemDTO.setAd(input.next());
		System.out.print("거래가격 : ");
		itemDTO.setPrice(input.nextInt());
		System.out.print("타이틀 : ");
		itemDTO.setTitle(input.next());
		System.out.print("컨텐츠 : ");
		itemDTO.setContents(input.next());
		itemDTO.setDate(LocalDateTime.now());
		itemDTO.setAccountDTO(lSt);

		for (int i = 0; i < itemDTOs.length; i++) {
			if (itemDTOs[i] == null) {
				itemDTOs[i] = itemDTO;
				break;
			} // if close
		} // for close

	}

	private static void file(Scanner input, FileBoardDTO[] fileDTOs, BoardDTO[] boardDTOs, AccountDTO lSt,
			ComentDTO[] fileComents, ComentDTO[] comentDTOs) {
		System.out.println("파일을 공유하는 게시판입니다.");
		boardDTOs = fileDTOs;// 보드 부모 객체에 아이템 자식 객체 연결
		comentDTOs = fileComents;
		sort(boardDTOs); // 시간오름차순으로 비교하여 배열 정렬
		find(boardDTOs); // 리스트 출력

		System.out.println("글을 작성하고 싶으시면 0을 입력해주세요");
		System.out.println(">>>");

		int i = choice(input, 0);// 입력값을 choice 메서드를 통하여 i에 입력
		if (i == -1) {// i 값은 배열에 맞게 출력하였기에 0부터 시작, -1은 입력값으로 0을 넣었을때 choice 메서드를 통해서 도출되는 값
			fileWrite(input, fileDTOs, lSt);// 새로운 글 작성 코드
		} else {
			System.out.println("프로그램 종류 : " + fileDTOs[i].getKind());// 자식 배열만 가지고 있는 요소
			System.out.println("적용 OS : " + fileDTOs[i].getOs());// 자식 배열만 가지고 있는 요소
			read(boardDTOs, i); // 부모 배열의 요소를 통하여 자식 배열의 값을 출력
			System.out.println("=========================");
			coments(comentDTOs, i, boardDTOs);
			if (lSt.getName() == boardDTOs[i].getAccountDTO().getName()) {// 작성자와 로그인 이름 정보가 같을 경우 실행
				readAfter(input, boardDTOs, i);// 수정과 삭제의 메서드
			} else {
				if (lSt.isAdminLisence() == true) {// 작성자의 이름이 같지 않더라도 관리자 권한이 존재할경우 진행
					adDelete(input, boardDTOs, i);// 삭제 메서드
				} else {
					fileComentsWrite(input, lSt, fileComents, boardDTOs, i);
				}// if close
			} // if close 작성자와 로그인이 같을 경우 열리는 선택지 글의 수정과 삭제 관련

		} // if close 입력값이 0일 경우 새로운 글 입력 글의 번호 입력시 내부 내용 조회 가능

	} // file close

	private static void fileComentsWrite(Scanner input, AccountDTO lSt, ComentDTO[] fileComents, BoardDTO[] boardDTOs,
			int i) {
		FileComentDTO comentDTO = new FileComentDTO();
		System.out.println("댓글을 다시겠습니까?");
		System.out.println("1. 네 | 2. 아니오");
		int select = input.next().charAt(0);
		switch (select) {
		case 49:

			System.out.print("댓글 : ");
			comentDTO.setComent(input.next());
			comentDTO.setDate(LocalDateTime.now()); // 작성 시간 추출하여 date 값에 입력
			comentDTO.setAccountDTO(lSt);// 작성자의 계정 정보 입력
			comentDTO.setTitle(boardDTOs[i].getTitle());

			for (int j = 0; j < fileComents.length; j++) { // 빈칸에 객체 삽입
				if (fileComents[j] == null) {
					fileComents[j] = comentDTO;
					break;
				} // if close
			} // for close
			break;
		case 50:
			break;
		default:
			System.out.println("1~2를 입력해주세요");
		}

		
	}

	private static void fileWrite(Scanner input, FileBoardDTO[] fileDTOs, AccountDTO lSt) {
		FileBoardDTO fileDTO = new FileBoardDTO();
		System.out.print("프로그램종류 : ");
		fileDTO.setKind(input.next());
		System.out.print("적용 OS : ");
		fileDTO.setOs(input.next());
		System.out.print("타이틀 : ");
		fileDTO.setTitle(input.next());
		System.out.print("컨텐츠 : ");
		fileDTO.setContents(input.next());
		fileDTO.setDate(LocalDateTime.now()); // 작성 시간 추출하여 date 값에 입력
		fileDTO.setAccountDTO(lSt);// 작성자의 계정 정보 입력

		for (int i = 0; i < fileDTOs.length; i++) { // 빈 배열에 객체 생성
			if (fileDTOs[i] == null) {
				fileDTOs[i] = fileDTO;
				break;
			} // if close
		} // for close
	}

	private static int choice(Scanner input, int i) {
		System.out.println("몇번글을 조회하시겠습까? 글을 작성하시려면 0을 눌러주세요");
		i = input.next().charAt(0) - 49; // 1은 49 2는 50 3은 51로 출력됨으로 49를 빼주면 숫자로 0부터 출력가능 이 숫자로 배열주소 참조
		return i;
	}

	private static void free(Scanner input, FreeBoardDTO[] freeDTOs, BoardDTO[] boardDTOs, AccountDTO lSt,
			ComentDTO[] freeComents, ComentDTO[] comentDTOs) {
		// 자유게시판
		System.out.println("자유롭게 글을 올리는 자유게시판입니다!");
		// 시간순 배열 정렬하기 메서드
		boardDTOs = freeDTOs; // 보드 배열에 free 배열을 연결 -> free배열의 객체를 보드배열의 객체로 출력가능 메서드의 범용화
		comentDTOs = freeComents;
		sort(boardDTOs);// 시간순 정렬
		find(boardDTOs); // freeDTOs값을 받아 부모 객체의 필드로만 리스트업

		System.out.println("글을 작성하고 싶으시면 0을 입력해주세요");
		System.out.println(">>>");

		int i = choice(input, 0); // 조회할 데이터 번호 입력하여 i값으로 유지.
		if (i == -1) {// i 값은 배열에 맞게 출력하였기에 0부터 시작, -1은 입력값으로 0을 넣었을때 choice 메서드를 통해서 도출되는 값
			freeWrite(input, freeDTOs, lSt);// 새로운 글 작성 코드
		} else {
			System.out.println(freeDTOs[i].getPurpose()); // 자식 배열만 가지고 있는 요소
			read(boardDTOs, i); // 부모 배열의 요소를 통하여 자식 배열의 값을 출력
			System.out.println("=========================");
			coments(comentDTOs, i, boardDTOs);
			if (lSt.getName() == boardDTOs[i].getAccountDTO().getName()) {
				readAfter(input, boardDTOs, i);// 수정과 삭제의 메서드
			} else {
				if (lSt.isAdminLisence() == true) {// 작성자의 이름이 같지 않더라도 관리자 권한이 존재할경우 진행
					adDelete(input, boardDTOs, i);// 게시글 삭제 메서드
				} else {

					freeComentsWrite(input, lSt, freeComents, boardDTOs, i);
				}
			} // if close 작성자와 로그인이 같을 경우 열리는 선택지 글의 수정과 삭제 관련

		} // if close 입력값이 0일 경우 새로운 글 입력 글의 번호 입력시 내부 내용 조회 가능

	}

	private static void freeComentsWrite(Scanner input, AccountDTO lSt, ComentDTO[] freeComents, BoardDTO[] boardDTOs,
			int i) {
		FreeComentDTO comentDTO = new FreeComentDTO();
		System.out.println("댓글을 다시겠습니까?");
		System.out.println("1. 네 | 2. 아니오");
		int select = input.next().charAt(0);
		switch (select) {
		case 49:

			System.out.print("댓글 : ");
			comentDTO.setComent(input.next());
			comentDTO.setDate(LocalDateTime.now()); // 작성 시간 추출하여 date 값에 입력
			comentDTO.setAccountDTO(lSt);// 작성자의 계정 정보 입력
			comentDTO.setTitle(boardDTOs[i].getTitle());

			for (int j = 0; j < freeComents.length; j++) { // 빈칸에 객체 삽입
				if (freeComents[j] == null) {
					freeComents[j] = comentDTO;
					break;
				} // if close
			} // for close
			break;
		case 50:
			break;
		default:
			System.out.println("1~2를 입력해주세요");

		}

	}

	private static void coments(ComentDTO[] comentDTOs, int i, BoardDTO[] boardDTOs) {
		for (int j = 0; j < comentDTOs.length; j++) {
			if (comentDTOs[j] != null) {
				if (boardDTOs[i].getTitle() == comentDTOs[j].getTitle()) {
					System.out.println("작성자 : " + comentDTOs[j].getAccountDTO().getId() + "| 작성 날짜 :"
							+ comentDTOs[j].getDate().format(formatter));
					System.out.println(comentDTOs[j].getComent());
				}
			}
		}

	}

	private static void adDelete(Scanner input, BoardDTO[] boardDTOs, int i) {
		// 관리자 계정으로 일반글 삭제 메서드
		System.out.println("이 글을 삭제하시겠습니까?");
		System.out.println("1. 삭제 | 2. 보류");
		int select = input.next().charAt(0) - 48;
		if (select == 1) {
			delete(input, boardDTOs, i);
		} else {
			System.out.println("게시판으로 돌아갑니다.");
		}

	}

	private static void readAfter(Scanner input, BoardDTO[] boardDTOs, int i) {
		System.out.println("1. 수정 | 2. 삭제 | 3. 종료 ");
		int select = input.next().charAt(0); // 스트링값으로 변경해서 인트값으로 받음 1 -> 49 2 -> 50 순으로 유니코드 출력
		switch (select) {
		case 49:
			System.out.println("게시판 수정입니다. 수정하실수 있는 항목은 아래와 같습니다.");
			System.out.println("1. 제목 | 2. 컨텐츠 | 3.게시판으로 돌아가기");
			int j = input.next().charAt(0);
			switch (j) {
			case 49:
				boardDTOs[i].setTitle(input.next());
				break;
			case 50:
				boardDTOs[i].setContents(input.next());
				break;
			case 51:
				System.out.println("게시판으로 돌아갑니다.");
				break;
			default:
				System.out.println("1~3을 입력해주세요");

			}// switch close

		case 50:
			System.out.println("글을 삭제하시겠습니까?");
			System.out.println("1. 네 | 2. 아니오");
			if (input.next().charAt(0) == 50) {
				delete(input, boardDTOs, i);
			} else {
				System.out.println("게시판으로 돌아갑니다.");
			}
			break;
		case 51:
			System.out.println("게시판으로 돌아갑니다.");
			break;
		default:
			System.out.println("1~3을 골라주세요.");

		} // switch close

	} // readAfter close

	private static void delete(Scanner input, BoardDTO[] boardDTOs, int i) {
		// 게시판 정보 삭제 메서드
		boardDTOs[i] = null;

	}

	private static void freeWrite(Scanner input, FreeBoardDTO[] freeDTOs, AccountDTO lSt) {
		FreeBoardDTO freeDTO = new FreeBoardDTO();
		System.out.print("글의 종류 : ");
		freeDTO.setPurpose(input.next());
		System.out.print("타이틀 : ");
		freeDTO.setTitle(input.next());
		System.out.print("컨텐츠 : ");
		freeDTO.setContents(input.next());
		freeDTO.setDate(LocalDateTime.now()); // 작성 시간 추출하여 date 값에 입력
		freeDTO.setAccountDTO(lSt);// 작성자의 계정 정보 입력

		for (int i = 0; i < freeDTOs.length; i++) { // 빈칸에 객체 삽입
			if (freeDTOs[i] == null) {
				freeDTOs[i] = freeDTO;
				break;
			} // if close
		} // for close
	} // freeWrite close

	private static void read(BoardDTO[] boardDTOs, int i) {
		// 보드 부모객체에 연결한 자식 객체의 정보를 부모객체의 구성요소로 프린트하기 위한 매서드

		System.out.println(boardDTOs[i].getNo() + ". " + boardDTOs[i].getTitle());
		System.out.println("작성자 : " + boardDTOs[i].getAccountDTO().getId() + "| 작성 날짜 :"
				+ boardDTOs[i].getDate().format(formatter));
		System.out.println(boardDTOs[i].getContents());

	}

	private static BoardDTO[] find(BoardDTO[] boardDTOs) {
		// 게시판 출력
		for (int i = 0; i < boardDTOs.length; i++) {
			if (boardDTOs[i] != null) {
				boardDTOs[i].setNo(i + 1);// 배열의 방 순서에 1을 더하여 글 번호 데이터 입력
				System.out.println(boardDTOs[i].getNo() + ". " + boardDTOs[i].getTitle());
				System.out.println("작성자 : " + boardDTOs[i].getAccountDTO().getId() + " | 작성 날짜 :"
						+ boardDTOs[i].getDate().format(formatter));// 시간데이터 나타낼때 년월일시간만 출력되게 형식 맞춤
			} else {
				System.out.println("더이상 글이 없습니다.");
				break;
			} // if close
		} // for close
		return boardDTOs;
	} // findAccount close

	private static void sort(BoardDTO[] boardDTOs) {
		// find 매서드 작동 전 배열에 있는 객체들을 시간순으로 오름차 정렬 시키는 매서드
		BoardDTO chDTO = new BoardDTO();
		for (int i = 0; i < boardDTOs.length; i++) {
			if (boardDTOs[i] != null) {
				for (int j = i + 1; j < boardDTOs.length; j++) {
					if (boardDTOs[j] != null) {
						if (boardDTOs[i].getDate().isBefore(boardDTOs[j].getDate())) {
							chDTO = boardDTOs[i];
							boardDTOs[i] = boardDTOs[j];
							boardDTOs[j] = chDTO;
						} // if close i배열의 시간이 j배열의 시간보다 전이냐
					} // if close j 배열이 빈칸이 아니라면
				} // j는 i다음칸부터 끝까지
			} // i 배열이 빈칸이 아니렴ㄴ
		} // i 처음부터 끝까지
	} // sort close 배열을 시간 오름차순으로 정렬

}// class close
