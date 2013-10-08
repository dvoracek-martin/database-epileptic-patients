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
import cz.cvut.fit.genepi.entity.card.OutcomeEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.OutcomeService;

@Controller
public class OutcomeController {

	@Autowired
	PatientService patientService;

	@Autowired
	RoleService roleService;

	@Autowired
	OutcomeService outcomeService;

	@RequestMapping(value = "/patient/{patientID}/outcome/create", method = RequestMethod.GET)
	public String outcomeCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

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
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/outcome/createView";
		} else {
			outcome.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			outcomeService.save(outcome);
			return "redirect:/patient/" + patientID + "/outcome/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientID}/outcome/{outcomeID}/delete", method = RequestMethod.GET)
	public String outcomeDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("outcomeID") Integer outcomeID) {

		outcomeService.delete(outcomeService.findByID(
				OutcomeEntity.class, outcomeID));
		return "redirect:/patient/" + patientID + "/outcome/list";
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
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);
		model.addAttribute("patient", patient);
		return "patient/outcome/listView";
	}
}
