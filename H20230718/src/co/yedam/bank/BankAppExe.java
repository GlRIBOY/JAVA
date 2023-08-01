package co.yedam.bank;

import java.util.Scanner;

public class BankAppExe {

	public static void main(String[] args) {
		boolean run = true;
		BankApp app = new BankApp();
		Scanner scn = new Scanner(System.in);
		
		while(run) {
			System.out.println("1.계좌등록 2.입금 3.출금 4.잔액조회 5.계좌목록 6.종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			if(menu == 1) {
				System.out.print("계좌번호: ");
				String num = scn.nextLine();
				System.out.print("성명: ");
				String name = scn.nextLine();
				System.out.print("입금액: ");
				int dep = 0;
				int de = Integer.parseInt(scn.nextLine());
				if(de < 0 ) {
					System.out.println("음수값은 입력할 수 없습니다");
				}else {
					dep = de;
					Account account = new Account(num, name, dep);
					if(app.addAccount(account)) {
						System.out.println("complete");
					}else {
						System.out.println("fair");
					}
				}
				
				
			
			}else if(menu == 2) {
				app.deposit();
			}else if(menu == 3) {
				app.withdraw();
			}else if(menu == 4) {
				app.checkBalance();
			}else if(menu == 5) {
				app.accountList();
			}else if(menu == 6) {
				run = false;
				System.out.println("종료");
			}
			
			
		}//end of while

	}//end of main

}
