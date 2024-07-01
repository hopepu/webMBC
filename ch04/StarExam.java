package ch04;

import java.util.Scanner;

public class StarExam {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int len = input.nextInt();
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < i; j++) {
			System.out.print(" ");
			}
			for (int j = 0; j < (2*len)-1-(i*2); j++) {
				System.out.print("*");
				
			}
			System.out.println("");
		}
		
	}

}
