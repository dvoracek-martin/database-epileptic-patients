package cz.cvut.fit.genepi.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeniedController {
	
	/**
	 * Simply selects the denied view to render by returning its name.
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "deniedView";
	}	
}
