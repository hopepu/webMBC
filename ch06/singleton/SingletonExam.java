package ch06.singleton;

public class SingletonExam {
	
	public static void main(String[] args) {
		// 싱클톤을 사용해보자.
		
//		생성자에 private를 붙여서 안됨
//		Singleton obj1 = new Singleton();
//		Singleton obj2 = new Singleton();
		
		Singleton obj3 = Singleton.getInstance();//싱글톤 객체 성공
		Singleton obj4 = Singleton.getInstance();//싱글톤 객체 성공
		
		if(obj3 == obj4) {
			System.out.println("같은 싱글톤 객체입니다.");
		} else {
			System.out.println("다른 싱글톤 객체입니다.");
		} //if close
		
	} // main close

} // class close
