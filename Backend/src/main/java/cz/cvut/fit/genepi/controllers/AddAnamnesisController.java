package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 * The Class AddAnamnesisController.
 */
@Controller
public class AddAnamnesisController {

	/**
	 * selects the profile view to render by returning its name.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
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
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/addAnamnesis", method = RequestMethod.GET)
	public String addAnamnesisGET(Locale locale, Model model) {
		return "addAnamnesisView";
	}
}