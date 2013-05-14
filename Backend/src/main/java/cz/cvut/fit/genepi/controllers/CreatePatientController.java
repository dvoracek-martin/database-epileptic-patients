package cz.cvut.fit.genepi.controllers;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.managers.PatientManager;

// TODO: Auto-generated Javadoc
/**
 * The Class CreatePatientController.
 */
@Controller
public class CreatePatientController {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(CreatePatientController.class);
	
	// create new Patient	
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
	public void createNewPatient( String nin, Date birthday, String gender,
				int doctorId, int deleted, int checked, int contactId, int commentId){
			PatientManager patientImpl = new PatientManager();
			patientImpl.createPatient(nin, birthday, gender, doctorId, deleted, checked, contactId, commentId);
			patientImpl.save();
			logger.info("Created new patient with nin: "+nin);
		}

	/**
	 * selects the profile view to render by returning its name.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */

	@RequestMapping(value = "/createPatient", method = RequestMethod.POST)
	public String createPatientPOST(Locale locale, Model model) {	
		return "createPatientView";
	}

	/**
	 * Creates the patient get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/createPatient", method = RequestMethod.GET)
	public String createPatientGET(Locale locale, Model model) {
		return "createPatientView";
	}
}