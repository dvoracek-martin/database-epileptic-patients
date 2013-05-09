package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreatedPatientController {
	private static final Logger logger = LoggerFactory
			.getLogger(CreatedPatientController.class);
	
	/**
	 * selects the profile view to render by returning its name.
	 */
	@RequestMapping(value = "/createdPatient", method = RequestMethod.POST)
	public String createdPatientPOST(Locale locale, Model model) {	
		return "createdPatientView";
	}
	
	@RequestMapping(value = "/createdPatient", method = RequestMethod.GET)
	public String createdPatientGET(Locale locale, Model model) {	
		return "createdPatientView";
	}
	
}