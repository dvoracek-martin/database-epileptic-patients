package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.AnamnesisDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.AnamnesisVO;
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

    private GenericCardService<AnamnesisDisplayVO, AnamnesisVO, AnamnesisEntity> genericCardService;

    private AuthorizationChecker authorizationChecker;

    /**
     * The patient service.
     */
    private PatientService patientService;

    /**
     * The anamnesis service.
     */
    private AnamnesisService anamnesisService;

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
                               GenericCardService<AnamnesisDisplayVO, AnamnesisVO, AnamnesisEntity> genericCardService) {

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

        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        AnamnesisDisplayVO anamnesisDisplayVo = anamnesisService.getRecordsByPatientId(patientId);

        model.addAttribute("patient", patient);

        if (anamnesisDisplayVo == null) {
            model.addAttribute("dateBeforeBirth", false);
            model.addAttribute("anamnesis", new AnamnesisVO());
            return "patient/anamnesis/createView";
        } else {
            return "redirect:/patient/" + patientId + "/anamnesis/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/anamnesis/create", method = RequestMethod.POST)
    public String anamnesisCreatePOST(
            @ModelAttribute("anamnesis") @Valid AnamnesisVO anamnesis, BindingResult result,
            @ModelAttribute("patient") PatientDisplayVO patientDisplayVo,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayVo.getBirthday(), anamnesis.getDate());
            if (result.hasErrors() || dateNotOk) {

                model.addAttribute("dateBeforeBirth", dateNotOk);

                return "patient/anamnesis/createView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.save(anamnesis, AnamnesisEntity.class);
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
        model.addAttribute("anamnesis", genericCardService.getById(anamnesisId, AnamnesisVO.class, AnamnesisEntity.class));
        return "patient/anamnesis/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/anamnesis/{anamnesisId}/edit", method = RequestMethod.POST)
    public String anamnesisEditPOST(
            @ModelAttribute("anamnesis") @Valid AnamnesisVO anamnesis, BindingResult result,
            @ModelAttribute("patient") PatientDisplayVO patientDisplayVo,
            @PathVariable("patientId") int patientId,
            @PathVariable("anamnesisId") Integer anamnesisId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayVo.getBirthday(), anamnesis.getDate());
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
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        AnamnesisDisplayVO anamnesisDisplayVo = anamnesisService.getRecordsByPatientId(patientId);

        model.addAttribute("anamnesisDisplayVo", anamnesisDisplayVo);
//        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("patient", patient);
        return "patient/anamnesis/listView";
    }
}