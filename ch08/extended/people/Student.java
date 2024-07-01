package ch08.extended.people;

public class Student extends People{
	// 필드
	public int studentNo;
	
	// 생성자
	public Student(String name, String ssn, int studentNo) {
		super(name, ssn);
//		this.name = name;
//		this.ssn = ssn;
		this.studentNo = studentNo;
				
		
	} // 커스텀 생성자 Student student = new Student("김기원", "주민번호", 2406)
	// 메서드
	

}
