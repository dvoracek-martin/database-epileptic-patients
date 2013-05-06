package cz.cvut.fit.genepi.controllers;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.models.PatientDAO;
import cz.cvut.fit.genepi.modelsImpl.PatientDAOImpl;

@Controller
public class PatientController {
	private static final Logger logger = LoggerFactory
			.getLogger(PatientController.class);

	// returns patient from dtb according to id	
	public PatientDAO findByID(int id) {
		PatientDAOImpl patientImpl = new PatientDAOImpl();
		return (PatientDAO) patientImpl.findByID(PatientDAO.class, id);		
	}
	
	// returns all patients from dtb
	public List<PatientDAO> findAll(){
		PatientDAOImpl patientImpl = new PatientDAOImpl();
		return (List<PatientDAO>) patientImpl.findAll(PatientDAO.class);	
	}
	
	// create new Patient	
	public void createNewPatient( String nin, Date birthday, String gender,
			int doctorId, int deleted, int checked, int contactId, int commentId){
		PatientDAOImpl patientImpl = new PatientDAOImpl();
		patientImpl.createPatient(nin, birthday, gender, doctorId, deleted, checked, contactId, commentId);
		patientImpl.save(patientImpl.patient);
	}
	
	
	/**
	 * selects the profile view to render by returning its name.
	 */	

	@RequestMapping(value = "/patient", method = RequestMethod.POST)
	public String patientGET(Locale locale, Model model) {	
		return "patient";
	}

	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public String patientPOST(Locale locale, Model model) {
		return "patient";
	}
}
