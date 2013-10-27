package cz.cvut.fit.genepi.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class is a controller class which handles requests connected with a denied page.
 */
@Controller
public class DeniedController {

	/**
	 * Handles the request to access denied page.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @return the string of a view to be rendered.
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String deniedGET(Model model, Locale locale) {
		return "deniedView";
	}
}
