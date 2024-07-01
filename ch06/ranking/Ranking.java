package ch06.ranking;

public enum Ranking {
	// enum 타입은 열거 타입으로 자동으로 숫자 판단이 가능한 코드이다.
	// enum에 활용되는 부분은 제한된 문자열을 숫자로 판단하는 역할을 많이 함.
	// 열거 타입에 선언된 상수는 대문자로 사용함.(여러문자인 경우  _ 으로 구분함)
	
	
	GUEST,
	MEMBER,
	VIP,
	VVIP,
	VVVIP
	
}
