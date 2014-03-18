package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.DiagnosticTestScalpEegDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.NeurologicalFindingDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.DiagnosticTestScalpEegVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestScalpEegService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEegEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;
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
@SessionAttributes({"diagnosticTestScalpEeg"})
public class DiagnosticTestScalpEegController {

    private AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private DiagnosticTestScalpEegService diagnosticTestScalpEegService;

    private GenericCardService<DiagnosticTestScalpEegDisplayVO, DiagnosticTestScalpEegVO, DiagnosticTestScalpEegEntity> genericCardService;

    @Autowired
    public DiagnosticTestScalpEegController(AuthorizationChecker authorizationChecker,
                                            PatientService patientService,
                                            DiagnosticTestScalpEegService diagnosticTestScalpEegService,
                                            @Qualifier("genericCardServiceImpl")
                                            GenericCardService<DiagnosticTestScalpEegDisplayVO, DiagnosticTestScalpEegVO, DiagnosticTestScalpEegEntity> genericCardService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.diagnosticTestScalpEegService = diagnosticTestScalpEegService;
        this.genericCardService = genericCardService;
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/create", method = RequestMethod.GET)
    public String diagnosticTestScalpEegCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("diagnosticTestScalpEeg", new DiagnosticTestScalpEegVO());
        return "patient/diagnosticTestScalpEeg/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/create", method = RequestMethod.POST)
    public String diagnosticTestScalpEegCreatePOST(
            @ModelAttribute("diagnosticTestScalpEeg") @Valid DiagnosticTestScalpEegVO diagnosticTestScalpEeg, BindingResult result,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), diagnosticTestScalpEeg.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/diagnosticTestScalpEeg/createView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            genericCardService.save(diagnosticTestScalpEeg, DiagnosticTestScalpEegEntity.class);
            return "redirect:/patient/" + patientId + "/diagnostic-test-scalp-eeg/list";
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
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("diagnosticTestScalpEeg", genericCardService.getById(diagnosticTestScalpEegId, DiagnosticTestScalpEegVO.class, DiagnosticTestScalpEegEntity.class));
        return "patient/diagnosticTestScalpEeg/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-test-scalp-eeg/{diagnosticTestScalpEegId}/edit", method = RequestMethod.POST)
    public String diagnosticTestScalpEegEditPOST(
            @ModelAttribute("diagnosticTestScalpEeg") @Valid DiagnosticTestScalpEegVO diagnosticTestScalpEeg, BindingResult result,
            @PathVariable("patientId") int patientId,
            @PathVariable("diagnosticTestScalpEegId") int diagnosticTestScalpEegId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), diagnosticTestScalpEeg.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
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

        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<DiagnosticTestScalpEegDisplayVO> diagnosticTestScalpEegDisplayVoList = genericCardService.getRecordsByPatientId(patientId, DiagnosticTestScalpEegDisplayVO.class, DiagnosticTestScalpEegEntity.class);
        model.addAttribute("diagnosticTestScalpEegList", diagnosticTestScalpEegDisplayVoList);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("patient", patient);
        return "patient/diagnosticTestScalpEeg/listView";
    }
}