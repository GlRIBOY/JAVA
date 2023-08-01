package co.yedam.student;

import java.util.Scanner;

public class StudentAppExe {

	public static void main(String[] args) {
		StudentApp app = new StudentApp();
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while(run) {
			System.out.println("메뉴 : 1.등록 2.목록 3.합계 4.최고점 5.종료");
			System.out.print(">>");
			int menu = Integer.parseInt(scn.nextLine());
			if(menu == 1) {
				System.out.print("번호: ");
				String no = scn.nextLine();
				System.out.print("이름: ");
				String na = scn.nextLine();
				System.out.print("성적: ");
				int sco = Integer.parseInt(scn.nextLine());
				System.out.print("키: ");
				double hei = Integer.parseInt(scn.nextLine());
							
				Student student = new Student(no, na, sco, hei);
				if(app.addStudent(student)) {
					System.out.println("complete");
				}else {
					System.out.println("fair");
				}
				
			}else if(menu == 2) {
				app.studentList();
			}else if(menu == 3) {
				int result = app.sumScores();
				System.out.println("total " + result); 
			}else if(menu == 4) {
				app.maxPrint();
			}else if(menu == 5) {
				run = false;
			}
		}
	}

	
}
