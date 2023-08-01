package co.yedam;

import java.util.Scanner;

public class ConditionExe2 {
	public static void main(String[] args) {

		//Menu();
		//Menu2();
		
	} // end of main()
	
/*	public static void Menu() {
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("메뉴를 선택하세요(숫자를 입력)>> ");
			System.out.println("1.로그인 2.로그아웃 3.회원가입 4.종료");
			String menu = scn.nextLine();
			int menus = Integer.parseInt(menu);
	
			switch(menus) {
			case 1: login(); break;
			case 2: logout(); break;
			case 3: signUp(); break;
			}if(menus == 4) {exit(); break;}

		}
	}*/
	
/*	public static void Menu2() {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("메뉴를 선택하세요(숫자를 입력)>> ");
			System.out.println("1.로그인 2.로그아웃 3.회원가입 4.종료");
			String menu = scn.nextLine();
			int menus = Integer.parseInt(menu);

			switch(menus) {
			case 1: login(); break;
			case 2: logout(); break;
			case 3: signUp(); break;
			default: run = false;
			}

		}
	}*/
	
	
	public static void login() {
		System.out.println("로그인메뉴입니다");
	}
	public static void logout() {
		System.out.println("로그아웃메뉴입니다");
	}
	public static void signUp() {
		System.out.println("회원가입메뉴입니다");
	}
	public static void exit() {
		System.out.println("end of prog");
		int menus = 0;
	}
}