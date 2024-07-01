package kr.co.mbc.bank.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import kr.co.mbc.bank.dto.AccountDTO;
import kr.co.mbc.bank.dto.BreakdownDTO;
import kr.co.mbc.bank.dto.MemberDTO;

public class AccountSV {
	static AccountDTO newAccountDTOs = new AccountDTO();
	static Date date;
	static Calendar cal = Calendar.getInstance();

	public static void menu(Scanner input, MemberDTO loginDTO, MemberDTO[] memberDTOs, AccountDTO[] accountDTOs,
			BreakdownDTO[] breakdownDTOs) {

		boolean run = true;
		System.out.println("진행하실 업무를 선택해주세요");
		while (run) {
			System.out.println("1. 계좌조회 | 2. 계좌개설 | 3. 예금 | 4. 출금 | 5. 송금 | 6. 종료하기");
			System.out.print(">>>");
			int select = input.next().charAt(0);
			switch (select) {
			case 49:
				System.out.println("보유하신 계좌를 조회합니다.");
				System.out.println(loginDTO.getName() + "님이 보유하신 계좌는 아래와 같습니다.");
				findAccount(input, loginDTO, memberDTOs, accountDTOs, run);
				searchAccount(input, loginDTO, memberDTOs, accountDTOs, breakdownDTOs);
				break;
			case 50:
				System.out.println("계좌를 개설합니다.");
				createAccount(input, loginDTO, memberDTOs, accountDTOs);
				break;
			case 51:
				System.out.println("예금합니다.");
				bank(input, loginDTO, accountDTOs, memberDTOs, breakdownDTOs);
				break;
			case 52:
				System.out.println("출금합니다.");
				withDraw(input, loginDTO, accountDTOs, memberDTOs, breakdownDTOs);
				break;
			case 53:
				System.out.println("송금합니다.");
				send(input, loginDTO, accountDTOs, breakdownDTOs);
				break;
			case 54:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("1~6을 입력해주세요");

			} // switch close

		} // while close 계좌관리 메뉴

	}

	private static void searchAccount(Scanner input, MemberDTO loginDTO, MemberDTO[] memberDTOs,
			AccountDTO[] accountDTOs, BreakdownDTO[] breakdownDTOs) {
		System.out.println("어떤 구좌를 조회하겠습니까? 구좌번호를 입력해주세요.");
		System.out.println(">>>");
		int aNo = input.nextInt();
		for (int i = 0; i < breakdownDTOs.length; i++) {
			if (breakdownDTOs[i] != null) {
				if (breakdownDTOs[i].getaNo() == aNo) {
					System.out.println(breakdownDTOs[i].getYear() + "." + breakdownDTOs[i].getMonth() + "."
							+ breakdownDTOs[i].getDay() + " " + breakdownDTOs[i].getHour() + ":"
							+ breakdownDTOs[i].getMinute() + " 입출금액 : " + breakdownDTOs[i].getAmount() + " 예금잔액 : "
							+ breakdownDTOs[i].gettAmount());
				} // if close
			} // if close
		} // for close
	}// searchAccount close

	private static void send(Scanner input, MemberDTO loginDTO, AccountDTO[] accountDTOs,
			BreakdownDTO[] breakdownDTOs) {
		System.out.println("추후 업데이트 하겠습니다.");

	}

	private static void withDraw(Scanner input, MemberDTO loginDTO, AccountDTO[] accountDTOs, MemberDTO[] memberDTOs,
			BreakdownDTO[] breakdownDTOs) {
		// 출금관련
		boolean pass = false;
		System.out.println("출금관련입니다. 귀하가 보유하신 구좌는 아래와 같습니다.");
		pass = findAccount(input, loginDTO, memberDTOs, accountDTOs, pass);
		if (pass) {
			System.out.println("어떤 구좌에서 출금하시겠습니까 구좌번호를 입력해주세요.");
			System.out.println(">>>");
			int aNo = input.nextInt();
			System.out.println("구좌의 비밀번호를 입력하세요");
			System.out.println(">>>");
			int pw = input.nextInt();
			boolean pass2 = false;
			pass2 = password(input, accountDTOs, aNo, pw, pass2);
			if (pass2) {
				System.out.println("얼마를 출금하시겠습니까?");
				System.out.println(">>>");
				long gBal = -(input.nextLong()); // 출금이라 입력값에 - 추가
				banking(input, loginDTO, accountDTOs, memberDTOs, breakdownDTOs, gBal, aNo);
			} else {
				System.out.println("구좌 또는 비밀번호가 틀렸습니다. 다시 확인해주시기 바랍니다.");
			} // if close
		} // if close

	}// withDraw close

	private static boolean password(Scanner input, AccountDTO[] accountDTOs, int aNo, int pw, boolean pass2) {
		// 계좌 통과용 패스워드 체크
		for (int i = 0; i < accountDTOs.length; i++) {
			if (accountDTOs[i] != null) {
				if (accountDTOs[i].getaPw() == pw && accountDTOs[i].getaNo() == aNo) {
					pass2 = true;
				} else {
					System.out.println(accountDTOs[i].getaPw()+accountDTOs[i].getaNo());
					pass2 = false;
				} // if close
			} // if close
		} // for close
		return pass2;
	} // password close

