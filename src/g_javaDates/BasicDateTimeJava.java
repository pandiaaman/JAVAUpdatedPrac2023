package g_javaDates;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class BasicDateTimeJava {

	public static void main(String[] args) {
		/*
		 *  OLD WAYS OF HANDLING DATE AND TIME IN JAVA
java.util.Date: It is used to show specific instant of time, with unit of millisecond.

java.util.Calendar: It is an abstract class that provides methods for converting between instances and manipulating the calendar fields in different ways.

java.text.SimpleDateFormat: It is a class that is used to format and parse the dates in a predefined manner or user defined pattern.

java.util.TimeZone: It represents a time zone offset, and also figures out daylight savings.
		 */

		
		//java.util.Date implements Serializable, Comparable, Cloneable
		Date date = new Date();
		System.out.println(date);
		
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(df1.format(date));
		
		
		LocalDateTime dtm1 = LocalDateTime.now();
		System.out.println("local date time " + dtm1);
		System.out.println("local date : " + dtm1.toLocalDate());
		System.out.println("local time : " + dtm1.toLocalTime());
		
		//Calendar class
		
		Calendar cal = Calendar.getInstance();
		System.out.println("complete calendar object : " +cal);
		System.out.println("current year " + cal.get(Calendar.YEAR));
		System.out.println("current date " + cal.get(Calendar.DATE));
		System.out.println("current month " + cal.get(Calendar.MONTH));
		
		//setting a calendar to a diffferent date
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, 4);
		cal1.add(Calendar.MONTH, 3);
		cal1.add(Calendar.YEAR, 2020);
		
		System.out.println("date provided by us :" + cal1.getTime());
		
		//getting maximum
		System.out.println("max no of days in july : " + (cal.getMaximum(Calendar.JULY)));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * Issues with above methods
		 * 
		 * Thread safety : Date and Calendar class are not thread safe, which leads to hard to debug concurrency issues
		 * Difficult time zone handling : is difficult with Date and Calendar classes as developers have to write the logic
		 * Bad API designing : classic APIs does not provide methods to perform basic day to day functions
		 */
		
		/*
		 * NEW DATE TIME API IN JAVA
		 */
	}

}
