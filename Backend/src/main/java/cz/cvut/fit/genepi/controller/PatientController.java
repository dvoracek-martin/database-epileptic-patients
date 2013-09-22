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
import org.springframework.web.bind.annotation.RequestParam;

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.AnamnesisService;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.UserService;
import cz.cvut.fit.genepi.serviceImpl.ExportServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CreatedPatientController.
 */
@Controller
public class PatientController {

	/** The patient service. */
	@Autowired
	private PatientService patientService;

	/** The anamnesis service. */
	@Autowired
	private AnamnesisService anamnesisService;

	@Autowired
	private UserService userService;

	/**
	 * Creates the patient get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/patient/create", method = RequestMethod.GET)
	public String createPatientGET(Locale locale, Model model) {
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		//doctors = userService.getDoctors();
		model.addAttribute("patient", new PatientEntity());
		model.addAttribute("doctors", doctors);
		System.out.println("test");
		return "patient/createView";
	}

	/**
	 * Adds the patient.
	 * 
	 * @param patient
	 *            the patient
	 * @param result
	 *            the result
	 * @return the string
	 */
	@RequestMapping(value = "/patient/add", method = RequestMethod.POST)
	public String addPatient(
			@ModelAttribute("patient") @Valid PatientEntity patient,
			BindingResult result) {
		if (result.hasErrors()) {
			return "patient/createView";
		} else {
			patientService.save(patient);
			return "redirect:/patient/" + Integer.toString(patient.getId())
					+ "/overview";
		}
	}

	/**
	 * Patient overview post.
	 * 
	 * @param id
	 *            the id
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/patientOverview", method = RequestMethod.POST)
	public String patientOverviewPOST(@RequestParam("id") int id,
			Locale locale, Model model) {
		model.addAttribute("id", id);
		return "patient/overviewView";
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
	@RequestMapping(value = "/patient/{patientID}/overview", method = RequestMethod.GET)
	public String patientOverviewGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		PatientEntity patient = patientService.findByID(PatientEntity.class,
				patientID);
		model.addAttribute("patient", patient);
		model.addAttribute("anamnesis",
				anamnesisService.findLatestAnamnesisByPatientID(patientID));
		return "patient/overviewView";
	}

	/**
	 * Patients list get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/patient/list", method = RequestMethod.GET)
	public String patientsListGET(Locale locale, Model model) {
		model.addAttribute("patientList",
				patientService.findAll(PatientEntity.class));
		return "patient/listView";
	}

	@RequestMapping(value = "/patient/{patientID}/delete", method = RequestMethod.GET)
	public String patientDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		patientService.delete(patientService.findByID(PatientEntity.class,
				patientID));
		return "patient/overviewView";
	}

	
	@RequestMapping(value = "/patient/{patientID}/edit", method = RequestMethod.GET)
	public String patientEditGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		patientService.delete(patientService.findByID(PatientEntity.class,
				patientID));
		return "patient/editView";
	}
		
	@RequestMapping(value = "/patient/edit", method = RequestMethod.POST)
	public String patientEditPOST(Locale locale, Model model,
			@ModelAttribute("patient") @Valid PatientEntity patient,
			BindingResult result) {
		if (result.hasErrors()) {
			return "patient/"+ Integer.toString(patient.getId())+"/edit";
		} else {
			patientService.save(patient);
			return "redirect:/patient/" + Integer.toString(patient.getId())
					+ "/overview";
		}
	}
	
	@RequestMapping(value = "/patient/{patientID}/export", method = RequestMethod.GET)
	public String patientExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		new ExportServiceImpl("xlsx", patientID);
		return "redirect:/patient/" + Integer.toString(patientID) + "/overview";
	}
}