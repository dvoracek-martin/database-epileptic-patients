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
import cz.cvut.fit.genepi.entity.card.NeuropsychologyEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.NeuropsychologyService;

@Controller
public class NeuropsychologyController {

	@Autowired
	PatientService patientService;

	@Autowired
	RoleService roleService;

	@Autowired
	NeuropsychologyService neuropsychologyService;

	@RequestMapping(value = "/patient/{patientID}/neuropsychology/create", method = RequestMethod.GET)
	public String neuropsychologyCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

		model.addAttribute("patient", patient);
		model.addAttribute("neuropsychology", new NeuropsychologyEntity());
		return "patient/neuropsychology/createView";
	}

	/**
	 * Adds the neuropsychology.
	 * 
	 * @param neuropsychology
	 *            the neuropsychology
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/neuropsychology/create", method = RequestMethod.POST)
	public String neuropsychologyCreatePOST(
			@ModelAttribute("neuropsychology") @Valid NeuropsychologyEntity neuropsychology,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/neuropsychology/createView";
		} else {
			neuropsychology.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			neuropsychologyService.save(neuropsychology);
			return "redirect:/patient/" + patientID + "/neuropsychology/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientID}/neuropsychology/{neuropsychologyID}/delete", method = RequestMethod.GET)
	public String neuropsychologyDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("neuropsychologyID") Integer neuropsychologyID) {

		neuropsychologyService.delete(neuropsychologyService.findByID(
				NeuropsychologyEntity.class, neuropsychologyID));
		return "redirect:/patient/" + patientID + "/neuropsychology/list";
	}

	@RequestMapping(value = "/patient/{patientID}/neuropsychology/{neuropsychologyID}/export", method = RequestMethod.GET)
	public String neuropsychologyExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("neuropsychologyID") Integer neuropsychologyID) {
		return "redirect:/patient/" + patientID + "/neuropsychology/list";
	}
	
	
	@RequestMapping(value = "/patient/{patientID}/neuropsychology/list", method = RequestMethod.GET)
	public String neuropsychologyListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);
		model.addAttribute("patient", patient);
		return "patient/neuropsychology/listView";
	}
}
