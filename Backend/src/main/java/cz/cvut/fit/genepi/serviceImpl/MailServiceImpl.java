package cz.cvut.fit.genepi.serviceImpl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.MailService;

// TODO: Auto-generated Javadoc
/**
 * The Class MailService.
 */
@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MessageSource messageSource;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(MailServiceImpl.class);

	/** The Message type. */
	private String MessageType;

	/**
	 * Gets the message type.
	 * 
	 * @return the message type
	 */
	public String getMessageType() {
		return MessageType;
	}

	/**
	 * Sets the message type.
	 * 
	 * @param messageType
	 *            the new message type
	 */
	public void setMessageType(String messageType) {
		MessageType = messageType;
	}

	/**
	 * Send mail.
	 * 
	 * @param recipient
	 *            the recipient
	 * @param map
	 *            the map
	 * @throws Exception
	 *             the exception
	 */
	public void sendMail(String recipient, HashMap<String, Object> map,
			Locale locale) throws Exception { // Recipient's email
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

			String encodingOptions = "text/html; charset=UTF-8";
			message.setHeader("Content-Type", encodingOptions);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			if (map.get("subject").equals("changeOfThePassword")) {
				message.setSubject("Changed password to GENEPI system");
				UserEntity user = (UserEntity) map.get("user");

				/*
				 * String text = "Dear " + user.getUsername() + ",\n\n" +
				 * "your password was changed to: " + map.get("password") +
				 * ".\n\nRegards,\nGENEPI team.";
				 */
				String[] messagePrameters = new String[] { user.getUsername(),
						(String) map.get("password") };
				String text = messageSource.getMessage("changedPassword",
						messagePrameters, locale);
				System.out.println(text);
				message.setText(text);
				Transport.send(message);

				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date today = Calendar.getInstance().getTime();
				String reportDate = df.format(today);
				logger.info(reportDate
						+ " Message about the change of the password was sent to user "
						+ user.getId());
			} else if (map.get("subject").equals("creationOfANewUser")) {
				message.setSubject("New account to GENEPI system","utf-8");
				UserEntity user = (UserEntity) map.get("user");
				/*
				 * String text = "Dear " + user.getUsername() + ",\n\n" +
				 * "your account was created. Your password is: " +
				 * map.get("password") +
				 * ".\nPlease change it in your user administration as soon as possible.\n\nRegards,\nGENEPI team."
				 * ;
				 */
				String[] messagePrameters = new String[] { user.getUsername(),
						(String) map.get("password") };
				String text = messageSource.getMessage("userCreated",
						messagePrameters, locale);
				System.out.println(text);
				message.setText(text, "UTF-8");
				
				MimeMessage message2 = new MimeMessage( session ); 

				message2.setFrom(new InternetAddress(from));

				// Set To: header field of the header.
				message2.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to));

				
				
				// Setting the Subject and Content Type 
				message2.setSubject( "neco", "utf-8" ); // <---- 

				// Create a message part to represent the body text 
				BodyPart messageBodyPart = new MimeBodyPart(); 
				messageBodyPart.setContent( text, "text/html; charset=utf-8" ); // <---- 

				// use a MimeMultipart as we need to handle the file attachments 
				Multipart multipart = new MimeMultipart(); 

				// add the message body to the mime message 
				multipart.addBodyPart( messageBodyPart ); 

				// Put all message parts in the message 
				message2.setContent( multipart ); 

				Transport.send( message2 );
				
				
				
				Transport.send(message);

				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date today = Calendar.getInstance().getTime();
				String reportDate = df.format(today);
				logger.info(reportDate
						+ " Message about the creation of a new account was sent to user "
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
