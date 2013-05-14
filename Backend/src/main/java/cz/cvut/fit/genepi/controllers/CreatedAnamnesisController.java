package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 * The Class CreatedAnamnesisController.
 */
@Controller
public class CreatedAnamnesisController {

	
	/**
	 * selects the profile view to render by returning its name.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/createdAnamnesis", method = RequestMethod.POST)
	public String createdPatientPOST(Locale locale, Model model) {	
		return "createdAnamnesisView";
	}
	
	/**
	 * Created patient get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/createdAnamnesis", method = RequestMethod.GET)
	public String createdPatientGET(Locale locale, Model model) {	
		return "createdAnamnesisView";
	}
	
}