package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 * The Class MyProfileController.
 */
@Controller
public class MyProfileController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(MyProfileController.class);

	/**
	 * selects the profile view to render by returning its name.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */

	@RequestMapping(value = "/myProfile", method = RequestMethod.POST)
	public String loginPOST(Locale locale, Model model) {	
		return "myProfileView";
	}

	/**
	 * Login get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/myProfile", method = RequestMethod.GET)
	public String loginGET(Locale locale, Model model) {
		return "myProfileView";
	}
}
