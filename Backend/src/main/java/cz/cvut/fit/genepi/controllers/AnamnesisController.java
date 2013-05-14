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

// TODO: Auto-generated Javadoc
/**
 * The Class AnamnesisController.
 */
@Controller
public class AnamnesisController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(AnamnesisController.class);

	/**
	 * selects the profile view to render by returning its name.
	 *
	 * @param id the id
	 * @return the contact entity
	 */

	public ContactEntity findContactByID(int id){
		ContactManager patientImpl = new ContactManager();
		return patientImpl.findByID(id);
	}
	
	/**
	 * Login post.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/anamnesis", method = RequestMethod.POST)
	public String loginPOST(Locale locale, Model model) {	
		return "anamnesisView";
	}

	/**
	 * Login get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/anamnesis", method = RequestMethod.GET)
	public String loginGET(Locale locale, Model model) {
		return "anamnesisView";
	}
}