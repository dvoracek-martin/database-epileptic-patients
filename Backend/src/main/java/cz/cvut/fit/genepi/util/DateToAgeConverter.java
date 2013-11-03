package cz.cvut.fit.genepi.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateToAgeConverter {

	public static String getAge(int beginning) {
		DateFormat df = new SimpleDateFormat("yyyy");
		Date today = Calendar.getInstance().getTime();
		String currentYear = df.format(today);
		int year=Integer.parseInt(currentYear);		
		return Integer.toString(year-beginning);		
	}
}
