package cz.cvut.fit.genepi.presentationLayer.controller.card;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyOldEntity;

@Controller
public class NeuropsychologyController {

	private PatientService patientService;

	private NeuropsychologyService neuropsychologyService;

	@Autowired
	public NeuropsychologyController(PatientService patientService,
			NeuropsychologyService neuropsychologyService) {
		this.patientService = patientService;
		this.neuropsychologyService = neuropsychologyService;
	}

	@RequestMapping(value = "/patient/{patientID}/neuropsychology/create", method = RequestMethod.GET)
	public String neuropsychologyCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		model.addAttribute("patient", patient);
		model.addAttribute("neuropsychology", new NeuropsychologyEntity());
		return "patient/neuropsychology/createView";
	}

	@RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/delete", method = RequestMethod.GET)
	public String neuropsychologyDeleteGET(Locale locale, Model model,
			@PathVariable("patientId") Integer patientId,
			@PathVariable("neuropsychologyId") Integer neuropsychologyId) {

		neuropsychologyService.delete(neuropsychologyService.findByID(
				NeuropsychologyEntity.class, neuropsychologyId));
		return "redirect:/patient/" + patientId + "/neuropsychology/list";
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
	@RequestMapping(value = "/patient/{patientId}/neuropsychology/{anamnesisId}/hide", method = RequestMethod.GET)
	public String neuropsychologyHideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("neuropsychologyId") Integer neuropsychologyId,
			Locale locale, Model model) {

		neuropsychologyService.hide(neuropsychologyService.findByID(
				NeuropsychologyEntity.class, neuropsychologyId));
		return "redirect:/patient/" + patientId + "/neuropsychology/list";
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
	@RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/unhide", method = RequestMethod.GET)
	public String neuropsychologyUnhideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("neuropsychologyId") Integer neuropsychologyId,
			Locale locale, Model model) {

		neuropsychologyService.unhide(neuropsychologyService.findByID(
				NeuropsychologyEntity.class, neuropsychologyId));
		// TODO: address to get back to admin module where is list od hidden
		// records.
		return "redirect:/patient/" + patientId + "/neuropsychology/list";
	}

	@RequestMapping(value = "/patient/{patientID}/neuropsychology/{neuropsychologyID}/export", method = RequestMethod.GET)
	public String neuropsychologyExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("neuropsychologyID") Integer neuropsychologyID) {
		return "redirect:/patient/" + patientID + "/neuropsychology/list";
	}

	@RequestMapping(value = "/patient/{patientID}/neuropsychology/list", method = RequestMethod.GET)
	public String neuropsychologyListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService
				.getPatientByIdWithNeuropsychologyList(patientID);
		model.addAttribute("patient", patient);
		return "patient/neuropsychology/listView";
	}
}
