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
import cz.cvut.fit.genepi.entity.card.HistologyEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.HistologyService;

@Controller
public class HistologyController {

	@Autowired
	PatientService patientService;

	@Autowired
	RoleService roleService;

	@Autowired
	HistologyService histologyService;

	@RequestMapping(value = "/patient/{patientID}/histology/create", method = RequestMethod.GET)
	public String histologyCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

		model.addAttribute("patient", patient);
		model.addAttribute("histology", new HistologyEntity());
		return "patient/histology/createView";
	}

	/**
	 * Adds the histology.
	 * 
	 * @param histology
	 *            the histology
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/histology/create", method = RequestMethod.POST)
	public String histologyCreatePOST(
			@ModelAttribute("histology") @Valid HistologyEntity histology,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/histology/createView";
		} else {
			histology.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			histologyService.save(histology);
			return "redirect:/patient/" + patientID + "/histology/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientID}/histology/{histologyID}/delete", method = RequestMethod.GET)
	public String histologyDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("histologyID") Integer histologyID) {

		histologyService.delete(histologyService.findByID(
				HistologyEntity.class, histologyID));
		return "redirect:/patient/" + patientID + "/histology/list";
	}

	@RequestMapping(value = "/patient/{patientID}/histology/{histologyID}/export", method = RequestMethod.GET)
	public String histologyExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("histologyID") Integer histologyID) {
		return "redirect:/patient/" + patientID + "/histology/list";
	}
	
	
	@RequestMapping(value = "/patient/{patientID}/histology/list", method = RequestMethod.GET)
	public String histologyListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.getPatientByIdWithHistologyList(patientID);
		model.addAttribute("patient", patient);
		return "patient/histology/listView";
	}
}
