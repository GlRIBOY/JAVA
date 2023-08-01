package co.yedam.memo;

import java.util.Calendar;
import java.util.Scanner;

public class MemoAppExe {

	public static void main(String[] args) {
		MemoApp app = new MemoApp();
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Calendar cal = Calendar.getInstance();
		
		while(run){
			
			System.out.println("1.메모등록 2.메모수정 3.메모삭제 4.메모목록 5.메모조회 6.종료");
			System.out.print("메뉴선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			if(menu == 1) {
				int memoNum = 0;
				String memoCnt = "";
				String memoDate = "";
				if(app.memoN == 0) {
					memoNum = 1;
				}else {
					memoNum = app.memoN + 1;
				}
				System.out.print("입력>> ");
				memoCnt = scn.nextLine();
				memoDate = cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DATE);

				
				Memo memo = new Memo(memoNum, memoCnt, memoDate);
				app.addMemo(memo);
				
			}else if(menu == 2) {
				app.editMemo();
			}else if(menu == 3) {
				app.delMemo();
			}else if(menu == 4) {
				app.memoList();
			}else if(menu == 5) {
				app.searchMemo();
			}else if(menu == 6) {
				run = false;
			}
		}
		
	}//main

}
