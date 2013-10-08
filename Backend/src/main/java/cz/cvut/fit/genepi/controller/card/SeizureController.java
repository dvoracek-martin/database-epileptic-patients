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
import cz.cvut.fit.genepi.entity.card.SeizureEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.SeizureService;

@Controller
public class SeizureController {

	@Autowired
	PatientService patientService;

	@Autowired
	RoleService roleService;

	@Autowired
	SeizureService seizureService;

	@RequestMapping(value = "/patient/{patientID}/seizure/create", method = RequestMethod.GET)
	public String seizureCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

		model.addAttribute("patient", patient);
		model.addAttribute("seizure", new SeizureEntity());
		return "patient/seizure/createView";
	}

	/**
	 * Adds the seizure.
	 * 
	 * @param seizure
	 *            the seizure
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/seizure/create", method = RequestMethod.POST)
	public String seizureCreatePOST(
			@ModelAttribute("seizure") @Valid SeizureEntity seizure,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/seizure/createView";
		} else {
			seizure.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			seizureService.save(seizure);
			return "redirect:/patient/" + patientID + "/seizure/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientID}/seizure/{seizureID}/delete", method = RequestMethod.GET)
	public String seizureDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("seizureID") Integer seizureID) {

		seizureService.delete(seizureService.findByID(
				SeizureEntity.class, seizureID));
		return "redirect:/patient/" + patientID + "/seizure/list";
	}

	@RequestMapping(value = "/patient/{patientID}/seizure/{seizureID}/export", method = RequestMethod.GET)
	public String seizureExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("seizureID") Integer seizureID) {
		return "redirect:/patient/" + patientID + "/seizure/list";
	}
	
	
	@RequestMapping(value = "/patient/{patientID}/seizure/list", method = RequestMethod.GET)
	public String seizureListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);
		model.addAttribute("patient", patient);
		return "patient/seizure/listView";
	}
}
