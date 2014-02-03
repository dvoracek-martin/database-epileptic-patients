package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.HistologyVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.HistologyService;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes({"histology"})
public class HistologyController {

    private PatientService patientService;

    private HistologyService histologyService;

    @Autowired
    public HistologyController(PatientService patientService,
                               HistologyService histologyService) {

        this.patientService = patientService;
        this.histologyService = histologyService;
    }

    @RequestMapping(value = "/patient/{patientId}/histology/create", method = RequestMethod.GET)
    public String histologyCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("histology", new HistologyVO());
        return "patient/histology/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("histologyId") Integer histologyId,
            Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("histology", histologyService.getById(HistologyVO.class, HistologyEntity.class, histologyId));
        return "patient/histology/formView";
    }

    /**
     * Adds the histology.
     *
     * @param histology the histology
     * @param result    the result
     * @param patientID the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/histology/save", method = RequestMethod.POST)
    public String histologySavePOST(
            @ModelAttribute("histology") @Valid HistologyVO histology, BindingResult result,
            @PathVariable("patientId") Integer patientId,
            Locale locale, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/histology/formView";
        } else {
            histology.setPatientId(patientId);
            histologyService.save(HistologyEntity.class, histology);
            return "redirect:/patient/" + patientId + "/histology/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/delete", method = RequestMethod.GET)
    public String histologyDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("histologyId") Integer histologyId,
            Locale locale, Model model) {

        histologyService.delete(HistologyEntity.class, histologyId);
        return "redirect:/patient/" + patientId + "/histology/list";
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
            @PathVariable("histologyId") Integer histologyId,
            Locale locale, Model model) {

        histologyService.hide(histologyId);
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
            @PathVariable("histologyId") Integer histologyId,
            Locale locale, Model model) {

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
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithHistologyList(patientId));
        return "patient/histology/listView";
    }
}
