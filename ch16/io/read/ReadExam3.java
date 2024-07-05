package ch16.io.read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExam3 {
	
	public static void main(String[] args) throws Exception {
		// 파일에서 글자를 추출용으로 활용 가능
		// 파일에는 head body tale 3구조
		InputStream inputStream = new FileInputStream("c:\\temp\\text.txt");
		// 폴더명이나 파일처리에서는 대소문자를 구분하지 않는다.
		// \역슬래쉬는 이스케이프 처리에 쓰이므로 주소 기입시에는 \\로 써주는것으로 \인식이 가능케 한다.
		int readByteNo;
		byte[] readBytes = new byte[8];
		readByteNo = inputStream.read(readBytes, 2, 3);
		// read(읽어오는 배열, 데이터 값을 넣기 시작하는 배열, 불러오는 갯수)
		for(int i = 0; i < readBytes.length; i++) {
			System.out.println((char)readBytes[i]);
			
		}
		inputStream.close();
	}


}
