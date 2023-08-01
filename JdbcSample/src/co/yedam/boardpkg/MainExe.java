package co.yedam.boardpkg;

import java.util.Scanner;

interface Menu {
	int ADD = 1, EDIT = 2, DEL = 3, LIST = 4, INFO = 5, EXIT = 6;
}

public class MainExe {
	public static void menuPrint() {
		System.out.println("1.등록 2.수정 3.삭제 4.목록 5.개인정보 6.종료");
		System.out.print("선택>> ");
	}

	public static void main(String[] args) {

		BoardService svc = new BoardApp();
		BoardApp appB = new BoardApp();
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		System.out.println("관리자 여부: " + appB.isAdmin("admin", "admin"));
			
		

		while (run) {

			menuPrint();
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case Menu.ADD:
				svc.addBoard(null);
			case Menu.EDIT:
				svc.editBoard(null);
			case Menu.DEL:
				svc.delBoard(1);
			case Menu.LIST:
				for (Board brd : svc.boardList()) {
					System.out.println(brd);
				}
				break;
			case Menu.INFO:
				svc.modInfo(null);
			case Menu.EXIT:
			}
		}
		System.out.println("end of prog.");
		scn.close();
	}
}
