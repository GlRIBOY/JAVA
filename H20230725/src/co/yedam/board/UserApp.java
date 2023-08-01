package co.yedam.board;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class UserApp {
	private static UserApp userApp = new UserApp();
	private UserApp() {}
	static UserApp getUserApp() {
		return userApp;
	}//싱글톤설정=>스레드문제발생
	BoardApp bApp = BoardApp.getBoardApp();
	Scanner scn = new Scanner(System.in);
	Storage storage = new Storage();
	List<User> userList = new Vector<>();

	boolean run = true;

	public void homeMenu() {
		while (run) {
			System.out.println("┌----------ㅡ-메뉴-ㅡ---------┐");
			System.out.println("|    1.로그인     2.회원가입    |");
			System.out.println("└-------------ㅡ------------┘");
			System.out.print("선택: ");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				login();
			} else if (menu == 2) {
				addUser();
			} else {
				System.out.println("존재하지 않는 메뉴입니다.");
			}
		}
	}

	public void addUser() {

		String id;
		while (true) {
			System.out.println("┌---------ㅡ-아이디-----------┐");
			System.out.println("| 도형x, 공백x, 3자이상, 10자이하 |");
			System.out.println("└-------------ㅡ------------┘");
			System.out.print("아이디: ");
			id = scn.nextLine();

			if (id.length() < 3 || id.length() > 10 || id.contains(" ")) {
				System.out.println("아이디를 확인하시오.\n");
				continue;
			}

			for (int i = 0; i < userList.size(); i++) {
				if (id.equals(userList.get(i).id)) {
					System.out.println("이미 사용 중인 아이디입니다.");
				}
			}
			break;
		}

		while (true) {
			System.out.println("┌-----------비밀번호----------┐");
			System.out.println("| 도형x, 공백x, 8자이상, 20자이하 |");
			System.out.println("└-------------ㅡ------------┘");
			System.out.print("비밀번호: ");
			String password = scn.nextLine();
			if (password.length() < 8 || password.length() > 20 || password.contains(" ")) {
				System.out.println("비밀번호를 확인하시오.\n");
				continue;
			}
			userList.add(new User(id, password));
			break;
		}
		

		System.out.println("회원가입이 완료되었습니다.\n");
		storage.storeToFileU();
	}// end addUser

	public void login() {

		System.out.println("------------로그인 ----------");
		System.out.print("아이디: ");
		String id = scn.nextLine();
		if(userList.size() == 0) {
			System.out.println("회원가입을 하시오");
			return;
		}
		for (int i = 0; i < userList.size(); i++) {
			if (id.equals(userList.get(i).id)) {
				System.out.print("비밀번호: ");
				String password = scn.nextLine();
				if (password.equals(userList.get(i).password)) {
					System.out.println(userList.get(i).id + "님께서 로그인하셨습니다.\n");
					break;
				} else {
					System.out.println("비밀번호가 틀립니다.\n");
					continue;
				}
			} else {
				System.out.println("일치하는 정보가 없습니다.\n");
			}
		}
		bApp.mainMenu();
	}// end login

	public void editPassword() {
		System.out.print("아이디: ");
		String id = scn.nextLine();
		System.out.print("현재 비밀번호: ");
		String password = scn.nextLine();
		System.out.println(userList.size());

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).id.equals(id)) {
				if (userList.get(i).password.equals(password)) {
					System.out.print("변경할 비밀번호: ");
					userList.get(i).password = scn.nextLine();
					System.out.println("비밀번호 변경완료\n");
					Storage storage = new Storage();
					storage.storeToFileU();
					break;
				} else {
					System.out.println("비밀번호를 확인하시오.");
					break;
				}
			}

		}
	}
}// end class
