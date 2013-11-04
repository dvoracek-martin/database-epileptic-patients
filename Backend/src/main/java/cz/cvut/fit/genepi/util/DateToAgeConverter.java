package cz.cvut.fit.genepi.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateToAgeConverter {

	public static String getAge(Date beginningEpilepsy) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();		
		String currentYear = df.format(today);
		String beginningYear=df.format(beginningEpilepsy);
		
		
		currentYear=currentYear.substring(6,10);
		beginningYear=beginningYear.substring(6,10);
		int year=Integer.parseInt(currentYear);
		int beginning=Integer.parseInt(beginningYear);	
		
		return Integer.toString(year-beginning);		
	}
}
