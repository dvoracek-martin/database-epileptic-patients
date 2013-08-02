package cz.cvut.fit.genepi.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.entity.PatientEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class AnamnesisController.
 */
@Controller
public class AnamnesisController {

	@RequestMapping(value = "/anamnesis", method = RequestMethod.GET)
	public String anamnesisGET(Locale locale, Model model) {
		return "anamnesisView";
	}

	@RequestMapping(value = "/createAnamnesis", method = RequestMethod.GET)
	public String createAnamnesisGET(Locale locale, Model model) {
		return "createAnamnesisView";
	}

	@RequestMapping(value = "/createdAnamnesis", method = RequestMethod.GET)
	public String createdAnamnesisGET(Locale locale, Model model) {
		return "createdAnamnesisView";
	}
	
	@RequestMapping(value = "/anamnesis/{patientID}", method = RequestMethod.GET)
	public String patientOverviewGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findPatientByID(patientID);	
		model.addAttribute("patient", patient);
		model.addAttribute("anamnesis",
				anamnesisService.findLatestAnamnesisByPatientID(patientID));
		return "patientOverviewView";
	}
}