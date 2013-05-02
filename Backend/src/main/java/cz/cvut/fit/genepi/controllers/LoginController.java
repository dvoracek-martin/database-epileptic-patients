package cz.cvut.fit.genepi.controllers;

import java.util.Date;
import java.util.Locale;

import model.DBUser;

import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import util.HibernateUtil;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	/**
	 * Simply selects the admin view to render by returning its name.
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("LOGIN! The client locale is {}.", locale);

		/*
		 * =============================================== 
		 * THIS BLOCK DEMONSTRATES THE WORK WITH HIBERNATE 
		 * ===============================================
		 */

		// create new session via HibernateUtil class
		// this class seeks for the hibernate.cfg.xml file and maps the entities
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// create new object according to its model
		DBUser user = new DBUser();

		user.setUserId(101);
		user.setUsername("superman");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());

		session.save(user);

		// save the data to the database
		session.getTransaction().commit();

		// close the connection
		session.disconnect();

		return "login";
	}
}