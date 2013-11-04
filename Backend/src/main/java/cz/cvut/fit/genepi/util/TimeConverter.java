package cz.cvut.fit.genepi.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeConverter {

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
	
	public static String getDate(Date date){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String formatedDate=df.format(date);
		formatedDate=formatedDate.substring(0,10);
		return formatedDate;	
	}
}
