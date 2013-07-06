package cz.cvut.fit.genepi.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.cvut.fit.genepi.service.PatientService;

// TODO: Auto-generated Javadoc
/**
 * The Class CreatedPatientController.
 */
@Controller
public class PatientController {

	@Autowired
	private PatientService patientService;

	/**
	 * Created patient get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/createdPatient", method = RequestMethod.GET)
	public String createdPatientGET(Locale locale, Model model) {
		return "createdPatientView";
	}

	@RequestMapping(value = "/createPatient", method = RequestMethod.GET)
	public String createPatientGET(Locale locale, Model model) {
		return "createPatientView";
	}

	@RequestMapping(value = "/patientOverview", method = RequestMethod.POST)
	public String patientOverviewPOST(@RequestParam("id") int id,
			Locale locale, Model model) {
		/* this.id = id; */
		model.addAttribute("id", id);
		return "patientOverviewView";
	}

	@RequestMapping(value = "/patientOverview", method = RequestMethod.GET)
	public String patientOverviewGET(Locale locale, Model model) {
		return "patientOverviewView";
	}

	@RequestMapping(value = "/patientsList", method = RequestMethod.GET)
	public String patientsListGET(Locale locale, Model model) {
		model.addAttribute("patientList", patientService.findAll());
		return "patientsListView";
	}

}