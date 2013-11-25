package cz.cvut.fit.genepi.presentationLayer.controller.card;

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

import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.PharmacotherapyService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;

@Controller
public class PharmacotherapyController {

	private PatientService patientService;

	private PharmacotherapyService pharmacotherapyService;

	@Autowired
	public PharmacotherapyController(PatientService patientService,
			PharmacotherapyService pharmacotherapyService) {
		this.patientService = patientService;
		this.pharmacotherapyService = pharmacotherapyService;
	}

	@RequestMapping(value = "/patient/{patientID}/pharmacotherapy/create", method = RequestMethod.GET)
	public String pharmacotherapyCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		model.addAttribute("patient", patient);
		model.addAttribute("pharmacotherapy", new PharmacotherapyEntity());
		return "patient/pharmacotherapy/createView";
	}

	/**
	 * Adds the pharmacotherapy.
	 * 
	 * @param pharmacotherapy
	 *            the pharmacotherapy
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/pharmacotherapy/create", method = RequestMethod.POST)
	public String pharmacotherapyCreatePOST(
			@ModelAttribute("pharmacotherapy") @Valid PharmacotherapyEntity pharmacotherapy,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/pharmacotherapy/createView";
		} else {
			pharmacotherapy.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			pharmacotherapyService.save(pharmacotherapy);
			return "redirect:/patient/" + patientID + "/pharmacotherapy/list";
		}
	}

	@RequestMapping(value = "/patient/{patientID}/pharmacotherapy/{pharmacotherapyID}/delete", method = RequestMethod.GET)
	public String pharmacotherapyDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("pharmacotherapyID") Integer pharmacotherapyID) {

		pharmacotherapyService.delete(pharmacotherapyService.findByID(
				PharmacotherapyEntity.class, pharmacotherapyID));
		return "redirect:/patient/" + patientID + "/pharmacotherapy/list";
	}

	/**
	 * Handles the GET request to hide pharmacotherapy.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an pharmacotherapy.
	 * @param anamnesisId
	 * 
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the address to which the user will be redirected.
	 */
	@RequestMapping(value = "/patient/{patientId}/pharmacotherapy/{pharmacotherapyId}/hide", method = RequestMethod.GET)
	public String pharmacotherapyHideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("pharmacotherapyId") Integer pharmacotherapyId,
			Locale locale, Model model) {

		pharmacotherapyService.hide(pharmacotherapyService.findByID(
				PharmacotherapyEntity.class, pharmacotherapyId));
		return "redirect:/patient/" + patientId + "/pharmacotherapy/list";
	}

	/**
	 * Handles the GET request to unhide pharmacotherapy.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an pharmacotherapy.
	 * @param anamnesisId
	 * 
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the address to which the user will be redirected.
	 */
	@RequestMapping(value = "/patient/{patientId}/pharmacotherapy/{anamnesisId}/unhide", method = RequestMethod.GET)
	public String pharmacotherapyUnhideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("pharmacotherapyId") Integer pharmacotherapyId,
			Locale locale, Model model) {

		pharmacotherapyService.unhide(pharmacotherapyService.findByID(
				PharmacotherapyEntity.class, pharmacotherapyId));
		// TODO: address to get back to admin module where is list od hidden
		// records.
		return "redirect:/patient/" + patientId + "/pharmacotherapy/list";
	}

	@RequestMapping(value = "/patient/{patientID}/pharmacotherapy/{pharmacotherapyID}/export", method = RequestMethod.GET)
	public String pharmacotherapyExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("pharmacotherapyID") Integer pharmacotherapyID) {
		return "redirect:/patient/" + patientID + "/pharmacotherapy/list";
	}

	@RequestMapping(value = "/patient/{patientID}/pharmacotherapy/list", method = RequestMethod.GET)
	public String pharmacotherapyListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService
				.getPatientByIdWithPharmacotherapyList(patientID);
		model.addAttribute("patient", patient);
		return "patient/pharmacotherapy/listView";
	}
}
