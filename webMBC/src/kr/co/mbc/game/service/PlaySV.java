package kr.co.mbc.game.service;

import java.util.Scanner;

import kr.co.mbc.game.dto.CartDTO;
import kr.co.mbc.game.dto.CharacterDTO;
import kr.co.mbc.game.dto.GliderDTO;
import kr.co.mbc.game.dto.ItemDTO;
import kr.co.mbc.game.dto.MemberDTO;
import kr.co.mbc.game.dto.TireDTO;

public class PlaySV {

	public static void menu(Scanner input, CharacterDTO[] characterDTOs, MemberDTO loginState, CartDTO[] cartDTOs,
			GliderDTO[] gliderDTOs, TireDTO[] tireDTOs, ItemDTO[] itemDTOs) {
		// 게임 실행
		System.out.println("게임 실행 코너입니다.");
		System.out.println(loginState.toString());
		System.out.println("주행을 시작합니다.");
		System.out.println("주행이 완료되었습니다.");
		
		
	}

}
