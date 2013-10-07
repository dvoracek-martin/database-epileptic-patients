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
import cz.cvut.fit.genepi.entity.card.InvasiveTestEEGEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.InvasiveTestEEGService;

@Controller
public class InvasiveTestEEGController {

	@Autowired
	PatientService patientService;

	@Autowired
	RoleService roleService;

	@Autowired
	InvasiveTestEEGService invasiveTestEEGService;

	@RequestMapping(value = "/patient/{patientID}/invasiveTestEEG/create", method = RequestMethod.GET)
	public String invasiveTestEEGCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

		model.addAttribute("patient", patient);
		model.addAttribute("invasiveTestEEG", new InvasiveTestEEGEntity());
		return "patient/invasiveTestEEG/createView";
	}

	/**
	 * Adds the invasiveTestEEG.
	 * 
	 * @param invasiveTestEEG
	 *            the invasiveTestEEG
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/invasiveTestEEG/create", method = RequestMethod.POST)
	public String invasiveTestEEGCreatePOST(
			@ModelAttribute("invasiveTestEEG") @Valid InvasiveTestEEGEntity invasiveTestEEG,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/invasiveTestEEG/createView";
		} else {
			invasiveTestEEG.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			invasiveTestEEGService.save(invasiveTestEEG);
			return "redirect:/patient/" + patientID + "/invasiveTestEEG/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientID}/invasiveTestEEG/{invasiveTestEEGID}/delete", method = RequestMethod.GET)
	public String invasiveTestEEGDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("invasiveTestEEGID") Integer invasiveTestEEGID) {

		invasiveTestEEGService.delete(invasiveTestEEGService.findByID(
				InvasiveTestEEGEntity.class, invasiveTestEEGID));
		return "redirect:/patient/" + patientID + "/invasiveTestEEG/list";
	}

	@RequestMapping(value = "/patient/{patientID}/invasiveTestEEG/{invasiveTestEEGID}/export", method = RequestMethod.GET)
	public String invasiveTestEEGExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("invasiveTestEEGID") Integer invasiveTestEEGID) {
		return "redirect:/patient/" + patientID + "/invasiveTestEEG/list";
	}
	
	
	@RequestMapping(value = "/patient/{patientID}/invasiveTestEEG/list", method = RequestMethod.GET)
	public String invasiveTestEEGListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);
		model.addAttribute("patient", patient);
		return "patient/invasiveTestEEG/listView";
	}
}
