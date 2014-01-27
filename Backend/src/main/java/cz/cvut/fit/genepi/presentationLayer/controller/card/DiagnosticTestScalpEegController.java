package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.DiagnosticTestScalpEegVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestScalpEegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes({"diagnosticTestScalpEeg"})
public class DiagnosticTestScalpEegController {

    private PatientService patientService;

    private DiagnosticTestScalpEegService diagnosticTestScalpEegService;

    @Autowired
    public DiagnosticTestScalpEegController(PatientService patientService,
                                            DiagnosticTestScalpEegService diagnosticTestScalpEegService) {

        this.patientService = patientService;
        this.diagnosticTestScalpEegService = diagnosticTestScalpEegService;
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-testScalp-eeg/create", method = RequestMethod.GET)
    public String diagnosticTestScalpEegCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("diagnosticTestScalpEeg", new DiagnosticTestScalpEegVO());
        return "patient/diagnosticTestScalpEeg/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-testScalp-eeg/{diagnosticTestScalpEegId}/edit", method = RequestMethod.GET)
    public String diagnosticTestScalpEegEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
            Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("complication", diagnosticTestScalpEegService.getById(DiagnosticTestScalpEegVO.class, diagnosticTestScalpEegId));
        return "patient/diagnosticTestScalpEeg/formView";
    }

    /**
     * Adds the diagnosticTestScalpEEG.
     *
     * @param diagnosticTestScalpEEG the diagnosticTestScalpEEG
     * @param result                 the result
     * @param patientID              the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/diagnostic-testScalp-eeg/save", method = RequestMethod.POST)
    public String diagnosticTestScalpEegCreatePOST(
            @ModelAttribute("diagnosticTestScalpEeg") @Valid DiagnosticTestScalpEegVO diagnosticTestScalpEeg,
            @PathVariable("patientId") Integer patientId,
            BindingResult result, Locale locale, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/diagnosticTestScalpEeg/formView";
        } else {
            diagnosticTestScalpEeg.setPatientId(patientId);
            diagnosticTestScalpEegService.save(diagnosticTestScalpEeg);
            return "redirect:/patient/" + patientId + "/diagnostic-testScalp-eeg/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/diagnostic-testScalp-eeg/{diagnosticTestScalpEegId}/delete", method = RequestMethod.GET)
    public String diagnosticTestScalpEegDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
            Locale locale, Model model) {

        diagnosticTestScalpEegService.delete(diagnosticTestScalpEegId);
        return "redirect:/patient/" + patientId + "/diagnostic-testScalp-eeg/list";
    }

    /**
     * Handles the GET request to hide diagnosticTestScalpEeg.
     *
     * @param patientId   the id of a patient whom we are creating an
     *                    diagnosticTestScalpEeg.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/diagnostic-testScalp-eeg/{diagnosticTestScalpEegId}/hide", method = RequestMethod.GET)
    public String diagnosticTestScalpEegHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
            Locale locale, Model model) {

        diagnosticTestScalpEegService.hide(diagnosticTestScalpEegId);
        return "redirect:/patient/" + patientId + "/diagnostic-testScalp-eeg/list";
    }

    /**
     * Handles the GET request to unhide diagnosticTestScalpEeg.
     *
     * @param patientId   the id of a patient whom we are creating an
     *                    diagnosticTestScalpEeg.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/diagnostic-testScalp-eeg/{diagnosticTestScalpEegId}/unhide", method = RequestMethod.GET)
    public String diagnosticTestScalpEegUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
            Locale locale, Model model) {

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

    @RequestMapping(value = "/patient/{patientId}/diagnostic-testScalp-eeg/list", method = RequestMethod.GET)
    public String diagnosticTestScalpEegListGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDiagnosticTestScalpEegList(patientId));
        return "patient/diagnosticTestScalpEeg/listView";
    }
}