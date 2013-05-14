package cz.cvut.fit.genepi.controllers;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.modelsImpl.PatientDAOImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class AddAnamnesisController.
 */
@Controller
public class AddAnamnesisController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(AddAnamnesisController.class);

	/**
	 * selects the profile view to render by returning its name.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */

	// addAnamnesis

	@RequestMapping(value = "/addAnamnesis", method = RequestMethod.POST)
	public String addAnamnesisPOST(Locale locale, Model model) {
		return "addAnamnesisView";
	}

	/**
	 * Adds the anamnesis get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/addAnamnesis", method = RequestMethod.GET)
	public String addAnamnesisGET(Locale locale, Model model) {
		return "addAnamnesisView";
	}
}