package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UnderConstructionController {
	private static final Logger logger = LoggerFactory
			.getLogger(UnderConstructionController.class);
	
	/**
	 * selects the profile view to render by returning its name.
	 */
	@RequestMapping(value = "/underConstruction", method = RequestMethod.POST)
	public String patientsListPOST(Locale locale, Model model) {	
		return "underConstructionView";
	}
	
	@RequestMapping(value = "/underConstruction", method = RequestMethod.GET)
	public String patientsListGET(Locale locale, Model model) {	
		return "underConstructionView";
	}
	
}