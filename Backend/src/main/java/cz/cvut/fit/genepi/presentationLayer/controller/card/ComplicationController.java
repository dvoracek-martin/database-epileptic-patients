package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.ComplicationService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.ComplicationEntity;
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
public class ComplicationController {

    private PatientService patientService;

    private ComplicationService complicationService;

    @Autowired
    public ComplicationController(PatientService patientService,
                                  ComplicationService complicationService) {
        this.patientService = patientService;
        this.complicationService = complicationService;
    }

    @RequestMapping(value = "/patient/{patientID}/complication/create", method = RequestMethod.GET)
    public String complicationCreateGET(Locale locale, Model model,
                                        @PathVariable("patientID") Integer patientID) {
        PatientEntity patient = patientService.findByID(PatientEntity.class,
                patientID);

        model.addAttribute("patient", patient);
        model.addAttribute("complication", new ComplicationEntity());
        return "patient/complication/createView";
    }

    /**
     * Adds the complication.
     *
     * @param complication the complication
     * @param result       the result
     * @param patientID    the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientID}/complication/create", method = RequestMethod.POST)
    public String complicationCreatePOST(
            @ModelAttribute("complication") @Valid ComplicationEntity complication,
            BindingResult result, @PathVariable("patientID") Integer patientID) {
        if (result.hasErrors()) {
            return "patient/complication/createView";
        } else {
            complication.setPatient(patientService.findByID(
                    PatientEntity.class, patientID));
            complicationService.save(complication);
            return "redirect:/patient/" + patientID + "/complication/list";
        }
    }

    @RequestMapping(value = "/patient/{patientID}/complication/{complicationID}/delete", method = RequestMethod.GET)
    public String complicationDeleteGET(Locale locale, Model model,
                                        @PathVariable("patientID") Integer patientID,
                                        @PathVariable("complicationID") Integer complicationID) {

        complicationService.delete(complicationService.findByID(
                ComplicationEntity.class, complicationID));
        return "redirect:/patient/" + patientID + "/complication/list";
    }

    /**
     * Handles the GET request to hide complication.
     *
     * @param patientId   the id of a patient whom we are creating an complication.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/complication/{complicationId}/hide", method = RequestMethod.GET)
    public String complicationHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("complicationId") Integer complicationId,
            Locale locale, Model model) {

        complicationService.hide(complicationService.findByID(
                ComplicationEntity.class, complicationId));
        return "redirect:/patient/" + patientId + "/complication/list";
    }

    /**
     * Handles the GET request to unhide complication.
     *
     * @param patientId   the id of a patient whom we are creating an complication.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/complication/{complicationId}/unhide", method = RequestMethod.GET)
    public String complicationUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("complicationId") Integer complicationId,
            Locale locale, Model model) {

        complicationService.unhide(complicationService.findByID(
                ComplicationEntity.class, complicationId));
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/xomplication/list";
    }

    @RequestMapping(value = "/patient/{patientID}/complication/{complicationID}/export", method = RequestMethod.GET)
    public String complicationExportGET(Locale locale, Model model,
                                        @PathVariable("patientID") Integer patientID,
                                        @PathVariable("complicationID") Integer complicationID) {
        return "redirect:/patient/" + patientID + "/complication/list";
    }

    @RequestMapping(value = "/patient/{patientID}/complication/list", method = RequestMethod.GET)
    public String complicationListGET(Locale locale, Model model,
                                      @PathVariable("patientID") Integer patientID) {
        PatientEntity patient = patientService
                .getPatientByIdWithComplicationList(patientID);
        model.addAttribute("patient", patient);
        return "patient/complication/listView";
    }
}
