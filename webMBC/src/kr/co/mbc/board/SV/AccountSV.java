package kr.co.mbc.board.SV;

import java.util.Scanner;

import kr.co.mbc.board.DTO.AccountDTO;

public class AccountSV {

	public static AccountDTO menu(Scanner input, AccountDTO[] accountDTOs, AccountDTO lSt) {
		// 회원관리 메뉴
		boolean run = true;
		while (run) {
			System.out.println("아래의 메뉴에서 선택해주세요.");
			System.out.println("1. 로그인 | 2. 계정생성 | 3. 계정정보수정 | 4. 계정삭제 | 5. 계정관리종료");
			System.out.print(">>>");
			int select = input.next().charAt(0);
			switch (select) {
			case 49:
				System.out.println("로그인 메뉴입니다.");
				lSt = login(input, lSt, accountDTOs);
				break;
			case 50:
				System.out.println("계정생성 메뉴입니다.");
				if (lSt.islStatus() != true) {
					create(input, accountDTOs);
				} else {
					System.out.println("로그인이 되어있습니다.");
				}
				break;
			case 51:
				if (lSt.islStatus() == true) {
					System.out.println("계정정보수정 메뉴입니다.");
					lSt = modify(input, lSt, accountDTOs);
				} else {
					System.out.println("로그인이 필요합니다.");
				}
				break;
			case 52:
				if (lSt.islStatus() == true) {
					System.out.println("계정삭제 메뉴입니다.");
					lSt = delete(input, lSt, accountDTOs);
				} else {
					System.out.println("로그인이 필요합니다.");
				}
				break;
			case 53:
				System.out.println("메인메뉴로 돌아갑니다.");
				run = false;
				break;
			default:
				System.out.println("1~5을 입력해주시기 바랍니다.");

			}// switch close
		} // while close

		return lSt;

	} // menu close

	private static AccountDTO delete(Scanner input, AccountDTO lSt, AccountDTO[] accountDTOs) {
		System.out.println("계정을 삭제하시겠습니까?");
		System.out.println("1. 네 | 2. 아니오");
		int select = input.next().charAt(0);
		switch (select) {
		case 49:
			for (int i = 0; i < accountDTOs.length; i++) {
				if (accountDTOs[i] != null) {
					if (accountDTOs[i].getId().equals(lSt.getId()) && accountDTOs[i].getPw().equals(lSt.getPw())) {
						accountDTOs[i] = null;
						lSt.setId(null);
						lSt.setName(null);
						lSt.setPw(null);
						lSt.setAddress(null);
						lSt.setSsn(null);
						lSt.setpNo(null);
						lSt.setlStatus(false);
						break;
					} // if close

				} // if close 비어있지 않는 배열 찾음

			} // for close
			System.out.println("계정이 삭제되었습니다.");
			break;
		case 50:
			break;
		default:
			System.out.println("1~2에서 골라주세요.");
		}
		return lSt;
	}

	private static AccountDTO modify(Scanner input, AccountDTO lSt, AccountDTO[] accountDTOs) {
		// 계정수정메뉴
		System.out.println(lSt.getId() + "님의 정보는 아래와 같습니다.");
		search(lSt, accountDTOs);
		System.out.println("6. 종료하기");
		System.out.println("어떤 정보를 바꾸시겠습니까?");
		int select = input.next().charAt(0);
		switch (select) {
		case 49:
			System.out.println("변경하실 정보를 입력해주세요.");
			System.out.print(">>>");
			lSt.setName(input.next());
			change(lSt, accountDTOs);
			break;
		case 50:
			System.out.println("변경하실 정보를 입력해주세요.");
			System.out.print(">>>");
			lSt.setSsn(input.next());
			change(lSt, accountDTOs);
			break;
		case 51:
			System.out.println("변경하실 정보를 입력해주세요.");
			System.out.print(">>>");
			lSt.setpNo(input.next());
			change(lSt, accountDTOs);
			break;
		case 52:
			System.out.println("변경하실 정보를 입력해주세요.");
			System.out.print(">>>");
			lSt.setAddress(input.next());
			change(lSt, accountDTOs);
			break;
		case 53:
			System.out.println("변경하실 정보를 입력해주세요.");
			System.out.print(">>>");
			lSt.setPw(input.next());
			change(lSt, accountDTOs);
			break;
		case 54:
			System.out.println("로그인 메뉴로 돌아갑니다.");
			break;
		default:
			System.out.println("1~4를 골라주시기 바랍니다.");

		}
		return lSt;
	}

	private static void change(AccountDTO lSt, AccountDTO[] accountDTOs) {
		for (int i = 0; i < accountDTOs.length; i++) {
			if (accountDTOs[i] != null) {
				if (accountDTOs[i].getId().equals(lSt.getId())) {
					accountDTOs[i] = lSt;
					break;
				} // if close

			} // if close 비어있지 않는 배열 찾음

		} // for close

	} // change close

