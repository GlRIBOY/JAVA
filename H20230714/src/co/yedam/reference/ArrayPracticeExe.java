package co.yedam.reference;

import java.util.Scanner;

public class ArrayPracticeExe {

	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;//학생수
		int[] scores = null;//학생점수를 저장하기 위한 배열
		Scanner scn = new Scanner(System.in);
		int sumScore = 0;
		
		while(run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택>> ");
			int selectNo = Integer.parseInt(scn.nextLine());
			if(selectNo == 1) {
				System.out.print("학생수>> ");
				studentNum = Integer.parseInt(scn.nextLine());
				scores = new int[studentNum];
			}else if((selectNo == 2 || selectNo == 3 || selectNo == 4) && studentNum == 0) {
				System.out.println("학생 수를 입력하지 않았습니다\n");
			}else if(selectNo == 2) {
				for(int i = 0; i < scores.length; i++) {
					System.out.print("scores[" + i + "]>> ");
					scores[i] = Integer.parseInt(scn.nextLine());
				}
			}else if(selectNo == 3) {
				for(int score : scores) {
					 sumScore = sumScore + score;
					}
				if(sumScore == 0){
					System.out.println("점수를 입력하지 않았습니다\n");
				}else{
					for(int i = 0; i < scores.length; i++) {
						System.out.println("scores[" + i + "]>> " + scores[i]);
						}
				}
			}else if(selectNo == 4) {
				for(int score : scores) {
					 sumScore = sumScore + score;
					}
				if(sumScore == 0){
					System.out.println("점수를 입력하지 않았습니다\n");
				}else {
					int maxSco = 0;
					int avgD = 0; 
					for(int i = 0; i < scores.length; i++) {
						avgD += scores[i];
						if(maxSco < scores[i]) {
						maxSco = scores[i];
						}
					}
					int avgSco = avgD / (scores.length);
					System.out.println(maxSco);
					System.out.println(avgSco);
				}

				
			}else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("end of prog");
	}

}
