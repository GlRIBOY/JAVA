package co.yedam.student;

//복합적인 구조의 데이터.
public class Student {
	//필드.
	private int studentNo;
	private String studentName;
	private int score;
	
	//메소드(함수의 기능과 같음)
	//naming rule : 두 단어의 조합이면 두번재 단어의 첫번째 대문자 표기.
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo; 
	}
	public int getStudentNo() {
		return studentNo;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName; 
	}
	public String getStudentName() {
		return studentName;
	}
	
	public void setScore(int score) {
		this.score = score; 
	}
	public int getScore() {
		return score;
	}
}
