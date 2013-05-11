package cz.cvut.fit.genepi.controllers;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.modelsImpl.PatientDAOImpl;

@Controller
public class CreatePatientController {
	private static final Logger logger = LoggerFactory
			.getLogger(CreatePatientController.class);
	
	// create new Patient	
		public void createNewPatient( String nin, Date birthday, String gender,
				int doctorId, int deleted, int checked, int contactId, int commentId){
			PatientDAOImpl patientImpl = new PatientDAOImpl();
			patientImpl.createPatient(nin, birthday, gender, doctorId, deleted, checked, contactId, commentId);
			patientImpl.save(patientImpl);
		}

	/**
	 * selects the profile view to render by returning its name.
	 */

	@RequestMapping(value = "/createPatient", method = RequestMethod.POST)
	public String createPatientPOST(Locale locale, Model model) {	
		return "createPatientView";
	}

	@RequestMapping(value = "/createPatient", method = RequestMethod.GET)
	public String createPatientGET(Locale locale, Model model) {
		return "createPatientView";
	}
}