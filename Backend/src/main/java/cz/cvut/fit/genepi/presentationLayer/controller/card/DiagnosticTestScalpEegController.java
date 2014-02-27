package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.DiagnosticTestScalpEegVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestScalpEegService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEegEntity;
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
@SessionAttributes({"diagnosticTestScalpEeg"})
public class DiagnosticTestScalpEegController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private DiagnosticTestScalpEegService diagnosticTestScalpEegService;

    private UserService userService;

    @Autowired
    public DiagnosticTestScalpEegController(PatientService patientService,
                                            DiagnosticTestScalpEegService diagnosticTestScalpEegService) {

        this.patientService = patientService;
        this.diagnosticTestScalpEegService = diagnosticTestScalpEegService;
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/create", method = RequestMethod.GET)
    public String diagnosticTestScalpEegCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("diagnosticTestScalpEeg", new DiagnosticTestScalpEegVO());
        return "patient/diagnosticTestScalpEeg/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/{diagnosticTestScalpEegId}/edit", method = RequestMethod.GET)
    public String diagnosticTestScalpEegEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("diagnosticTestScalpEeg", diagnosticTestScalpEegService.getById(DiagnosticTestScalpEegVO.class, DiagnosticTestScalpEegEntity.class, diagnosticTestScalpEegId));
        return "patient/diagnosticTestScalpEeg/formView";
    }

    /**
     * Adds the diagnosticTestScalpEEG.
     *
     * @param result the result
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/save", method = RequestMethod.POST)
    public String diagnosticTestScalpEegSavePOST(
            @ModelAttribute("diagnosticTestScalpEeg") @Valid DiagnosticTestScalpEegVO diagnosticTestScalpEeg, BindingResult result,
            @PathVariable("patientId") Integer patientId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), diagnosticTestScalpEeg.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/diagnosticTestScalpEeg/formView";
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
            diagnosticTestScalpEeg.setPatientId(patientId);
            diagnosticTestScalpEegService.save(DiagnosticTestScalpEegEntity.class, diagnosticTestScalpEeg);
            return "redirect:/patient/" + patientId + "/diagnostic-test-scalp-eeg/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/{diagnosticTestScalpEegId}/delete", method = RequestMethod.GET)
    public String diagnosticTestScalpEegDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        diagnosticTestScalpEegService.delete(DiagnosticTestScalpEegEntity.class, diagnosticTestScalpEegId);
        return "redirect:/patient/" + patientId + "/diagnostic-test-scalp-eeg/list";
    }

    /**
     * Handles the GET request to hide diagnosticTestScalpEeg.
     *
     * @param patientId the id of a patient whom we are creating an
     *                  diagnosticTestScalpEeg.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/{diagnosticTestScalpEegId}/hide", method = RequestMethod.GET)
    public String diagnosticTestScalpEegHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
            Locale locale, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        diagnosticTestScalpEegService.hide(diagnosticTestScalpEegId);
        return "redirect:/patient/" + patientId + "/diagnostic-test-scalp-eeg/list";
    }

    /**
     * Handles the GET request to unhide diagnosticTestScalpEeg.
     *
     * @param patientId the id of a patient whom we are creating an
     *                  diagnosticTestScalpEeg.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/{diagnosticTestScalpEegId}/unhide", method = RequestMethod.GET)
    public String diagnosticTestScalpEegUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        diagnosticTestScalpEegService.unhide(diagnosticTestScalpEegId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/diagnostic-testScalp-eeg/list";
    }

    /*@RequestMapping(value = "/patient/{patientID}/diagnosticTestScalpEEG/{diagnosticTestScalpEEGID}/export", method = RequestMethod.GET)
    public String diagnosticTestScalpEEGExportGET(Locale locale, Model model,
                                                  @PathVariable("patientID") Integer patientID,
                                                  @PathVariable("diagnosticTestScalpEEGID") Integer diagnosticTestScalpEEGID) {
        return "redirect:/patient/" + patientID + "/diagnosticTestScalpEEG/list";
    }*/

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/list", method = RequestMethod.GET)
    public String diagnosticTestScalpEegListGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDiagnosticTestScalpEegList(patientId);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/diagnosticTestScalpEeg/listView";
    }
}