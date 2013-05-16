package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.entities.AnamnesisEntity;
import cz.cvut.fit.genepi.entities.ContactEntity;
import cz.cvut.fit.genepi.managers.ContactManager;
import cz.cvut.fit.genepi.managers.AnamnesisManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AnamnesisController.
 */
@Controller
public class AnamnesisController {
	
	/**
	 * Selects the profile view to render by returning its name.
	 *
	 * @param id the id
	 * @return the contact entity
	 */

	public ContactEntity findContactByID(int id){
		ContactManager contactManager = new ContactManager();
		return contactManager.findByID(id);
	}
	
	public AnamnesisEntity findAnamnesisByPatientID(int patient_id){
		AnamnesisManager anamnesisManager = new AnamnesisManager();
		return anamnesisManager.findAnamnesisByPatientID(patient_id);
	}
	
	/**
	 * Anamnesis post.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/anamnesis", method = RequestMethod.POST)
	public String anamnesisPOST(Locale locale, Model model) {	
		return "anamnesisView";
	}

	/**
	 * Anamnesis get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/anamnesis", method = RequestMethod.GET)
	public String anamnesisGET(Locale locale, Model model) {
		return "anamnesisView";
	}
}