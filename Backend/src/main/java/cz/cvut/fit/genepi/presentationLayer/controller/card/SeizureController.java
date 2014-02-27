package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.SeizureVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureDetailService;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes({"seizure"})
public class SeizureController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private SeizureService seizureService;

    private SeizureDetailService seizureDetailService;

    private UserService userService;

    @Autowired
    public SeizureController(PatientService patientService,
                             SeizureService seizureService, SeizureDetailService seizureDetailService) {
        this.patientService = patientService;
        this.seizureService = seizureService;
        this.seizureDetailService = seizureDetailService;
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/create", method = RequestMethod.GET)
    public String seizureCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizure", new SeizureVO());
        return "patient/seizure/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/edit", method = RequestMethod.GET)
    public String seizureEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureId") Integer seizureId, Locale locale,
            Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizure", seizureService.getById(SeizureVO.class, SeizureEntity.class, seizureId));

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
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), seizure.getDate())
                || patientService.getPatientByIdWithAnamnesisList(patientId).getAnamnesisList().size() ==0 ||
                TimeConverter.compareDates(patientService.getPatientByIdWithAnamnesisList(patientId).getAnamnesisList().get(0).getBeginningEpilepsy(), seizure.getDate())) {
            model.addAttribute("patient", patientService.getPatientByIdWithDoctor(patientId));
            return "patient/seizure/formView";
        } else {
            seizure.setPatientId(patientId);
            Authentication auth = SecurityContextHolder.getContext()
                    .getAuthentication();
            List<GrantedAuthority> roles = (List<GrantedAuthority>) auth.getAuthorities();
            boolean isSuperdoctor = false;
            for (GrantedAuthority r : roles) {
                if (r.getAuthority().equals("ROLE_SUPER_DOCTOR")) {
                    isSuperdoctor = true;
                    break;
                }
            }
            if (!isSuperdoctor)
                patientService.findByID(PatientEntity.class, patientId).setVerified(false);
            seizureService.save(SeizureEntity.class, seizure);
            return "redirect:/patient/" + patientId + "/seizure/list";
        }
    }

    @RequestMapping(value = "/patient/{patientID}/seizure/{seizureID}/delete", method = RequestMethod.GET)
    public String seizureDeleteGET(Locale locale, Model model,
                                   @PathVariable("patientID") Integer patientID,
                                   @PathVariable("seizureID") Integer seizureID, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        /*seizureService.delete(seizureService.findByID(SeizureEntity.class,
                seizureID));*/
        return "redirect:/patient/" + patientID + "/seizure/list";
    }

    /**
     * Handles the GET request to hide seizure.
     *
     * @param patientId the id of a patient whom we are creating an seizure.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/hide", method = RequestMethod.GET)
    public String seizureDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureId") Integer seizureId, Locale locale,
            Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        seizureService.hide(seizureId);
        return "redirect:/patient/" + patientId + "/seizure/list";
    }

    /**
     * Handles the GET request to unhide seizure.
     *
     * @param patientId the id of a patient whom we are creating an seizure.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/unhide", method = RequestMethod.GET)
    public String seizureUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureId") Integer seizureId, Locale locale,
            Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        seizureService.unhide(seizureId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/seizure/list";
    }

    @RequestMapping(value = "/patient/{patientID}/seizure/{seizureID}/export", method = RequestMethod.GET)
    public String seizureExportGET(Locale locale, Model model,
                                   @PathVariable("patientID") Integer patientID,
                                   @PathVariable("seizureID") Integer seizureID, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        return "redirect:/patient/" + patientID + "/seizure/list";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/list", method = RequestMethod.GET)
    public String seizureListGET(Locale locale, Model model,
                                 @PathVariable("patientId") Integer patientId, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService
                .getPatientDisplayByIdWithSeizureList(patientId);
        model.addAttribute("patient", patient);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
       /* PatientEntity patient = patientService
                .getPatientByIdWithSeizureList(patientID);
        model.addAttribute("patient", patient);*/
        return "patient/seizure/listView";
    }
}
