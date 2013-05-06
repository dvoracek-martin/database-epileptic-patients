package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddAnamnesisController {
	private static final Logger logger = LoggerFactory
			.getLogger( AddAnamnesisController.class);

	/**
	 * selects the profile view to render by returning its name.
	 */

	@RequestMapping(value = "/addAnamnesis", method = RequestMethod.POST)
	public String addAnamnesisPOST(Locale locale, Model model) {	
		return "addAnamnesis";
	}

	@RequestMapping(value = "/addAnamnesis", method = RequestMethod.GET)
	public String addAnamnesisGET(Locale locale, Model model) {
		return "addAnamnesis";
	}
}