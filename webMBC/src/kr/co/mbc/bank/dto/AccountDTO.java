package kr.co.mbc.bank.dto;

public class AccountDTO {
	//필드
	private int aNo; //계좌번호
	private int aPw; //계좌비밀번호
	private long balance; //계좌 잔액
	
	private MemberDTO memberDTOs; //계좌주인 정보 연결
	private BreakdownDTO breakdownDTOs; // 입금 출금 송금 내역 연결
	//생성자
	
	
	//메서드
	public int getaNo() {
		return aNo;
	}
	public int getaPw() {
		return aPw;
	}
	public long getBalance() {
		return balance;
	}
	public void setaNo(int aNo) {
		this.aNo = aNo;
	}
	public void setaPw(int aPw) {
		this.aPw = aPw;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public MemberDTO getMemberDTOs() {
		return memberDTOs;
	}
	public BreakdownDTO getBreakdownDTOs() {
		return breakdownDTOs;
	}
	public void setMemberDTOs(MemberDTO memberDTOs) {
		this.memberDTOs = memberDTOs;
	}
	public void setBreakdownDTOs(BreakdownDTO breakdownDTOs) {
		this.breakdownDTOs = breakdownDTOs;
	}
	
	
	

}
