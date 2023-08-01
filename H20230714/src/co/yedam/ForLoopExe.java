package co.yedam;

public class ForLoopExe {

	public static void main(String[] args) {
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();//줄바꿈
		//1의 위치 지정
		int pos = getFirstDay(6);
		for(int i = 0; i < pos; i++) {
			System.out.printf("%4s", "");
		}
		int lastDate = getLastDate(6);
		for(int i = 1; i <=lastDate; i++) {
			System.out.printf("%1s", "");//day 사이 여백
			System.out.printf("%3d", i);
			if((i + pos) % 7 == 0) {
				System.out.println();//줄바꿈
			}
		}
		

	}//end of main
	
	//월 정보를 입력하면 해당월의 1일의 위치(공란을 반환)
	public static int getFirstDay(int month) {
		int pos = 0;
		
		switch(month) {
		case 1:
			pos = 0; break;
		case 2:
			pos = 3; break;
		case 3:
			pos = 3; break;
		case 4:
			pos = 6; break;
		case 5:
			pos = 1; break;
		case 6:
			pos = 4; break;
		case 7:
			pos = 6; break;
		case 8:
			pos = 2; break;
		case 9:
			pos = 5; break;
		case 10:
			pos = 0; break;
		case 11:
			pos = 3; break;
		case 12:
			pos = 5; break;
			
		}
		
		return pos;
	}
	
	//월정보를 입력하면 해당월의 마지막날을 반환하는 메소드
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch(month) {
		case 2: lastDate = 28; break;
		case 4:
		case 6:
		case 9:
		case 11: lastDate = 30;
		}
		return lastDate;
	}
	
}
