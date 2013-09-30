package cz.cvut.fit.genepi.service;

import java.util.HashMap;
import java.util.Locale;

public interface MailService {
	public void sendMail(String recipient, HashMap<String, Object> map,
			Locale locale) throws Exception;
}
