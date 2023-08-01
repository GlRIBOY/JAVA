package co.yedam.memo;

import java.util.Scanner;

public class MemoApp {
//메모등록addMemo, 수정editMemo(번호로조회, 내용수정), 삭제delMemo(번호로), 목록memoList, 조회(번호로)searchMemo
	//ex) 1 장보기 230719
	//	  2 운동하기 230718
	Memo[] memos;
	Scanner scn = new Scanner(System.in);
	int memoN = 0;
	
	MemoApp(){
		memos = new Memo[9];
	}
	
	void addMemo(Memo mm) {

			memos[memoN++] = mm;
	}
	
	void editMemo() {
		System.out.print("메모 번호: ");
		int menu = Integer.parseInt(scn.nextLine());
		for(int i = 0; i < memoN; i++) {
			if(menu == memos[i].memoNum) {
				System.out.print("입력: ");
				memos[i].memoCnt = scn.nextLine();
			}else {
				System.out.println("없는 번호입니다");
			}
		}
	}
	
	void delMemo() {
		System.out.print("메모 번호: ");
		int menu = Integer.parseInt(scn.nextLine());
		for(int i = 0; i < memoN; i++) {
			if(memos[i] !=null && menu == memos[i].memoNum) {
				memos[i] = null;
				
//				for(int j = 0; j < memoN; j++) {
//					if(j >= i) {
//						memos[j].memoNum = memos[j].memoNum-1;
//					}
//				}
				continue;
			}
		}

	}
	
	void memoList() {
		for(int i = 0; i < memoN; i++) {
			if(memos[i] != null) {
			System.out.println("번호: " + memos[i].memoNum + "      날짜: " + memos[i].memoDate);
			}
		}
	}
	
	void searchMemo() {
		System.out.print("메모 번호: ");
		int menu = Integer.parseInt(scn.nextLine());
		for(int i = 0; i < memoN; i++) {
			if(memos[i] != null && menu == memos[i].memoNum) {
				System.out.printf("번호: %-2d 날짜: %s\n", memos[i].memoNum, memos[i].memoDate);
				System.out.println("내용: " + memos[i].memoCnt);
			}
		}
	}
	
}//끝
