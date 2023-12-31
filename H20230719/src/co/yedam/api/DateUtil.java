package co.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String dateToStr(Date date) {
		//Date는 String타입으로 생성
		SimpleDateFormat sdf = //
				new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}
	
	public static String dateToStr(Date date, String pattern) {
		SimpleDateFormat sdf = //
				new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static Date strToDate(String dday) {
		SimpleDateFormat sdf = //
				new SimpleDateFormat("yyyy-MM-dd");
		try{
			return sdf.parse(dday);
		}catch(ParseException p){
			p.printStackTrace();
		}
	}

	
}
