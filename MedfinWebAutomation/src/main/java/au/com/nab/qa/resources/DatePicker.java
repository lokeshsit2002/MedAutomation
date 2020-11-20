package au.com.nab.qa.resources;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import au.com.nab.qa.base.TestBase;


public class DatePicker extends TestBase {

	private String startDate = null;
	private String endDate = null;

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public static String theMonth(int month) {
		String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		return monthNames[month - 1];
	}
	
	public static String theDay(int dayOfWeek) {
		String[] DayNames = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		return DayNames[dayOfWeek - 1];
	}
	
	public static String theDayNumber(int dayNum) {
		String[] DayNumber = { "1","2","3","4","5","6","7","8","9"};
		
		if(dayNum<10) {
		return DayNumber[dayNum - 1];
		}
		else 
		return Integer.toString(dayNum);
	}

	// Picks up current system for Departure DAte and +7 days for Return date
	// Returns in format tue 13 Apr 2019
	public static DatePicker getDates() {
		DatePicker date = new DatePicker();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, Integer.parseInt(prop.getProperty("StartDays")));
		String sdfStartMonth = new SimpleDateFormat("MM").format(cal.getTime());
		String startMonthName = theMonth(Integer.parseInt(sdfStartMonth));
		
		String sdfStartDayOfWeek = new SimpleDateFormat("u").format(cal.getTime());
		String startDayOfWeekName = theDay(Integer.parseInt(sdfStartDayOfWeek));
		
		String sdfStartDayNum = new SimpleDateFormat("d").format(cal.getTime());
		String startDayNumber = theDayNumber(Integer.parseInt(sdfStartDayNum));


		// Mon Dec 02 14:26:15 IST 2019
		System.out.println(cal.getTime());

		System.out.println(startMonthName);
		System.out.println(startDayOfWeekName);
		System.out.println(startDayNumber);

		String[] rawDate = cal.getTime().toString().split(" ");

		// "Thursday, December 26, 2019"
	//	date.startDate = startDayOfWeekName + ", " + startMonthName + " " + rawDate[2] + ", " + rawDate[5];
		date.startDate = startDayOfWeekName + ", " + startMonthName + " " + startDayNumber + ", " + rawDate[5];
		System.out.println(date.startDate);

		cal.add(Calendar.DATE, Integer.parseInt(prop.getProperty("EndDays")));
		String sdfEndMonth = new SimpleDateFormat("MM").format(cal.getTime());
		String endMonthName = theMonth(Integer.parseInt(sdfEndMonth));
		
		String sdfEndDayOfWeek = new SimpleDateFormat("u").format(cal.getTime());
		String endDayOfWeekName = theDay(Integer.parseInt(sdfEndDayOfWeek));
		
		String sdfEndDayNum = new SimpleDateFormat("d").format(cal.getTime());
		String endDayNumber = theDayNumber(Integer.parseInt(sdfEndDayNum));

		// Mon Dec 02 14:26:15 IST 2019
		System.out.println(cal.getTime());

		System.out.println(endMonthName);
		System.out.println(endDayOfWeekName);

		String[] rawDateE = cal.getTime().toString().split(" ");

		// "Thursday, December 26, 2019"
	//	date.endDate = endDayOfWeekName + ", " + endMonthName + " " + rawDateE[2] + ", " + rawDateE[5];
		date.endDate = endDayOfWeekName + ", " + endMonthName + " " + endDayNumber + ", " + rawDateE[5];
		System.out.println(date.endDate);
		return date;
	}

}
