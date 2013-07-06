package cz.cvut.fit.genepi.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 * The Class AnamnesisController.
 */
@Controller
public class AnamnesisController {


	@RequestMapping(value = "/anamnesis", method = RequestMethod.POST)
	public String anamnesisPOST(Locale locale, Model model) {
		return "anamnesisView";
	}

	@RequestMapping(value = "/anamnesis", method = RequestMethod.GET)
	public String anamnesisGET(Locale locale, Model model) {
		return "anamnesisView";
	}

	@RequestMapping(value = "/createAnamnesis", method = RequestMethod.GET)
	public String CreateAnamnesisGET(Locale locale, Model model) {
		return "createAnamnesisView";
	}

	@RequestMapping(value = "/createdAnamnesis", method = RequestMethod.GET)
	public String createdAnamnesisGET(Locale locale, Model model) {
		return "createdAnamnesisView";
	}
}