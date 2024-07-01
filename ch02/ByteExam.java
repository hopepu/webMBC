package ch02;

public class ByteExam {

	public static void main(String[] args) {
		// byte 타입은 8bit 처리용 타입으로 -128 ~ +127까지의 범위(0포함)를 처리한다.
		// 색상정보 rgb, cmyk, 등 처리용
		// 파일 업로드, 다운로드, 그림, 영상, 사운드 등.....
		
		byte var1 = -128;
		byte var2 = 127;
		byte var3 = 0;
		// byte var4 = -129; 
		// byte var5 = 128;
		
		// 127값이 초과되는 계산을 하게되면 -128부터 로테이션 된다.
		byte var6 = 125;
		int var7 = 125;
		for(int i=0; i<5; i++) {//0부터 5까지 1씩 증가 0-> 1 -> 2 -> 3 -> 4
			var6++; //var6 값에 1 증가
			var7++; //var7 값에 1 증가
			System.out.println("var6 값 : " + var6 + "     var7값 : " + var7);
			
		}

	}

}
