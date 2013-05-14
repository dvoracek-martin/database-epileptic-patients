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
 * The Class EditController.
 */
@Controller
public class EditController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(EditController .class);
	
	/**
	 * Simply selects the edit view to render by returning its name.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Accessing edit page!.", locale);
		
		return "edit";
	}	
}
