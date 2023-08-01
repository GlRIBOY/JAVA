package co.yedam.singleton;

import java.util.Calendar;

public class CalendarExe {

	public static void main(String[] args) {
		showCal(2022, 7);

	}
	
	public static void showCal(int year, int month) {
		Calendar cal = Calendar.getInstance();//오늘날자벙보
		cal.set(year, month-1, 1);

		System.out.println("연도: " + cal.get(Calendar.YEAR));
		System.out.println("연도: " + cal.get(Calendar.MONTH));
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.getActualMaximum(Calendar.DATE));//말일
		
		//coding here 달력만들기
	String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();//줄바꿈
		//1의 위치 지정
		int pos = cal.get(Calendar.DAY_OF_WEEK)-1;
		for(int i = 0; i < pos; i++) {
			System.out.printf("%4s", "");
		}
		int lastDate = cal.getActualMaximum(Calendar.DATE);
		for(int i = 1; i <=lastDate; i++) {
			System.out.printf("%1s", "");//day 사이 여백
			System.out.printf("%3d", i);
			if((i + pos) % 7 == 0) {
				System.out.println();//줄바꿈
			}
		}
	}

}
