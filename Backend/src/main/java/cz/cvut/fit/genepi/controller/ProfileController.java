package cz.cvut.fit.genepi.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class MyProfileController.
 */
@Controller
public class ProfileController {

	/** The user service. */
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profileGET(Locale locale, Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		model.addAttribute("user",
				userService.findUserByUsername(auth.getName()));
		return "profileView";
	}
}
