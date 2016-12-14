package Date;

import java.util.Calendar;
import java.util.Date;

/**
 * 判断是否闰年
 * 1.year能被400整除 ;2.year能被4整除，不能被100整除
 **/
public class IsLeapYear {
	
	public static boolean isLeapYear(Date date) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		int year = calender.get(Calendar.YEAR);
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
	}
	public static void main(String[] args){
		Calendar calender = Calendar.getInstance();
		calender.set(Calendar.YEAR, 2015);
		System.out.println(isLeapYear(calender.getTime()));
	}
}
