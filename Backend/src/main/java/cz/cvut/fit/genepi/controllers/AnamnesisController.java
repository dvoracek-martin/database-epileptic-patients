package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.entities.ContactEntity;
import cz.cvut.fit.genepi.managers.ContactManager;

@Controller
public class AnamnesisController {
	private static final Logger logger = LoggerFactory
			.getLogger(AnamnesisController.class);

	/**
	 * selects the profile view to render by returning its name.
	 */

	public ContactEntity findContactByID(int id){
		ContactManager patientImpl = new ContactManager();
		return patientImpl.findByID(id);
	}
	
	@RequestMapping(value = "/anamnesis", method = RequestMethod.POST)
	public String loginPOST(Locale locale, Model model) {	
		return "anamnesisView";
	}

	@RequestMapping(value = "/anamnesis", method = RequestMethod.GET)
	public String loginGET(Locale locale, Model model) {
		return "anamnesisView";
	}
}