	private static void search(AccountDTO lSt, AccountDTO[] accountDTOs) {
		// 계정정보 출력 로그인된 정보를 출력
		System.out.println("1.  이 름  : " + lSt.getName());
		System.out.println("2. 주민번호 : " + lSt.getSsn());
		System.out.println("3. 전화번호 : " + lSt.getpNo());
		System.out.println("4.  주 소  : " + lSt.getAddress());
		System.out.println("5. 비밀번호 : " + lSt.getPw());

	}

	private static void create(Scanner input, AccountDTO[] accountDTOs) {
		AccountDTO accountDTO = new AccountDTO();// 정보 입력용 어카운트 객체 생성
		System.out.println("아래에 정보를 입력해주세요");
		boolean run = true;
		while(run) {
		System.out.print("ID(닉네임) : ");
		accountDTO.setId(input.next()); // 정보 입력용 객체 데이터 입력
		run = idCheck(accountDTOs, accountDTO, run);
		}//while close 아이디 같은것이 있는지 내부 확인코드
		
		System.out.print("PW : ");
		accountDTO.setPw(input.next()); // 정보 입력용 객체 데이터 입력
		System.out.print("이름 : ");
		accountDTO.setName(input.next()); // 정보 입력용 객체 데이터 입력
		System.out.print("주민번호 : ");
		accountDTO.setSsn(input.next()); // 정보 입력용 객체 데이터 입력
		System.out.print("전화번호 : ");
		accountDTO.setpNo(input.next()); // 정보 입력용 객체 데이터 입력
		System.out.print("주소 : ");
		accountDTO.setAddress(input.next()); // 정보 입력용 객체 데이터 입력
		accountDTO.setlStatus(false);
		
		
		register(accountDTOs, accountDTO);

	} // create close

	private static boolean idCheck(AccountDTO[] accountDTOs, AccountDTO accountDTO, boolean run) {
		// 아이디 동일 객체 있는지 확인용
		for(int i = 0; i<accountDTOs.length ; i++) {
			if(accountDTOs[i]!=null) {
			if(accountDTOs[i].getId().equals(accountDTO.getId())) {
				run = true;
				System.out.println("동일한 id가 존재합니다 다른 id를 입력하세요");
				break;
			} else {
				run = false;
			} // 동일한 id가 존재할경우 run을 트루값으로 돌려줘서 id 재 입력 
			  // 중복 id가 없을경우 run을 false로 돌려줘서 계정가입 진행
			}//if close 배열의 null값 회피용
		}//for close
		return run;
	}//if close

	private static void register(AccountDTO[] accountDTOs, AccountDTO accountDTO) {
		// 가입정보 객체 등록용
		for (int i = 0; i < accountDTOs.length; i++) {
			if (accountDTOs[i] == null) {// 비어있으면 등록
					accountDTOs[i] = accountDTO;
					System.out.println(accountDTOs[i].getName() + "님 가입을 환영합니다.");
					break;
			}//if close
		} // for close				
	} // register close

	private static AccountDTO login(Scanner input, AccountDTO lSt, AccountDTO[] accountDTOs) {
		if (lSt.islStatus() != true) {
			System.out.print("ID : ");
			lSt.setId(input.next()); // 로그인 배열에 아이디에 값을 입력
			System.out.print("PW : ");
			lSt.setPw(input.next()); // 로그인 배열에 비밀번호에 값을 입력

			lSt = find(lSt, accountDTOs);
			if (lSt.getName() != null) {// 로그인 배열의 이름이 비어있지 않은 경우 진행
				lSt.setlStatus(true);// 로그인 상태임을 나타내는 논리값
			} else {
				System.out.println("아이디와 비밀번호를 다시 확인해주시기 바랍니다.");
			}

		} else {
			System.out.println("이미 로그인이 되어있습니다.");
		}
		return lSt; // 갱신된 로그인 배열을 상위로 돌려줌.
	} // login close

	private static AccountDTO find(AccountDTO lSt, AccountDTO[] accountDTOs) {
		// 아이디와 패스워드로 배열 속 정보 찾기
		for (int i = 0; i < accountDTOs.length; i++) {
			if (accountDTOs[i] != null) {
				if (accountDTOs[i].getId().equals(lSt.getId()) && accountDTOs[i].getPw().equals(lSt.getPw())) {
					lSt = accountDTOs[i];
					System.out.println("로그인에 성공하였습니다." + lSt.getId() + "님 환영합니다.");
					break;
				} // if close

			} // if close 비어있지 않는 배열 찾음

		} // for close

		return lSt;
	} // find close
} // class close
