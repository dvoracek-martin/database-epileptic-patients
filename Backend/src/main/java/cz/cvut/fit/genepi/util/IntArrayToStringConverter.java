package cz.cvut.fit.genepi.util;


import org.dozer.CustomConverter;
import org.dozer.MappingException;

public class IntArrayToStringConverter implements CustomConverter {

    public Object convert(Object destination, Object source,
                          Class destClass, Class sourceClass) {
        if (source == null) {
            return null;
        }
        if (source instanceof int[]) {
            if (((int[]) source).length == 0) {
                return "[]";
            } else {
                int[] details = (int[]) source;
                StringBuilder sb = new StringBuilder();

                sb.append("[\"").append(details[0]);
                for (int i = 1; i < details.length; i++) {
                    sb.append("\",\"").append(details[i]);
                }
                sb.append("\"]");

                return sb.toString();
            }
        } else if (source instanceof String) {
            if(source.equals("[]")){
                return null;
            }
            String str = ((String) source).replaceAll("[^\\d,]", "");
            String[] numbers = str.split(",");
            int[] ints = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                ints[i] = Integer.parseInt(numbers[i]);
            }
            return ints;
        } else {
            throw new MappingException("Converter TestCustomConverter "
                    + "used incorrectly. Arguments passed in were:"
                    + destination + " and " + source);
        }
    }
}