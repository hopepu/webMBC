package kr.co.mbc.bank.dto;

import java.sql.Date;

public class BreakdownDTO {
	public static final char[] toString = null;
	//필드
	private long amount;
	private long tAmount;
	private long aNo;	
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	
	
	
	//생성자
	
	
	//메서드

	
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public long getAmount() {
		return amount;
	}
	public long getaNo() {
		return aNo;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public void setaNo(long aNo) {
		this.aNo = aNo;
	}
	@Override
	public String toString() {
		return "BreakdownDTO [amount=" + amount + ", aNo=" + aNo + ", year=" + year + ", month=" + month + ", day="
				+ day + ", hour=" + hour + ", minute=" + minute + "]";
	}
	public long gettAmount() {
		return tAmount;
	}
	public void settAmount(long tAmount) {
		this.tAmount = tAmount;
	}
	
	

}
