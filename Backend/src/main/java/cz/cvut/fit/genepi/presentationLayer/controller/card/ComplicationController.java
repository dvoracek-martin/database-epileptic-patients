package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.ComplicationVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.businessLayer.service.card.ComplicationService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.ComplicationEntity;
import cz.cvut.fit.genepi.util.AuthorizationChecker;
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
@SessionAttributes({"complication"})
public class ComplicationController {

    private PatientService patientService;

    private ComplicationService complicationService;

    private UserService userService;

    @Autowired
    public ComplicationController(PatientService patientService,
                                  ComplicationService complicationService) {

        this.patientService = patientService;
        this.complicationService = complicationService;
    }

    @RequestMapping(value = "/patient/{patientId}/complication/create", method = RequestMethod.GET)
    public String complicationCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("complication", new ComplicationVO());
        return "patient/complication/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/complication/{complicationId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("complicationId") Integer complicationId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("complication", complicationService.getById(ComplicationVO.class, ComplicationEntity.class, complicationId));
        return "patient/complication/formView";
    }

    /**
     * Adds the complication.
     *
     * @param complication the complication
     * @param result       the result
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/complication/save", method = RequestMethod.POST)
    public String complicationSavePOST(
            @ModelAttribute("complication") @Valid ComplicationVO complication, BindingResult result,
            @PathVariable("patientId") Integer patientId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), complication.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/complication/formView";
        } else {
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
            complication.setPatientId(patientId);
            complicationService.save(ComplicationEntity.class, complication);
            return "redirect:/patient/" + patientId + "/complication/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/complication/{complicationId}/delete", method = RequestMethod.GET)
    public String complicationDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("complicationId") Integer complicationId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        complicationService.delete(ComplicationEntity.class, complicationId);
        return "redirect:/patient/" + patientId + "/complication/list";
    }

    /**
     * Handles the GET request to hide complication.
     *
     * @param patientId the id of a patient whom we are creating an complication.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/complication/{complicationId}/hide", method = RequestMethod.GET)
    public String complicationHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("complicationId") Integer complicationId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        complicationService.hide(complicationId);
        return "redirect:/patient/" + patientId + "/complication/list";
    }

    /**
     * Handles the GET request to unhide complication.
     *
     * @param patientId the id of a patient whom we are creating an complication.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/complication/{complicationId}/unhide", method = RequestMethod.GET)
    public String complicationUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("complicationId") Integer complicationId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        complicationService.unhide(complicationId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/complication/list";
    }

   /* @RequestMapping(value = "/patient/{patientID}/complication/{complicationID}/export", method = RequestMethod.GET)
    public String complicationExportGET(Locale locale, Model model,
                                        @PathVariable("patientID") Integer patientID,
                                        @PathVariable("complicationID") Integer complicationID) {

        return "redirect:/patient/" + patientID + "/complication/list";
    }*/

    @RequestMapping(value = "/patient/{patientId}/complication/list", method = RequestMethod.GET)
    public String complicationListGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithComplicationList(patientId);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/complication/listView";
    }
}
