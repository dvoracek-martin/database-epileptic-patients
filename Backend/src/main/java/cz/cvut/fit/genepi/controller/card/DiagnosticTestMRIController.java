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
import cz.cvut.fit.genepi.entity.card.DiagnosticTestMRIEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.card.DiagnosticTestMRIService;

@Controller
public class DiagnosticTestMRIController {

	private PatientService patientService;

	private DiagnosticTestMRIService diagnosticTestMRIService;

	@Autowired
	public DiagnosticTestMRIController(PatientService patientService,
			DiagnosticTestMRIService diagnosticTestMRIService) {
		this.patientService = patientService;
		this.diagnosticTestMRIService = diagnosticTestMRIService;
	}

	@RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/create", method = RequestMethod.GET)
	public String diagnosticTestMRICreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		model.addAttribute("patient", patient);
		model.addAttribute("diagnosticTestMRI", new DiagnosticTestMRIEntity());
		return "patient/diagnosticTestMRI/createView";
	}

	/**
	 * Adds the diagnosticTestMRI.
	 * 
	 * @param diagnosticTestMRI
	 *            the diagnosticTestMRI
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/create", method = RequestMethod.POST)
	public String diagnosticTestMRICreatePOST(
			@ModelAttribute("diagnosticTestMRI") @Valid DiagnosticTestMRIEntity diagnosticTestMRI,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/diagnosticTestMRI/createView";
		} else {
			diagnosticTestMRI.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			diagnosticTestMRIService.save(diagnosticTestMRI);
			return "redirect:/patient/" + patientID + "/diagnosticTestMRI/list";
		}
	}

	@RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/{diagnosticTestMRIID}/delete", method = RequestMethod.GET)
	public String diagnosticTestMRIDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("diagnosticTestMRIID") Integer diagnosticTestMRIID) {

		diagnosticTestMRIService.delete(diagnosticTestMRIService.findByID(
				DiagnosticTestMRIEntity.class, diagnosticTestMRIID));
		return "redirect:/patient/" + patientID + "/diagnosticTestMRI/list";
	}

	/**
	 * Handles the GET request to hide diagnosticTestMri.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an diagnosticTestMri.
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
	@RequestMapping(value = "/patient/{patientId}/diagnosticTestMri/{diagnosticTestMriId}/hide", method = RequestMethod.GET)
	public String diagnosticTestMriHideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("diagnosticTestMriId") Integer diagnosticTestMriId,
			Locale locale, Model model) {

		diagnosticTestMRIService.hide(diagnosticTestMRIService.findByID(
				DiagnosticTestMRIEntity.class, diagnosticTestMriId));
		return "redirect:/patient/" + patientId + "/diagnosticTestMri/list";
	}

	/**
	 * Handles the GET request to unhide diagnosticTestMri.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an diagnosticTestMri.
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
	@RequestMapping(value = "/patient/{patientId}/diagnosticTestMri/{diagnosticTestMriId}/unhide", method = RequestMethod.GET)
	public String diagnosticTestMriUnhideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("diagnosticTestMriId") Integer diagnosticTestMriId,
			Locale locale, Model model) {

		diagnosticTestMRIService.unhide(diagnosticTestMRIService.findByID(
				DiagnosticTestMRIEntity.class, diagnosticTestMriId));
		// TODO: address to get back to admin module where is list od hidden
		// records.
		return "redirect:/patient/" + patientId + "/diagnosticTestMri/list";
	}

	@RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/{diagnosticTestMRIID}/export", method = RequestMethod.GET)
	public String diagnosticTestMRIExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("diagnosticTestMRIID") Integer diagnosticTestMRIID) {
		return "redirect:/patient/" + patientID + "/diagnosticTestMRI/list";
	}

	@RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/list", method = RequestMethod.GET)
	public String diagnosticTestMRIListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService
				.getPatientByIdWithDiagnosticTestMRIList(patientID);
		model.addAttribute("patient", patient);
		return "patient/diagnosticTestMRI/listView";
	}
}
