package ch08.lineage.service;

import java.util.Scanner;

import ch08.lineage.DTO.AccountDTO;
import ch08.lineage.DTO.ElfDTO;
import ch08.lineage.DTO.HumanDTO;
import ch08.lineage.DTO.KnightDTO;

public class CharacterService {
	// 객체를 이용하여 캐릭터 선택용 부메뉴

	public static void menu(Scanner scanner, AccountDTO loginAccount, KnightDTO knightDTO, ElfDTO elfDTO,
			HumanDTO humanDTO) {
		System.out.println("1. 기사 | 2. 요정 | 3. 마법사 | 4. 도적 | 5. 군주 | 6. 총사 | 7. 종료");
		System.out.print(">>>");
		int select = scanner.next().charAt(0);
		switch (select) {
		case 49:
			System.out.println("기사를 선택하셨습니다.");
			loginAccount.setHumanDTO(knightDTO);
			System.out
					.println(loginAccount.getNickname() + "님" + loginAccount.getHumanDTO().getName() + "캐릭터를 선택하셨습니다.");
//			loginAccount.setKnightDTO(knightDTO);
//			System.out.println(loginAccount.getNickname()+"님 "
//								+ loginAccount.getKnightDTO().getName()+" 캐릭터를 선택하셨습니다.");
			break;
		case 50:
			System.out.println("요정을 선택하셨습니다.");
			loginAccount.setHumanDTO(elfDTO);
			System.out.println(loginAccount.getNickname() + "님" + loginAccount.getHumanDTO().getName() + "캐릭터를 선택하셨습니다."
					+ loginAccount.getHumanDTO());
			break;

		case 51:
			System.out.println("마법사를 선택하셨습니다.");
			break;
		case 52:
			System.out.println("도적을 선택하셨습니다.");
			break;
		case 53:
			System.out.println("군주를 선택하셨습니다.");
			break;
		case 54:
			System.out.println("총사를 선택하셨습니다.");
			break;
		case 55:
			System.out.println("캐릭터 선택을 종료합니다.");
			break;
		default:
			System.out.println("1~7을 골라주세요");

		}

	} // 메뉴 메서드 종료

} // 클래스 종료
