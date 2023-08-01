package co.yedam.collect.board;

import java.util.Scanner;

public class MainExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String loginId  = "";
		
		//로그인되면 기능사요ㅗㅇ
		
		//1.등록(작성자 = 로그인아이디) 2.목록 3.단건조회 4.삭제 9.종료
		
		BoardApp appB = new BoardApp();
		UserApp appU = new UserApp();
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.조회 4.삭제 9.종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(scn.nextLine());
			if(menu == 1) {
				boolean result = appU.login();
				if(result) {
					System.out.println("글 쓰시오");
					String bor = scn.nextLine();
					appB.addBoard(bor);
				}
				
			}
		}
		
		
	}

}
