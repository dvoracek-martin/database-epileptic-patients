package cz.cvut.fit.genepi.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/anamnesis/create", method = RequestMethod.GET)
	public String createAnamnesisGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);
		model.addAttribute("patient", patient);
		model.addAttribute("anamnesis", new AnamnesisEntity());
		return "patient/anamnesis/createView";
	}

	/**
	 * Adds the anamnesis.
	 * 
	 * @param anamnesis
	 *            the anamnesis
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/anamnesis/add", method = RequestMethod.POST)
	public String addAnamnesis(
			@ModelAttribute("anamnesis") @Valid AnamnesisEntity anamnesis,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/anamnesis/createView";
		} else {
			anamnesis.setpatientId(patientID);
			anamnesisService.save(anamnesis);
			return "redirect:/patient/" + patientID + "/anamnesis/list";
		}
	}

	@RequestMapping(value = "/patient/{patientID}/anamnesis/{anamnesisID}/delete", method = RequestMethod.GET)
	public String deleteAnamnesis(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("anamnesisID") Integer anamnesisID) {

		anamnesisService.delete(anamnesisService.findByID(
				AnamnesisEntity.class, anamnesisID));
		return "redirect:/patient/" + patientID + "/anamnesis/list";
	}

	/**
	 * Patient overview get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/anamnesis/list", method = RequestMethod.GET)
	public String patientOverviewGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);
		model.addAttribute("patient", patient);
		List<AnamnesisEntity> anamnesisEntities = new ArrayList<AnamnesisEntity>();
		anamnesisEntities = anamnesisService
				.findAnamnesisByPatientID(patientID);
		Collections.reverse(anamnesisEntities);
		model.addAttribute("anamnesisList", anamnesisEntities);
		return "patient/anamnesis/listView";
	}
}