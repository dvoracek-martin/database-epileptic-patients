package cz.cvut.fit.genepi.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.service.AnamnesisService;
import cz.cvut.fit.genepi.service.PatientService;

// TODO: Auto-generated Javadoc
/**
 * The Class CreatedPatientController.
 */
@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private AnamnesisService anamnesisService;

	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	public String addPatient(
			@ModelAttribute("patient") @Valid PatientEntity patient,
			BindingResult result) {
		if (result.hasErrors()) {
			return "createPatientView";
		} else {
			patientService.save(patient);
			return "redirect:/patientOverview/"
					+ Integer.toString(patient.getId());
		}
	}

	@RequestMapping(value = "/createPatient", method = RequestMethod.GET)
	public String createPatientGET(Locale locale, Model model) {
		model.addAttribute("patient", new PatientEntity());
		return "createPatientView";
	}

	@RequestMapping(value = "/patientOverview", method = RequestMethod.POST)
	public String patientOverviewPOST(@RequestParam("id") int id,
			Locale locale, Model model) {
		/* this.id = id; */
		model.addAttribute("id", id);
		return "patientOverviewView";
	}

	@RequestMapping(value = "/patientOverview/{patientID}", method = RequestMethod.GET)
	public String patientOverviewGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findPatientByID(patientID);	
		model.addAttribute("patient", patient);
		model.addAttribute("anamnesis",
				anamnesisService.findLatestAnamnesisByPatientID(patientID));
		return "patientOverviewView";
	}

	@RequestMapping(value = "/patientsList", method = RequestMethod.GET)
	public String patientsListGET(Locale locale, Model model) {
		model.addAttribute("patientList", patientService.findAll());
		return "patientsListView";
	}

}