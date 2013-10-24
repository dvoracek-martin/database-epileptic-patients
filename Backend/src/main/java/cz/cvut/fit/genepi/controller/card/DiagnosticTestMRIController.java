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
import cz.cvut.fit.genepi.entity.card.DiagnosticTestMRIEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.DiagnosticTestMRIService;

@Controller
public class DiagnosticTestMRIController {

	@Autowired
	PatientService patientService;

	@Autowired
	RoleService roleService;

	@Autowired
	DiagnosticTestMRIService diagnosticTestMRIService;

	@RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/create", method = RequestMethod.GET)
	public String diagnosticTestMRICreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

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

	@RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/{diagnosticTestMRIID}/export", method = RequestMethod.GET)
	public String diagnosticTestMRIExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("diagnosticTestMRIID") Integer diagnosticTestMRIID) {
		return "redirect:/patient/" + patientID + "/diagnosticTestMRI/list";
	}
	
	
	@RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/list", method = RequestMethod.GET)
	public String diagnosticTestMRIListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.getPatientByIdWithDiagnosticTestMRIList(patientID);
		model.addAttribute("patient", patient);
		return "patient/diagnosticTestMRI/listView";
	}
}
