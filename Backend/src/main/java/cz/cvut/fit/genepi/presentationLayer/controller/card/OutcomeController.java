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
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.businessLayer.service.card.OutcomeService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.OutcomeEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;

@Controller
public class OutcomeController {

	private PatientService patientService;

	private OutcomeService outcomeService;

	private OperationService operationService;

	@Autowired
	public OutcomeController(PatientService patientService,
			OutcomeService outcomeService, OperationService operationService) {
		this.patientService = patientService;
		this.outcomeService = outcomeService;
		this.operationService = operationService;
	}

	@RequestMapping(value = "/patient/{patientID}/outcome/create?distance={distance}&operation={operationId}", method = RequestMethod.GET)
	public String outcomeCreateGET(
			@PathVariable("patientID") Integer patientID,
			@PathVariable("distance") Integer distance,
			@PathVariable("operationId") Integer operationId, Locale locale,
			Model model) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		model.addAttribute("patient", patient);
		model.addAttribute("outcome", new OutcomeEntity());
		return "patient/outcome/createView";
	}

	/**
	 * Adds the outcome.
	 * 
	 * @param outcome
	 *            the outcome
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/outcome/create", method = RequestMethod.POST)
	public String outcomeCreatePOST(
			@ModelAttribute("outcome") @Valid OutcomeEntity outcome,
			BindingResult result, @PathVariable("patientID") Integer patientID,
			@PathVariable("distance") Integer distance,
			@PathVariable("operationId") Integer operationId) {
		if (result.hasErrors()) {
			return "patient/outcome/createView";
		} else {
			outcome.setPatient(patientService.findByID(PatientEntity.class,
					patientID));
			outcome.setOperation(operationService.findByID(
					OperationEntity.class, operationId));
			outcomeService.save(outcome);
			return "redirect:/patient/" + patientID + "/outcome/list";
		}
	}

	@RequestMapping(value = "/patient/{patientID}/outcome/{outcomeID}/delete", method = RequestMethod.GET)
	public String outcomeDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("outcomeID") Integer outcomeID) {

		outcomeService.delete(outcomeService.findByID(OutcomeEntity.class,
				outcomeID));
		return "redirect:/patient/" + patientID + "/outcome/list";
	}

	/**
	 * Handles the GET request to hide outcome.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an outcome.
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
	@RequestMapping(value = "/patient/{patientId}/outcome/{outcomeId}/hide", method = RequestMethod.GET)
	public String outcomeHideGET(@PathVariable("patientId") Integer patientId,
			@PathVariable("outcomeId") Integer outcomeId, Locale locale,
			Model model) {

		outcomeService.hide(outcomeService.findByID(OutcomeEntity.class,
				outcomeId));
		return "redirect:/patient/" + patientId + "/outcome/list";
	}

	/**
	 * Handles the GET request to unhide outcome.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an outcome.
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
	@RequestMapping(value = "/patient/{patientId}/outcome/{anamnesisId}/unhide", method = RequestMethod.GET)
	public String outcomeUnhideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("outcomeId") Integer outcomeId, Locale locale,
			Model model) {

		outcomeService.unhide(outcomeService.findByID(OutcomeEntity.class,
				outcomeId));
		// TODO: address to get back to admin module where is list od hidden
		// records.
		return "redirect:/patient/" + patientId + "/outcome/list";
	}

	@RequestMapping(value = "/patient/{patientID}/outcome/{outcomeID}/export", method = RequestMethod.GET)
	public String outcomeExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("outcomeID") Integer outcomeID) {
		return "redirect:/patient/" + patientID + "/outcome/list";
	}

	@RequestMapping(value = "/patient/{patientID}/outcome/list", method = RequestMethod.GET)
	public String outcomeListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService
				.getPatientByIdWithOperationList(patientID);
		model.addAttribute("patient", patient);
		return "patient/outcome/listView";
	}
}
