package co.yedam.student;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student();//힙영역에 인스턴스 생성
		s1.stdName = "a";
		
		Student s2 = new Student();//기본생성자를 이용해서 인스턴스 생성
		s2.stdName = "a";
		s2.stdNo = "23-0002";
		

		System.out.println(s1);
		System.out.println(s2);

		System.out.println(s1 == s2);//주소값은 항상 다름
		
		//필드의 값은 메소드를 통해 비교
		System.out.println(s1.stdName == s2.stdName);
		System.out.println(s1.stdName.equals(s2.stdName));

		//전체필드를 초기화하는 생성자로 인스턴스 생성
		Student s3 = new Student("23-0001", "a", 80, 177.7);
		
		System.out.println(s3.showInfo());
		
		
	}
}
