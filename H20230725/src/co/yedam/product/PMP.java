package co.yedam.product;

import java.util.Scanner;

public class PMP {

	public static void main(String[] args) {
		Management m = new Management();
		Scanner scn = new Scanner(System.in);

		boolean run = true;

		while (run) {
			System.out.println("1.상품등록 2.판매 3.구매 4.재고 5.판매목록 6.구매목록 7.종료");
			try {
				int menu = Integer.parseInt(scn.nextLine());
				if (menu == 1) {
					m.add();
				} else if (menu == 2) {
					m.sell();
				} else if (menu == 3) {
					m.buy();
				} else if (menu == 4) {
					m.round();
				} else if (menu == 5) {
					m.sellList();
				} else if (menu == 6) {
					m.buyList();
				} else if (menu == 7) {
					run = false;
//				m.storeToFile(m.productList, "C:\\Temp/productList.db");
//				m.storeToFile(m.dateList, "C:\\Temp/dateList.db");
					m.storeToFileD();
					m.storeToFileP();
					System.out.println("종료");
				}
			} catch (NumberFormatException n) {
				System.out.println("번호를 입력하시오\n");
				continue;
			}
		}
		scn.close();
	}

}