	private static void banking(Scanner input, MemberDTO loginDTO, AccountDTO[] accountDTOs, MemberDTO[] memberDTOs,
			BreakdownDTO[] breakdownDTOs, long gBal, long aNo) {

		for (int i = 0; i < accountDTOs.length; i++) {
			if (accountDTOs[i] != null && accountDTOs[i].getaNo() == aNo) {
				if (accountDTOs[i].getBalance() + gBal > 0) {
					long balance = accountDTOs[i].getBalance() + gBal;
					accountDTOs[i].setBalance(balance);
					save(gBal, aNo, loginDTO, date, cal, breakdownDTOs, balance);
					System.out.println("결과 내역");
					System.out.println(
							"계좌번호 : " + accountDTOs[i].getaNo() + "     예금잔액 : " + accountDTOs[i].getBalance());
					break;
				} else {
					System.out.println("잔액이 부족합니다.");
					System.out.println(accountDTOs[i].getBalance());
				} // if close
			}else {
				System.out.println("해당하는 계좌가 없습니다.");
				break;
			}
			// if close
		} // for close

	}

	private static void save(long gBal, long aNo, MemberDTO loginDTO, Date date2, Calendar cal,
			BreakdownDTO[] breakdownDTOs, long balance) {
		//

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		BreakdownDTO newBreakdownDTOs = new BreakdownDTO();
		newBreakdownDTOs.setaNo(aNo);
		newBreakdownDTOs.setAmount(gBal);
		newBreakdownDTOs.setYear(year);
		newBreakdownDTOs.setMonth(month);
		newBreakdownDTOs.setDay(day);
		newBreakdownDTOs.setHour(hour);
		newBreakdownDTOs.setMinute(minute);
		newBreakdownDTOs.settAmount(balance);
		for (int i = 0; i < breakdownDTOs.length; i++) {
			if (breakdownDTOs[i] == null) {
				breakdownDTOs[i] = newBreakdownDTOs;
//				System.out.println(breakdownDTOs[i].toString());
				break;
			}
		}

	}

	private static void bank(Scanner input, MemberDTO loginDTO, AccountDTO[] accountDTOs, MemberDTO[] memberDTOs,
			BreakdownDTO[] breakdownDTOs) {
		// 입금
		boolean pass = false;
		System.out.println("입금관련입니다. 귀하가 보유하신 구좌는 아래와 같습니다.");
		pass = findAccount(input, loginDTO, memberDTOs, accountDTOs, pass);
		if (pass) {
			System.out.println("어떤 구좌에 입금하시겠습니까 구좌번호를 입력해주세요.");
			System.out.println(">>>");
			long aNo = input.nextLong();
			System.out.println("얼마를 입금하시겠습니까?");
			System.out.println(">>>");
			long gBal = input.nextLong();
			banking(input, loginDTO, accountDTOs, memberDTOs, breakdownDTOs, gBal, aNo);
		} // if close

	}// bank close

	private static void createAccount(Scanner input, MemberDTO loginDTO, MemberDTO[] memberDTOs,
			AccountDTO[] accountDTOs) {
		System.out.println("계좌를 개설하시겠습니까?");
		System.out.println("1. 네 | 2. 아니오");
		int select = input.next().charAt(0);
		switch (select) {
		case 49:
			System.out.println("구좌에 사용하실 패스워드를 입력해주시기 바랍니다.");
			System.out.println(">>>>");
			int pw = input.nextInt();
			int aco = (int) Math.floor(Math.random() * 999900);
			newAccountDTOs.setaNo(aco);
			newAccountDTOs.setaPw(pw);
			newAccountDTOs.setBalance(0);
			newAccountDTOs.setMemberDTOs(loginDTO);
			for (int i = 0; i < accountDTOs.length; i++) {
				if (accountDTOs[i] == null) {
					accountDTOs[i] = newAccountDTOs;
					System.out.println("계좌번호 : " + accountDTOs[i].getaNo() + "예금잔액 : " + accountDTOs[i].getBalance());
					break;
				} // if close
			} // for close

		case 50:
			break;

		default:
			System.out.println("1~2를 골라주세요");

		}// while close
	}

	private static boolean findAccount(Scanner input, MemberDTO loginDTO, MemberDTO[] memberDTOs,
			AccountDTO[] accountDTOs, boolean pass) {
		// 보유 계좌 찾기
		for (int i = 0; i < accountDTOs.length; i++) {
			if (accountDTOs[i] != null) {
				if (accountDTOs[i].getMemberDTOs().getName().equals(loginDTO.getName())) {
					System.out.println(
							"계좌번호 : " + accountDTOs[i].getaNo() + "     예금잔액 : " + accountDTOs[i].getBalance());
					pass = true;

				} // if close
			} else {
				System.out.println("더이상 구좌가 없습니다.");
				break;
			} // if close
		} // for close
		return pass;
	} // findAccount close

}
