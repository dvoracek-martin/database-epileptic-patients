package cz.cvut.fit.genepi.controller;

import java.util.Date;
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

import cz.cvut.fit.genepi.entity.AnamnesisEntity;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.service.AnamnesisService;
import cz.cvut.fit.genepi.service.PatientService;

// TODO: Auto-generated Javadoc
/**
 * The Class AnamnesisController.
 */
@Controller
public class AnamnesisController {

	/** The patient service. */
	@Autowired
	private PatientService patientService;

	/** The anamnesis service. */
	@Autowired
	private AnamnesisService anamnesisService;

	/**
	 * Creates the anamnesis get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @param patientID the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/createAnamnesis", method = RequestMethod.GET)
	public String createAnamnesisGET(Locale locale, Model model, @PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(patientID);
		model.addAttribute("patient", patient);
		model.addAttribute("anamnesis", new AnamnesisEntity());
		return "createAnamnesisView";
	}

	/**
	 * Adds the anamnesis.
	 *
	 * @param anamnesis the anamnesis
	 * @param result the result
	 * @param patientID the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/addAnamnesis", method = RequestMethod.POST)
	public String addAnamnesis(
			@ModelAttribute("anamnesis") @Valid AnamnesisEntity anamnesis,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "createAnamnesisView";
		} else {
			anamnesis.setAdded(new Date());
			anamnesisService.save(anamnesis);
			return "redirect:/anamnesis/"
					+ patientID;
		}
	}

	/**
	 * Patient overview get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @param patientID the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/anamnesis/{patientID}", method = RequestMethod.GET)
	public String patientOverviewGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(patientID);
		model.addAttribute("patient", patient);
		model.addAttribute("anamnesisList",
				anamnesisService.findAnamnesisByPatientID(patientID));
		return "anamnesisView";
	}
}