package cz.cvut.fit.genepi.presentationLayer.controller.card;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyOldService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyOldEntity;

@Controller
public class NeuropsychologyOldController {

	private PatientService patientService;

	private NeuropsychologyOldService neuropsychologyOldService;

	@Autowired
	public NeuropsychologyOldController(PatientService patientService,
			NeuropsychologyOldService neuropsychologyOldService) {
		this.patientService = patientService;
		this.neuropsychologyOldService = neuropsychologyOldService;
	}	

	@RequestMapping(value = "/patient/{patientID}/neuropsychology-old/{neuropsychologyOldID}/delete", method = RequestMethod.GET)
	public String neuropsychologyOldDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("neuropsychologyOldID") Integer neuropsychologyOldID) {

		neuropsychologyOldService.delete(neuropsychologyOldService.findByID(
				NeuropsychologyOldEntity.class, neuropsychologyOldID));
		return "redirect:/patient/" + patientID + "/neuropsychology-old/list";
	}

	/**
	 * Handles the GET request to hide neuropsychology.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an neuropsychology.
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
	@RequestMapping(value = "/patient/{patientId}/neuropsychology-old/{anamnesisId}/hide", method = RequestMethod.GET)
	public String neuropsychologyHideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("neuropsychologyId") Integer neuropsychologyId,
			Locale locale, Model model) {

		neuropsychologyOldService.hide(neuropsychologyOldService.findByID(
				NeuropsychologyOldEntity.class, neuropsychologyId));
		return "redirect:/patient/" + patientId + "/neuropsychology-old/list";
	}

	/**
	 * Handles the GET request to unhide neuropsychology.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an neuropsychology.
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
	@RequestMapping(value = "/patient/{patientId}/neuropsychology-old/{neuropsychologyId}/unhide", method = RequestMethod.GET)
	public String neuropsychologyUnhideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("neuropsychologyId") Integer neuropsychologyId,
			Locale locale, Model model) {

		neuropsychologyOldService.unhide(neuropsychologyOldService.findByID(
				NeuropsychologyOldEntity.class, neuropsychologyId));
		// TODO: address to get back to admin module where is list od hidden
		// records.
		return "redirect:/patient/" + patientId + "/neuropsychology-old/list";
	}

	@RequestMapping(value = "/patient/{patientID}/neuropsychology-old/{neuropsychologyID}/export", method = RequestMethod.GET)
	public String neuropsychologyExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("neuropsychologyID") Integer neuropsychologyID) {
		return "redirect:/patient/" + patientID + "/neuropsychology-old/list";
	}

	@RequestMapping(value = "/patient/{patientID}/neuropsychology-old/list", method = RequestMethod.GET)
	public String neuropsychologyListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService
				.getPatientByIdWithNeuropsychologyOldList(patientID);
		model.addAttribute("patient", patient);
		return "patient/neuropsychologyOld/listView";
	}
}
