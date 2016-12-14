package Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static void main(String[] args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = sdf.parse("2016-01-14");
		Date d2 = sdf.parse("2016-01-15");

		System.out.println(getIntervalDayNoBefore(d1, d2));

	}

	public static int getIntervalDayNoBefore(Date startDate, Date endDate)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s1 = sdf.format(startDate);
		String s2 = sdf.format(endDate);
		System.out.println(s1);
		System.out.println(s2);
		Date date1 = sdf.parse(s1);
		Date date2 = sdf.parse(s2);
		int day = 0;
		System.out.println(date1);
		System.out.println(date2);
		day = (int) ((date2.getTime() / 86400000L) - (date1.getTime() / 86400000L));
		return day;
	}

}
