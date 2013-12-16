package cz.cvut.fit.genepi.presentationLayer.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.businessLayer.service.ExportParamsService;
import cz.cvut.fit.genepi.businessLayer.service.ExportToCsvService;
import cz.cvut.fit.genepi.businessLayer.service.ExportToDocxService;
import cz.cvut.fit.genepi.businessLayer.service.ExportToPdfService;
import cz.cvut.fit.genepi.businessLayer.service.ExportToTxtService;
import cz.cvut.fit.genepi.businessLayer.service.ExportToXlsxService;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.RoleService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.businessLayer.service.card.AnamnesisService;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.util.LoggingService;

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
			BindingResult result, @RequestParam("doctorId") Integer doctorId,
			Locale locale, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("doctors", roleService.getAllDoctors());
			return "patient/createView";
		} else {
			// patient.setDoctor(userService.findByID(UserEntity.class,
			// doctorId));
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
		model.addAttribute("id");
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
	 * 
	 *         =====================================
	 * 
	 *         DEPRECATED
	 * 
	 *         =====================================
	 * @RequestMapping(value = "/patient/list", method = RequestMethod.GET)
	 *                       public String patientsListGET(Locale locale, Model
	 *                       model) { model.addAttribute("patientList",
	 *                       patientService.findAll(PatientEntity.class));
	 *                       return "patient/listView"; }
	 */

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
	public String patientsListGET(Locale locale, Model model,
			@RequestParam("maxResults") int maxResults,
			@RequestParam("pageNumber") int pageNumber) {
		model.addAttribute("patientList", patientService.findAllWithPagination(
				PatientEntity.class, maxResults, pageNumber));
		model.addAttribute("maxResults", maxResults);
		model.addAttribute("pageNumber", pageNumber);
		// hotfix - there will be some method for getting the count yet
		model.addAttribute("countOfPatients",
				patientService.getCount(PatientEntity.class));
		return "patient/listView";
	}

	/**
	 * Patients list search get. This method is used to provide results for AJAX
	 * calls
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/patient/listSearch", method = RequestMethod.GET)
	public @ResponseBody
	Model patientsListSearchGET(Locale locale, Model model,
			@RequestParam("maxResults") int maxResults,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("name") String name) {

		List<String> tmpList = new ArrayList<String>();
		tmpList.add("contact.firstName");
		tmpList.add("contact.lastName");
		tmpList.add("nin");

		model.addAttribute("patientList", patientService
				.findByNameWithPagination(PatientEntity.class, maxResults,
						pageNumber, tmpList, name));
		model.addAttribute("maxResults", maxResults);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("countOfPatients",
				patientService.getCountOfUnhidden(PatientEntity.class));
		return model;
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
	@RequestMapping(value = "/patient/{patientId}/edit", method = RequestMethod.GET)
	public String patientEditGET(Locale locale, Model model,
			@PathVariable("patientId") Integer patientId) {
		model.addAttribute("patient",
				patientService.getPatientByIdWithDoctor(patientId));
		model.addAttribute("doctors", roleService.getAllDoctors());
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
	@RequestMapping(value = "/patient/{patientId}/edit", method = RequestMethod.POST)
	public String patientEditPOST(Locale locale, Model model,
			@Valid @ModelAttribute("patient") PatientEntity patient,
			BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("doctors", roleService.getAllDoctors());
			return "patient/editView";
		} else {
			patientService.save(patient);
			return "redirect:/patient/" + /* Integer.toString( */patient.getId()/* ) */
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

		List<ExportParamsEntity> listOfSavedConfigurations = new ArrayList<ExportParamsEntity>();
		List<ExportParamsEntity> listOfSavedConfigurationsTmp = new ArrayList<ExportParamsEntity>();
		listOfSavedConfigurationsTmp = exportParamsService
				.findAll(ExportParamsEntity.class);

		for (ExportParamsEntity exportEntityParams : listOfSavedConfigurationsTmp) {
			if (exportEntityParams.isGeneric())
				listOfSavedConfigurations.add(exportEntityParams);
		}

		List<ExportParamsEntity> listOfUsersSavedConfigurations = new ArrayList<ExportParamsEntity>();
		listOfUsersSavedConfigurations = exportParamsService
				.findExportParamsEntityByUserID(user.getId());

		if (listOfSavedConfigurations.size() > 0)
			listOfSavedConfigurations.remove(0);
		if ((listOfUsersSavedConfigurations.size() > 0) && (user.getId() == 1))
			listOfUsersSavedConfigurations.remove(0);

		model.addAttribute("listOfSavedConfigurations",
				listOfSavedConfigurations);
		model.addAttribute("listOfUsersSavedConfigurations",
				listOfUsersSavedConfigurations);
		model.addAttribute("user", user);
		model.addAttribute("exportParams",
				exportParamsService.findByID(ExportParamsEntity.class, 1));
		List<PatientEntity> listOfPatients = new ArrayList<PatientEntity>();
		listOfPatients.add(patientService.findByID(PatientEntity.class,
				patientID));
		model.addAttribute("patientList", listOfPatients);
		model.addAttribute("patient", listOfPatients.get(0));
		return "patient/exportView";
	}

	@RequestMapping(value = "/patient/export", method = RequestMethod.POST)
	public String patientExportPOST(
			@ModelAttribute("exportParams") ExportParamsEntity exportParams,
			@RequestParam("patient") Integer[] patientID,
			@RequestParam("exportType") String exportType, Locale locale,
			Model model) {
		logger.setLogger(PatientController.class);

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		List<PatientEntity> patientList = new ArrayList<PatientEntity>();
		for (Integer patient : patientID) {
			patientList.add(patientService.getPatientByIdWithAllLists(patient));
		}
		if (exportType.equals("pdf")) {
			try {
				String url = exportToPdfService.export(patientList,
						userService.findUserByUsername(auth.getName()), locale,
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
					userService.findUserByUsername(auth.getName()), locale,
					exportParams);
			return "redirect:/resources/downloads/" + url;
		} else if (exportType.equals("docx")) {
			String url = exportToDocxService.export(patientList,
					userService.findUserByUsername(auth.getName()), locale,
					exportParams);
			return "redirect:/resources/downloads/" + url;
		} else if (exportType.equals("txt")) {
			String url = exportToTxtService.export(patientList,
					userService.findUserByUsername(auth.getName()), locale,
					exportParams);
			return "redirect:/resources/downloads/" + url;
		} else if (exportType.equals("csv")) {
			String url = exportToCsvService.export(patientList,
					userService.findUserByUsername(auth.getName()), locale,
					exportParams);
			return "redirect:/resources/downloads/" + url;
		}

		List<PatientEntity> listOfPatients = new ArrayList<PatientEntity>();
		listOfPatients.add(patientService.findByID(PatientEntity.class,
				patientID[0]));
		model.addAttribute("patientList", listOfPatients);
		model.addAttribute("listOfPossibleExportParams",
				exportParamsService.findAll(ExportParamsEntity.class));
		model.addAttribute("exportType", exportType);
		model.addAttribute("patient", listOfPatients.get(0));
		return "patient/exportView";
	}

	@RequestMapping(value = "/patient/export/save", method = RequestMethod.POST)
	public String patientExportSavePOST(
			@ModelAttribute("exportParams") ExportParamsEntity exportParams,
			@RequestParam("patient") Integer[] patient,
			@RequestParam("isGeneric") boolean isGeneric,
			@RequestParam("exportName") String exportName, Locale locale,
			Model model) {

		exportParams.setName(exportName);
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		exportParams.setUserID(userService.findUserByUsername(auth.getName())
				.getId());
		exportParams.setGeneric(isGeneric);
		exportParamsService.save(exportParams);

		return "redirect:/patient/" + patient[0] + "/export";
	}

	// TODO: revision
	@RequestMapping(value = "/patient/export/load", method = RequestMethod.POST)
	public String patientExportLoadPOST(Model model, Locale locale,
			@RequestParam("patient") Integer[] patientID,
			@RequestParam("exportId") Integer exportID) {

		if (logger.getLogger() == null)
			logger.setLogger(PatientController.class);

		ExportParamsEntity exportParams = exportParamsService.findByID(
				ExportParamsEntity.class, exportID);

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		UserEntity user = userService.findUserByUsername(auth.getName());

		model.addAttribute("exportParams", exportParams);

		List<ExportParamsEntity> listOfSavedConfigurations = new ArrayList<ExportParamsEntity>();
		List<ExportParamsEntity> listOfSavedConfigurationsTmp = new ArrayList<ExportParamsEntity>();
		listOfSavedConfigurationsTmp = exportParamsService
				.findAll(ExportParamsEntity.class);

		for (ExportParamsEntity exportEntityParams : listOfSavedConfigurationsTmp) {
			if (exportEntityParams.isGeneric())
				listOfSavedConfigurations.add(exportEntityParams);
		}

		List<ExportParamsEntity> listOfUsersSavedConfigurations = new ArrayList<ExportParamsEntity>();
		listOfUsersSavedConfigurations = exportParamsService
				.findExportParamsEntityByUserID(user.getId());

		if (listOfSavedConfigurations.size() > 0)
			listOfSavedConfigurations.remove(0);
		if ((listOfUsersSavedConfigurations.size() > 0) && (user.getId() == 1))
			listOfUsersSavedConfigurations.remove(0);

		model.addAttribute("listOfSavedConfigurations",
				listOfSavedConfigurations);
		model.addAttribute("listOfUsersSavedConfigurations",
				listOfUsersSavedConfigurations);
		model.addAttribute("user", user);
		model.addAttribute("patient", /* patientService.delete( */
				patientService.findByID(PatientEntity.class, patientID[0]))/* ) */;
		List<PatientEntity> patientList = new ArrayList<PatientEntity>();
		for (Integer patient : patientID) {
			patientList.add(patientService.getPatientByIdWithAllLists(patient));
		}

		model.addAttribute("patientList", patientList);
		return "patient/exportView";
	}

	@RequestMapping(value = "/patient/export/delete", method = RequestMethod.POST)
	public String patientExportDeletePOST(
			@RequestParam("patient") Integer[] patientId,
			@RequestParam("exportId") Integer exportId) {
		exportParamsService.delete(exportParamsService.findByID(
				ExportParamsEntity.class, exportId));
		return "redirect:/patient/" + patientId[0] + "/export";
	}
}
