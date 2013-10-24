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
import cz.cvut.fit.genepi.entity.card.InvasiveTestECOGEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.InvasiveTestECOGService;

@Controller
public class InvasiveTestECOGController {

	@Autowired
	PatientService patientService;

	@Autowired
	RoleService roleService;

	@Autowired
	InvasiveTestECOGService invasiveTestECOGService;

	@RequestMapping(value = "/patient/{patientID}/invasiveTestECOG/create", method = RequestMethod.GET)
	public String invasiveTestECOGCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

		model.addAttribute("patient", patient);
		model.addAttribute("invasiveTestECOG", new InvasiveTestECOGEntity());
		return "patient/invasiveTestECOG/createView";
	}

	/**
	 * Adds the invasiveTestECOG.
	 * 
	 * @param invasiveTestECOG
	 *            the invasiveTestECOG
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/invasiveTestECOG/create", method = RequestMethod.POST)
	public String invasiveTestECOGCreatePOST(
			@ModelAttribute("invasiveTestECOG") @Valid InvasiveTestECOGEntity invasiveTestECOG,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/invasiveTestECOG/createView";
		} else {
			invasiveTestECOG.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			invasiveTestECOGService.save(invasiveTestECOG);
			return "redirect:/patient/" + patientID + "/invasiveTestECOG/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientID}/invasiveTestECOG/{invasiveTestECOGID}/delete", method = RequestMethod.GET)
	public String invasiveTestECOGDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("invasiveTestECOGID") Integer invasiveTestECOGID) {

		invasiveTestECOGService.delete(invasiveTestECOGService.findByID(
				InvasiveTestECOGEntity.class, invasiveTestECOGID));
		return "redirect:/patient/" + patientID + "/invasiveTestECOG/list";
	}

	@RequestMapping(value = "/patient/{patientID}/invasiveTestECOG/{invasiveTestECOGID}/export", method = RequestMethod.GET)
	public String invasiveTestECOGExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("invasiveTestECOGID") Integer invasiveTestECOGID) {
		return "redirect:/patient/" + patientID + "/invasiveTestECOG/list";
	}
	
	
	@RequestMapping(value = "/patient/{patientID}/invasiveTestECOG/list", method = RequestMethod.GET)
	public String invasiveTestECOGListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.getPatientByIdWithInvasiveTestECOGList(patientID);
		model.addAttribute("patient", patient);
		return "patient/invasiveTestECOG/listView";
	}
}
