package co.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteBufExe {

	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("c:/Temp/skkkr.jpg");

		OutputStream os = new FileOutputStream("c:/Temp/copy2.jpg");

		System.out.println("start");

		byte[] buf = new byte[1000];// 한번에 읽어들이는 양을 기본값 1에서 1000 바이트로 지정

		while (true) {
			int data = is.read(buf);
			os.write(buf);
			if (data == -1) {

				break;
			}
		}
		System.out.println("end");
		is.close();
		os.flush();
		os.close();
	}

}
