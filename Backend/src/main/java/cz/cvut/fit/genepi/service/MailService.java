package cz.cvut.fit.genepi.service;

import java.util.HashMap;

public interface MailService {

	public void sendMail(String attachmentName, String recipient, HashMap<String,String> map)
			throws Exception;

}
