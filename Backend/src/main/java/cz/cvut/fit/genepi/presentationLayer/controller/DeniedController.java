package cz.cvut.fit.genepi.presentationLayer.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class is a controller class which handles requests connected with a
 * denied page.
 */
@Controller
public class DeniedController {

	/**
	 * Handles the request to access denied page.
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the string of a view to be rendered.
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String deniedGET(Locale locale, Model model) {
		return "deniedView";
	}
}