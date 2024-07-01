package kr.co.mbc.bank;

import java.util.Scanner;

import kr.co.mbc.bank.dto.AccountDTO;
import kr.co.mbc.bank.dto.BreakdownDTO;
import kr.co.mbc.bank.service.AccountSV;
import kr.co.mbc.bank.service.MemberSV;
import kr.co.mbc.bank.dto.MemberDTO;

public class BankExam {
	public static Scanner input = new Scanner(System.in);
	public static MemberDTO[] memberDTOs = new MemberDTO[100];
	public static AccountDTO[] accountDTOs = new AccountDTO[300];
	public static BreakdownDTO[] breakdownDTOs = new BreakdownDTO[50000];
	public static MemberDTO loginDTO;

	public static void main(String[] args) {
		MemberDTO loginDTO = new MemberDTO();
		System.out.println("======= MBC BANK에 어서오세요 =======");
		loginDTO = MemberSV.menu(input, loginDTO, memberDTOs);
		AccountSV.menu(input, loginDTO, memberDTOs, accountDTOs, breakdownDTOs);
		System.out.println("안녕히 가십시요.");
	}// main close

}// class close
