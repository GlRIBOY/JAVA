package co.yedam.board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class BoardApp {
	private static BoardApp boardApp = new BoardApp();
	private BoardApp() {}
	static BoardApp getBoardApp() {
		return boardApp;
	}//싱글톤설정=>스레드문제발생
	UserApp uApp = UserApp.getUserApp();
	Scanner scn = new Scanner(System.in);

	List<Board> boardList = new Vector<>();

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

	boolean run = true;

	public void mainMenu() {

		while (run) {
			System.out.println("┌ㅡ-------------------메뉴-------------------ㅡ┐");
			System.out.println("| 1.글등록 2.글수정 3.글삭제 4.목록 5.종료 9.비밀변호변경|");
			System.out.println("└------------------------------ㅡ------------┘");
			System.out.print("선택: ");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				addBoard();
			} else if (menu == 2) {
				editBoard();
			} else if (menu == 3) {
				delBoard();
			} else if (menu == 4) {
				listBoard();
			} else if (menu == 5) {
				shutdown();
			} else if (menu == 9) {
				uApp.editPassword();
			} else {
				System.out.println("존재하지 않는 메뉴입니다.");
			}
		}
	}// end main

	public void addBoard() {
		System.out.print("아아디: ");
		String loginId = scn.nextLine();
		int no = boardList.size() + 1;// 글번호
		System.out.print("제목: ");
		String title = scn.nextLine();// 글제목
		System.out.println("---------------------내용---------------------");
		String board = scn.nextLine();
		String writer = loginId;
		String writeDate = sdf.format(date);
		boardList.add(new Board(no, title, board, writer, writeDate));
		System.out.println("글 등록 완료\n글번호: " + no + " 제목: " + title + " 글쓴이: " + writer + " 작성일: " + writeDate + "\n");

	}// end add

	public void editBoard() {
		System.out.print("아아디: ");
		String loginId = scn.nextLine();
		System.out.println("글 목록");
		System.out.println("-------------------------------");
		System.out.println("글번호  제목          날짜");
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).writer.equals(loginId)) {
				System.out.printf("%d%10s%s", boardList.get(i).no, boardList.get(i).title, boardList.get(i).date);
			}
		}
		System.out.print("번호: ");
		int selectNo = Integer.parseInt(scn.nextLine());
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).writer.equals(loginId) && boardList.get(i).no == selectNo) {
				System.out.println("내용\n" + boardList.get(i).board);
				System.out.print("수정: ");
				String board = scn.nextLine();
				boardList.get(i).board = board;
				System.out.println("수정완료\n");
				break;
			}
		}
	}// end edit

	public void delBoard() {
		System.out.print("아아디: ");
		String loginId = scn.nextLine();
		System.out.println("글 목록");
		System.out.println("-------------------------------");
		System.out.println("글번호  제목          날짜");
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).writer.equals(loginId)) {
				System.out.printf("%d%10s%s", boardList.get(i).no, boardList.get(i).title, boardList.get(i).date);
			}
		}
		System.out.print("번호: ");
		int selectNo = Integer.parseInt(scn.nextLine());
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).writer.equals(loginId) && boardList.get(i).no == selectNo) {
				boardList.remove(i);

				for (int j = i; j < boardList.size(); j++) {
					boardList.get(j).no = boardList.get(j).no - 1;
				}
				break;
			}
		}
	}// end del

	public void listBoard() {
		System.out.print("아아디: ");
		String loginId = scn.nextLine();
		System.out.println("글 목록");
		System.out.println("-------------------------------");
		System.out.println("글번호  제목          날짜");
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).writer.equals(loginId)) {
				System.out.printf("%d%10s%s", boardList.get(i).no, boardList.get(i).title, boardList.get(i).date);
			}
		}
	}// end list

	public void shutdown() {
//		UserApp userApp = new UserApp();
//		System.out.print("아아디: ");
//		String loginId = scn.nextLine();
//		System.out.println("┌-------------------메뉴---------┐");
//		System.out.println("|           1.로그아웃            |");
//		System.out.println("└-------------------------------┘");
//		System.out.print("선택: ");
//		int menu = Integer.parseInt(scn.nextLine());
//		if (menu == 1) {
//			run = false;
//			System.out.println(loginId + "님께서 로그아웃하였습니다.\n");
//		} else if (menu == 2) {
//			UserApp u = new UserApp();
			run = false;
			System.out.println("로그아웃");
//			System.out.println(loginId + "님께서 로그아웃하였습니다.");

//		}
	}// end shutdown
}
