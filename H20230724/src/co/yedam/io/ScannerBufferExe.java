package co.yedam.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//이름/주소/연락처 3건입력 템프에 2txt로 저장
public class ScannerBufferExe {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		FileWriter fw = new FileWriter("c:/Temp/addres2.txt");

		String temp = "";
		while (true) {
			temp = scn.nextLine();

			if (temp.equals("-1")) {
				break;
			}
			fw.write(temp + "\n");
		}

		fw.close();
		scn.close();
	}

}
