package cz.cvut.fit.genepi.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import cz.cvut.fit.genepi.service.MailService;

public class MailServiceImpl implements MailService {

	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_HOST_PORT = "587";
	private static final String SMTP_AUTH_USER = "genepimailbot";
	private static final String SMTP_AUTH_PWD = "Kobliha0123";

	private String MessageType;

	public String getMessageType() {
		return MessageType;
	}

	public void setMessageType(String messageType) {
		MessageType = messageType;
	}

	public void sendMail(String attachmentName, String recipient,
			HashMap<String, String> map) throws Exception {

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties props = System.getProperties();

		// Setup mail server
		props.setProperty("mail.smtp.host", host);

		// Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(props);
		Transport transport = session.getTransport();

		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("genepi_mailbot@gmail.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(
				"Dworza@gmail.com"));
		message.setSubject("Some subject");
		message.setSentDate(new Date());

		MimeBodyPart messagePart = new MimeBodyPart();
		if (getMessageType().equals("newPassword")) {
			messagePart.setText("some text" + map.get("newPassword"));
		} else if (getMessageType().equals("newPassword")) {
			messagePart.setText("some text");
		} else if (getMessageType().equals("newPassword")) {
			messagePart.setText("some text");
		} else if (getMessageType().equals("newPassword")) {
			messagePart.setText("some text");
		} else {
			messagePart.setText("error");
		}

		//
		// Set the email attachment file
		//

		MimeBodyPart attachmentPart = new MimeBodyPart();
		if (attachmentName != null) {
			FileDataSource fileDataSource = new FileDataSource(attachmentName) {
				@Override
				public String getContentType() {
					return "application/octet-stream";
				}
			};

			attachmentPart.setDataHandler(new DataHandler(fileDataSource));
			attachmentPart.setFileName("newimage.jpg");
		}
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messagePart);
		if (attachmentName != null) {
			multipart.addBodyPart(attachmentPart);
		}
		message.setContent(multipart);

		transport.connect();
		transport.sendMessage(message,
				message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {

		@Override
		public PasswordAuthentication getPasswordAuthentication() {
			String username = SMTP_AUTH_USER;
			String password = SMTP_AUTH_PWD;
			return new PasswordAuthentication(username, password);
		}
	}
}
