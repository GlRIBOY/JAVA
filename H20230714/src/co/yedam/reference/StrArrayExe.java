package co.yedam.reference;

import java.util.Scanner;

public class StrArrayExe {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		String[] strAry = new String[3]; // 크기가 3인배열.
		int[] scores = new int[3];
		
		for(int i = 0; i < strAry.length; i++) {
			System.out.print("이름>> ");
			strAry[i] = scn.nextLine();
			System.out.print("점수>> ");
			scores[i] = Integer.parseInt(scn.nextLine());
			}
		
		System.out.println("검색하고싶은 학생의 이름을 입력>>> ");
		String searchName = scn.nextLine();
		
		for(int i = 0; i < strAry.length; i++) {
			if(strAry[i].equals(searchName)) {
			System.out.printf("이름은 %s, 점수는 %d \n", strAry[i], scores[i]);
			}
		}

	}
}
