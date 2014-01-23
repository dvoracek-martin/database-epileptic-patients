package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.HistologyService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;
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
public class HistologyController {

    private PatientService patientService;

    private HistologyService histologyService;

    @Autowired
    public HistologyController(PatientService patientService,
                               HistologyService histologyService) {
        this.patientService = patientService;
        this.histologyService = histologyService;
    }

    @RequestMapping(value = "/patient/{patientID}/histology/create", method = RequestMethod.GET)
    public String histologyCreateGET(Locale locale, Model model,
                                     @PathVariable("patientID") Integer patientID) {
        PatientEntity patient = patientService.findByID(PatientEntity.class,
                patientID);

        model.addAttribute("patient", patient);
        model.addAttribute("histology", new HistologyEntity());
        return "patient/histology/createView";
    }

    /**
     * Adds the histology.
     *
     * @param histology the histology
     * @param result    the result
     * @param patientID the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientID}/histology/create", method = RequestMethod.POST)
    public String histologyCreatePOST(
            @ModelAttribute("histology") @Valid HistologyEntity histology,
            BindingResult result, @PathVariable("patientID") Integer patientID) {
        if (result.hasErrors()) {
            return "patient/histology/createView";
        } else {
            histology.setPatient(patientService.findByID(PatientEntity.class,
                    patientID));
            histologyService.save(histology);
            return "redirect:/patient/" + patientID + "/histology/list";
        }
    }

    @RequestMapping(value = "/patient/{patientID}/histology/{histologyID}/delete", method = RequestMethod.GET)
    public String histologyDeleteGET(Locale locale, Model model,
                                     @PathVariable("patientID") Integer patientID,
                                     @PathVariable("histologyID") Integer histologyID) {

        histologyService.delete(histologyService.findByID(
                HistologyEntity.class, histologyID));
        return "redirect:/patient/" + patientID + "/histology/list";
    }

    /**
     * Handles the GET request to hide histology.
     *
     * @param patientId   the id of a patient whom we are creating an histology.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/hide", method = RequestMethod.GET)
    public String histologyHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("histologyId") Integer histologyId, Locale locale,
            Model model) {

        histologyService.hide(histologyService.findByID(HistologyEntity.class,
                histologyId));
        return "redirect:/patient/" + patientId + "/histology/list";
    }

    /**
     * Handles the GET request to unhide histology.
     *
     * @param patientId   the id of a patient whom we are creating an histology.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/unhide", method = RequestMethod.GET)
    public String histologyUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("histologyId") Integer histologyId, Locale locale,
            Model model) {

        histologyService.unhide(histologyService.findByID(
                HistologyEntity.class, histologyId));
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/histology/list";
    }

    @RequestMapping(value = "/patient/{patientID}/histology/{histologyID}/export", method = RequestMethod.GET)
    public String histologyExportGET(Locale locale, Model model,
                                     @PathVariable("patientID") Integer patientID,
                                     @PathVariable("histologyID") Integer histologyID) {
        return "redirect:/patient/" + patientID + "/histology/list";
    }

    @RequestMapping(value = "/patient/{patientID}/histology/list", method = RequestMethod.GET)
    public String histologyListGET(Locale locale, Model model,
                                   @PathVariable("patientID") Integer patientID) {
        PatientEntity patient = patientService
                .getPatientByIdWithHistologyList(patientID);
        model.addAttribute("patient", patient);
        return "patient/histology/listView";
    }
}
