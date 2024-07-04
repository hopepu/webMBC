package ch14.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExam {

	public static void main(String[] args) {
		// list 컬렉션은 Arraylist, vector, Linkedlist 3가지를 주로 사용한다.
		// list 컬렉션은 배열 대신 활용도가 높다.(길이가 자유롭다)
		// list<String> 는 강한타입체크로 String 만 들어간다.
		// List<String> list = new ArrayList<String>(); -> 10개가 기본값
		
		List<String> listS = new ArrayList<String>();
		
		listS.add("자바"); 			// 0번 인덱스
		listS.add("Oracle"); 		// 데이터베이스
		listS.add("JDBC");      	// java + DB연동
		listS.add("HTML, CSS, JS");	// 프론트
		listS.add("JSP"); 			// java + DB + 프론트 연동
		listS.add("tomcat");		// 서버 프로그래밍(servlet)
		listS.add("Linux");			// 배포서버
		listS.add("AWS");			// 가상 배포서버
		listS.add(5, "servlet");	// 5번 인덱스, jsp + java
		
		int size = listS.size();
		System.out.println("총 객체수 : " + size);
		System.out.println("---------------------------");
		
		String skill = listS.get(2);
		System.out.println("2번 객체 : " + skill);
		
		listS.remove(2);listS.remove(2);
		listS.remove("JSP");

		
		System.out.println("--------for 전체 출력---------");
			
		
		for(int i = 0 ; i<listS.size(); i++) {
			System.out.println(i+"번째 값 : " + listS.get(i));
		}
		
		
		
		System.out.println("--for each 전체 출력(index사용 안함)--");
		for(String str : listS) {
			System.out.println(str);
		}
		
		
	}
}
