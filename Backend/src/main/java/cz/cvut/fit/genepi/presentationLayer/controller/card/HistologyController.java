package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.HistologyVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.businessLayer.service.card.HistologyService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;
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
@SessionAttributes({"histology"})
public class HistologyController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private HistologyService histologyService;

    private UserService userService;

    @Autowired
    public HistologyController(PatientService patientService,
                               HistologyService histologyService) {

        this.patientService = patientService;
        this.histologyService = histologyService;
    }

    @RequestMapping(value = "/patient/{patientId}/histology/create", method = RequestMethod.GET)
    public String histologyCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("histology", new HistologyVO());
        return "patient/histology/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("histologyId") Integer histologyId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("histology", histologyService.getById(HistologyVO.class, HistologyEntity.class, histologyId));
        return "patient/histology/formView";
    }

    /**
     * Adds the histology.
     *
     * @param histology the histology
     * @param result    the result
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/histology/save", method = RequestMethod.POST)
    public String histologySavePOST(
            @ModelAttribute("histology") @Valid HistologyVO histology, BindingResult result,
            @PathVariable("patientId") Integer patientId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), histology.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/histology/formView";
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
            histology.setPatientId(patientId);
            histologyService.save(HistologyEntity.class, histology);
            return "redirect:/patient/" + patientId + "/histology/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/delete", method = RequestMethod.GET)
    public String histologyDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("histologyId") Integer histologyId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        histologyService.delete(HistologyEntity.class, histologyId);
        return "redirect:/patient/" + patientId + "/histology/list";
    }

    /**
     * Handles the GET request to hide histology.
     *
     * @param patientId the id of a patient whom we are creating an histology.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/hide", method = RequestMethod.GET)
    public String histologyHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("histologyId") Integer histologyId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        histologyService.hide(histologyId);
        return "redirect:/patient/" + patientId + "/histology/list";
    }

    /**
     * Handles the GET request to unhide histology.
     *
     * @param patientId the id of a patient whom we are creating an histology.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/unhide", method = RequestMethod.GET)
    public String histologyUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("histologyId") Integer histologyId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        histologyService.unhide(histologyId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/histology/list";
    }

    /*@RequestMapping(value = "/patient/{patientID}/histology/{histologyID}/export", method = RequestMethod.GET)
    public String histologyExportGET(Locale locale, Model model,
                                     @PathVariable("patientID") Integer patientID,
                                     @PathVariable("histologyID") Integer histologyID) {
        return "redirect:/patient/" + patientID + "/histology/list";
    }*/

    @RequestMapping(value = "/patient/{patientId}/histology/list", method = RequestMethod.GET)
    public String histologyListGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithHistologyList(patientId);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/histology/listView";
    }
}
