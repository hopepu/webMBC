package ch06.Board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Board { // 보드 객체용
	// 필드
	int bno; // 게시물 번호
	String title; // 게시물 제목
	String content; // 내용
	String nickName; // 별명(작성자)
	String regDate; // 작성일

	// 생성자

	// 메서드

	public void read(Scanner input, Board[] boards, LoginStatus lSt) {

		System.out.println("조회하실 글의 번호를 입력해주세요");
		System.out.print(">>>");
//		System.out.println(boards[0].bno);
		int boardNum = input.nextInt();
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				if (boards[i].bno == boardNum) {
					System.out.println("글 번호 : " + boards[i].bno + "  작성일 : " + boards[i].regDate);
					System.out.println("글 제목 : " + boards[i].title);
					System.out.println("글 쓴이 : " + boards[i].nickName);
					System.out.println(boards[i].content);
					System.out.println("=============================================");
					break;
				} // if 종료
			} // if 종료

		} // for 종료

	}// read 매서드 종료

	public Board write(Scanner input, Board[] boards, LoginStatus lSt) {
		Board newBoard = new Board();
		System.out.println("게시하실 글의 제목을 적어주세요.");
		String title = input.next();
		System.out.println("게시하실 글을 적어주세요");
		String content = input.next();
		System.out.println("이대로 게시하시겠습니까?");
		System.out.println("1.Y | 2.N");
		int select = input.nextInt();
		switch (select) {
		case 1:
			newBoard.nickName = lSt.nickName;
			newBoard.content = content;
			newBoard.title = title;
			newBoard.regDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
			newBoard.bno = 0;
			System.out.println("게시판에 저장되었습니다.");
			System.out.println("=============================================");
			break;

		case 2:
			System.out.println("게시판으로 돌아갑니다.");
			System.out.println("=============================================");
			break;

		default:
			System.out.println("1~2를 입력해주시기 바랍니다");

		}// 스위치 종료
		return newBoard;

	} // write 매서드 종료

	private void modifyB(Scanner input, Board[] boards, LoginStatus lSt) {
		System.out.println("수정하실 글의 번호를 입력해주세요");
		System.out.print(">>>");
		int boardNum = input.nextInt();
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				if (boards[i].nickName == lSt.nickName) {
					System.out.println("수정 사항을 다음에서 골라주세요.");
					System.out.println("1. 제목");
					System.out.println("2. 내용");
					System.out.println("3. 수정 취소");
					System.out.println(">>>");
					int select = input.nextInt();
					switch (select) {
					case 1:
						System.out.println("현재 글의 제목은 " + boards[i].title + "입니다.");
						System.out.println("수정하실 제목을 써주세요");
						String modify = input.next();
						boards[i].title = modify;
						System.out.println("성공적으로 수정되었습니다.");
						System.out.println("=============================================");
						break;

					case 2:
						System.out.println("현재 글의 내용은 " + boards[i].content + "입니다.");
						System.out.println("수정하실 내용을 써주세요");
						String modify2 = input.next();
						boards[i].content = modify2;
						System.out.println("성공적으로 수정되었습니다.");
						System.out.println("=============================================");
						break;

					case 3:
						System.out.println("게시판으로 돌아갑니다.");
						break;

					default:
						System.out.println("1~3를 입력해주세요");
					}

					break;
				} else {
					System.out.println("대상 글의 글쓴이는 " + lSt.nickName + "이 아니라서 수정할 권한이 없습니다.");
					break;
				} // if 종료
			} // if 종료

		} // for 종료

	} // modifyB method close

	private void delete(Scanner input, Board[] boards, LoginStatus lSt) {
		System.out.println("수정하실 글의 번호를 입력해주세요");
		System.out.print(">>>");
		int boardNum = input.nextInt();
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				if (boards[i].nickName == lSt.nickName) {
					System.out.println("이 글을 삭제하시겠습니까?");
					int select = input.nextInt();
					System.out.println("1.Y | 2.N");
					switch (select) {
					case 1:
						boards[i] = null;
						System.out.println("게시글이 삭제되었습니다.");
						System.out.println("=============================================");
						break;

					case 2:

						System.out.println("게시판으로 돌아갑니다.");
						System.out.println("=============================================");
						break;

					default:
						System.out.println("1~2를 입력해주세요");
					}

					break;
				} else {
					System.out.println("대상 글의 글쓴이는 " + lSt.nickName + "이 아니라서 수정할 권한이 없습니다.");
					break;
				}
			}
		}

	}

	public void menuB(Scanner input, Board[] boards, Member[] members, LoginStatus lSt) {

		boolean run = true;
		System.out.println("---- 회원 전용 게시판 입니다. ----");
		while (run) {
			for (int i = 0; i < boards.length; i++) {
				if (boards[i] != null) {
					System.out.print((i + 1) + "    " + boards[i].title + "    " + boards[i].nickName + "    "
							+ boards[i].regDate);
					boards[i].bno = (int) (i + 1);
					System.out.println("");
//					System.out.println(boards[i].bno + "값이 안들어가는거니");
				} else {
					System.out.println("----이후 글이 존재하지 않습니다.----");
					break;
				}
			} // for 종료
			System.out.println("1. 게시글 조회");
			System.out.println("2. 글쓰기");
			System.out.println("3. 글수정");
			System.out.println("4. 글삭제");
			System.out.println("5. 메인메뉴로 돌아가기");
			System.out.print(">>>");
			int select = input.nextInt();
			switch (select) {
			case 1:
				System.out.println("게시글을 조회합니다.");
				read(input, boards, lSt);
				break;
			case 2:
				System.out.println("새 글을 작성합니다.");
				Board newboard = write(input, boards, lSt);
				for (int i = 0; i < boards.length; i++) {
					if (boards[i] == null) {
						boards[i] = newboard;
//						System.out.println(boards[i].title + "객체가 배열에 저장됨");
						break;
					}
				}
				break;
			case 3:
				System.out.println("글을 수정합니다.");
				modifyB(input, boards, lSt);
				break;
			case 4:
				System.out.println("글을 삭제합니다.");
				delete(input, boards, lSt);
				break;
			case 5:
				System.out.println("메인 메뉴로 돌아갑니다.");
				run = false;
				break;
			default:
				System.out.println("1~5사이의 메뉴를 선택해주시기바랍니다.");
			} // switch 종료

		} // while 종료

	} // 메서드 종료

} // 클래스 종료
