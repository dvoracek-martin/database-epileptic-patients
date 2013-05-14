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

import cz.cvut.fit.genepi.entities.ContactEntity;
import cz.cvut.fit.genepi.entities.PatientEntity;
import cz.cvut.fit.genepi.managers.ContactManager;
import cz.cvut.fit.genepi.managers.PatientManager;

@Controller
public class PatientOverviewController {
	private static final Logger logger = LoggerFactory
			.getLogger(PatientOverviewController.class);

	private int id;

	// returns patient from dtb according to id
	public PatientEntity findByID(int id) {
		PatientManager patientImpl = new PatientManager();
		return patientImpl.findByID(id);
	}

	// returns current patient from dtb according to id
	public PatientEntity findByID() {
		PatientManager patientImpl = new PatientManager();
		return patientImpl.findByID(this.id);
	}

	public ContactEntity findContactByID(int id) {
		ContactManager patientImpl = new ContactManager();
		return patientImpl.findByID(id);
	}

	// create new Patient
	public void createNewPatient(String nin, Date birthday, String gender,
			int doctorId, int deleted, int checked, int contactId, int commentId) {
		PatientManager patientImpl = new PatientManager();
		patientImpl.createPatient(nin, birthday, gender, doctorId, deleted,
				checked, contactId, commentId);
		patientImpl.save();
	}

	/**
	 * selects the profile view to render by returning its name.
	 */

	@RequestMapping(value = "/patientOverview", method = RequestMethod.POST)
	public String patientOverviewPOST(@RequestParam("id") int id,
			Locale locale, Model model) {
		this.id = id;
		model.addAttribute("id", id);
		return "patientOverviewView";
	}

	@RequestMapping(value = "/patientOverview", method = RequestMethod.GET)
	public String patientOverviewPOST(Locale locale, Model model) {
		return "patientOverviewView";
	}
}
