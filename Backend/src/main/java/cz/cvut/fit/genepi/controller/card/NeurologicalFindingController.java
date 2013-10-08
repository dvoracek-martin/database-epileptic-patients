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
import cz.cvut.fit.genepi.entity.card.NeurologicalFindingEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.NeurologicalFindingService;

@Controller
public class NeurologicalFindingController {

	@Autowired
	PatientService patientService;

	@Autowired
	RoleService roleService;

	@Autowired
	NeurologicalFindingService neurologicalFindingService;

	@RequestMapping(value = "/patient/{patientID}/neurologicalFinding/create", method = RequestMethod.GET)
	public String neurologicalFindingCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

		model.addAttribute("patient", patient);
		model.addAttribute("neurologicalFinding", new NeurologicalFindingEntity());
		return "patient/neurologicalFinding/createView";
	}

	/**
	 * Adds the neurologicalFinding.
	 * 
	 * @param neurologicalFinding
	 *            the neurologicalFinding
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/neurologicalFinding/create", method = RequestMethod.POST)
	public String neurologicalFindingCreatePOST(
			@ModelAttribute("neurologicalFinding") @Valid NeurologicalFindingEntity neurologicalFinding,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/neurologicalFinding/createView";
		} else {
			neurologicalFinding.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			neurologicalFindingService.save(neurologicalFinding);
			return "redirect:/patient/" + patientID + "/neurologicalFinding/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientID}/neurologicalFinding/{neurologicalFindingID}/delete", method = RequestMethod.GET)
	public String neurologicalFindingDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("neurologicalFindingID") Integer neurologicalFindingID) {

		neurologicalFindingService.delete(neurologicalFindingService.findByID(
				NeurologicalFindingEntity.class, neurologicalFindingID));
		return "redirect:/patient/" + patientID + "/neurologicalFinding/list";
	}

	@RequestMapping(value = "/patient/{patientID}/neurologicalFinding/{neurologicalFindingID}/export", method = RequestMethod.GET)
	public String neurologicalFindingExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("neurologicalFindingID") Integer neurologicalFindingID) {
		return "redirect:/patient/" + patientID + "/neurologicalFinding/list";
	}
	
	
	@RequestMapping(value = "/patient/{patientID}/neurologicalFinding/list", method = RequestMethod.GET)
	public String neurologicalFindingListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);
		model.addAttribute("patient", patient);
		return "patient/neurologicalFinding/listView";
	}
}
