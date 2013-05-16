package cz.cvut.fit.genepi.controllers;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.cvut.fit.genepi.entities.AnamnesisEntity;
import cz.cvut.fit.genepi.entities.ContactEntity;
import cz.cvut.fit.genepi.entities.PatientEntity;
import cz.cvut.fit.genepi.managers.ContactManager;
import cz.cvut.fit.genepi.managers.AnamnesisManager;
import cz.cvut.fit.genepi.managers.PatientManager;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientOverviewController.
 */
@Controller
public class PatientOverviewController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(PatientOverviewController.class);

	/** The id. */
	private int id;

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the patient entity
	 */
	public PatientEntity findByID(int id) {
		PatientManager patientImpl = new PatientManager();
		return patientImpl.findByID(id);
	}

	// returns current patient from dtb according to id
	/**
	 * Find by id.
	 *
	 * @return the patient entity
	 */
	public PatientEntity findByID() {
		PatientManager patientManager = new PatientManager();
		return patientManager.findByID(this.id);
	}

	/**
	 * Find contact by id.
	 *
	 * @param id the id
	 * @return the contact entity
	 */
	public ContactEntity findContactByID(int id) {
		ContactManager contactManager = new ContactManager();
		return contactManager.findByID(id);
	}
	
	public AnamnesisEntity findAnamnesisByPatientID(int patient_id){
		AnamnesisManager anamnesisManager = new AnamnesisManager();
		return anamnesisManager.findAnamnesisByPatientID(patient_id);
	}

	/**
	 * Creates the new patient.
	 *
	 * @param nin the nin
	 * @param birthday the birthday
	 * @param gender the gender
	 * @param doctorId the doctor id
	 * @param deleted the deleted
	 * @param checked the checked
	 * @param contactId the contact id
	 * @param commentId the comment id
	 */
	public void createNewPatient(String nin, Date birthday, String gender,
			int doctorId, int deleted, int checked, int contactId, int commentId) {
		PatientManager patientManager = new PatientManager();
		patientManager.createPatient(nin, birthday, gender, doctorId, deleted,
				checked, contactId, commentId);
		patientManager.save();
		logger.info("Created new anamnesis for patient nin: "+nin);
	}

	/**
	 * selects the profile view to render by returning its name.
	 *
	 * @param id the id
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */

	@RequestMapping(value = "/patientOverview", method = RequestMethod.POST)
	public String patientOverviewPOST(@RequestParam("id") int id,
			Locale locale, Model model) {
		this.id = id;
		model.addAttribute("id", id);
		return "patientOverviewView";
	}

	/**
	 * Patient overview post.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/patientOverview", method = RequestMethod.GET)
	public String patientOverviewGET(Locale locale, Model model) {
		return "patientOverviewView";
	}
}
