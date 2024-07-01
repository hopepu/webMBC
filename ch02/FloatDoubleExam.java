package ch02;

public class FloatDoubleExam {

	public static void main(String[] args) {
		// float는 32bit, double은 64bit로 실수 처리한다.(소수점)
		// 소수점 연산은 부동 소수점 연산 기법을 사용한다.(지수부, 가수부)
		// float은 소수점 뒤에 F를 붙여야 함
		// double은 소수정의 정확성이 좋기 때문에 실제로 많이 활용됨.
		
		double var1 = 3.14 ;
//		float var2 = 3.14 ; Type mismatch: cannot convert from double to float
		
		//정밀도 테스트
		double var4 = 0.123456789123456789;
		float var5 = 0.123456781123456789F;
		
		System.out.println(var4); // 0.12345678912345678 소수 18자리까지 나오고 버림
		System.out.println(var5); // 0.12345679 소수 9자리까지 나오고 올림
		
		//foat이 반올림 하는지에 대한 테스트, 부정확하기 때문에 2까지는 내림의 결과 나옴 >> 부정확함임 올림이 기본 베이스
		float var6 = 0.1111111111111111111f;
		float var7 = 0.2222222222222222222f;
		float var8 = 0.333333333333333333f;
		float var9 = 0.44444444444444444f;
		float var10 = 0.5555555555555555f;
		float var11 = 0.666666666666666f;
		System.out.println(var6);
		System.out.println(var7);
		System.out.println(var8);
		System.out.println(var9);
		System.out.println(var10);
		System.out.println(var11);
		

	}

}
