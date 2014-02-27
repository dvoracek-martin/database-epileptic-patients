package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.DiagnosticTestMriVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestMriService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestMriEntity;
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
@SessionAttributes({"diagnosticTestMri"})
public class DiagnosticTestMriController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private DiagnosticTestMriService diagnosticTestMriService;

    private UserService userService;

    @Autowired
    public DiagnosticTestMriController(PatientService patientService,
                                       DiagnosticTestMriService diagnosticTestMriService) {
        this.patientService = patientService;
        this.diagnosticTestMriService = diagnosticTestMriService;
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-mri/create", method = RequestMethod.GET)
    public String diagnosticTestMriCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("diagnosticTestMri", new DiagnosticTestMriVO());
        return "patient/diagnosticTestMri/formView";
    }


    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-mri/{diagnosticTestMriId}/edit", method = RequestMethod.GET)
    public String diagnosticTestMriEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestMriId") Integer diagnosticTestMriId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("diagnosticTestMri", diagnosticTestMriService.getById(DiagnosticTestMriVO.class, DiagnosticTestMriEntity.class, diagnosticTestMriId));
        return "patient/diagnosticTestMri/formView";
    }

    /**
     * Adds the diagnosticTestMRI.
     *
     * @param result the result
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-mri/save", method = RequestMethod.POST)
    public String diagnosticTestMriSavePOST(
            @ModelAttribute("diagnosticTestMri") @Valid DiagnosticTestMriVO diagnosticTestMri, BindingResult result,
            @PathVariable("patientId") Integer patientId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), diagnosticTestMri.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/diagnosticTestMri/formView";
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
            diagnosticTestMri.setPatientId(patientId);
            diagnosticTestMriService.save(DiagnosticTestMriEntity.class, diagnosticTestMri);
            return "redirect:/patient/" + patientId + "/diagnostic-test-mri/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-mri/{diagnosticTestMriId}/delete", method = RequestMethod.GET)
    public String diagnosticTestMriDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestMriId") Integer diagnosticTestMriId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        diagnosticTestMriService.delete(DiagnosticTestMriEntity.class, diagnosticTestMriId);
        return "redirect:/patient/" + patientId + "/diagnosticTestMri/list";
    }

    /**
     * Handles the GET request to hide diagnosticTestMri.
     *
     * @param patientId the id of a patient whom we are creating an diagnosticTestMri.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-mri/{diagnosticTestMriId}/hide", method = RequestMethod.GET)
    public String diagnosticTestMriHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestMriId") Integer diagnosticTestMriId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        diagnosticTestMriService.hide(diagnosticTestMriId);
        return "redirect:/patient/" + patientId + "/diagnostic-test-mri/list";
    }

    /**
     * Handles the GET request to unhide diagnosticTestMri.
     *
     * @param patientId the id of a patient whom we are creating an diagnosticTestMri.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-mri/{diagnosticTestMriId}/unhide", method = RequestMethod.GET)
    public String diagnosticTestMriUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestMriId") Integer diagnosticTestMriId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        diagnosticTestMriService.unhide(diagnosticTestMriId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/diagnosticTestMri/list";
    }

    /*@RequestMapping(value = "/patient/{patientID}/diagnostic-test-mri/{diagnosticTestMRIID}/export", method = RequestMethod.GET)
    public String diagnosticTestMRIExportGET(Locale locale, Model model,
                                             @PathVariable("patientID") Integer patientID,
                                             @PathVariable("diagnosticTestMRIID") Integer diagnosticTestMRIID) {
        return "redirect:/patient/" + patientID + "/diagnosticTestMRI/list";
    }*/

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-mri/list", method = RequestMethod.GET)
    public String diagnosticTestMriListGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDiagnosticTestMriList(patientId);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/diagnosticTestMri/listView";
    }
}