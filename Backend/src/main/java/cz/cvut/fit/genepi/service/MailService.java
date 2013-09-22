package cz.cvut.fit.genepi.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.cvut.fit.genepi.controller.HomeController;

public class MailService {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private String MessageType;

	public String getMessageType() {
		return MessageType;
	}

	public void setMessageType(String messageType) {
		MessageType = messageType;
	}

	public void sendMail(String attachmentName, String recipient,
			HashMap<String, String> map) throws Exception { // Recipient's email
															// ID needs to be
															// mentioned.
		String to = "Dworza@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "web@mail.com";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
			logger.info("Sent message successfully....");
		} catch (MessagingException mex) {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

			Date today = Calendar.getInstance().getTime();
			String reportDate = df.format(today);
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			mex.printStackTrace(pw);
			sw.toString(); // stack trace as a string
			logger.info(reportDate
					+ " Error when attemting to send an email: "
					+ sw.toString());

			mex.printStackTrace();
		}
	}
}
