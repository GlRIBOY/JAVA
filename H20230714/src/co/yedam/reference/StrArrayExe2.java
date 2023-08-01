package co.yedam.reference;

import java.util.Scanner;

public class StrArrayExe2 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		String[] strAry = new String[3]; // 크기가 s3인배열.
		int[] scores = new int[3];
		
		for(int i = 0; i < strAry.length; i++) {
			System.out.print("이름>> ");
			strAry[i] = scn.nextLine();
			System.out.print("점수>> ");
			scores[i] = Integer.parseInt(scn.nextLine());
			}
		int maxScore = 0;
		String maxName = "";
		for(int i = 0; i< strAry.length; i++) {
			if(scores[i] > maxScore) {
				maxScore = scores[i];
				maxName = strAry[i];
			}
		}
		System.out.printf("이름은 %s, 점수는 %d \n", maxName, maxScore);
	}
}