package cz.cvut.fit.genepi.controllers;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.entities.PatientEntity;
import cz.cvut.fit.genepi.managers.PatientManagers;

@Controller
public class PatientsListController {
	private static final Logger logger = LoggerFactory
			.getLogger(PatientsListController.class);

	// returns all patients from dtb
	public List<PatientEntity> findAll(){
		PatientManagers patientImpl = new PatientManagers();
		return patientImpl.findAll();	
	}
	
	/**
	 * selects the profile view to render by returning its name.
	 */	

	@RequestMapping(value = "/patientsList", method = RequestMethod.POST)
	public String patientsListGET(Locale locale, Model model) {	
		return "patientsListView";
	}

	@RequestMapping(value = "/patientsList", method = RequestMethod.GET)
	public String patientsListPOST(Locale locale, Model model) {
		return "patientsListView";
	}
}