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
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.ExportParamsService;
import cz.cvut.fit.genepi.service.ExportToCsvService;
import cz.cvut.fit.genepi.service.ExportToDocxService;
import cz.cvut.fit.genepi.service.ExportToPdfService;
import cz.cvut.fit.genepi.service.ExportToTxtService;
import cz.cvut.fit.genepi.service.ExportToXlsxService;
import cz.cvut.fit.genepi.service.LoggingService;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.UserService;
import cz.cvut.fit.genepi.service.card.AnamnesisService;

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

	@Autowired
	private ExportToTxtService exportToTxtService;

	@Autowired
	private ExportToCsvService exportToCsvService;

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
		model.addAttribute("doctors", roleService.getAllDoctors());
		model.addAttribute("patient", new PatientEntity());
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
	public String patientCreatePOST(Locale locale, Model model,
			@ModelAttribute("patient") @Valid PatientEntity patient,
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("doctors", roleService.getAllDoctors());
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
		model.addAttribute("patient",
				patientService.getPatientByIdWithAllLists(patientID));
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
		return "redirect:/patient/list";
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
			@Valid @ModelAttribute("patient") PatientEntity patient,
			BindingResult result) {

		if (result.hasErrors()) {
			return "patient/editView";
		} else {
			patientService.save(patient);
			return "redirect:/patient/" + Integer.toString(patient.getId())
					+ "/overview";
		}
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

		// @TODO:
		// chyba - tohle tedkon se predava do my sets, ale melo by se predavat
		// do user sets
		// predelat, aby se zobrazovalo spravne + pridat logiku na zobrazovani
		// my sets
		List<ExportParamsEntity> listOfSavedConfigurations = new ArrayList<ExportParamsEntity>();
		List<ExportParamsEntity> listOfSavedConfigurationsTmp = new ArrayList<ExportParamsEntity>();
		listOfSavedConfigurationsTmp = exportParamsService
				.findExportParamsEntityByUserID(user.getId());

		for (ExportParamsEntity exportEntityParams : listOfSavedConfigurationsTmp) {
			if (exportEntityParams.isGeneric())
				;
			listOfSavedConfigurations.add(exportEntityParams);
		}

		List<ExportParamsEntity> listOfUsersSavedConfigurations = new ArrayList<ExportParamsEntity>();
		listOfUsersSavedConfigurations = exportParamsService
				.findAll(ExportParamsEntity.class);

		model.addAttribute("listOfPossibleCards", listOfPossibleCards);
		model.addAttribute("listOfSavedConfigurations",
				listOfSavedConfigurations);
		model.addAttribute("listOfUsersSavedConfigurations",
				listOfUsersSavedConfigurations);
		model.addAttribute("user", user);

		model.addAttribute("patient",
				patientService.findByID(PatientEntity.class, patientID));
		String[] arrayOfAsignedCards = null;
		model.addAttribute("arrayOfAsignedCards", arrayOfAsignedCards);
		return "patient/exportView";
	}

	@RequestMapping(value = "/patient/export", method = RequestMethod.POST)
	public String patientExportPOST(
			@ModelAttribute("patient") PatientEntity patient,
			@RequestParam("exportType") String exportType,
			@RequestParam("cards") String[] cards, Locale locale, Model model) {
		logger.setLogger(PatientController.class);

		// TODO:
		// get exportParams from FE
		ExportParamsEntity exportParams = new ExportParamsEntity();

		List<String> listOfExports = new ArrayList<String>();
		for (String s : cards) {
			listOfExports.add(s);
		}

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		patient = patientService.getPatientByIdWithAllLists(patient.getId());
		List<PatientEntity> patientList = new ArrayList<PatientEntity>();
		patientList.add(patient);

		if (exportType.equals("pdf")) {
			try {
				String url = exportToPdfService.export(patientList,
						userService.findUserByUsername(auth.getName()),
						listOfExports, listOfPossibleCards, locale,
						exportParams);
				return "redirect:/resources/downloads/" + url;
			} catch (FileNotFoundException e) {
				logger.logError(
						"File wasn't found when trying to export to pdf.", e);
			} catch (DocumentException e) {
				logger.logError(
						"Document exception when trying to export to pdf.", e);
			}
		} else if (exportType.equals("xlsx")) {
			String url = exportToXlsxService.export(patientList,
					userService.findUserByUsername(auth.getName()),
					listOfExports, locale, exportParams);
			return "redirect:/resources/downloads/" + url;
		} else if (exportType.equals("docx")) {
			String url = exportToDocxService.export(patientList,
					userService.findUserByUsername(auth.getName()),
					listOfExports, locale, exportParams);
			return "redirect:/resources/downloads/" + url;
		} else if (exportType.equals("txt")) {
			String url = exportToTxtService.export(patientList,
					userService.findUserByUsername(auth.getName()), locale,
					listOfExports, listOfPossibleCards, exportParams);
			return "redirect:/resources/downloads/" + url;
		} else if (exportType.equals("csv")) {
			String url = exportToCsvService.export(patientList,
					userService.findUserByUsername(auth.getName()), locale,
					listOfExports, listOfPossibleCards, exportParams);
			return "redirect:/resources/downloads/" + url;
		}

		model.addAttribute("patient",
				patientService.findByID(PatientEntity.class, patient.getId()));
		model.addAttribute("listOfPossibleExportParams",
				exportParamsService.findAll(ExportParamsEntity.class));
		model.addAttribute("exportType", exportType);
		return "patient/exportView";
	}

	@RequestMapping(value = "/patient/export/save", method = RequestMethod.POST)
	public String patientExportSavePOST(
			@RequestParam("patientId") Integer patientId,
			@RequestParam("isGeneric") boolean isGeneric,
			@RequestParam("exportName") String exportName,
			@RequestParam("cards") String[] cards, Locale locale, Model model) {
		ExportParamsEntity exportParams = new ExportParamsEntity();
		exportParams.setName(exportName);
		String params = "";

		for (String s : cards) {
			params += s + ",";
		}

		params = params.substring(0, params.length() - 1);
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		exportParams.setUserID(userService.findUserByUsername(auth.getName())
				.getId());
		exportParams.setParams(params);
		exportParams.setGeneric(isGeneric);
		exportParamsService.save(exportParams);

		return "redirect:/patient/" + patientId + "/export";
	}

	// TODO: revision
	@RequestMapping(value = "/patient/export/load", method = RequestMethod.POST)
	public String patientExportLoadPOST(Model model, Locale locale,
			@RequestParam("patientId") Integer patientId,
			@RequestParam("exportId") Integer exportID) {

		if (logger.getLogger() == null)
			logger.setLogger(PatientController.class);

		ExportParamsEntity exportParams = exportParamsService.findByID(
				ExportParamsEntity.class, exportID);
		String[] arrayOfAsignedCards = exportParams.getParams().split(",");

		List<String> listOfAllCards = new ArrayList<String>();
		listOfAllCards.add(messageSource.getMessage("label.anamnesis", null,
				locale));
		listOfAllCards.add("Farmakoloterapie");
		listOfAllCards.add("Zachvaty");
		listOfAllCards.add("Farmakoloterapie");
		listOfAllCards.add("Neurologicke nalezy");
		listOfAllCards.add("Neuropsychologie");
		listOfAllCards.add("Diagnosticke EEG testy");
		listOfAllCards.add("Diagnosticke MRI testy");
		listOfAllCards.add("Invazivni EEG testy");
		listOfAllCards.add("Invazivni ECoG testy");
		listOfAllCards.add("Operace");
		listOfAllCards.add("Histologie");
		listOfAllCards.add("Komplikace");
		listOfAllCards.add("Outcome");

		List<String> listOfPossibleCards = new ArrayList<String>();

		boolean found = false;
		for (String possibleCard : listOfAllCards) {
			found = false;
			for (String card : arrayOfAsignedCards)
				if (card.equals(possibleCard) && (exportParams.getId() != 1)) {
					found = true;
					continue;
				}
			if (!found) {
				listOfPossibleCards.add(possibleCard);
			}
		}

		for (String s : listOfPossibleCards) {
			System.out.println(s);
		}
		for (String s : arrayOfAsignedCards) {
			System.out.println(s);
		}

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		UserEntity user = userService.findUserByUsername(auth.getName());

		model.addAttribute("listOfPossibleCards", listOfPossibleCards);
		model.addAttribute("arrayOfAsignedCards", arrayOfAsignedCards);

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

		model.addAttribute("patient",
				patientService.findByID(PatientEntity.class, patientId));
		return "patient/exportView";
	}

	@RequestMapping(value = "/patient/export/delete", method = RequestMethod.POST)
	public String patientExportDeletePOST(
			@RequestParam("patientId") Integer patientId,
			@RequestParam("exportId") Integer exportId) {
		exportParamsService.delete(exportParamsService.findByID(
				ExportParamsEntity.class, exportId));
		return "redirect:/patient/" + patientId + "/export";
	}
}