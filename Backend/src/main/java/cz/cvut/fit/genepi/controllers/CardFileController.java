package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CardFileController {
	private static final Logger logger = LoggerFactory
			.getLogger(CardFileController.class);

	/**
	 * selects the profile view to render by returning its name.
	 */

	@RequestMapping(value = "/cardFile", method = RequestMethod.POST)
	public String cardFilePOST(Locale locale, Model model) {	
		return "cardFile";
	}

	@RequestMapping(value = "/cardFile", method = RequestMethod.GET)
	public String cardFileGET(Locale locale, Model model) {
		return "cardFile";
	}
}