package ch06.ScoresCard;

import java.util.Scanner;

public class ScoresMainExam {
//	필드 -> 맴버 변수로 main에서 사용할 배열이나 객체등을 생성
	private static Scanner input = new Scanner(System.in);
	// 현 클래스 내에서 호출되어 사용함
	// 메인에서는 privat static 을 써야 객체를 한개씩 생성
	private static Student[] st = new Student[5];// 학생 객체용으로 5칸 배열 생성함/
//	String[] string = new String[5];	

//	생성자 -> main일 경우  new를 사용하지 않음(정적 static 으로 사용하지 않음.

//	메서드

	public static void main(String[] args) {
//		주실행 클래스로 메뉴와 클래스.메서드 호출용으로 작업
//		객체 : 학생, 성적, 통계....
		boolean run = true; // 반복실행 시작

		while (run) { // 종료 run = false;
			System.out.println("===========학생관리프로그램v2(객체)===========");
			System.out.println("1. 학생관리 | 2. 성적입력  | 3. 통계 | 4. 종료");
			System.out.println("========================================");
			System.out.print(">>>");

			int select = input.nextInt(); // 객체 사용전에 private static 확인 필수
			switch (select) {
			case 1:
				System.out.println("학생관리 클래스로 진입");
				boolean strun = true;
				while (strun) {
					System.out.println("1. 학생등록 | 2. 학생조회 | 3. 학생수정 | 4. 학생삭제 | 5.메인메뉴");
					System.out.print(">>>");
					int stSelect = input.nextInt();
					switch (stSelect) {
					case 1:
						System.out.println("학생등록 메뉴입니다.");
						Student regStudent = new Student(); // 객체생성
						System.out.println("이름 : ");
						regStudent.name = input.next(); // 키보드로 받은 이름
						System.out.println("학번 : ");
						regStudent.num = input.nextInt(); // 키보드로 받은 학번
						System.out.println("성별 : ");
						regStudent.sex = input.next(); // 키보드로 받은 성별
						System.out.println("학년 : ");
						regStudent.grade = input.nextInt(); // 키보드로 받은 학년
						System.out.println("반 : ");
						regStudent.classroom = input.nextInt(); // 키보드로 받은 반
						System.out.println("====== 객체 생성 -> 입력 완료 ======");
						System.out.println("======= 배열 빈칸을 찾아 저장 =======");
						for (int i = 0; i < st.length; i++) {
							if (st[i] == null) {// st배열의 빈칸 찾기
								st[i] = regStudent;// 위에 만든 객체를 넣음
								System.out.println("save complete!");
								break; // 저장 후 종료
							} // st[i]가 null일때 입력 if close

						} // for close : null find
						break;

					case 2:
						System.out.println("전체학생 보기");
						for (int i = 0; i < st.length; i++) {
							if (st[i] != null) {
								System.out.println("===================");
								System.out.println("이름 : " + st[i].name);
								System.out.println("학번 : " + st[i].num);
								System.out.println("성별 : " + st[i].sex);
								System.out.println("학년 : " + st[i].grade);
								System.out.println("반 : " + st[i].classroom);
							} // if문 종료
						} // for st배열 전체 반복
						break; // 학생보기 정지

					case 3:
						System.out.println("학생수정 메뉴입니다.");
						System.out.println("수정할 학생 이름을 검색하세요");
						System.out.print(">>>");
						String searchName = input.next();
						Student findStudent = find(searchName); // 아래 만든 메서드
						if (findStudent == null) {
							System.out.println("찾은 학생이 없습니다.");
						} else {
							System.out.println("수정할 학생 번호를 입력하세요.");
							findStudent.num = input.nextInt();
							System.out.println("학생 정보 수정 완료");
						} // if else close
						break;

					case 4:
						System.out.println("삭제할 학생명을 입력하세요");
						System.out.print(">>>");
						String deleteName = input.next();
						Student deleteStudent = find(deleteName); // 아래 만든 메서드
						if (deleteStudent == null) {
							System.out.println("찾은 학생이 없습니다.");
						} else {
							for(int i=0; i<st.length; i++) {
								if(st[i].name.equals(deleteStudent.name)) {
									st[i]=null;
									System.out.println("삭제완료!!!!");
									break;
								}
							
							System.out.println("학생 정보 삭제 완료");
							}//for close
						} // if else close
						break;
						
					case 5 :
						System.out.println("메인메뉴로 돌아갑니다.");
						strun = false;
						

					default:
						System.out.println("1~5까지만 입력해주세요");

					}// case1 switch close

				} // case1 while close

				break;

			case 2:
				System.out.println("성적관리 클래스로 진입");
				break;

			case 3:
				System.out.println("통계 클래스로 진입");
				break;

			case 4:
				System.out.println("성적표 프로그램 종료");
				run = false;
				break;

			default:
				System.out.println("잘못된 입력입니다 1~4사이의 메뉴를 입력해주세요.");
				// break 작성하면 종료
			}// switch(주메뉴) close

		} // while close

	} // main close

	private static Student find(String name) {
		// 이름으로 객체를 찾아오는 메서드 -> 리턴은 Student 객체
		Student student = null; // 빈객체 생성
		for (int i = 0; i < st.length; i++) {
			if (st[i] != null) {
				String arrayName = st[i].name; // 배열에 있는 이름을 가져옴
				if (arrayName.equals(name)) { // 배열name과 키보드 name 비교
					student = st[i];
					break;
				} // if 종료
			} // if문 종료
		} // for close

		return student; // 리턴객체 생성
	}// find 메서드 종료

} // class close
