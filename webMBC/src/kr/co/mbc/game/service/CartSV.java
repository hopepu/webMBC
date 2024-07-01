package kr.co.mbc.game.service;

import java.util.Scanner;

import kr.co.mbc.game.dto.CartDTO;
import kr.co.mbc.game.dto.CharacterDTO;
import kr.co.mbc.game.dto.GliderDTO;
import kr.co.mbc.game.dto.ItemDTO;
import kr.co.mbc.game.dto.MemberDTO;
import kr.co.mbc.game.dto.TireDTO;

public class CartSV {
	// 필드

	// 생성자

	// 메서드
	public MemberDTO menu(Scanner input, CharacterDTO[] characterDTOs, MemberDTO loginState, CartDTO[] cartDTOs,
			GliderDTO[] gliderDTOs, TireDTO[] tireDTOs, ItemDTO[] itemDTOs) {
		boolean run = true;
		while (run) {
			System.out.println("카트관리 항목입니다. 아래에서 변경할 옵션을 선택해주세요");
			System.out.println("1. 캐릭터 | 2. 카트 | 3. 글라이더 | 4. 타이어 | 5. 아이템 | 6. 메인으로 돌아가기");
			System.out.println(">>>");
			int select = input.next().charAt(0);
			switch (select) {
			case 49:
				System.out.println("캐릭터 관리 항목입니다.");
				character(input, characterDTOs, loginState);
				break;
			case 50:
				System.out.println("캐릭터 관리 항목입니다.");
				cart(input, cartDTOs, loginState);
				break;
			case 51:
				System.out.println("캐릭터 관리 항목입니다.");
				glider(input, gliderDTOs, loginState);
				break;
			case 52:
				System.out.println("캐릭터 관리 항목입니다.");
				tier(input, tireDTOs, loginState);
				break;
			case 53:
				System.out.println("캐릭터 관리 항목입니다.");
				item(input, itemDTOs, loginState);
				break;
			case 54:
				System.out.println("메인으로 돌아갑니다.");
				run = false;
				break;

			default:
				System.out.println("1~6을 골라주세요");
			} // switch close

		} // while close
		return loginState;

	} // menu close

	private void item(Scanner input, ItemDTO[] itemDTOs, MemberDTO loginState) {
		// 아이템 선택 매서드

		for (int i = 0; i < itemDTOs.length; i++) {
			if (itemDTOs[i] != null) {
				System.out.println((i + 1) + ". " + itemDTOs[i].toString());
			} // if close
		} // for close
		System.out.println("아이템을 선택하세요.");
		System.out.print(">>>");
		String selectChar = input.next();
		for (int i = 0; i < itemDTOs.length; i++) {
			if (itemDTOs[i] != null && (itemDTOs[i].name.equals(selectChar)||i==((int)selectChar.charAt(0)-49))) {
				loginState.itemDTO = itemDTOs[i];
				// 키보드로 선택한 캐릭터 정보를 로그인한 객체에 연결!!!
			}// if close
		} // for close
		System.out.println(loginState.nickName + "님은 " + loginState.itemDTO.name + "을 선택하셨습니다.");



	}

	private void tier(Scanner input, TireDTO[] tireDTOs, MemberDTO loginState) {
		// 타이어 선택 메서드

		for (int i = 0; i < tireDTOs.length; i++) {
			if (tireDTOs[i] != null) {
				System.out.println((i + 1) + ". " + tireDTOs[i].toString());
			} // if close
		} // for close
		System.out.println("타이어를 선택하세요.");
		System.out.print(">>>");
		String selectChar = input.next();
		for (int i = 0; i < tireDTOs.length; i++) {
			if (tireDTOs[i] != null && (tireDTOs[i].name.equals(selectChar)||i==((int)selectChar.charAt(0)-49))) {
				loginState.tireDTO = tireDTOs[i];
				// 키보드로 선택한 캐릭터 정보를 로그인한 객체에 연결!!!
			} // if close
		} // for close
		System.out.println(loginState.nickName + "님은 " + loginState.tireDTO.name + "을 선택하셨습니다.");


	}

	private void glider(Scanner input, GliderDTO[] gliderDTOs, MemberDTO loginState) {
		// 글라이드 선택 메서드

		for (int i = 0; i < gliderDTOs.length; i++) {
			if (gliderDTOs[i] != null) {
				System.out.println((i + 1) + ". " + gliderDTOs[i].toString());
			} // if close
		} // for close
		System.out.println("글라이더을 선택하세요.");
		System.out.print(">>>");
		String selectChar = input.next();
		for (int i = 0; i < gliderDTOs.length; i++) {
			if (gliderDTOs[i] != null && (gliderDTOs[i].name.equals(selectChar)||i==((int)selectChar.charAt(0)-49))) {
				loginState.gliderDTO = gliderDTOs[i];
				// 키보드로 선택한 캐릭터 정보를 로그인한 객체에 연결!!!
			}// if close
		} // for close
		System.out.println(loginState.nickName + "님은 " + loginState.gliderDTO.name + "을 선택하셨습니다.");


	}

	private void cart(Scanner input, CartDTO[] cartDTOs, MemberDTO loginState) {
		// 카트 선택 메서드

		for (int i = 0; i < cartDTOs.length; i++) {
			if (cartDTOs[i] != null) {
				System.out.println((i + 1) + ". " + cartDTOs[i].toString());
			} // if close
		} // for close
		System.out.println("차량을 선택하세요.");
		System.out.print(">>>");
		String selectChar = input.next();
		for (int i = 0; i < cartDTOs.length; i++) {
			if (cartDTOs[i] != null && (cartDTOs[i].name.equals(selectChar)||i==((int)selectChar.charAt(0)-49))) {
				loginState.cartDTO = cartDTOs[i];
				// 키보드로 선택한 캐릭터 정보를 로그인한 객체에 연결!!!
			}// if close
		} // for close
		System.out.println(loginState.nickName + "님은 " + loginState.cartDTO.name + "을 선택하셨습니다.");
	} // cart close

	private void character(Scanner input, CharacterDTO[] characterDTOs, MemberDTO loginState) {
		// 캐릭터 선택 메서드
		for (int i = 0; i < characterDTOs.length; i++) {
			if (characterDTOs[i] != null) {
				System.out.println((i + 1) + ". " + characterDTOs[i].toString());
			} // if close
		} // for close
		System.out.println("캐릭터를 선택하세요.");
		System.out.print(">>>");
		String selectChar = input.next();

		for (int i = 0; i < characterDTOs.length; i++) {
			if (characterDTOs[i] != null && (characterDTOs[i].name.equals(selectChar)||i==((int)selectChar.charAt(0)-49))) {
				loginState.characterDTO = characterDTOs[i];
				// 키보드로 선택한 캐릭터 정보를 로그인한 객체에 연결!!!

			}// if close

		} // for close
		System.out.println(loginState.nickName + "님은 " + loginState.characterDTO.name + "을 선택하셨습니다.");

	}// character close

} // class close
