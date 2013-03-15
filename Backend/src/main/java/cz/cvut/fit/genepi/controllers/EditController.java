package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditController {
	
	private static final Logger logger = LoggerFactory.getLogger(EditController .class);
	
	/**
	 * Simply selects the edit view to render by returning its name.
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Accessing edit page!.", locale);
		
		return "edit";
	}	
}
