package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.PatientVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.PatientVO;
import cz.cvut.fit.genepi.businessLayer.service.*;
import cz.cvut.fit.genepi.businessLayer.service.card.AnamnesisService;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.util.AuthorizationChecker;
import cz.cvut.fit.genepi.util.JSONEncoder;
import cz.cvut.fit.genepi.util.LoggingService;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// TODO: Auto-generated Javadoc

/**
 * The Class CreatedPatientController.
 */
@Controller
@SessionAttributes({"patient","patientVO"})
public class PatientController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ExportParamsService exportParamsService;

    /**
     * The patient service.
     */
    @Autowired
    private PatientService patientService;

    /**
     * The anamnesis service.
     */
    @Autowired
    private AnamnesisService anamnesisService;

    /**
     * The user service.
     */
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

    /**
     * The Constant logger.
     */
    private LoggingService logger = new LoggingService();

    /**
     * Creates the patient get.
     *
     * @param locale the locale
     * @param model  the model
     * @return the string
     */
    @RequestMapping(value = "/patient/create", method = RequestMethod.GET)
    public String patientCreateGET(Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("doctors", roleService.getAllDoctors());
        model.addAttribute("patient", new PatientEntity());
        return "patient/createView";
    }

    /**
     * Adds the patient.
     *
     * @param patient the patient
     * @param result  the result
     * @return the string
     */
    @RequestMapping(value = "/patient/create", method = RequestMethod.POST)
    public String patientCreatePOST(
            @ModelAttribute("patient") @Valid PatientEntity patient,
            BindingResult result, @RequestParam("doctorId") Integer doctorId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors() || TimeConverter.compareDates(patient.getBirthday(), DateTime.now())) {
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
     * @param id     the id
     * @param locale the locale
     * @param model  the model
     * @return the string
     */
    //TODO: unused
    @RequestMapping(value = "/patientOverview", method = RequestMethod.POST)
    public String patientOverviewPOST(@RequestParam("id") int id,
                                      Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("id");
        return "patient/overviewView";
    }

    @RequestMapping(value = "/patient/{patientId}/verify", method = RequestMethod.GET)
    public String patientVerifyGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        PatientDisplayVO patientDisplay = patientService.getPatientDisplayByIdWithDoctor(patientId);
        PatientVO patient = patientService.getById(patientId);

        model.addAttribute("patient", patientDisplay);
        model.addAttribute("patientVO", patient);

        return "patient/verifyView";
    }

    @RequestMapping(value = "/patient/{patientId}/verify", method = RequestMethod.POST)
    public String patientVerifyPOST(
            @ModelAttribute("patientVO") @Valid PatientVO patientVO, BindingResult result,
            @PathVariable("patientId") Integer patientId,
            Locale locale, Model model HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        if (result.hasErrors()) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            model.addAttribute("patientVO", patientService.getById(patientId));
            return "patient/verifyView";
        } else {
            patientService.save(patientVO);
            return "redirect:/patient/"+patientId+"/overview";
        }
    }

    /**
     * Patient overview get.
     *
     * @param locale the locale
     * @param model  the model
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/overview", method = RequestMethod.GET)
    public String patientOverviewGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithAllLists(patientId);

        if (patient.getAnamnesisList().size() == 0) {
            model.addAttribute("displayAnamnesisCreate", true);
        } else {
            model.addAttribute("displayCreate", false);
        }
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
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
     * @param locale the locale
     * @param model  the model
     * @return the string
     */
    @RequestMapping(value = "/patient/list", method = RequestMethod.GET)
    public String patientsListGET(Locale locale, Model model,
                                  @RequestParam("maxResults") int maxResults, HttpServletRequest request/*,
                                  @RequestParam("pageNumber") int pageNumber*/) {
      /*  model.addAttribute("patientList", patientService.findAllWithPagination(PatientEntity.class, maxResults, pageNumber));
        model.addAttribute("maxResults", maxResults);
        model.addAttribute("pageNumber", pageNumber);
        // hotfix - there will be some method for getting the count yet
        model.addAttribute("countOfPatients",
                patientService.getCount(PatientEntity.class));*/
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("maxResult", maxResults);
        return "patient/listView";
    }

    /**
     * Patients list search get. This method is used to provide results for AJAX
     * calls
     *
     * @param locale the locale
     * @param model  the model
     * @return the string
     */
    @RequestMapping(value = "/patient/listSearch", method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
    public
    @ResponseBody
    String patientsListSearchGET(Locale locale, Model model,
                                 @RequestParam("maxResults") int maxResults,
                                 @RequestParam("pageNumber") int pageNumber,
                                 @RequestParam("search") String searchString, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        List<String> searchParams = new ArrayList<>();
        searchParams.add("contact.firstName");
        searchParams.add("contact.lastName");
        searchParams.add("nin");

        int patientsCount = patientService.getCountOfUnhidden(PatientEntity.class, searchString);
        JSONEncoder e = new JSONEncoder();
        return (e.encode(patientService
                .findByNameWithPagination(PatientEntity.class, maxResults,
                        pageNumber, searchParams, searchString), patientsCount));
    }

    /**
     * Patient delete get.
     *
     * @param locale    the locale
     * @param model     the model
     * @param patientID the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientID}/delete", method = RequestMethod.GET)
    public String patientDeleteGET(Locale locale, Model model,
                                   @PathVariable("patientID") Integer patientID, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        patientService.delete(patientService.findByID(PatientEntity.class,
                patientID));
        return "redirect:/patient/list";
    }

    /**
     * Patient edit get.
     *
     * @param locale the locale
     * @param model  the model
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/edit", method = RequestMethod.GET)
    public String patientEditGET(Locale locale, Model model,
                                 @PathVariable("patientId") Integer patientId, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient",
                patientService.getPatientByIdWithDoctor(patientId));
        model.addAttribute("doctors", roleService.getAllDoctors());
        return "patient/editView";
    }

    /**
     * Patient edit post.
     *
     * @param locale  the locale
     * @param model   the model
     * @param patient the patient
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/edit", method = RequestMethod.POST)
    public String patientEditPOST(Locale locale, Model model,
                                  @Valid @ModelAttribute("patient") PatientEntity patient,
                                  BindingResult result, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        if (result.hasErrors()) {
            model.addAttribute("doctors", roleService.getAllDoctors());
            return "patient/editView";
        } else {
            Authentication auth = SecurityContextHolder.getContext()
                    .getAuthentication();
            List<RoleEntity> roles = userService.findUserByUsername(auth.getName()).getRoles();
            boolean isSuperdoctor = false;
            for (RoleEntity r : roles) {
                if (r.getAuthority().equals("ROLE_SUPER_DOCTOR"))
                    isSuperdoctor = true;
            }
            if (!isSuperdoctor)
                patient.setVerified(false);
            patientService.save(patient);
            return "redirect:/patient/" + /* Integer.toString( */patient.getId()/* ) */
                    + "/overview";
        }
    }

    /**
     * Patient export get.
     *
     * @param locale    the locale
     * @param model     the model
     * @param patientID the patient id
     * @return the string
     */

    @RequestMapping(value = "/patient/{patientID}/export", method = RequestMethod.GET)
    public String patientExportGET(Locale locale, Model model,
                                   @PathVariable("patientID") Integer patientID, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
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
            //@RequestParam("toTable") boolean toTable,
            @RequestParam("exportType") String exportType, Locale locale, boolean anonymize,
            Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        logger.setLogger(PatientController.class);

        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();

 /*
         * TODO
         * FOR TESTING PURPOSES ONLY ! DELETE AFTER TESTING
         */
        boolean toTable = false;

        exportParams.setPatient(true);
        exportParams.setPatientBirthday(true);
        exportParams.setContactFirstName(true);
        exportParams.setContactLastName(true);
        exportParams.setPatientNin(true);
        exportParams.setPatientGender(true);
        exportParams.setContactCountry(true);
        exportParams.setContactAddressStreet(true);
        exportParams.setContactAddressHn(true);
        exportParams.setContactAddressCity(true);
        exportParams.setContactPhoneNumber(true);
        exportParams.setContactEmail(true);
        exportParams.setPatientAgeAtTheBeginningOfEpilepsy(true);
        exportParams.setPatientDoctorId(true);


        exportParams.setSeizure(true);
        exportParams.setSeizureAdded(true);
        exportParams.setSeizureAddUserId(true);
        exportParams.setSeizureComment(true);
        exportParams.setSeizureDate(true);
        exportParams.setSeizureDetailComment(true);
        exportParams.setSeizureDoctorId(true);
        exportParams.setSeizureFrequency(true);
        exportParams.setSeizureDetailComment(true);
        exportParams.setSeizureDetailILAEClassification(true);
        exportParams.setSeizureDetailSSCClassification(true);
        exportParams.setSeizureSecondarilyGeneralizedSeizure(true);
        exportParams.setSeizureSeizuresWhileAwakeEpi(true);
        exportParams.setSeizureSeizuresWhileAwakeLatent(true);
        exportParams.setSeizureSeizuresWhileAwakeNonEpi(true);
        exportParams.setSeizureSeizuresWhileSleepEpi(true);
        exportParams.setSeizureSeizuresWhileSleepLatent(true);
        exportParams.setSeizureSeizuresWhileSleepNonEpi(true);

        exportParams.setPharmacotherapy(true);
        exportParams.setPharmacotherapyDuringSurgery(true);
        exportParams.setPharmacotherapyEffective(true);
        exportParams.setPharmacotherapyComment(true);
        exportParams.setPharmacotherapyAED(true);

        exportParams.setNeurologicalFinding(true);
        exportParams.setNeurologicalFindingAbnormalNeurologicalFinding(true);
        exportParams.setNeurologicalFindingAdded(true);
        exportParams.setNeurologicalFindingAddUserId(true);
        exportParams.setNeurologicalFindingComment(true);
        exportParams.setNeurologicalFindingDate(true);
        exportParams.setNeurologicalFindingDoctorId(true);
        exportParams.setNeurologicalFindingHemiparesis(true);
        exportParams.setNeurologicalFindingHemisphereDominance(true);
        exportParams.setNeurologicalFindingId(true);
        exportParams.setNeurologicalFindingVisualFieldDefects(true);

        exportParams.setNeuropsychology(true);
        exportParams.setNeuropsychologyAdded(true);
        exportParams.setNeuropsychologyAddUserId(true);
        exportParams.setNeuropsychologyComment(true);
        exportParams.setNeuropsychologyDate(true);
        exportParams.setNeuropsychologyDoctorId(true);
        exportParams.setNeuropsychologyEmotionalStatus(true);
        exportParams.setNeuropsychologyFindingDetail(true);
        exportParams.setNeuropsychologyId(true);
        exportParams.setNeuropsychologyIntellect(true);
        exportParams.setNeuropsychologyIntellectualPerformance(true);
        exportParams.setNeuropsychologyIntellectualPerformanceNonverbalDesignCap(true);
        exportParams.setNeuropsychologyIntellectualPerformanceNonverbalAbstraction(true);
        exportParams.setNeuropsychologyIntellectualPerformanceVerbally(true);
        exportParams.setNeuropsychologyEmotionalStatus(true);
        exportParams.setNeuropsychologyNeurodevelopmentalExamination(true);
        exportParams.setNeuropsychologyNeurodevelopmentalExaminationAdaptability(true);
        exportParams.setNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills(true);
        exportParams.setNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills(true);
        exportParams.setNeuropsychologyNeuropsychologicalProfileAttention(true);
        exportParams.setNeuropsychologyNeurodevelopmentalExaminationSocialBehavior(true);
        exportParams.setNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively(true);
        exportParams.setNeuropsychologyNeuropsychologicalProfileCognitiveSpeed(true);
        exportParams.setNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively(true);
        exportParams.setNeuropsychologyNeurodevelopmentalExaminationAdaptability(true);
        exportParams.setNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity(true);
        exportParams.setNeuropsychologyPresenceOfChangesDetail(true);
        exportParams.setNeuropsychologyPatientId(true);
        exportParams.setNeuropsychologyNeuropsychologicalProfile(true);
        exportParams.setNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding(true);
        exportParams.setNeuropsychologyNeuropsychologicalProfilePerceptionVisual(true);
        exportParams.setNeuropsychologyNeuropsychologicalProfileMotorCoordination(true);
        exportParams.setNeuropsychologyNeuropsychologicalProfileMemoryOperating(true);
        exportParams.setNeuropsychologyNeuropsychologicalProfileMemoryVerbal(true);
        exportParams.setNeuropsychologyNeuropsychologicalProfileMemoryNonverbal(true);
        exportParams.setNeuropsychologyNeuropsychologicalProfileMemoryLearning(true);

        exportParams.setNeuropsychologyOld(true);
        exportParams.setNeuropsychologyOldAdded(true);
        exportParams.setNeuropsychologyOldAddUserId(true);
        exportParams.setNeuropsychologyOldAdhdSyndrome(true);
        exportParams.setNeuropsychologyOldComment(true);
        exportParams.setNeuropsychologyOldDate(true);
        exportParams.setNeuropsychologyOldDevelopmentalLanguageDisorders(true);
        exportParams.setNeuropsychologyOldDoctorId(true);
        exportParams.setNeuropsychologyOldIntelligenceLevel(true);
        exportParams.setNeuropsychologyOldNeuropsychologicalExamination(true);
        exportParams.setNeuropsychologyOldSpecificLearning(true);
        exportParams.setNeuropsychologyOldIntelligenceLevel(true);

        exportParams.setDiagnosticTestEEG(true);
        exportParams.setDiagnosticTestEEGBasicActivity(true);
        exportParams.setDiagnosticTestEEGComment(true);
        exportParams.setDiagnosticTestEEGDate(true);
        exportParams.setDiagnosticTestEEGDoctorId(true);
        exportParams.setDiagnosticTestEEGDone(true);
        exportParams.setDiagnosticTestEEGIctalEEGPatterns(true);
        exportParams.setDiagnosticTestEEGInterictalEEGSpikes(true);
        exportParams.setDiagnosticTestEEGDescriptionVideoEEG(true);
        exportParams.setDiagnosticTestEEGLocalizationIctalEEGPattern(true);
        exportParams.setDiagnosticTestEEGLocalizationInerictalEEGSpikes(true);
        exportParams.setDiagnosticTestEEGBasicActivity(true);
        exportParams.setDiagnosticTestEEGSecondarySidedSynchrony(true);
        exportParams.setDiagnosticTestEEGSlow(true);
        exportParams.setDiagnosticTestEEGStatusEpilepticus(true);

        exportParams.setDiagnosticTestMRI(true);
        exportParams.setDiagnosticTestMRIDate(true);
        exportParams.setDiagnosticTestMRIDescribe(true);
        exportParams.setDiagnosticTestMRIComment(true);
        exportParams.setDiagnosticTestMRIDescription(true);
        exportParams.setDiagnosticTestMRIDescriptionMrsAbnormality(true);
        exportParams.setDiagnosticTestMRIDescriptionPetHypometabolism(true);
        exportParams.setDiagnosticTestMRIDescriptionSpectHyperperfuse(true);
        exportParams.setDiagnosticTestMRIDescriptionSpectHypoperfuse(true);
        exportParams.setdiagnosticTestMRILocalizationPetHypometabolism(true);
        exportParams.setdiagnosticTestMRIInterictalSpect(true);
        exportParams.setDiagnosticTestMRIWada(true);
        exportParams.setDiagnosticTestMRISiscom(true);
        exportParams.setDiagnosticTestMRIProtocol(true);
        exportParams.setDiagnosticTestMRIPatientId(true);
        exportParams.setDiagnosticTestMRIMrsProtocol(true);
        exportParams.setDiagnosticTestMRIMrsFinding(true);
        exportParams.setdiagnosticTestMRILocalizationPetHypometabolism(true);
        exportParams.setdiagnosticTestMRIInterictalSpect(true);
        exportParams.setDiagnosticTestMRIWada(true);
        exportParams.setDiagnosticTestMRISiscom(true);
        exportParams.setDiagnosticTestMRIProtocol(true);
        exportParams.setDiagnosticTestMRILocalizationSpecHypoperfuse(true);
        exportParams.setdiagnosticTestMRILocalizationPetHypometabolism(true);
        exportParams.setDiagnosticTestMRIMrsProtocol(true);
        exportParams.setDiagnosticTestMRIPatientId(true);
        exportParams.setdiagnosticTestMRIInterictalSpect(true);

        // Find out, if data should be anonymized or not
        boolean shallAnonymize = true;

        UserEntity user = userService.findUserByUsername(auth.getName());
        List<RoleEntity> listOfAssignedRoles = user.getRoles();

        boolean approved = false;
        for (RoleEntity assignedRole : listOfAssignedRoles) {
            if (assignedRole.getAuthority().equals("ROLE_SUPER_DOCTOR") || assignedRole.getAuthority().equals("ROLE_DOCTOR")) {
                approved = true;
                break;
            }
        }

        if (!anonymize & approved) {
            shallAnonymize = false;
        }

        List<PatientEntity> patientList = new ArrayList<PatientEntity>();
        for (Integer patient : patientID) {
            patientList.add(patientService.getPatientByIdWithAllLists(patient));
        }
        if (exportType.equals("pdf")) {
            try {
                String url = exportToPdfService.export(patientList,
                        userService.findUserByUsername(auth.getName()), locale,
                        exportParams, shallAnonymize, toTable);
                return "redirect:/resources/downloads/" + url;
            } catch (FileNotFoundException e) {
                logger.logError(
                        "File wasn't found when trying to export to pdf.", e);
            }
        } else if (exportType.equals("xlsx")) {
            String url = exportToXlsxService.export(patientList,
                    userService.findUserByUsername(auth.getName()), locale,
                    exportParams, shallAnonymize);
            return "redirect:/resources/downloads/" + url;
        } else if (exportType.equals("docx")) {
            String url = exportToDocxService.export(patientList,
                    userService.findUserByUsername(auth.getName()), locale,
                    exportParams, shallAnonymize, toTable);
            return "redirect:/resources/downloads/" + url;
        } else if (exportType.equals("txt")) {
            String url = exportToTxtService.export(patientList,
                    userService.findUserByUsername(auth.getName()), locale,
                    exportParams, shallAnonymize);
            return "redirect:/resources/downloads/" + url;
        } else if (exportType.equals("csv")) {
            String url = exportToCsvService.export(patientList,
                    userService.findUserByUsername(auth.getName()), locale,
                    exportParams, shallAnonymize);
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
            Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
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
                                        @RequestParam("exportId") Integer exportID, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
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
            @RequestParam("exportId") Integer exportId, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        exportParamsService.delete(exportParamsService.findByID(
                ExportParamsEntity.class, exportId));
        return "redirect:/patient/" + patientId[0] + "/export";
    }
}