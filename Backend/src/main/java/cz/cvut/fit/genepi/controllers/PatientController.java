package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {
	private static final Logger logger = LoggerFactory
			.getLogger(PatientController.class);

	/**
	 * selects the profile view to render by returning its name.
	 */

	@RequestMapping(value = "/patient", method = RequestMethod.POST)
	public String patientGET(Locale locale, Model model) {	
		return "patient";
	}

	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public String patientPOST(Locale locale, Model model) {
		return "patient";
	}
}
