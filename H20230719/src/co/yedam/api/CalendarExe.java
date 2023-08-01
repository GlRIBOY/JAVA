package co.yedam.api;

import java.util.Calendar;

public class CalendarExe {

	public static void main(String[] args) {
		Calendar cal1 = Calendar.getInstance();
		System.out.println(cal1);
		System.out.println(cal1.get(Calendar.YEAR));
	}

}
