package co.yedam;

import java.util.Scanner;

public class WhileLoopExe {
	static Scanner scn = new Scanner(System.in); //ctrl + shift + O
	static int balance = 0;
	
	public static void main(String[] args) {

		//은행: 1. 입금, 2. 출금, 3. 잔액조회, 4. 종료
		boolean run = true;
		while(run) {
			System.out.println("1.입금 2.출금 3.잔액조회 4.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			/*	Scanner scn = new Scanner(System.in); //ctrl + shift + O
			 *	int balance = 0;
			 * case 1: System.out.print("입금액을 입력>> "); int var1 =
			 * Integer.parseInt(scn.nextLine()); if(balance + var1 > 100000) {
			 * System.out.println("예금한도 초과하였습니다"); System.out.printf("현재 잔액은 %d 입니다\n\n",
			 * balance); }else{ balance = balance + var1;
			 * System.out.printf("현재 잔액은 %d 입니다\n\n", balance); } break; case 2:
			 * System.out.print("출금액을 입력>> "); int var2 = Integer.parseInt(scn.nextLine());
			 * if(var2 >= balance) { System.out.println("잔액이 부족합니다");
			 * System.out.printf("현재 잔액은 %d 입니다\n\n", balance); continue; } balance =
			 * balance - var2; System.out.printf("현재 잔액은 %d 입니다\n\n", balance);
			 * 
			 * case 3: System.out.printf("현재 잔액은 %d 입니다\n\n", balance); break;
			 */
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				check();
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("잘못된 선택입니다\n");
			}
			
			
		}
		System.out.println("end of prog");
		
		
		
	}//end of main
	public static void deposit() {
		System.out.print("입금액을 입력>> ");
		int var1 = Integer.parseInt(scn.nextLine());
		if(balance + var1 > 100000) {
			System.out.println("예금한도 초과하였습니다");
			System.out.printf("현재 잔액은 %d 입니다\n\n", balance);
		}else{
		balance = balance + var1;
		System.out.printf("현재 잔액은 %d 입니다\n\n", balance);
		}
	}// end of deposit
	
	public static void withdraw() {
		System.out.print("출금액을 입력>> ");
		int var2 = Integer.parseInt(scn.nextLine());
		if(var2 > balance) {
			System.out.println("잔액이 부족합니다");
			System.out.printf("현재 잔액은 %d 입니다\n\n", balance);
			return;
		}
		balance = balance - var2;
		System.out.printf("현재 잔액은 %d 입니다\n\n", balance);
	}// end of withdraw
	
	public static void check() {
		System.out.printf("현재 잔액은 %d 입니다\n\n", balance);
		
	}
}