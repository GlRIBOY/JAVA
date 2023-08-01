package co.yedam.student;

public class StudentExe {

	public static void main(String[] args) {
		// 학생번호, 학생이름, 점수.
		Student std1 = new Student(); //인스턴스
		std1.setStudentNo(100);
		std1.setStudentName("홍길동");
		std1.setScore(80);
		
		Student std2 = new Student();
		std2.setStudentNo(110);
		std2.setStudentName("kally");
		std2.setScore(85);
		
		Student std3 = new Student();
		std3.setStudentNo(120);
		std3.setStudentName("pool");
		std3.setScore(90);
		
		Student[] students = {std1, std2, std3};
		students = new Student[5];
		students[0] = std1;
		students[1] = std2;
		students[2] = std3;
		
		String searchName = "홍길동";
		
		int maxScore = 0;
		
		int sum = 0, cnt = 0;
		double avg = 0; 
				
		Student maxStd = new Student();
		
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null) {
				if(students[i].getStudentName().equals(searchName))
				System.out.printf("학생번호 : %d, 이름 : %s, 점수 : %d", students[i].getStudentNo(), students[i].getStudentName(), students[i].getScore());


				if(students[i].getScore() > maxScore) {
					maxScore = students[i].getScore();
					maxStd = students[i];
				}
				sum += students[i].getScore();
				cnt++;
			}	
		}
		System.out.println();
		System.out.printf("학생번호 : %d, 이름 : %s, 점수 : %d", maxStd.getStudentNo(), maxStd.getStudentName(), maxStd.getScore());
		System.out.println();
		avg = (double) sum / cnt;
		System.out.printf("합계점수 : %d, 평균점수 : %.1f", sum, avg);
		
		
	}

}
