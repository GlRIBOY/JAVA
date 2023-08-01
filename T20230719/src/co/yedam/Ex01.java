package co.yedam;

import java.util.Scanner;

public class Ex01 {
	
	
	
	public static void main(String[] args) {
	
		Scanner scn = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;

		System.out.print("num1: ");
		num1 = Integer.parseInt(scn.nextLine());
		System.out.print("num2: ");
		num2 = Integer.parseInt(scn.nextLine());
		
	
		if(num1>num2) {
			System.out.println(num1);
		}else {
			System.out.println(num2);
		}
	}
	
	
}
