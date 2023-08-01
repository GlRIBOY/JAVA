package co.yedam.board;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Storage {
	
	UserApp uApp = UserApp.getUserApp();
	
	public void storeToFileU() {
		// 출력스트림. 객체에 담아야함
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/dateList.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(uApp.userList);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			System.out.println("저장 오류");
		}
	}

}
