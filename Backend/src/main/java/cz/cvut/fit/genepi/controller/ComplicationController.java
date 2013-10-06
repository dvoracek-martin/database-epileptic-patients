package cz.cvut.fit.genepi.controller;

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

import cz.cvut.fit.genepi.entity.ComplicationEntity;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.ComplicationService;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;

@Controller
public class ComplicationController {

	@Autowired
	PatientService patientService;

	@Autowired
	RoleService roleService;

	@Autowired
	ComplicationService complicationService;

	@RequestMapping(value = "/patient/{patientID}/complication/create", method = RequestMethod.GET)
	public String complicationCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

		model.addAttribute("patient", patient);
		model.addAttribute("complication", new ComplicationEntity());
		return "patient/complication/createView";
	}

	/**
	 * Adds the complication.
	 * 
	 * @param complication
	 *            the complication
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/complication/create", method = RequestMethod.POST)
	public String complicationCreatePOST(
			@ModelAttribute("complication") @Valid ComplicationEntity complication,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/complication/createView";
		} else {
			complication.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			complicationService.save(complication);
			return "redirect:/patient/" + patientID + "/complication/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientID}/complication/{complicationID}/delete", method = RequestMethod.GET)
	public String complicationDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("complicationID") Integer complicationID) {

		complicationService.delete(complicationService.findByID(
				ComplicationEntity.class, complicationID));
		return "redirect:/patient/" + patientID + "/complication/list";
	}

	@RequestMapping(value = "/patient/{patientID}/complication/{complicationID}/export", method = RequestMethod.GET)
	public String complicationExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("complicationID") Integer complicationID) {
		return "redirect:/patient/" + patientID + "/complication/list";
	}
	
	
	@RequestMapping(value = "/patient/{patientID}/complication/list", method = RequestMethod.GET)
	public String complicationListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);
		model.addAttribute("patient", patient);
		return "patient/complication/listView";
	}
}
