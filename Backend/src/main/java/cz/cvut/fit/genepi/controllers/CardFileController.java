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
 * The Class CardFileController.
 */
@Controller
public class CardFileController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(CardFileController.class);

	/**
	 * selects the profile view to render by returning its name.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */

	@RequestMapping(value = "/cardFile", method = RequestMethod.POST)
	public String cardFilePOST(Locale locale, Model model) {	
		return "cardFile";
	}

	/**
	 * Card file get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/cardFile", method = RequestMethod.GET)
	public String cardFileGET(Locale locale, Model model) {
		return "cardFile";
	}
}