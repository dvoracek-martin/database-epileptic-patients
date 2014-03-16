package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.SeizureVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes({"seizure"})
public class SeizureController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private SeizureService seizureService;

    @Autowired
    public SeizureController(PatientService patientService,
                             SeizureService seizureService) {
        this.patientService = patientService;
        this.seizureService = seizureService;
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/create", method = RequestMethod.GET)
    public String seizureCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizure", new SeizureVO());
        return "patient/seizure/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/edit", method = RequestMethod.GET)
    public String seizureEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizure", seizureService.getById(seizureId, SeizureVO.class, SeizureEntity.class));

        return "patient/seizure/formView";
    }

    /**
     * Adds the seizure.
     *
     * @param seizure the seizure
     * @param result  the result
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/seizure/save", method = RequestMethod.POST)
    public String seizureSavePOST(
            @ModelAttribute("seizure") @Valid SeizureVO seizure, BindingResult result,
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), seizure.getDate())
                || patientService.getPatientByIdWithAnamnesisList(patientId).getAnamnesisList().size() == 0 ||
                TimeConverter.compareDates(patientService.getPatientByIdWithAnamnesisList(patientId).getAnamnesisList().get(0).getBeginningEpilepsy(), seizure.getDate())) {
            model.addAttribute("patient", patientService.getPatientByIdWithDoctor(patientId));
            return "patient/seizure/formView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            seizureService.save(seizure, SeizureEntity.class);
            return "redirect:/patient/" + patientId + "/seizure/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/delete", method = RequestMethod.GET)
    public String seizureDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        seizureService.delete(seizureId, SeizureEntity.class);
        return "redirect:/patient/" + patientId + "/seizure/list";
    }

    /**
     * Handles the GET request to hide seizure.
     *
     * @param patientId the id of a patient whom we are creating an seizure.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/hide", method = RequestMethod.GET)
    public String seizureHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        seizureService.hide(seizureId, SeizureEntity.class);
        return "redirect:/patient/" + patientId + "/seizure/list";
    }

    /**
     * Handles the GET request to unhide seizure.
     *
     * @param patientId the id of a patient whom we are creating an seizure.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/unhide", method = RequestMethod.GET)
    public String seizureUnhideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        seizureService.unhide(seizureId, SeizureEntity.class);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/seizure/list";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/list", method = RequestMethod.GET)
    public String seizureListGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithSeizureList(patientId);
        model.addAttribute("patient", patient);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
       /* PatientEntity patient = patientService
                .getPatientByIdWithSeizureList(patientID);
        model.addAttribute("patient", patient);*/
        return "patient/seizure/listView";
    }
}
