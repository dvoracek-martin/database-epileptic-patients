package cz.cvut.fit.genepi.controller.card;

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

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.card.AnamnesisService;

/**
 * This class is a controller class which handles requests connected with
 * anamnesis.
 */
@Controller
public class AnamnesisController {

	/** The patient service. */
	private PatientService patientService;

	/** The anamnesis service. */
	private AnamnesisService anamnesisService;

	/**
	 * Constructor which serves to autowire services.
	 * 
	 * 
	 * @param patientService
	 *            the patientService to be autowired.
	 * @param anamnesisService
	 *            the anamnesisService to be autowired.
	 */
	@Autowired
	public AnamnesisController(PatientService patientService,
			AnamnesisService anamnesisService) {
		this.patientService = patientService;
		this.anamnesisService = anamnesisService;
	}

	/**
	 * Handles the GET request to access page for creating new anamnesis.
	 * 
	 * @param patientId
	 *            the id of a patient we are creating an anamnesis.
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the string of a view to be rendered.
	 */
	@RequestMapping(value = "/patient/{patientId}/anamnesis/create", method = RequestMethod.GET)
	public String anamnesisCreateGET(
			@PathVariable("patientId") Integer patientId, Locale locale,
			Model model) {

		model.addAttribute("patient",
				patientService.findByID(PatientEntity.class, patientId));
		model.addAttribute("anamnesis", new AnamnesisEntity());
		return "patient/anamnesis/createView";
	}

	/**
	 * Handles the POST request to create new anamnesis.
	 * 
	 * @param anamnesis
	 *            the anamnesis which was filled in form at front-end. It is
	 *            grabbed from POST string and validated.
	 * 
	 * @param result
	 *            the result of binding form from front-end to an
	 *            AnamnesisEntity. It is used to determine if there were some
	 *            errors during binding.
	 * 
	 * @param patientId
	 *            the id of a patient we are creating an anamnesis.
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the string of a view to be rendered if the binding has errors
	 *         otherwise, the string of an address to which the user will be
	 *         redirected.
	 */
	@RequestMapping(value = "/patient/{patientId}/anamnesis/create", method = RequestMethod.POST)
	public String anamnesisCreatePOST(
			@ModelAttribute("anamnesis") @Valid AnamnesisEntity anamnesis,
			BindingResult result, @PathVariable("patientId") Integer patientId,
			Locale locale, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("patient",
					patientService.findByID(PatientEntity.class, patientId));
			return "patient/anamnesis/createView";
		} else {
			anamnesis.setPatient(patientService.findByID(PatientEntity.class,
					patientId));
			anamnesisService.save(anamnesis);
			return "redirect:/patient/" + patientId + "/anamnesis/list";
		}
	}

	/**
	 * Handles the GET request to access page for editing anamnesis.
	 * 
	 * @param patientId
	 *            the id of a patient we are creating an anamnesis.
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the string of a view to be rendered.
	 */
	@RequestMapping(value = "/patient/{patientId}/anamnesis/{anamnesisId}/edit", method = RequestMethod.GET)
	public String anamnesisEditGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("anamnesisId") Integer anamnesisId, Locale locale,
			Model model) {

		model.addAttribute("patient",
				patientService.findByID(PatientEntity.class, patientId));
		model.addAttribute("anamnesis", anamnesisService.findByID(AnamnesisEntity.class, anamnesisId));
		return "patient/anamnesis/createView";
	}

	/**
	 * Handles the POST request to edit anamnesis.
	 * 
	 * @param anamnesis
	 *            the anamnesis which was filled in form at front-end. It is
	 *            grabbed from POST string and validated.
	 * 
	 * @param result
	 *            the result of binding form from front-end to an
	 *            AnamnesisEntity. It is used to determine if there were some
	 *            errors during binding.
	 * 
	 * @param patientId
	 *            the id of a patient we are creating an anamnesis.
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the string of a view to be rendered if the binding has errors
	 *         otherwise, the string of an address to which the user will be
	 *         redirected.
	 */
	@RequestMapping(value = "/patient/{patientId}/anamnesis/{anamnesisId}/edit", method = RequestMethod.POST)
	public String anamnesisEditPOST(
			@ModelAttribute("anamnesis") @Valid AnamnesisEntity anamnesis,
			BindingResult result, @PathVariable("patientId") Integer patientId,
			Locale locale, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("patient",
					patientService.findByID(PatientEntity.class, patientId));
			return "patient/anamnesis/createView";
		} else {
			anamnesis.setPatient(patientService.findByID(PatientEntity.class,
					patientId));
			anamnesisService.save(anamnesis);
			return "redirect:/patient/" + patientId + "/anamnesis/list";
		}
	}

	/**
	 * Delete anamnesis.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param patientID
	 *            the patient id
	 * @param anamnesisID
	 *            the anamnesis id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/anamnesis/{anamnesisID}/delete", method = RequestMethod.GET)
	public String anamnesisDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("anamnesisID") Integer anamnesisID) {

		anamnesisService.delete(anamnesisService.findByID(
				AnamnesisEntity.class, anamnesisID));
		return "redirect:/patient/" + patientID + "/anamnesis/list";
	}

	@RequestMapping(value = "/patient/{patientID}/anamnesis/{anamnesisID}/export", method = RequestMethod.GET)
	public String anamnesisExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("anamnesisID") Integer anamnesisID) {
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
	public String anamnesisListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		model.addAttribute("patient",
				patientService.getPatientByIdWithAnamnesisList(patientID));
		return "patient/anamnesis/listView";
	}
}