package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestScalpEEGService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEegEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class DiagnosticTestScalpEEGController {

    private PatientService patientService;

    private DiagnosticTestScalpEEGService diagnosticTestScalpEEGService;

    @Autowired
    public DiagnosticTestScalpEEGController(PatientService patientService,
                                            DiagnosticTestScalpEEGService diagnosticTestScalpEEGService) {
        this.patientService = patientService;
        this.diagnosticTestScalpEEGService = diagnosticTestScalpEEGService;
    }

    @RequestMapping(value = "/patient/{patientID}/diagnosticTestScalpEEG/create", method = RequestMethod.GET)
    public String diagnosticTestScalpEEGCreateGET(Locale locale, Model model,
                                                  @PathVariable("patientID") Integer patientID) {
        PatientEntity patient = patientService.findByID(PatientEntity.class,
                patientID);

        model.addAttribute("patient", patient);
        model.addAttribute("diagnosticTestScalpEEG",
                new DiagnosticTestScalpEegEntity());
        return "patient/diagnosticTestScalpEEG/createView";
    }

    /**
     * Adds the diagnosticTestScalpEEG.
     *
     * @param diagnosticTestScalpEEG the diagnosticTestScalpEEG
     * @param result                 the result
     * @param patientID              the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientID}/diagnosticTestScalpEEG/create", method = RequestMethod.POST)
    public String diagnosticTestScalpEEGCreatePOST(
            @ModelAttribute("diagnosticTestScalpEEG") @Valid DiagnosticTestScalpEegEntity diagnosticTestScalpEEG,
            BindingResult result, @PathVariable("patientID") Integer patientID) {
        if (result.hasErrors()) {
            return "patient/diagnosticTestScalpEEG/createView";
        } else {
            diagnosticTestScalpEEG.setPatient(patientService.findByID(
                    PatientEntity.class, patientID));
            diagnosticTestScalpEEGService.save(diagnosticTestScalpEEG);
            return "redirect:/patient/" + patientID + "/diagnosticTestScalpEEG/list";
        }
    }

    @RequestMapping(value = "/patient/{patientID}/diagnosticTestScalpEEG/{diagnosticTestScalpEEGID}/delete", method = RequestMethod.GET)
    public String diagnosticTestScalpEEGDeleteGET(Locale locale, Model model,
                                                  @PathVariable("patientID") Integer patientID,
                                                  @PathVariable("diagnosticTestScalpEEGID") Integer diagnosticTestScalpEEGID) {

        diagnosticTestScalpEEGService.delete(diagnosticTestScalpEEGService
                .findByID(DiagnosticTestScalpEegEntity.class,
                        diagnosticTestScalpEEGID));
        return "redirect:/patient/" + patientID + "/diagnosticTestScalpEEG/list";
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
    @RequestMapping(value = "/patient/{patientId}/diagnosticTestScalpEeg/{diagnosticTestScalpEegId}/hide", method = RequestMethod.GET)
    public String diagnosticTestScalpEegHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
            Locale locale, Model model) {

        diagnosticTestScalpEEGService.hide(diagnosticTestScalpEEGService
                .findByID(DiagnosticTestScalpEegEntity.class,
                        diagnosticTestScalpEegId));
        return "redirect:/patient/" + patientId + "/anamnesis/list";
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
    @RequestMapping(value = "/patient/{patientId}/diagnosticTestScalpEeg/{diagnosticTestScalpEegId}/unhide", method = RequestMethod.GET)
    public String diagnosticTestScalpEegUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestScalpEegId") Integer diagnosticTestScalpEegId,
            Locale locale, Model model) {

        diagnosticTestScalpEEGService.unhide(diagnosticTestScalpEEGService
                .findByID(DiagnosticTestScalpEegEntity.class,
                        diagnosticTestScalpEegId));
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/anamnesis/list";
    }

    @RequestMapping(value = "/patient/{patientID}/diagnosticTestScalpEEG/{diagnosticTestScalpEEGID}/export", method = RequestMethod.GET)
    public String diagnosticTestScalpEEGExportGET(Locale locale, Model model,
                                                  @PathVariable("patientID") Integer patientID,
                                                  @PathVariable("diagnosticTestScalpEEGID") Integer diagnosticTestScalpEEGID) {
        return "redirect:/patient/" + patientID + "/diagnosticTestScalpEEG/list";
    }

    @RequestMapping(value = "/patient/{patientID}/diagnosticTestScalpEEG/list", method = RequestMethod.GET)
    public String diagnosticTestScalpEEGListGET(Locale locale, Model model,
                                                @PathVariable("patientID") Integer patientID) {
        PatientEntity patient = patientService
                .getPatientByIdWithDiagnosticTestScalpEEGList(patientID);
        model.addAttribute("patient", patient);
        return "patient/diagnosticTestScalpEEG/listView";
    }
}
