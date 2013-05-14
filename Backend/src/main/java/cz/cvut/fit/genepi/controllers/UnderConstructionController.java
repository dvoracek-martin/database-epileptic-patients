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
 * The Class UnderConstructionController.
 */
@Controller
public class UnderConstructionController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(UnderConstructionController.class);
	
	/**
	 * selects the profile view to render by returning its name.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/underConstruction", method = RequestMethod.POST)
	public String patientsListPOST(Locale locale, Model model) {	
		return "underConstructionView";
	}
	
	/**
	 * Patients list get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/underConstruction", method = RequestMethod.GET)
	public String patientsListGET(Locale locale, Model model) {	
		return "underConstructionView";
	}
	
}