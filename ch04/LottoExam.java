package ch04;

import java.util.Scanner;

public class LottoExam {

	public static void main(String[] args) {
		//		정수 6개의 값을 입력받고 랜덤으로 6개의 값을 생성
		//		몇개가 맞았는지 파악

		// 로또 번호 입력 중복 숫자와 입력 오류 잡는 프로그램 기반

		Scanner input = new Scanner(System.in);
		boolean next = true;
		int myNum1 = 0;
		int myNum2 = 0;
		int myNum3 = 0;
		int myNum4 = 0;
		int myNum5 = 0;
		int myNum6 = 0;

		while (next = true) {
			System.out.print("첫번째 번호 : ");
			myNum1 = input.nextInt();
			if(myNum1 > 0 && myNum1 <= 45) {
				next = false;
				break;
			} else {System.out.println("입력이 잘못되었습니다. 다시 입력해주시기 바랍니다.");
			}}
		next=true;
		while (next = true) {
			System.out.print("두번째 번호 : ");
			myNum2 = input.nextInt();
			if(myNum2 > 0 && myNum2 <= 45 && myNum1 != myNum2) {
				next = false;
				break;
			} else {System.out.println("입력이 잘못되었습니다. 다시 입력해주시기 바랍니다.");
			}}
		next=true;
		while (next = true) {
			System.out.print("세번째 번호 : ");
			myNum3 = input.nextInt();
			if(myNum3 > 0 && myNum3 <= 45 && myNum1 != myNum3 && myNum2 != myNum3) {
				next = false;
				break;
			} else {System.out.println("입력이 잘못되었습니다. 다시 입력해주시기 바랍니다.");
			}}
		next=true;
		while (next = true) {
			System.out.print("네번째 번호 : ");
			myNum4 = input.nextInt();
			if(myNum4 > 0 && myNum4 <= 45 && myNum1 != myNum4 && myNum2 != myNum4 && myNum3 != myNum4) {
				next = false;
				break;
			} else {System.out.println("입력이 잘못되었습니다. 다시 입력해주시기 바랍니다.");
			}}
		next=true;
		while (next = true) {
			System.out.print("다섯번째 번호 : ");
			myNum5 = input.nextInt();
			if(myNum5 > 0 && myNum5 <= 45 && myNum1 != myNum5 && myNum2 != myNum5 && myNum3 != myNum5 && myNum4 != myNum5) {
				next = false;
				break;
			} else {System.out.println("입력이 잘못되었습니다. 다시 입력해주시기 바랍니다.");
			}}
		next=true;
		while (next = true) {
			System.out.print("여섯번째 번호 : ");
			myNum6 = input.nextInt();
			if(myNum6 > 0 && myNum6 <= 45 && myNum1 != myNum6 && myNum2 != myNum6 && myNum3 != myNum6 && myNum4 != myNum6 && myNum5 != myNum6){
				next = false;
				break;
			} else {System.out.println("입력이 잘못되었습니다. 다시 입력해주시기 바랍니다.");
			}}

		System.out.println(myNum1 + ", " + myNum2 + ", " + myNum3 + ", " + myNum4 + ", " + myNum5 + ", " + myNum6);

		int Num1 = 0;
		int Num2 = 0;
		int Num3 = 0;
		int Num4 = 0;
		int Num5 = 0;
		int Num6 = 0;

		while (next = true) {
			Num1 = (int)(Math.random()*45)+1;
			if(Num1 > 0 && Num1 <= 45) {
				next = false;
				break;
			} }
		System.out.println("첫번째 당첨 번호 : " + Num1);
		next=true;

		while (next = true) {
			Num2 = (int)(Math.random()*45)+1;
			if(Num2 > 0 && Num2 <= 45 && Num1 != Num2) {
				next = false;
				break;
			} }
		System.out.println("두번째 당첨 번호 : " + Num2);
		next=true;

		while (next = true) {
			Num3 = (int)(Math.random()*45)+1;
			if(Num3 > 0 && Num3 <= 45 && Num1 != Num3 && Num2 != Num3) {
				next = false;
				break;
			}}
		System.out.println("세번째 당첨 번호 : " + Num3);
		next=true;

		while (next = true) {
			Num4 =  (int)(Math.random()*45)+1;
			if(Num4 > 0 && Num4 <= 45 && Num1 != Num4 && Num2 != Num4 && Num3 != Num4) {
				next = false;
				break;
			}}
		System.out.println("네번째 당첨 번호 : " + Num4);
		next=true;

		while (next = true) {	
			Num5 =  (int)(Math.random()*45)+1;
			if(Num5 > 0 && Num5 <= 45 && Num1 != Num5 && Num2 != Num5 && Num3 != Num5 && Num4 != myNum5) {
				next = false;
				break;
			}}
		System.out.println("다섯번째 당첨 번호 : " + Num5);
		next=true;

		while (next = true) {
			Num6 = (int)(Math.random()*45)+1;
			if(Num6 > 0 && Num6 <= 45 && Num1 != Num6 && Num2 != Num6 && Num3 != Num6 && Num4 != Num6 && Num5 != Num6){
				next = false;
				break;
			}}
		System.out.println("여섯번째 당첨 번호 : " + Num6);		
		System.out.println(Num1 + ", " + Num2 + ", " + Num3 + ", " + Num4 + ", " + Num5 + ", " + Num6);

		int x = 0;
		if(myNum1 == Num1 || myNum2 == Num1 || myNum3 == Num1 || myNum4 == Num1 || myNum5 == Num1 || myNum6 == Num1) {
			++x;
		}
		if(myNum1 == Num2 || myNum2 == Num2 || myNum3 == Num2 || myNum4 == Num2 || myNum5 == Num2 || myNum6 == Num2) {
			++x;
		}
		if(myNum1 == Num3 || myNum2 == Num3 || myNum3 == Num3 || myNum4 == Num3 || myNum5 == Num3 || myNum6 == Num3) {
			++x;
		}
		if(myNum1 == Num4 || myNum2 == Num4 || myNum3 == Num4 || myNum4 == Num4 || myNum5 == Num4 || myNum6 == Num4) {
			++x;
		}
		if(myNum1 == Num5 || myNum2 == Num5 || myNum3 == Num5 || myNum4 == Num5 || myNum5 == Num5 || myNum6 == Num5) {
			++x;
		}
		if(myNum1 == Num6 || myNum2 == Num6 || myNum3 == Num6 || myNum4 == Num6 || myNum5 == Num6 || myNum6 == Num6) {
			++x;
		}

		if(x==0) {
			System.out.println("낙첨입니다 다음 기회를 노려주세요!");
		} else {
			System.out.println("당첨된 번호는 총 " + x + "개입니다! 축하드립니다~");	
		}


	}

}


