package cz.cvut.fit.genepi.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 * The Class DeniedController.
 */
@Controller
public class DeniedController {
	
	/**
	 * Simply selects the denied view to render by returning its name.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String deniedGET(Locale locale, Model model) {		
		return "deniedView";
	}	
}
