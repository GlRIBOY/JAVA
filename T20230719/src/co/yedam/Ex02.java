package co.yedam;
import java.util.Scanner;
public class Ex02 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		int max = 0;
		int min = 0;
		int sum2 = 0;
		int sum3 = 0;
		int val = 0;
		System.out.print("num1: ");
		num1 = Integer.parseInt(scn.nextLine());
		System.out.print("num2: ");
		num2 = Integer.parseInt(scn.nextLine());

		if(num1>num2) {
			max = num1;
		}else {
			max = num2;
		}
		if(num1>num2) {
			min = num2;
		}else {
			min = num1;
		}
		int betVal = max-min;//맥스 민 값이 정해지는 코드 위에 존재하면 위 선언된 0값이 대입됨

		val = min+1;

		for(int i = 1; i < betVal; i++) {
			if(val%2 == 0) {
				sum2 += val;
				if(val%3 == 0) {
					sum3 += val;
				}
				val++;
			}else if(val%3 == 0) {
				sum3 += val;
				val++;
			}else {
				val++;
			}
		}
		
		System.out.printf("2배수합: %d, 3배수합: %d", sum2, sum3);
		
		
	}

}
