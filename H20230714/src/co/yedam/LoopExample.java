package co.yedam;

public class LoopExample {

	public static void main(String[] args) {
		
		//76300원 > 5만원:1장, 만원:2장, 5천원:1장, 천원:1장, 5백원:1개, 백원:3개
		int value = 76800; //5만원 이상
		int fm = 0;
		int man = 0;
		int oc = 0;
		int ch = 0;
		int fh = 0;
		int oh = 0;
		System.out.print(value + "원은 ");
		
		
		boolean fmb = true;
		while(fmb) {
			if(value >= 50000) {
			value -= 50000;
			fm++;
			
			}else {
				System.out.print("5만원 " + fm + "장, ");
				fmb = false;
			}
		}
		
		boolean manb = true;
		while(manb) {
			if(value >= 10000) {
			value -= 10000;
			man++;
			
			}else {
				System.out.print("만원 " + man + "장, ");
				manb = false;
			}
		}
		
		boolean ocb = true;
		while(ocb) {
			if(value >= 5000) {
			value -= 5000;
			oc++;
			
			}else {
				System.out.print("오천원 " + oc + "장, ");
				ocb = false;
			}
		}
		
		boolean chb = true;
		while(chb) {
			if(value >= 1000) {
			value -= 1000;
			ch++;
			
			}else {
				System.out.print("천원 " + ch + "장, ");
				chb = false;
			}
		}
		
		boolean fhb = true;
		while(fhb) {
			if(value >= 500) {
			value -= 500;
			fh++;
			
			}else {
				System.out.print("오백원 " + fh + "개, ");
				fhb = false;
			}
		}
		
		boolean ohb = true;
		while(ohb) {
			if(value >= 100) {
			value -= 100;
			oh++;
			
			}else {
				System.out.println("백원 " + oh + "개, ");
				ohb = false;
			}
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		int value2 = 76800; //5만원 이상
		
		System.out.print(value2 + "원은 ");
		
		int fm2 = (value2 - value2 % 50000)/50000;
		value2 -= fm2 * 50000;
		int m2 = (value2 - value2 % 10000)/10000;
		value2 -= m2 * 10000;
		int oc2 = (value2 - value2 % 5000)/5000;
		value2 -= oc2 * 5000;
		int c2 = (value2 - value2 % 1000)/1000;
		value2 -= c2 * 1000;
		int ob2 = (value2 - value2 % 500)/500;
		value2 -= ob2 * 500;
		int b2 = (value2 - value2 % 100)/100;

		
		System.out.println("5만원 " + fm2 + "장, " + "만원 " + m2 + "장, " + "오천원 " + oc2 + "장, " + "천원 " + c2 + "장, " + "오백원 " + ob2 + "개, " + "백원 " + b2 + "개, ");
		
		
		
	}

}
