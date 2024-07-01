package ch08.extended.people;

public class MBCSchoolExam{
	// 상속관계의 객체를 가져와 출력
	// 생성자를 활용해본다. -> 객체 생성시 초기값을 줌.
		
//	public MBCSchoolExam(String name, String ssn, int studentNo){
//		super(name, ssn, studentNo);
//	}
//	
	public static void main(String[] args) {
		
		People people = new People("부모", "엄마주민번호");
		System.out.println(people.name + people.ssn);
		
		Student student = new Student("자식", "자식주민번호", 12345);
		System.out.println(student.name);
		System.out.println(student.ssn);
		System.out.println(student.studentNo);
		
		Teacher teacher = new Teacher("선생님", "선생님주민번호", 39);
		System.out.println(teacher.name);
		System.out.println(teacher.ssn);
		System.out.println(teacher.employeeNo);
		
		//다형성
		People multi1 = new Student("문지현", "지현씨주번", 2);
		People multi2 = new Teacher("김기원", "김기원주번", 22);
		
		
		
		
		
	}
}
