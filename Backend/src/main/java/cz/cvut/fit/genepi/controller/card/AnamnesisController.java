package cz.cvut.fit.genepi.controller.card;

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
import cz.cvut.fit.genepi.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.card.AnamnesisService;

// TODO: Auto-generated Javadoc
/**
 * The Class AnamnesisController.
 */
@Controller
public class AnamnesisController {

	/** The patient service. */

	private PatientService patientService;

	private AnamnesisService anamnesisService;

	private RoleService roleService;

	@Autowired
	public AnamnesisController(PatientService patientService,
			AnamnesisService anamnesisService, RoleService roleService) {
		this.patientService = patientService;
		this.anamnesisService = anamnesisService;
		this.roleService = roleService;
	}

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

		/* getting all docs */
		model.addAttribute("doctors", roleService.getAllDoctors());

		model.addAttribute("patient", patientService.findByID(PatientEntity.class,
				patientID));
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
			BindingResult result, @PathVariable("patientID") Integer patientID,
			Model model, Locale locale) {
		if (result.hasErrors()) {
			model.addAttribute("doctors", roleService.getAllDoctors());
			model.addAttribute("patient", patientService.findByID(PatientEntity.class,
					patientID));
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
		model.addAttribute("patient",
				patientService.getPatientByIdWithAnamnesisList(patientID));
		return "patient/anamnesis/listView";
	}
}