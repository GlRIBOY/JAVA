package co.yedam.io;

import java.util.List;
import java.util.Scanner;

public class MemberManageExe {

	public static void main(String[] args) {
		// 이름 주소 연락처 =>추가 수정 삭제 목록, 종료(저장)
		MemberManage manager = new MemberManage();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				String[] data = null;
				while (true) {
					System.out.println("이름 주소 연락처");

					String str = scn.nextLine();
					data = str.split(" ");
					if (data.length != 3) {
						System.out.println("입력갯수 에러.");
						continue;
					}
					break;
				}
				Member member = new Member(data[0], data[1], data[2]);
				if (manager.add(member)) {
					System.out.println("등록 성공");
				} else {
					System.out.println("등록 실패");
				}

			} else if (menu == 2) {
				System.out.println("이름 연락처");
				String str = scn.nextLine();
				String[] data = str.split(" ");
				Member member = new Member(data[0], "", data[1]);
				if (manager.edit(member)) {
					System.out.println("변경 성공");
				} else {
					System.out.println("변경 실패");
				}
			} else if (menu == 3) {
				System.out.println("이름");
				String str = scn.nextLine();
				if (manager.del(str)) {
					System.out.println("변경 성공");
				} else {
					System.out.println("변경 실패");
				}
			} else if (menu == 4) {
				List<Member> list = manager.list();
				for (Member member : list) {
					System.out.println(member.toString());
				}
			} else if (menu == 5) {
				System.out.println("종료");
				manager.save1();
				run = false;
			}

		}
		System.out.println("end");
		scn.close();
	}

}
