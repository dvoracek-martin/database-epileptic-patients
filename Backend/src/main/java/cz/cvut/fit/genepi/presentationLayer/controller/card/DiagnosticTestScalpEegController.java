package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.card.DiagnosticTestScalpEegDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.DiagnosticTestScalpEegFormBO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEegEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"diagnosticTestScalpEeg", "patient"})
public class DiagnosticTestScalpEegController {

    private final AuthorizationChecker authorizationChecker;

    private final PatientService patientService;

    private final GenericCardService<DiagnosticTestScalpEegDisplayBO, DiagnosticTestScalpEegFormBO, DiagnosticTestScalpEegEntity> genericCardService;

    @Autowired
    public DiagnosticTestScalpEegController(AuthorizationChecker authorizationChecker,
                                            PatientService patientService,
                                            @Qualifier("genericCardServiceImpl")
                                            GenericCardService<DiagnosticTestScalpEegDisplayBO, DiagnosticTestScalpEegFormBO, DiagnosticTestScalpEegEntity> genericCardService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.genericCardService = genericCardService;
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/create", method = RequestMethod.GET)
    public String diagnosticTestScalpEegCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("diagnosticTestScalpEeg", new DiagnosticTestScalpEegFormBO());
        return "patient/diagnosticTestScalpEeg/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/create", method = RequestMethod.POST)
    public String diagnosticTestScalpEegCreatePOST(
            @ModelAttribute("diagnosticTestScalpEeg") @Valid DiagnosticTestScalpEegFormBO diagnosticTestScalpEeg, BindingResult result,
            @ModelAttribute("patient") PatientDisplayBO patientDisplayBO,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayBO.getBirthday(), diagnosticTestScalpEeg.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/diagnosticTestScalpEeg/createView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.save(diagnosticTestScalpEeg, DiagnosticTestScalpEegEntity.class);
                return "redirect:/patient/" + patientId + "/diagnostic-test-scalp-eeg/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/{diagnosticTestScalpEegId}/edit", method = RequestMethod.GET)
    public String diagnosticTestScalpEegEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("diagnosticTestScalpEegId") int diagnosticTestScalpEegId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("diagnosticTestScalpEeg", genericCardService.getById(diagnosticTestScalpEegId, DiagnosticTestScalpEegFormBO.class, DiagnosticTestScalpEegEntity.class));
        return "patient/diagnosticTestScalpEeg/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/{diagnosticTestScalpEegId}/edit", method = RequestMethod.POST)
    public String diagnosticTestScalpEegEditPOST(
            @ModelAttribute("diagnosticTestScalpEeg") @Valid DiagnosticTestScalpEegFormBO diagnosticTestScalpEeg, BindingResult result,
            @ModelAttribute("patient") PatientDisplayBO patientDisplayBO,
            @PathVariable("patientId") int patientId,
            @PathVariable("diagnosticTestScalpEegId") int diagnosticTestScalpEegId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayBO.getBirthday(), diagnosticTestScalpEeg.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/diagnosticTestScalpEeg/editView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.makeHistory(diagnosticTestScalpEegId, DiagnosticTestScalpEegEntity.class);
                diagnosticTestScalpEeg.setId(0);
                genericCardService.save(diagnosticTestScalpEeg, DiagnosticTestScalpEegEntity.class);
                return "redirect:/patient/" + patientId + "/diagnostic-test-scalp-eeg/list";
            }
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
        genericCardService.delete(diagnosticTestScalpEegId, DiagnosticTestScalpEegEntity.class);
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
        genericCardService.hide(diagnosticTestScalpEegId, DiagnosticTestScalpEegEntity.class);
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
        genericCardService.unhide(diagnosticTestScalpEegId, DiagnosticTestScalpEegEntity.class);
        return "redirect:/patient/" + patientId + "/diagnostic-testScalp-eeg/list";
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/list", method = RequestMethod.GET)
    public String diagnosticTestScalpEegListGET(
            @PathVariable("patientId") Integer patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        PatientDisplayBO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<DiagnosticTestScalpEegDisplayBO> diagnosticTestScalpEegDisplayBOList = genericCardService.getRecordsByPatientId(patientId, DiagnosticTestScalpEegDisplayBO.class, DiagnosticTestScalpEegEntity.class);
        model.addAttribute("diagnosticTestScalpEegDisplayBOList", diagnosticTestScalpEegDisplayBOList);
        model.addAttribute("patient", patient);
        return "patient/diagnosticTestScalpEeg/listView";
    }
}
