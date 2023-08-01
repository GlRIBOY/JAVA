package co.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferExe {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Temp\\g.exe");
		BufferedInputStream bis = new BufferedInputStream(fis);

		FileOutputStream fos = new FileOutputStream("C:\\Temp\\gCopy.exe");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int data;
		while ((data = bis.read()) != -1) {
			bos.write(data);
		}
		System.out.println("end");
		bos.flush();bos.close();fos.close();
		bis.close();fis.close();
	}

}
