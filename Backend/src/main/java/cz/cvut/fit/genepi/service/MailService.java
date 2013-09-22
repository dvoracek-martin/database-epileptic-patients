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

import cz.cvut.fit.genepi.entity.UserEntity;

public class MailService {
	private static final Logger logger = LoggerFactory
			.getLogger(MailService.class);

	private String MessageType;

	public String getMessageType() {
		return MessageType;
	}

	public void setMessageType(String messageType) {
		MessageType = messageType;
	}

	public void sendMail(String recipient, HashMap<String, Object> map)
			throws Exception { // Recipient's email
								// ID needs to be
								// mentioned.
		String to = "Dworza@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "mailbot@genepi.com";

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
			if (map.get("subject").equals("changeOfThePassword")) {
				message.setSubject("Changed password to GENEPI system");
				UserEntity user = (UserEntity) map.get("user");
				String text = "Dear " + user.getUsername() + ",\n\n"
						+ "your password was changed to: "
						+ map.get("password") + ".\n\nRegards,\nGENEPI team.";
				message.setText(text);
				Transport.send(message);

				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date today = Calendar.getInstance().getTime();
				String reportDate = df.format(today);
				logger.info(reportDate
						+ " Message about the change of the password was sent to user "
						+ user.getId());
			} else if (map.get("subject").equals("creationOfANewUser")) {
				message.setSubject("New account to GENEPI system");
				UserEntity user = (UserEntity) map.get("user");
				String text = "Dear " + user.getUsername() + ",\n\n"
						+ "your account was created. Your password is: "
						+ map.get("password") + ".\nPlease change it in your user administration as soon as possible.\n\nRegards,\nGENEPI team.";
				message.setText(text);
				Transport.send(message);

				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date today = Calendar.getInstance().getTime();
				String reportDate = df.format(today);
				logger.info(reportDate
						+ " Message about the creation of new account was sent to user "
						+ user.getId());
			} else {
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date today = Calendar.getInstance().getTime();
				String reportDate = df.format(today);
				logger.error(reportDate
						+ " Tried to send message with unknown subject");
			}
			// Send message

		} catch (MessagingException mex) {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date today = Calendar.getInstance().getTime();
			String reportDate = df.format(today);
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			mex.printStackTrace(pw);
			sw.toString(); // stack trace as a string
			logger.info(reportDate + " Error when attemting to send an email: "
					+ sw.toString());

			mex.printStackTrace();
		}
	}
}
