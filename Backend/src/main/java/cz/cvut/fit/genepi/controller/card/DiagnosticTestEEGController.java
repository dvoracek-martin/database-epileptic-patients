package cz.cvut.fit.genepi.controller.card;

import java.util.ArrayList;
import java.util.List;
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
import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.entity.card.DiagnosticTestEEGEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.DiagnosticTestEEGService;

@Controller
public class DiagnosticTestEEGController {

	@Autowired
	PatientService patientService;

	@Autowired
	RoleService roleService;

	@Autowired
	DiagnosticTestEEGService diagnosticTestEEGService;

	@RequestMapping(value = "/patient/{patientID}/diagnosticTestEEG/create", method = RequestMethod.GET)
	public String diagnosticTestEEGCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

		model.addAttribute("patient", patient);
		model.addAttribute("diagnosticTestEEG", new DiagnosticTestEEGEntity());
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
			@ModelAttribute("diagnosticTestEEG") @Valid DiagnosticTestEEGEntity diagnosticTestEEG,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/diagnosticTestEEG/createView";
		} else {
			diagnosticTestEEG.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			diagnosticTestEEGService.save(diagnosticTestEEG);
			return "redirect:/patient/" + patientID + "/diagnosticTestEEG/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientID}/diagnosticTestEEG/{diagnosticTestEEGID}/delete", method = RequestMethod.GET)
	public String diagnosticTestEEGDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("diagnosticTestEEGID") Integer diagnosticTestEEGID) {

		diagnosticTestEEGService.delete(diagnosticTestEEGService.findByID(
				DiagnosticTestEEGEntity.class, diagnosticTestEEGID));
		return "redirect:/patient/" + patientID + "/diagnosticTestEEG/list";
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
		PatientEntity patient = patientService.getPatientByIdWithDiagnosticTestEEGList(patientID);
		model.addAttribute("patient", patient);
		return "patient/diagnosticTestEEG/listView";
	}
}
