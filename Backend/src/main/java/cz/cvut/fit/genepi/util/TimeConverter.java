package cz.cvut.fit.genepi.util;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import org.joda.time.DateTime;
import org.joda.time.Years;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeConverter {

    public static String getCurrentAge(PatientEntity patient) {
        DateTime birth = new DateTime(patient.getBirthday());
        DateTime epilepsy = new DateTime(Calendar.getInstance().getTime());
        Years age = Years.yearsBetween(birth.withTimeAtStartOfDay(), epilepsy.withTimeAtStartOfDay());

        return Integer.toString(age.getYears());
    }

    public static String getAgeAtTheBeginningOfEpilepsy(PatientEntity patient) {
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
}
