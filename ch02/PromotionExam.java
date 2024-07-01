package ch02;

public class PromotionExam {

	public static void main(String[] args) {
//		자동타입 변환(Promotion)은 작은 크기의 타입을 큰 크기 타입으로 자동 변환
//		byte 1 -> short 2 -> int 4 -> long 8 -> float 4 -> double 8
//		예를 들어 국,영,수,사,과 과목의 점수는 byte 처리 가능 ->  총점은 int -> 평균은 double
		
		byte kor = 80;
		byte eng = 100;
		byte math = 50;
		byte sol = 80;
		byte sci = 73;
		
		System.out.println("--------현재 점수표--------");
		System.out.println("------------------------");
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("사회 : " + sol);
		System.out.println("과학 : " + sci);
		
//		byte total = 0; 연산은 기본 타입은 int(자동 타입 변환)
		int total = 0;
		System.out.println("---------총   점---------");
		total = kor + eng + math + sol + sci;
		System.out.println("총 점 : " + total);
		
		System.out.println("---------평   균---------");
		double avg = 0;
		avg = total / 5;
		System.out.println("평 균 : " + avg);
		
		if(avg>=60) {
			System.out.println("-------합격을 축하드립니다.------");
			System.out.println("현재 점수 : " + avg);
			System.out.println("합격 점수 : 60점 이상");
		} else {
			System.out.println("------불합격을 축하드립니다.------");
			System.out.println("현재 점수 : " + avg);
			System.out.println("합격 점수 : 60점 이상");
		}

	}

}
