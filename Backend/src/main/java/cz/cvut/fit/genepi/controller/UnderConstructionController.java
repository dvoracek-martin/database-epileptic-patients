package cz.cvut.fit.genepi.controller;

import java.util.Locale;

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

	/**
	 * selects the profile view to render by returning its name.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/underConstruction", method = RequestMethod.POST)
	public String underConstructionPOST(Locale locale, Model model) {
		return "underConstructionView";
	}

	/**
	 * Patients list get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/underConstruction", method = RequestMethod.GET)
	public String underConstructionGET(Locale locale, Model model) {
		return "underConstructionView";
	}

}