package co.yedam.memo;

import java.util.Scanner;

public class MemoApp {

	public static void main(String[] args) throws Exception {
		MemoManager manager = new MemoManager();

		Scanner scn = new Scanner(System.in);
		int menu = -1;

		while (true) {
			manager.printMenu();
			menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {

				manager.inputData();
			} else if (menu == 2) {
				manager.searchData();
			} else if (menu == 3) {
				manager.deleteNo();
			} else if (menu == 4) {
				manager.storeToFile();
				break;
			}
		}
	}

}
