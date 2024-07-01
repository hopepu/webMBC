package kr.co.mbc.game;

import java.util.Scanner;

import kr.co.mbc.game.dto.CartDTO;
import kr.co.mbc.game.dto.CharacterDTO;
import kr.co.mbc.game.dto.GliderDTO;
import kr.co.mbc.game.dto.ItemDTO;
import kr.co.mbc.game.dto.MemberDTO;
import kr.co.mbc.game.dto.TireDTO;
import kr.co.mbc.game.service.CartSV;
import kr.co.mbc.game.service.MemberSV;
import kr.co.mbc.game.service.PlaySV;

//마리오카트 게임프로젝트
// mvc 패턴(현직에서 쓰이는 구조)으로 프로젝트 구현
// dto : (Data Trasnfer Object, 데이터 전송 객체) 객체처리 -> new
// service : 부메뉴용(객체와 객체를 연결하여 서비스 제공)
// start : 배열과 주메뉴용

public class MarioKartExam {
	// 필드
	public static Scanner input = new Scanner(System.in); // 키보드 입력
	public static MemberDTO[] memberDTOs = new MemberDTO[10]; // 회원 배열
	public static CharacterDTO[] characterDTOs = new CharacterDTO[15]; // 캐릭터 배열
	public static CartDTO[] cartDTOs = new CartDTO[8]; // 카트 배열
	public static GliderDTO[] gliderDTOs = new GliderDTO[10]; // 글라이더 배열
	public static TireDTO[] tireDTOs = new TireDTO[10]; // 타이어 배열
	public static ItemDTO[] itemDTOs = new ItemDTO[10]; // 아이템 배열
	
	public static MemberDTO loginState ; // 로그인상태 유지
	
//	MemberSV memberService;(나중에 사용해보자)

	// 생성자 -> static에는 필요없음 (new가 필요없음)
	static {
		CharacterDTO characterDTO00 = new CharacterDTO("마리오", 3.0, 4.5, 3.7, 4.1, 3.8);
		CharacterDTO characterDTO01 = new CharacterDTO("루이지", 4.0, 4.4, 3.3, 4.0, 3.5);
		CharacterDTO characterDTO02 = new CharacterDTO("와리오", 4.8, 3.7, 4.7, 3.1, 4.8);
		CharacterDTO characterDTO03 = new CharacterDTO("피치", 2.8, 3.5, 4.7, 3.1, 4.8); //객체 생성완료
		characterDTOs[0] = characterDTO00;
		characterDTOs[1] = characterDTO01;
		characterDTOs[2] = characterDTO02;
		characterDTOs[3] = characterDTO03; //character DTO 배열에 삽입 완료
		
		CartDTO cartDTO00 = new CartDTO("바이크", 2.0, 3.0, 3.5, 6.0, 4.0);
		CartDTO cartDTO01 = new CartDTO("레이싱카", 4.0, 4.0, 4.5, 3.0, 3.0);
		CartDTO cartDTO02 = new CartDTO("SUV", 4.5, 3.5, 3.7, 4.0, 4.0);
		CartDTO cartDTO03 = new CartDTO("로켓", 10.0, 7.0, 10.0, 2.0, 1.0);
		cartDTOs[0] = cartDTO00;
		cartDTOs[1] = cartDTO01;
		cartDTOs[2] = cartDTO02;
		cartDTOs[3] = cartDTO03; //cart DTO 배열에 삽입 완료
		
		GliderDTO gliderDTO00 = new GliderDTO("낙하산", 1.2,1.0,0,0.4,0);
		GliderDTO gliderDTO01 = new GliderDTO("부스터", 3.0,2.0,3.0,1.0,0);
		GliderDTO gliderDTO02 = new GliderDTO("로켓", 4.0,3.0,4.0,0,0);
		gliderDTOs[0] = gliderDTO00;
		gliderDTOs[1] = gliderDTO01;
		gliderDTOs[2] = gliderDTO02; // glider DTO 배열에 삽입 완료
		
		TireDTO tireDTO00 = new TireDTO("고무", 0.4, 1.0, 1.0, 0.7, 0.8);
		TireDTO tireDTO01 = new TireDTO("돌", 2.4, 1.0, 1.0, 3.0, 4.5);
		TireDTO tireDTO02 = new TireDTO("나무", 0.1, 0.8, 0.6, 1.7, 2.0);
		tireDTOs[0] = tireDTO00;
		tireDTOs[1] = tireDTO01;
		tireDTOs[2] = tireDTO02;
		
		ItemDTO itemDTO00 = new ItemDTO("부스터", "순간적으로 가속도를 얻는다.", 3);
		ItemDTO itemDTO01 = new ItemDTO("미사일", "내 앞에 있는 사람을 일시적으로 멈추게한다.", 2);
		ItemDTO itemDTO02 = new ItemDTO("자석", "내 앞에 있는 사람을 끌어당긴다", 3);
		ItemDTO itemDTO03 = new ItemDTO("버내나", "바닥에 설치하여 밟은 사람이 미끄러진다.", 5);
		itemDTOs[0] = itemDTO00;		
		itemDTOs[1] = itemDTO01;
		itemDTOs[2] = itemDTO02;
		itemDTOs[3] = itemDTO03;
				
		
				
	} // 스태틱 블럭 -> 스태틱으로 만든 클랫의 초기값 배정

	// 메서드
	public static void main(String[] args) {
		loginState = new MemberDTO();

		System.out.println("========마리오 카트 게임을 시작합니다.========");
		boolean run = true; // 처음 구동
		while (run) {
			System.out.println("1. 회원관리 | 2. 카트관리 | 3. 게임실행 | 4. 종료");
			System.out.print(">>>");
//			int select = input.nextInt(); // 숫자가 아닌경우 오류발생함.(차후처리)
			int select = (int)(input.next().charAt(0));
//			System.out.println(select);
			
			switch (select) {
			case 49:
//				System.out.println("회원관리 클래스로 진입합니다.");
				MemberSV memberSV = new MemberSV(); //회원관리용 객체 생성
				loginState = memberSV.menu(input, memberDTOs, loginState); // 서비스의 메뉴 호출(스캐너 객체 전달)
				break;

			case 50:
				if(loginState.loginStatus == true) {
//				System.out.println("카트관리 클래스로 진입합니다.");
				CartSV cartSV = new CartSV();
				loginState = cartSV.menu(input, characterDTOs, loginState, cartDTOs, gliderDTOs, tireDTOs, itemDTOs);
				
				} else {
					System.out.println("로그인부터 하세요.");
				}//if close
				break;

			case 51:
				if(loginState.loginStatus == true) {
//				System.out.println("게임실행 클래스로 진입합니다.");
				if(loginState.cartDTO!=null&&loginState.characterDTO!=null&&loginState.gliderDTO!=null&&loginState.tireDTO!=null&&loginState.itemDTO!=null) {
					PlaySV.menu(input,  characterDTOs, loginState, cartDTOs, gliderDTOs, tireDTOs, itemDTOs);
					break;	
				} else {
					System.out.println("선택된 카트가 없습니다. 카트관리에서 카트를 선택해주시기 바랍니다.");
					break;
				}//if close
				} else {
					System.out.println("로그인부터 하세요.");
				} // if close
				break;
				

			case 52:
				System.out.println("종료합니다.");
				loginState.loginStatus=false;
				System.out.println(loginState.nickName+"님 안녕히가세요");
				run = false;
				break;

			default:
				System.out.println("1~4를 입력해주시기 바랍니다.");

			} // switch close

		} // while close

	} // main() close

} // MarioKartExam class close
