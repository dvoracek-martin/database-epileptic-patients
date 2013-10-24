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
import cz.cvut.fit.genepi.entity.card.PharmacotherapyEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.PharmacotherapyService;

@Controller
public class PharmacotherapyController {

	@Autowired
	PatientService patientService;

	@Autowired
	RoleService roleService;

	@Autowired
	PharmacotherapyService pharmacotherapyService;

	@RequestMapping(value = "/patient/{patientID}/pharmacotherapy/create", method = RequestMethod.GET)
	public String pharmacotherapyCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

		model.addAttribute("patient", patient);
		model.addAttribute("pharmacotherapy", new PharmacotherapyEntity());
		return "patient/pharmacotherapy/createView";
	}

	/**
	 * Adds the pharmacotherapy.
	 * 
	 * @param pharmacotherapy
	 *            the pharmacotherapy
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/pharmacotherapy/create", method = RequestMethod.POST)
	public String pharmacotherapyCreatePOST(
			@ModelAttribute("pharmacotherapy") @Valid PharmacotherapyEntity pharmacotherapy,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/pharmacotherapy/createView";
		} else {
			pharmacotherapy.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			pharmacotherapyService.save(pharmacotherapy);
			return "redirect:/patient/" + patientID + "/pharmacotherapy/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientID}/pharmacotherapy/{pharmacotherapyID}/delete", method = RequestMethod.GET)
	public String pharmacotherapyDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("pharmacotherapyID") Integer pharmacotherapyID) {

		pharmacotherapyService.delete(pharmacotherapyService.findByID(
				PharmacotherapyEntity.class, pharmacotherapyID));
		return "redirect:/patient/" + patientID + "/pharmacotherapy/list";
	}

	@RequestMapping(value = "/patient/{patientID}/pharmacotherapy/{pharmacotherapyID}/export", method = RequestMethod.GET)
	public String pharmacotherapyExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("pharmacotherapyID") Integer pharmacotherapyID) {
		return "redirect:/patient/" + patientID + "/pharmacotherapy/list";
	}
	
	
	@RequestMapping(value = "/patient/{patientID}/pharmacotherapy/list", method = RequestMethod.GET)
	public String pharmacotherapyListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.getPatientByIdWithPharmacotherapyList(patientID);
		model.addAttribute("patient", patient);
		return "patient/pharmacotherapy/listView";
	}
}
