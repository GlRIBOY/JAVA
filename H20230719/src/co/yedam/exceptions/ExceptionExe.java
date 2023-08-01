package co.yedam.exceptions;

import java.util.Scanner;

public class ExceptionExe {

	public static void main(String[] args) throws ClassNotFoundException {
		//NullPointException
		Scanner scn = new Scanner(System.in);
		String str = null;
		str = "hong";
		int age = 0;
		//try블럭에서 예외가 발생하면 catch블럭에 정의된 코드를 실행
		try {
			System.out.println(str.toString());
			age = Integer.parseInt("열살");
			System.out.println(str + " " + age);
		} catch(NullPointerException | NumberFormatException e) {
			System.out.println("예외");
//		}catch(NumberFormatException n) {
//			System.out.println("Format예외");
		}finally {
			scn.close();//리소스반환
		}
		
		try {
			Class cls = Class.forName("java.lang.Srting");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		exceptionMethod();
		
		System.out.println("end of prog");
	}
	
	public static void exceptionMethod() throws ClassNotFoundException {
		//예외처리의 책임을 메소드를 호출한 영역으로 떠넘기기
		Class cls = Class.forName("java.lang.Srting");
	}

}
