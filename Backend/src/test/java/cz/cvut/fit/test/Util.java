package cz.cvut.fit.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Util {

	private static final String CHARACTER = "a";

	public static String convertObjectToFormUrlEncodedBytes(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		Map<String, Object> propertyValues = mapper.convertValue(object,
				Map.class);

		Set<String> propertyNames = propertyValues.keySet();
		Iterator<String> nameIter = propertyNames.iterator();

		StringBuilder formUrlEncoded = new StringBuilder();

		for (int index = 0; index < propertyNames.size(); index++) {
			String currentKey = nameIter.next();
			Object currentValue = propertyValues.get(currentKey);

			formUrlEncoded.append(currentKey);
			formUrlEncoded.append("=");
			formUrlEncoded.append(currentValue);

			if (nameIter.hasNext()) {
				formUrlEncoded.append("&");
			}
		}

		return formUrlEncoded.toString();
	}

	public static String createRedirectViewPath(String path) {
		StringBuilder redirectViewPath = new StringBuilder();
		redirectViewPath.append("redirect:");
		redirectViewPath.append(path);
		return redirectViewPath.toString();
	}

	public static String createStringWithLength(int length) {
		StringBuilder builder = new StringBuilder();

		for (int index = 0; index < length; index++) {
			builder.append(CHARACTER);
		}

		return builder.toString();
	}
	
	public static String getDate(Date date){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String formatedDate=df.format(date);
		//formatedDate=formatedDate.substring(0,10);
		return formatedDate;	
	}
}