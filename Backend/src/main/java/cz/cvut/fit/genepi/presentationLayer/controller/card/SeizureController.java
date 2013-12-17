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
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;

@Controller
public class SeizureController {

	private PatientService patientService;

	private SeizureService seizureService;

	@Autowired
	public SeizureController(PatientService patientService,
			SeizureService seizureService) {
		this.patientService = patientService;
		this.seizureService = seizureService;
	}

	@RequestMapping(value = "/patient/{patientId}/seizure/create", method = RequestMethod.GET)
	public String seizureCreateGET(
			@PathVariable("patientId") Integer patientId,Locale locale, Model model) {
		PatientEntity patient = patientService.getPatientByIdWithDoctor(patientId);

		model.addAttribute("patient", patient);
		model.addAttribute("seizure", new SeizureEntity());
		return "patient/seizure/createView";
	}

	/**
	 * Adds the seizure.
	 * 
	 * @param seizure
	 *            the seizure
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientId}/seizure/create", method = RequestMethod.POST)
	public String seizureCreatePOST(
			@ModelAttribute("seizure") @Valid SeizureEntity seizure,
			BindingResult result, @PathVariable("patientId") Integer patientId,Locale locale, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("patient",
					patientService.getPatientByIdWithDoctor(patientId));
			return "patient/seizure/createView";
		} else {
			seizure.setPatient(patientService.findByID(PatientEntity.class,
					patientId));
			seizureService.save(seizure);
			return "redirect:/patient/" + patientId + "/seizure/list";
		}
	}

	@RequestMapping(value = "/patient/{patientID}/seizure/{seizureID}/delete", method = RequestMethod.GET)
	public String seizureDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("seizureID") Integer seizureID) {

		seizureService.delete(seizureService.findByID(SeizureEntity.class,
				seizureID));
		return "redirect:/patient/" + patientID + "/seizure/list";
	}

	/**
	 * Handles the GET request to hide seizure.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an seizure.
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
	@RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/hide", method = RequestMethod.GET)
	public String anamnesisDeleteGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("seizureId") Integer seizureId, Locale locale,
			Model model) {

		seizureService.hide(seizureService.findByID(SeizureEntity.class,
				seizureId));
		return "redirect:/patient/" + patientId + "/seizure/list";
	}

	/**
	 * Handles the GET request to unhide seizure.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an seizure.
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
	@RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/unhide", method = RequestMethod.GET)
	public String anamnesisUnhideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("seizureId") Integer seizureId, Locale locale,
			Model model) {

		seizureService.unhide(seizureService.findByID(SeizureEntity.class,
				seizureId));
		// TODO: address to get back to admin module where is list od hidden
		// records.
		return "redirect:/patient/" + patientId + "/seizure/list";
	}

	@RequestMapping(value = "/patient/{patientID}/seizure/{seizureID}/export", method = RequestMethod.GET)
	public String seizureExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("seizureID") Integer seizureID) {
		return "redirect:/patient/" + patientID + "/seizure/list";
	}

	@RequestMapping(value = "/patient/{patientID}/seizure/list", method = RequestMethod.GET)
	public String seizureListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService
				.getPatientByIdWithSeizureList(patientID);
		model.addAttribute("patient", patient);
		return "patient/seizure/listView";
	}
}
