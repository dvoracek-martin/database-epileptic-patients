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

import cz.cvut.fit.genepi.entity.AnamnesisEntity;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.AnamnesisService;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;

// TODO: Auto-generated Javadoc
/**
 * The Class AnamnesisController.
 */
@Controller
public class AnamnesisController {

	/** The patient service. */
	@Autowired
	private PatientService patientService;

	/** The anamnesis service. */
	@Autowired
	private AnamnesisService anamnesisService;

	@Autowired
	private RoleService roleService;

	/**
	 * Creates the anamnesis get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/anamnesis/create", method = RequestMethod.GET)
	public String anamnesisCreateGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);

		/* getting all docs */
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

		model.addAttribute("patient", patient);
		model.addAttribute("anamnesis", new AnamnesisEntity());
		return "patient/anamnesis/createView";
	}

	/**
	 * Adds the anamnesis.
	 * 
	 * @param anamnesis
	 *            the anamnesis
	 * @param result
	 *            the result
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/anamnesis/create", method = RequestMethod.POST)
	public String anamnesisCreatePOST(
			@ModelAttribute("anamnesis") @Valid AnamnesisEntity anamnesis,
			BindingResult result, @PathVariable("patientID") Integer patientID) {
		if (result.hasErrors()) {
			return "patient/anamnesis/createView";
		} else {
			anamnesis.setPatient(patientService.findByID(PatientEntity.class,
					patientID));
			anamnesisService.save(anamnesis);
			return "redirect:/patient/" + patientID + "/anamnesis/list";
		}
	}

	/**
	 * Delete anamnesis.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param patientID
	 *            the patient id
	 * @param anamnesisID
	 *            the anamnesis id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/anamnesis/{anamnesisID}/delete", method = RequestMethod.GET)
	public String anamnesisDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("anamnesisID") Integer anamnesisID) {

		anamnesisService.delete(anamnesisService.findByID(
				AnamnesisEntity.class, anamnesisID));
		return "redirect:/patient/" + patientID + "/anamnesis/list";
	}

	@RequestMapping(value = "/patient/{patientID}/anamnesis/{anamnesisID}/export", method = RequestMethod.GET)
	public String anamnesisExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID,
			@PathVariable("anamnesisID") Integer anamnesisID) {
		return "redirect:/patient/" + patientID + "/anamnesis/list";
	}

	/**
	 * Patient overview get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/anamnesis/list", method = RequestMethod.GET)
	public String anamnesisListGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);
		model.addAttribute("patient", patient);
		return "patient/anamnesis/listView";
	}
}