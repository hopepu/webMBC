package ch04;

import java.util.Scanner;

public class DoWhileExam {

	public static void main(String[] args) {
		// 업엔다운 게임 만들기
		// 컴퓨터가 랜덤 숫자를 생성한다 50
		// 사용자가 숫자를 입력한다.
		// 컴퓨터가 랜덤숫자를 판단하여 업 또는 다운을 알려준다.
		// 사용자의 숫자와 컴퓨터의 랜덤숫자가 일치하면 프로그램 종료와 함께 당첨 사실을 알린다.

		int answer = (int) (Math.random() * 49 + 1);
		System.out.println(answer);

		Scanner input = new Scanner(System.in);

		int question = 0;

		int i = 0;

		do {
			if (i < 3 && i >= 0) {
				System.out.println("1~50까지의 숫자를 입력해주세요." + (3-i) + "번안에 맞춰주세요");
				question = input.nextInt(); // 사용자가 숫자를 키보드로 입력 한다.
				i++;
				
				if (question < answer) { // 사람이 쓴 숫자가 크니 답은 아래쪽에 있다.
					System.out.println(question + "보다 위입니다.");
				
				} else if (question > answer) { // 사람이 쓴 숫자가 작으니 답은 위쪽에 있다.
					System.out.println(question + "보다 아래입니다.");
								}
			} // 3번안에 맞추기 if
			else {
				System.out.println("기회가 소진되었습니다.");
				System.out.println("You lose! 정답은" + answer);
				i++;
				break;
			}

		} while (question != answer);
		// 랜덤숫자와 입력숫자가 같지 않을경우 do 문으로 올라감.
		
		switch (i) {
		case 1:
			System.out.println("정답입니다 You, Win!!!!!" + answer);
			System.out.println(i+"번만에 맞추셨군요! 경품 100만원");
		case 2:
			System.out.println("정답입니다 You, Win!!!!!" + answer);
			System.out.println(i+"번만에 맞추셨군요! 경품 50만원");
		case 3:
			System.out.println("정답입니다 You, Win!!!!!" + answer);
			System.out.println(i+"번만에 맞추셨군요! 경품 10만원");
			
		} 
	}

}
