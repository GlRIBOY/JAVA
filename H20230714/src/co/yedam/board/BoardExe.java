package co.yedam.board;

import java.util.Scanner;

public class BoardExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Board[] boards = new Board[10];
		boolean run = true;
		
		while(run) {
			System.out.println("1.글쓰기 2.글 목록 3.수정 4.삭제 5.글읽기 6.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			if(menu == 1) {
				String bSub = "";
				int bNo = 0;
				String bTitle = "";
				boolean keep = true;
				
				//번호지정
				if(boards.length == 0) {
					bNo = 1;
				}else {
					bNo = boards.length + 1;
				}
				//작성자 입력
				System.out.print("작성자: ");
				String bWrt = scn.nextLine();
				//제목 입력
				System.out.print("제목: ");
				bTitle = scn.nextLine();
				//글 입력
				System.out.println("\n글 입력");
				while(keep) {
					if(scn.nextLine().equals("exit")) {
						keep = false;
						System.out.println("글 저장");
					}else {
						bSub += scn.nextLine() + "\n";
					}
				}
				Board board = new Board();
				board.setBrdNo(bNo);
				board.setBrdTitle(bTitle);
				board.setBrdSub(bSub);
				board.setBrdWriter(bWrt);

				
				for(int i = 0; i < boards.length; i++) {
					if(boards[i] == null){
						boards[i] = board; //배열의 빈값에 저장
						break; //한건 저장 후 반복문 종료
					}
				}System.out.println(boards.length);
			}
			else if(menu == 2) {
				boolean isExist = false;
				for(int i = 0; i < boards.length; i++) {
					if(boards[i] !=null) {
						System.out.println(boards[i].showList());
						isExist = true;
					}

				}
				if (isExist == false) {
					System.out.println("게시물이 없습니다");
				}
			}
			else if(menu == 3) {
				boolean isExist = false;
			}
		}//while end
	}// main end
}