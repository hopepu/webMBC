package ch06.Board;

import java.util.Scanner;

public class BoardExam {

	public static Scanner input = new Scanner(System.in);
	public static Member[] members = new Member[100];
	public static Board[] boards = new Board[1000];
	public static LoginStatus lSt = new LoginStatus();

	public static void main(String[] args) {
		// 게시판을 구현해보자.
		// 객체는 2개(Member, Board)
		// 회원제용 게시판 구현용
		System.out.println("======회원제 게시판======");
		boolean run = true;
		while (run) {
			
			System.out.println("1. 회원관리 | 2. 게시판 | 3. 종료");
			System.out.print(">>>");
			int select = input.nextInt();
			switch (select) {
			case 1:
				System.out.println("회원관리 클래스로 진입합니다.");
				Member member = new Member(); // 빈 객체 생성
				member.menu(input, members, lSt);
				break;
				
			case 2:
				if (lSt.lstatus == true) {
					System.out.println("게시판 클래스로 진입합니다.");
					Board board = new Board();
					board.menuB(input, boards, members, lSt);
				} else {
					System.out.println("로그인이 필요합니다.");
					member = new Member(); 
					member.menu(input, members, lSt);
				}
				
				break;
				
			case 3:
				System.out.println("종료합니다.");
				run = false;
				break;
				
			default:
				System.out.println("1~3값만 입력하세요.");

			} // switch close
			
		} // while close
		
	} // main close

} // class close
