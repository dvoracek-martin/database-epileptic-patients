package cz.cvut.fit.genepi.service;

public interface MailService {

	public void send(String attachmentName, String recipient) throws Exception;

	public void sendMail(String attachmentName, String recipient)
			throws Exception;

}
