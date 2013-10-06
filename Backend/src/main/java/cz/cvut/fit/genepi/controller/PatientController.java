package cz.cvut.fit.genepi.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.AnamnesisService;
import cz.cvut.fit.genepi.service.ExportParamsService;
import cz.cvut.fit.genepi.service.ExportToDocxService;
import cz.cvut.fit.genepi.service.ExportToPdfService;
import cz.cvut.fit.genepi.service.ExportToXlsxService;
import cz.cvut.fit.genepi.service.LoggingService;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class CreatedPatientController.
 */
@Controller
public class PatientController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ExportParamsService exportParamsService;

	/** The patient service. */
	@Autowired
	private PatientService patientService;

	/** The anamnesis service. */
	@Autowired
	private AnamnesisService anamnesisService;

	/** The user service. */
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private ExportToPdfService exportToPdfService;

	@Autowired
	private ExportToXlsxService exportToXlsxService;

	@Autowired
	private ExportToDocxService exportToDocxService;

	/** The Constant logger. */
	private LoggingService logger = new LoggingService();

	private List<String> listOfPossibleCards;

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
	public String patientCreateGET(Locale locale, Model model) {

		List<UserEntity> doctors = new ArrayList<UserEntity>();
		RoleEntity doctorRole = roleService.findByID(RoleEntity.class, 2);
		doctors = doctorRole.getUsers();
		model.addAttribute("doctors", doctors);

		model.addAttribute("patient", new PatientEntity());
		model.addAttribute("doctors", doctors);
		model.addAttribute("male",
				messageSource.getMessage("label.male", null, locale));
		model.addAttribute("female",
				messageSource.getMessage("label.female", null, locale));
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
	@RequestMapping(value = "/patient/create", method = RequestMethod.POST)
	public String patientCreatePOST(
			@ModelAttribute("patient") @Valid PatientEntity patient,
			BindingResult result, Locale locale, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("male",
					messageSource.getMessage("label.male", null, locale));
			model.addAttribute("female",
					messageSource.getMessage("label.female", null, locale));
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

	/**
	 * Patient delete get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/delete", method = RequestMethod.GET)
	public String patientDeleteGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		patientService.delete(patientService.findByID(PatientEntity.class,
				patientID));
		return "patient/overviewView";
	}

	/**
	 * Patient edit get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */
	@RequestMapping(value = "/patient/{patientID}/edit", method = RequestMethod.GET)
	public String patientEditGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {
		patientService.findByID(PatientEntity.class, patientID);
		model.addAttribute("patient",
				patientService.findByID(PatientEntity.class, patientID));
		return "patient/editView";
	}

	/**
	 * Patient edit post.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param patient
	 *            the patient
	 * @return the string
	 */
	@RequestMapping(value = "/patient/edit", method = RequestMethod.POST)
	public String patientEditPOST(Locale locale, Model model,
			@ModelAttribute("patient") PatientEntity patient) {

		patientService.save(patient);
		return "redirect:/patient/" + Integer.toString(patient.getId())
				+ "/overview";

	}

	/**
	 * Patient export get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param patientID
	 *            the patient id
	 * @return the string
	 */

	@RequestMapping(value = "/patient/{patientID}/export", method = RequestMethod.GET)
	public String patientExportGET(Locale locale, Model model,
			@PathVariable("patientID") Integer patientID) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		UserEntity user = userService.findUserByUsername(auth.getName());

		this.listOfPossibleCards = new ArrayList<String>();

		listOfPossibleCards.add(messageSource.getMessage("label.anamnesis",
				null, locale));
		listOfPossibleCards.add("Farmakoloterapie");
		listOfPossibleCards.add("Zachvaty");
		listOfPossibleCards.add("Farmakoloterapie");
		listOfPossibleCards.add("Neurologicke nalezy");
		listOfPossibleCards.add("Neuropsychologie");
		listOfPossibleCards.add("Diagnosticke EEG testy");
		listOfPossibleCards.add("Diagnosticke MRI testy");
		listOfPossibleCards.add("Invazivni EEG testy");
		listOfPossibleCards.add("Invazivni ECoG testy");
		listOfPossibleCards.add("Operace");
		listOfPossibleCards.add("Histologie");
		listOfPossibleCards.add("Komplikace");
		listOfPossibleCards.add("Outcome");

		List<ExportParamsEntity> listOfSavedConfigurations = new ArrayList<ExportParamsEntity>();
		listOfSavedConfigurations = exportParamsService
				.findExportParamsEntityByUserID(user.getId());

		List<ExportParamsEntity> listOfUsersSavedConfigurations = new ArrayList<ExportParamsEntity>();
		listOfUsersSavedConfigurations = exportParamsService
				.findAll(ExportParamsEntity.class);

		model.addAttribute("listOfPossibleCards", listOfPossibleCards);
		model.addAttribute("listOfSavedConfigurations",
				listOfSavedConfigurations);
		model.addAttribute("listOfUsersSavedConfigurations",
				listOfUsersSavedConfigurations);
		model.addAttribute("user", user);

		boolean isReady = false;
		model.addAttribute("patient",
				patientService.findByID(PatientEntity.class, patientID));
		model.addAttribute("isReady", isReady);
		return "patient/exportView";
	}

	@RequestMapping(value = "/patient/export", method = RequestMethod.POST)
	public String patientExportPOST(
			@ModelAttribute("patient") PatientEntity patient,
			@RequestParam("exportType") String exportType,
			@RequestParam("cards") String[] cards, Locale locale, Model model) {
		logger.setLogger(PatientController.class);

		List<String> listOfExports = new ArrayList<String>();
		for (String s : cards) {
			listOfExports.add(s);
		}

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		patient = patientService.findByID(PatientEntity.class, patient.getId());

		if (exportType.equals("pdf")) {
			try {
				exportToPdfService.export(patient,
						userService.findUserByUsername(auth.getName()),
						listOfExports, listOfPossibleCards);
			} catch (FileNotFoundException e) {
				logger.logError(
						"File wasn't found when trying to export to pdf.", e);
			} catch (DocumentException e) {
				logger.logError(
						"Document exception when trying to export to pdf.", e);
			}
		} else if (exportType.equals("xlsx")) {
			exportToXlsxService.export(patient,
					userService.findUserByUsername(auth.getName()),
					listOfExports);
		} else if (exportType.equals("docx")) {
			exportToDocxService.export(patient,
					userService.findUserByUsername(auth.getName()),
					listOfExports);
		}
		boolean isReady = true;
		model.addAttribute("patient",
				patientService.findByID(PatientEntity.class, patient.getId()));
		model.addAttribute("listOfExports", new ArrayList<String>());
		model.addAttribute("isReady", isReady);

		List<String> chosenRoles=new ArrayList<String>();
		boolean found = false;
		for (String possibleCard : listOfPossibleCards) {
			found = false;
			for (String card : cards)
				if (card == possibleCard) {
					found = true;
					continue;
				}
			if (!found) {
				chosenRoles.add(possibleCard);
			}
		}

		
		model.addAttribute("exportType",exportType);
		model.addAttribute("cards", cards);
		model.addAttribute("listOfPossibleCards", listOfPossibleCards.toArray());
		return "patient/exportView";
	}
}