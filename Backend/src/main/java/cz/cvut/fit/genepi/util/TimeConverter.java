package cz.cvut.fit.genepi.util;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Years;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeConverter {

    public static String getCurrentAge(PatientDisplayVO patient) {
        DateTime birth = new DateTime(patient.getBirthday());
        DateTime today = new DateTime(Calendar.getInstance().getTime());
        Years age = Years.yearsBetween(birth.withTimeAtStartOfDay(), today.withTimeAtStartOfDay());

        return Integer.toString(age.getYears());
    }

    public static String getAgeAtTheBeginningOfEpilepsy(PatientDisplayVO patient) {
        DateTime birth = new DateTime(patient.getBirthday());
        if (patient.getAnamnesisList().size() < 1)
            return "NA";
        DateTime epilepsy = new DateTime(patient.getAnamnesisList().get(0).getBeginningEpilepsy());
        Years age = Years.yearsBetween(birth.withTimeAtStartOfDay(), epilepsy.withTimeAtStartOfDay());

        return Integer.toString(age.getYears());
    }

    public static String getDate(Date date) {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String formatedDate = df.format(date);
        formatedDate = formatedDate.substring(0, 10);
        return formatedDate;
    }

    public static boolean compareDates (Date first, Date second){
        boolean isFormer=true;

        DateTime fistDate = new DateTime(first);
        DateTime secondDate = new DateTime(second);
        Days countOfTheDays = Days.daysBetween(fistDate.withTimeAtStartOfDay(), secondDate.withTimeAtStartOfDay());

        if (countOfTheDays.getDays()>=0)
            isFormer=false;
        return isFormer;
    }

    public static boolean compareDates (Date first, DateTime second){
        boolean isFormer=true;

        DateTime fistDate = new DateTime(first);
        DateTime secondDate = new DateTime(second);
        Days countOfTheDays = Days.daysBetween(fistDate.withTimeAtStartOfDay(), secondDate.withTimeAtStartOfDay());

        if (countOfTheDays.getDays()>=0)
            isFormer=false;
        return isFormer;
    }
}
