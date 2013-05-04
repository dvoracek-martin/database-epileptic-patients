package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {
	private static final Logger logger = LoggerFactory
			.getLogger(ProfileController.class);

	/**
	 * selects the profile view to render by returning its name.
	 */

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String loginPOST(Locale locale, Model model) {	
		return "profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String loginGET(Locale locale, Model model) {
		return "profile";
	}
}
