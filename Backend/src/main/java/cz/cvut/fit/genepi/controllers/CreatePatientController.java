package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreatePatientController {
	private static final Logger logger = LoggerFactory
			.getLogger(CreatePatientController.class);

	/**
	 * selects the profile view to render by returning its name.
	 */

	@RequestMapping(value = "/createPatient", method = RequestMethod.POST)
	public String createPatientPOST(Locale locale, Model model) {	
		return "createPatient";
	}

	@RequestMapping(value = "/createPatient", method = RequestMethod.GET)
	public String createPatientGET(Locale locale, Model model) {
		return "createPatient";
	}
}