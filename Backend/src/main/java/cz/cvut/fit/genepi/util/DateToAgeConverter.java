package cz.cvut.fit.genepi.util;

import org.dozer.CustomConverter;
import org.dozer.MappingException;
import org.joda.time.DateTime;
import org.joda.time.Years;

import java.util.Date;

public class DateToAgeConverter implements CustomConverter {

    public Object convert(Object destination, Object source,
                          Class destClass, Class sourceClass) {

        if (source == null) {
            return null;
        }
        if (source instanceof Date) {

            DateTime born = new DateTime(source);
            DateTime now = new DateTime();

            Years age = Years.yearsBetween(born.withTimeAtStartOfDay(), now.withTimeAtStartOfDay());

            return age.getYears();
        } else {
            throw new MappingException("Converter TestCustomConverter "
                    + "used incorrectly. Arguments passed in were:"
                    + destination + " and " + source);
        }
    }
}
