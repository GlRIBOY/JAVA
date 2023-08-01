package co.yedam.student;

public class StudentApp {
//학생의 정보등록, 등록된 목록출력, 성적의 합계, 최고점수를 계산
	//필드
	Student[] students;
	int studentNum = 0;
	
	//생성자
	StudentApp(){
		students = new Student[2];
	}
	
	//메소드
	boolean addStudent(Student std) {
		if(studentNum >= 2) {
			return false;
		}
		students[studentNum++] = std;
		return true;
	}
	
	void studentList() {
		for (int i = 0; i < studentNum; i++) {
			System.out.printf("학생번호 %s, 이름 %s, 점수 %d\n", students[i].stdNo, students[i].stdName, students[i].score);
		}
	}
	
	int sumScores() {
		int sum = 0;
		for (int i = 0; i < studentNum; i++) {
			sum += students[i].score;
		}
		return sum;
		//System.out.println("합계" + sum);
	}
	
	void maxPrint() {
		int max = 0;
		for(int i = 0; i < studentNum; i++) {
			if(max < students[i].score) {
				max = students[i].score;
			}
		}
		System.out.println(max);
	}
}
