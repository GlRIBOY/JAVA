package co.yedam.friend;

import java.util.Scanner;

public class MainExe {

	public static void main(String[] args) {
		AddressApp app = new AddressApp();
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		
		int menu = 0;
		//1등록2목록3수정4삭제5단건조회6종료
		//등록 학교, 회사, 친구

		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료");
			System.out.print("선택>> ");
			menu = Integer.parseInt(scn.nextLine());
			try {
				if(menu < 1 || menu > 6) {
					throw new MenuException(menu);
				}
			}catch(MenuException e) {
				e.showMessage();
				continue;
			}
			if(menu == INIT_MENU.ADD) {
				System.out.println("1.일반 2.학교 3.회사");
				System.out.print("선택>> ");
				int menu2 = Integer.parseInt(scn.nextLine());
				String name2 = "";
				String phone2 = "";
				String univ2 = "";
				String major2 = "";
				String company2 = "";
				String dept2 = "";
				if(menu2 == 1) {
					System.out.print("이름: ");
					name2 = scn.nextLine();
					System.out.print("전화번호: ");
					phone2 = scn.nextLine();
					
					Friend friend = new UnivFriend(name2, phone2, univ2, major2);
					app.addFriend(friend);
				}else if(menu2 == 2) {
					System.out.print("이름: ");
					name2 = scn.nextLine();
					System.out.print("전화번호: ");
					phone2 = scn.nextLine();
					System.out.print("학교명: ");
					univ2 = scn.nextLine();
					System.out.print("전공: ");
					major2 = scn.nextLine();
					
					Friend friend = new CompFriend(name2, phone2, company2, dept2);
					app.addFriend(friend);
				}else if(menu2 == 3) {
					System.out.print("이름: ");
					name2 = scn.nextLine();
					System.out.print("전화번호: ");
					phone2 = scn.nextLine();
					System.out.print("회사명: ");
					company2 = scn.nextLine();
					System.out.print("부서명: ");
					dept2 = scn.nextLine();
					
					Friend friend = new Friend(name2, phone2);
					app.addFriend(friend);
				}
			}
			if(menu == INIT_MENU.LIST) {
				System.out.println(app.friendList());
			}
		}//while
	}
		
		
		
}