package co.yedam.board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("1.추가 2.수정 3.조회 4.삭제 5.목록");
		int menu = Integer.parseInt(scn.nextLine());
		if(menu == 1) {
			System.out.print("제목: ");
			String title = scn.nextLine()	;
			System.out.print("내용: ");
			String content = scn.nextLine()	;
			System.out.print("작성자: ");
			String writer = scn.nextLine()	;
			BoardApp.register(String title, String content, String writer);
		}
	}

}
