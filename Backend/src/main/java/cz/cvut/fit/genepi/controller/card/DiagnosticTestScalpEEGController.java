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
import cz.cvut.fit.genepi.entity.card.DiagnosticTestScalpEEGEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.card.DiagnosticTestScalpEEGService;

@Controller
public class DiagnosticTestScalpEEGController {

	private PatientService patientService;

	private DiagnosticTestScalpEEGService diagnosticTestScalpEEGService;

	@Autowired
	public DiagnosticTestScalpEEGController(PatientService patientService,
			DiagnosticTestScalpEEGService diagnosticTestScalpEEGService) {
		this.patientService = patientService;
		this.diagnosticTestScalpEEGService = diagnosticTestScalpEEGService;
	}

	@RequestMapping(value = "/patient/{patientID}/diagnosticTestScalpEEG/create", method = RequestMethod.GET)
	public String diagnosticTestEEGCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		model.addAttribute("patient", patient);
		model.addAttribute("diagnosticTestEEG",
				new DiagnosticTestScalpEEGEntity());
		return "patient/diagnosticTestEEG/createView";
	}

	/**
	 * Adds the diagnosticTestEEG.
	 * 
	 * @param diagnosticTestEEG
	 *            the diagnosticTestEEG
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/diagnosticTestEEG/create", method = RequestMethod.POST)
	public String diagnosticTestEEGCreatePOST(
			@ModelAttribute("diagnosticTestEEG") @Valid DiagnosticTestScalpEEGEntity diagnosticTestEEG,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/diagnosticTestEEG/createView";
		} else {
			diagnosticTestEEG.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			diagnosticTestScalpEEGService.save(diagnosticTestEEG);
			return "redirect:/patient/" + patientID + "/diagnosticTestEEG/list";
		}
	}

	@RequestMapping(value = "/patient/{patientID}/diagnosticTestEEG/{diagnosticTestEEGID}/delete", method = RequestMethod.GET)
	public String diagnosticTestEEGDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("diagnosticTestEEGID") Integer diagnosticTestEEGID) {

		diagnosticTestScalpEEGService.delete(diagnosticTestScalpEEGService
				.findByID(DiagnosticTestScalpEEGEntity.class,
						diagnosticTestEEGID));
		return "redirect:/patient/" + patientID + "/diagnosticTestEEG/list";
	}

	/**
	 * Handles the GET request to hide diagnosticTestScalpEeg.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an
	 *            diagnosticTestScalpEeg.
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
	@RequestMapping(value = "/patient/{patientId}/diagnosticTestScalpEeg/{diagnosticTestScalpEegId}/hide", method = RequestMethod.GET)
	public String diagnosticTestScalpEegHideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
			Locale locale, Model model) {

		diagnosticTestScalpEEGService.hide(diagnosticTestScalpEEGService
				.findByID(DiagnosticTestScalpEEGEntity.class,
						diagnosticTestScalpEegId));
		return "redirect:/patient/" + patientId + "/anamnesis/list";
	}

	/**
	 * Handles the GET request to unhide diagnosticTestScalpEeg.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an
	 *            diagnosticTestScalpEeg.
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
	@RequestMapping(value = "/patient/{patientId}/diagnosticTestScalpEeg/{diagnosticTestScalpEegId}/unhide", method = RequestMethod.GET)
	public String diagnosticTestScalpEegUnhideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
			Locale locale, Model model) {

		diagnosticTestScalpEEGService.unhide(diagnosticTestScalpEEGService
				.findByID(DiagnosticTestScalpEEGEntity.class,
						diagnosticTestScalpEegId));
		// TODO: address to get back to admin module where is list od hidden
		// records.
		return "redirect:/patient/" + patientId + "/anamnesis/list";
	}

	@RequestMapping(value = "/patient/{patientID}/diagnosticTestEEG/{diagnosticTestEEGID}/export", method = RequestMethod.GET)
	public String diagnosticTestEEGExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("diagnosticTestEEGID") Integer diagnosticTestEEGID) {
		return "redirect:/patient/" + patientID + "/diagnosticTestEEG/list";
	}

	@RequestMapping(value = "/patient/{patientID}/diagnosticTestEEG/list", method = RequestMethod.GET)
	public String diagnosticTestEEGListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService
				.getPatientByIdWithDiagnosticTestEEGList(patientID);
		model.addAttribute("patient", patient);
		return "patient/diagnosticTestEEG/listView";
	}
}
