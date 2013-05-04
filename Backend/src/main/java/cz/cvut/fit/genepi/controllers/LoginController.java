package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.modelsImpl.UserDAOImpl;

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

		// create new object according to its model and call save method then
		UserDAOImpl user = new UserDAOImpl();
		user.createUser(1, "username", "createdBy");		
		user.saveUser();

		return "login";
	}
}