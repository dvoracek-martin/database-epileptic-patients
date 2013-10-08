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
import cz.cvut.fit.genepi.entity.card.OperationEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.OperationService;

@Controller
public class OperationController {

	@Autowired
	PatientService patientService;

	@Autowired
	RoleService roleService;

	@Autowired
	OperationService operationService;

	@RequestMapping(value = "/patient/{patientID}/operation/create", method = RequestMethod.GET)
	public String operationCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

		model.addAttribute("patient", patient);
		model.addAttribute("operation", new OperationEntity());
		return "patient/operation/createView";
	}

	/**
	 * Adds the operation.
	 * 
	 * @param operation
	 *            the operation
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/operation/create", method = RequestMethod.POST)
	public String operationCreatePOST(
			@ModelAttribute("operation") @Valid OperationEntity operation,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/operation/createView";
		} else {
			operation.setPatient(patientService.findByID(
					PatientEntity.class, patientID));
			operationService.save(operation);
			return "redirect:/patient/" + patientID + "/operation/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientID}/operation/{operationID}/delete", method = RequestMethod.GET)
	public String operationDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("operationID") Integer operationID) {

		operationService.delete(operationService.findByID(
				OperationEntity.class, operationID));
		return "redirect:/patient/" + patientID + "/operation/list";
	}

	@RequestMapping(value = "/patient/{patientID}/operation/{operationID}/export", method = RequestMethod.GET)
	public String operationExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("operationID") Integer operationID) {
		return "redirect:/patient/" + patientID + "/operation/list";
	}
	
	
	@RequestMapping(value = "/patient/{patientID}/operation/list", method = RequestMethod.GET)
	public String operationListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);
		model.addAttribute("patient", patient);
		return "patient/operation/listView";
	}
}
