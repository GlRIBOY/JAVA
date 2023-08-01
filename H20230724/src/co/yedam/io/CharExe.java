package co.yedam.io;

import java.io.FileReader;
import java.io.FileWriter;

public class CharExe {

	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("c:/Temp/test.txt");
		String path = "C:\\DEV\\worksapce\\H20230724\\src\\co\\yedam\\io\\ByteExe.java";
//		FileReader fr = new FileReader("c:/Temp/test.txt");
		FileReader fr = new FileReader(path);

		char a = 'a';
		char b = 'b';
		char c = 'c';

		fw.write(a);
		fw.write(b);
		fw.write(c);

		fw.flush();
		fw.close();
		while (true) {
			int date = fr.read();
			if (date == -1) {
				break;
			}
			System.out.print((char) date);
		}
		fr.close();
		
		System.out.println("end");

	}

}
