package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.DiagnosticTestScalpEegVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestScalpEegService;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEegEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes({"diagnosticTestScalpEeg"})
public class DiagnosticTestScalpEegController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private DiagnosticTestScalpEegService diagnosticTestScalpEegService;

    @Autowired
    public DiagnosticTestScalpEegController(PatientService patientService,
                                            DiagnosticTestScalpEegService diagnosticTestScalpEegService) {

        this.patientService = patientService;
        this.diagnosticTestScalpEegService = diagnosticTestScalpEegService;
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/create", method = RequestMethod.GET)
    public String diagnosticTestScalpEegCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("diagnosticTestScalpEeg", new DiagnosticTestScalpEegVO());
        return "patient/diagnosticTestScalpEeg/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/{diagnosticTestScalpEegId}/edit", method = RequestMethod.GET)
    public String diagnosticTestScalpEegEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("diagnosticTestScalpEegId") int diagnosticTestScalpEegId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("diagnosticTestScalpEeg", diagnosticTestScalpEegService.getById(diagnosticTestScalpEegId, DiagnosticTestScalpEegVO.class, DiagnosticTestScalpEegEntity.class));
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
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), diagnosticTestScalpEeg.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/diagnosticTestScalpEeg/formView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            diagnosticTestScalpEegService.save(diagnosticTestScalpEeg, DiagnosticTestScalpEegEntity.class);
            return "redirect:/patient/" + patientId + "/diagnostic-test-scalp-eeg/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/{diagnosticTestScalpEegId}/delete", method = RequestMethod.GET)
    public String diagnosticTestScalpEegDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("diagnosticTestScalpEegId") int diagnosticTestScalpEegId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        diagnosticTestScalpEegService.delete(diagnosticTestScalpEegId, DiagnosticTestScalpEegEntity.class);
        return "redirect:/patient/" + patientId + "/diagnostic-test-scalp-eeg/list";
    }

    /**
     * Handles the GET request to hide diagnosticTestScalpEeg.
     *
     * @param patientId the id of a patient whom we are creating an
     *                  diagnosticTestScalpEeg.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/{diagnosticTestScalpEegId}/hide", method = RequestMethod.GET)
    public String diagnosticTestScalpEegHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("diagnosticTestScalpEegId") int diagnosticTestScalpEegId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        diagnosticTestScalpEegService.hide(diagnosticTestScalpEegId, DiagnosticTestScalpEegEntity.class);
        return "redirect:/patient/" + patientId + "/diagnostic-test-scalp-eeg/list";
    }

    /**
     * Handles the GET request to unhide diagnosticTestScalpEeg.
     *
     * @param patientId the id of a patient whom we are creating an
     *                  diagnosticTestScalpEeg.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/{diagnosticTestScalpEegId}/unhide", method = RequestMethod.GET)
    public String diagnosticTestScalpEegUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        diagnosticTestScalpEegService.unhide(diagnosticTestScalpEegId, DiagnosticTestScalpEegEntity.class);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/diagnostic-testScalp-eeg/list";
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/list", method = RequestMethod.GET)
    public String diagnosticTestScalpEegListGET(
            @PathVariable("patientId") Integer patientId, Model model, HttpServletRequest request) {

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
