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
import cz.cvut.fit.genepi.businessLayer.service.card.NeurologicalFindingService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;

@Controller
public class NeurologicalFindingController {

	private PatientService patientService;

	private NeurologicalFindingService neurologicalFindingService;

	@Autowired
	public NeurologicalFindingController(PatientService patientService,
			NeurologicalFindingService neurologicalFindingService) {
		this.patientService = patientService;
		this.neurologicalFindingService = neurologicalFindingService;
	}

	@RequestMapping(value = "/patient/{patientID}/neurologicalFinding/create", method = RequestMethod.GET)
	public String neurologicalFindingCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		model.addAttribute("patient", patient);
		model.addAttribute("neurologicalFinding",
				new NeurologicalFindingEntity());
		return "patient/neurologicalFinding/createView";
	}

	/**
	 * Adds the neurologicalFinding.
	 * 
	 * @param neurologicalFinding
	 *            the neurologicalFinding
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/neurologicalFinding/create", method = RequestMethod.POST)
	public String neurologicalFindingCreatePOST(
			@ModelAttribute("neurologicalFinding") @Valid NeurologicalFindingEntity neurologicalFinding,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/neurologicalFinding/createView";
		} else {
			neurologicalFinding.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			neurologicalFindingService.save(neurologicalFinding);
			return "redirect:/patient/" + patientID
					+ "/neurologicalFinding/list";
		}
	}

	@RequestMapping(value = "/patient/{patientID}/neurologicalFinding/{neurologicalFindingID}/delete", method = RequestMethod.GET)
	public String neurologicalFindingDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("neurologicalFindingID") Integer neurologicalFindingID) {

		neurologicalFindingService.delete(neurologicalFindingService.findByID(
				NeurologicalFindingEntity.class, neurologicalFindingID));
		return "redirect:/patient/" + patientID + "/neurologicalFinding/list";
	}

	/**
	 * Handles the GET request to hide neurologicalFinding.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an
	 *            neurologicalFinding.
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
	@RequestMapping(value = "/patient/{patientId}/neurologicalFinding/{neurologicalFindingId}/hide", method = RequestMethod.GET)
	public String neurologicalFindingHideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("neurologicalFindingId") Integer neurologicalFindingId,
			Locale locale, Model model) {

		neurologicalFindingService.hide(neurologicalFindingService.findByID(
				NeurologicalFindingEntity.class, neurologicalFindingId));
		return "redirect:/patient/" + patientId + "/neurologicalFinding/list";
	}

	/**
	 * Handles the GET request to unhide neurologicalFinding.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an
	 *            neurologicalFinding.
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
	@RequestMapping(value = "/patient/{patientId}/neurologicalFinding/{anamnesisId}/unhide", method = RequestMethod.GET)
	public String neurologicalFindingGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("neurologicalFindingId") Integer neurologicalFindingId,
			Locale locale, Model model) {

		neurologicalFindingService.unhide(neurologicalFindingService.findByID(
				NeurologicalFindingEntity.class, neurologicalFindingId));
		// TODO: address to get back to admin module where is list od hidden
		// records.
		return "redirect:/patient/" + patientId + "/neurologicalFinding/list";
	}

	@RequestMapping(value = "/patient/{patientID}/neurologicalFinding/{neurologicalFindingID}/export", method = RequestMethod.GET)
	public String neurologicalFindingExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("neurologicalFindingID") Integer neurologicalFindingID) {
		return "redirect:/patient/" + patientID + "/neurologicalFinding/list";
	}

	@RequestMapping(value = "/patient/{patientID}/neurologicalFinding/list", method = RequestMethod.GET)
	public String neurologicalFindingListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService
				.getPatientByIdWithNeurologicalFindingList(patientID);
		model.addAttribute("patient", patient);
		return "patient/neurologicalFinding/listView";
	}
}