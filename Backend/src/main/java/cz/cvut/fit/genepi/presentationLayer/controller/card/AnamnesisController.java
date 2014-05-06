package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.card.AnamnesisDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.AnamnesisFormBO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.AnamnesisService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * This class is a controller class which handles requests connected with
 * anamnesis.
 */
@Controller
@SessionAttributes({"anamnesis", "patient"})
public class AnamnesisController {

    private final GenericCardService<AnamnesisDisplayBO, AnamnesisFormBO, AnamnesisEntity> genericCardService;

    private final AuthorizationChecker authorizationChecker;

    /**
     * The patient service.
     */
    private final PatientService patientService;

    /**
     * The anamnesis service.
     */
    private final AnamnesisService anamnesisService;

    /**
     * Constructor which serves to autowire services.
     *
     * @param patientService   the patientService to be autowired.
     * @param anamnesisService the anamnesisService to be autowired.
     */
    @Autowired
    public AnamnesisController(AuthorizationChecker authorizationChecker,
                               PatientService patientService,
                               AnamnesisService anamnesisService,
                               @Qualifier("genericCardServiceImpl")
                               GenericCardService<AnamnesisDisplayBO, AnamnesisFormBO, AnamnesisEntity> genericCardService) {

        this.genericCardService = genericCardService;
        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.anamnesisService = anamnesisService;
    }

    /**
     * Handles the GET request to access page for creating new anamnesis.
     *
     * @param patientId the id of a patient whom we are creating an anamnesis.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/create", method = RequestMethod.GET)
    public String anamnesisCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        PatientDisplayBO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        AnamnesisDisplayBO anamnesisDisplayBO = anamnesisService.getRecordsByPatientId(patientId);

        model.addAttribute("patient", patient);

        if (anamnesisDisplayBO == null) {
            model.addAttribute("dateBeforeBirth", false);
            model.addAttribute("anamnesis", new AnamnesisFormBO());
            return "patient/anamnesis/createView";
        } else {
            return "redirect:/patient/" + patientId + "/anamnesis/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/anamnesis/create", method = RequestMethod.POST)
    public String anamnesisCreatePOST(
            @ModelAttribute("anamnesis") @Valid AnamnesisFormBO anamnesis, BindingResult result,
            @ModelAttribute("patient") PatientDisplayBO patientDisplayBO,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayBO.getBirthday(), anamnesis.getDate());
            if (result.hasErrors() || dateNotOk) {

                model.addAttribute("dateBeforeBirth", dateNotOk);

                return "patient/anamnesis/createView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                if (anamnesisService.getRecordsByPatientId(patientId) == null) {
                    genericCardService.save(anamnesis, AnamnesisEntity.class);
                }
                return "redirect:/patient/" + patientId + "/anamnesis/list";
            }
        }
    }

    /**
     * Handles the GET request to access page for editing anamnesis.
     *
     * @param patientId the id of a patient whom we are editing an anamnesis.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/{anamnesisId}/edit", method = RequestMethod.GET)
    public String anamnesisEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("anamnesisId") Integer anamnesisId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("anamnesis", genericCardService.getById(anamnesisId, AnamnesisFormBO.class, AnamnesisEntity.class));
        return "patient/anamnesis/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/anamnesis/{anamnesisId}/edit", method = RequestMethod.POST)
    public String anamnesisEditPOST(
            @ModelAttribute("anamnesis") @Valid AnamnesisFormBO anamnesis, BindingResult result,
            @ModelAttribute("patient") PatientDisplayBO patientDisplayBO,
            @PathVariable("patientId") int patientId,
            @PathVariable("anamnesisId") Integer anamnesisId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayBO.getBirthday(), anamnesis.getDate());
            if (result.hasErrors() || dateNotOk) {

                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/anamnesis/editView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.makeHistory(anamnesisId, AnamnesisEntity.class);
                anamnesis.setId(0);
                genericCardService.save(anamnesis, AnamnesisEntity.class);
                return "redirect:/patient/" + patientId + "/anamnesis/list";
            }
        }
    }

    /**
     * Handles the GET request to access page for listing anamnesis.
     *
     * @param patientId the id of a patient whose anamnesis we are listing.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/list", method = RequestMethod.GET)
    public String anamnesisListGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayBO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        AnamnesisDisplayBO anamnesisDisplayBO = anamnesisService.getRecordsByPatientId(patientId);

        model.addAttribute("anamnesisDisplayBO", anamnesisDisplayBO);
        model.addAttribute("patient", patient);
        return "patient/anamnesis/listView";
    }
}
