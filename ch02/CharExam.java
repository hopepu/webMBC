package ch02;

public class CharExam {

	public static void main(String[] args) {
		// 유니코드는 0~65535 숫자에 글자테이블을 매핑하여 문자를 출력해준다.
		// char는 2byte 처리가 되며 작은 따옴표로 처리 해야 한다.
		
		char c1 = 75;
		char c2 = 105;
		char c3 = 109;
		System.out.print(c1);				
		System.out.print(c2);
		System.out.println(c3);

	}

}
