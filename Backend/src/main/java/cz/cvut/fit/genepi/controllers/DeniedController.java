package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeniedController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * Simply selects the denied view to render by returning its name.
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String denied(Locale locale, Model model) {
		logger.info("DENIED! The client locale is {}.", locale);
		
		return "denied";
	}	
}