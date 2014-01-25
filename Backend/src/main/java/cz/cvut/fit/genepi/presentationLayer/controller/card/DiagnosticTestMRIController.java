package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestMriService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestMriEntity;
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
public class DiagnosticTestMRIController {

    private PatientService patientService;

    private DiagnosticTestMriService diagnosticTestMriService;

    @Autowired
    public DiagnosticTestMRIController(PatientService patientService,
                                       DiagnosticTestMriService diagnosticTestMriService) {
        this.patientService = patientService;
        this.diagnosticTestMriService = diagnosticTestMriService;
    }

    @RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/create", method = RequestMethod.GET)
    public String diagnosticTestMRICreateGET(Locale locale, Model model,
                                             @PathVariable("patientID") Integer patientID) {
        PatientEntity patient = patientService.findByID(PatientEntity.class,
                patientID);

        model.addAttribute("patient", patient);
        model.addAttribute("diagnosticTestMRI", new DiagnosticTestMriEntity());
        return "patient/diagnosticTestMRI/createView";
    }

    /**
     * Adds the diagnosticTestMRI.
     *
     * @param diagnosticTestMRI the diagnosticTestMRI
     * @param result            the result
     * @param patientID         the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/create", method = RequestMethod.POST)
    public String diagnosticTestMRICreatePOST(
            @ModelAttribute("diagnosticTestMRI") @Valid DiagnosticTestMriEntity diagnosticTestMRI,
            BindingResult result, @PathVariable("patientID") Integer patientID) {
        if (result.hasErrors()) {
            return "patient/diagnosticTestMRI/createView";
        } else {
            diagnosticTestMRI.setPatient(patientService.findByID(
                    PatientEntity.class, patientID));
            diagnosticTestMriService.save(diagnosticTestMRI);
            return "redirect:/patient/" + patientID + "/diagnosticTestMRI/list";
        }
    }

    @RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/{diagnosticTestMRIID}/delete", method = RequestMethod.GET)
    public String diagnosticTestMRIDeleteGET(Locale locale, Model model,
                                             @PathVariable("patientID") Integer patientID,
                                             @PathVariable("diagnosticTestMRIID") Integer diagnosticTestMRIID) {

        diagnosticTestMriService.delete(diagnosticTestMriService.findByID(
                DiagnosticTestMriEntity.class, diagnosticTestMRIID));
        return "redirect:/patient/" + patientID + "/diagnosticTestMRI/list";
    }

    /**
     * Handles the GET request to hide diagnosticTestMri.
     *
     * @param patientId   the id of a patient whom we are creating an diagnosticTestMri.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/diagnosticTestMri/{diagnosticTestMriId}/hide", method = RequestMethod.GET)
    public String diagnosticTestMriHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestMriId") Integer diagnosticTestMriId,
            Locale locale, Model model) {

        diagnosticTestMriService.hide(diagnosticTestMriService.findByID(
                DiagnosticTestMriEntity.class, diagnosticTestMriId));
        return "redirect:/patient/" + patientId + "/diagnosticTestMri/list";
    }

    /**
     * Handles the GET request to unhide diagnosticTestMri.
     *
     * @param patientId   the id of a patient whom we are creating an diagnosticTestMri.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/diagnosticTestMri/{diagnosticTestMriId}/unhide", method = RequestMethod.GET)
    public String diagnosticTestMriUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("diagnosticTestMriId") Integer diagnosticTestMriId,
            Locale locale, Model model) {

        diagnosticTestMriService.unhide(diagnosticTestMriService.findByID(
                DiagnosticTestMriEntity.class, diagnosticTestMriId));
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/diagnosticTestMri/list";
    }

    @RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/{diagnosticTestMRIID}/export", method = RequestMethod.GET)
    public String diagnosticTestMRIExportGET(Locale locale, Model model,
                                             @PathVariable("patientID") Integer patientID,
                                             @PathVariable("diagnosticTestMRIID") Integer diagnosticTestMRIID) {
        return "redirect:/patient/" + patientID + "/diagnosticTestMRI/list";
    }

    @RequestMapping(value = "/patient/{patientID}/diagnosticTestMRI/list", method = RequestMethod.GET)
    public String diagnosticTestMRIListGET(Locale locale, Model model,
                                           @PathVariable("patientID") Integer patientID) {
        PatientEntity patient = patientService
                .getPatientByIdWithDiagnosticTestMRIList(patientID);
        model.addAttribute("patient", patient);
        return "patient/diagnosticTestMRI/listView";
    }
}
