package ch08.lineage.service;

import java.util.Scanner;

import ch08.lineage.DTO.AccountDTO;

public class LoginService {
	// 로그인에 관한 부메뉴 용
	public static AccountDTO menu(Scanner scanner, AccountDTO[] accountDTOs, AccountDTO loginAccount) {
		System.out.println("1. 로그인 | 2. 회원가입 | 3. 회원수정 | 4. 빠져나가기");
		System.out.print(">>>");
		int select = scanner.next().charAt(0);
		switch (select) {
		case 49:
			System.out.println("로그인을 시작합니다.");
			System.out.print("id : ");
			String id = scanner.next();
			System.out.print("pw : ");
			String pw = scanner.next();
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setId(id);
			accountDTO.setPw(pw);
			for (int i = 0; i < accountDTOs.length; i++) {
				if (accountDTOs[i] != null) {
					if (accountDTOs[i].getId().equals(accountDTO.getId())) {
						System.out.println("해당하는 id가 있습니다.");
						if (accountDTOs[i].getPw().equals(accountDTO.getPw())) {
							loginAccount = accountDTOs[i];
							System.out.println("로그인에 성공했습니다.");
							break;
						} else {
							System.out.println("해당하는 pw가 없습니다.");
						} // if close
					} else {
						System.out.println("해당하는 id가 없습니다.");
					} // if close
				} else {
					System.out.println("해당하는 객체가 없습니다.");
					break;
				} // if close
			} // for close
			default :
				System.out.println("1~4를 선택해주세요");
		} // switch close
		return loginAccount;
	} // menu() method close
} // class close
