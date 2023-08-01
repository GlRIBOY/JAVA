package co.yedam.memo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemoManager {
	Scanner scn = new Scanner(System.in);
	List<Memo> memoStorage = new ArrayList<>();

	FileInputStream fis;

	public MemoManager() {
		readFromFile();
	}

	// 메뉴출력
	public void printMenu() {
		System.out.println("1.등록 2.검색 3.삭제 4.종료");
		System.out.print("Select>> ");
	}

	private int getNextNo() {
		int no = 0;
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getNo() > no) {
				no = memoStorage.get(i).getNo();
			}
		}
		return no + 1;
	}

	public void inputData() throws Exception {
		int no = getNextNo();
		System.out.print("Date>> ");
		String date = scn.nextLine();

		System.out.print("Content>> ");
		String content = scn.nextLine();

		Memo memo = null;

		if (date.isEmpty()) {
			memo = new Memo(no, content);
		} else {
			memo = new Memo(no, date, content);
		}
		if (memoStorage.add(memo)) {
			System.out.println("정상등록");
		} else {
			System.out.println("에러");
		}

	}// end inputData

	public void searchData() {
		System.out.print("Date>> ");
		String date = scn.nextLine();
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getDate().equals(date)) {
				System.out.println("No:" + memoStorage.get(i).getNo() + ", Date: " + memoStorage.get(i).getDate()
						+ ", Content: " + memoStorage.get(i).getContent());
			}
		}
		// 입력된 날짜의 메모를 출력
	}

	public void deleteNo() {
		System.out.print("No>> ");
		int no = Integer.parseInt(scn.nextLine());
		for (int i = 0; i < memoStorage.size(); i++) {
			if (memoStorage.get(i).getNo() == no) {
				memoStorage.remove(i);
			}
		}
	}

	public void storeToFile() {
		// 출력스트림. 객체에 담아야함
		try {
			FileOutputStream fos = new FileOutputStream("c:/Temp/Memo.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(memoStorage);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			System.out.println("저장 오류");

		}
	}

	public void readFromFile() {
		// 입력스트림. 객체에 담아야함

		try {
			fis = new FileInputStream("c:/Temp/Memo.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			memoStorage = (List<Memo>) ois.readObject();
			ois.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("불러오기 오류");

		}
	}
}
