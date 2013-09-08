package cz.cvut.fit.genepi.service;

public interface  MailService {
	public void send(String attachmentName) throws Exception ;
	public void sendMail(String attachmentName) throws Exception ;

}
