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
import cz.cvut.fit.genepi.entity.card.InvasiveTestECOGEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.card.InvasiveTestECOGService;

@Controller
public class InvasiveTestECOGController {

	private PatientService patientService;

	private InvasiveTestECOGService invasiveTestECOGService;

	@Autowired
	public InvasiveTestECOGController(PatientService patientService,
			InvasiveTestECOGService invasiveTestECOGService) {
		this.patientService = patientService;
		this.invasiveTestECOGService = invasiveTestECOGService;
	}

	@RequestMapping(value = "/patient/{patientID}/invasiveTestECOG/create", method = RequestMethod.GET)
	public String invasiveTestECOGCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		model.addAttribute("patient", patient);
		model.addAttribute("invasiveTestECOG", new InvasiveTestECOGEntity());
		return "patient/invasiveTestECOG/createView";
	}

	/**
	 * Adds the invasiveTestECOG.
	 * 
	 * @param invasiveTestECOG
	 *            the invasiveTestECOG
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/invasiveTestECOG/create", method = RequestMethod.POST)
	public String invasiveTestECOGCreatePOST(
			@ModelAttribute("invasiveTestECOG") @Valid InvasiveTestECOGEntity invasiveTestECOG,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/invasiveTestECOG/createView";
		} else {
			invasiveTestECOG.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			invasiveTestECOGService.save(invasiveTestECOG);
			return "redirect:/patient/" + patientID + "/invasiveTestECOG/list";
		}
	}

	@RequestMapping(value = "/patient/{patientID}/invasiveTestECOG/{invasiveTestECOGID}/delete", method = RequestMethod.GET)
	public String invasiveTestECOGDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("invasiveTestECOGID") Integer invasiveTestECOGID) {

		invasiveTestECOGService.delete(invasiveTestECOGService.findByID(
				InvasiveTestECOGEntity.class, invasiveTestECOGID));
		return "redirect:/patient/" + patientID + "/invasiveTestECOG/list";
	}

	/**
	 * Handles the GET request to hide invasiveTestEcog.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an invasiveTestEcog.
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
	@RequestMapping(value = "/patient/{patientId}/invasiveTestEcog/{anamnesisId}/hide", method = RequestMethod.GET)
	public String invasiveTestEcogHideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("invasiveTestEcogId") Integer invasiveTestEcogId,
			Locale locale, Model model) {

		invasiveTestECOGService.hide(invasiveTestECOGService.findByID(
				InvasiveTestECOGEntity.class, invasiveTestEcogId));
		return "redirect:/patient/" + patientId + "/invasiveTestEcog/list";
	}

	/**
	 * Handles the GET request to unhide invasiveTestEcog.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an invasiveTestEcog.
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
	@RequestMapping(value = "/patient/{patientId}/invasiveTestEcog/{invasiveTestEcogId}/unhide", method = RequestMethod.GET)
	public String invasiveTestEcogUnhideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("invasiveTestEcogId") Integer invasiveTestEcogId,
			Locale locale, Model model) {

		invasiveTestECOGService.unhide(invasiveTestECOGService.findByID(
				InvasiveTestECOGEntity.class, invasiveTestEcogId));
		// TODO: address to get back to admin module where is list od hidden
		// records.
		return "redirect:/patient/" + patientId + "/invasiveTestEcog/list";
	}

	@RequestMapping(value = "/patient/{patientID}/invasiveTestECOG/{invasiveTestECOGID}/export", method = RequestMethod.GET)
	public String invasiveTestECOGExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("invasiveTestECOGID") Integer invasiveTestECOGID) {
		return "redirect:/patient/" + patientID + "/invasiveTestECOG/list";
	}

	@RequestMapping(value = "/patient/{patientID}/invasiveTestECOG/list", method = RequestMethod.GET)
	public String invasiveTestECOGListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService
				.getPatientByIdWithInvasiveTestECOGList(patientID);
		model.addAttribute("patient", patient);
		return "patient/invasiveTestECOG/listView";
	}
}
