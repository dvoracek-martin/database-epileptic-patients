package cz.cvut.fit.genepi.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.entity.NewsMessageEntity;
import cz.cvut.fit.genepi.service.NewsMessageService;

// TODO: Auto-generated Javadoc
/**
 * Handles requests for the application home page.
 */
@Scope("session")
@Controller
public class HomeController {

	@Autowired
	private NewsMessageService newsMessageService;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

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
			logger.info(reportDate + " Error when attemting to send an email: "
					+ sw.toString());

			mex.printStackTrace();
		}

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);

		/*
		 * next line allows you to access property formattedDate within your
		 * home.jsp page. you can access it with writting ${serverTime} just to
		 * your html code
		 */
		model.addAttribute("patientList",
				newsMessageService.findAll(NewsMessageEntity.class));
		model.addAttribute("serverTime", formattedDate);
		return "homeView";
	}
}
