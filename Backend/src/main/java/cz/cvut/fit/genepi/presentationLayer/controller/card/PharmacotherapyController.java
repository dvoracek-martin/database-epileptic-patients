package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.PharmacotherapyVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.PharmacotherapyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes({"pharmacotherapy"})
public class PharmacotherapyController {

    private PatientService patientService;

    private PharmacotherapyService pharmacotherapyService;

    @Autowired
    public PharmacotherapyController(PatientService patientService,
                                     PharmacotherapyService pharmacotherapyService) {
        this.patientService = patientService;
        this.pharmacotherapyService = pharmacotherapyService;
    }

    @RequestMapping(value = "/patient/{patientId}/pharmacotherapy/create", method = RequestMethod.GET)
    public String pharmacotherapyCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("pharmacotherapy", new PharmacotherapyVO());
        return "patient/pharmacotherapy/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/pharmacotherapy/{pharmacotherapyId}/edit", method = RequestMethod.GET)
    public String pharmacotherapyEditGET(@PathVariable("patientId") Integer patientId,
                                         @PathVariable("pharmacotherapyId") Integer pharmacotherapyId,
                                         Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("pharmacotherapy", pharmacotherapyService.getById(PharmacotherapyVO.class, pharmacotherapyId));
        return "patient/pharmacotherapy/formView";
    }

    /**
     * Adds the pharmacotherapy.
     *
     * @param pharmacotherapy the pharmacotherapy
     * @param result          the result
     * @param patientID       the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/pharmacotherapy/save", method = RequestMethod.POST)
    public String pharmacotherapySavePOST(
            @ModelAttribute("pharmacotherapy") @Valid PharmacotherapyVO pharmacotherapy,
            BindingResult result, @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/pharmacotherapy/formView";
        } else {
            pharmacotherapy.setPatientId(patientId);
            pharmacotherapyService.save(pharmacotherapy);
            return "redirect:/patient/" + patientId + "/pharmacotherapy/list";
        }
    }

    @RequestMapping(value = "/patient/{patientID}/pharmacotherapy/{pharmacotherapyID}/delete", method = RequestMethod.GET)
    public String pharmacotherapyDeleteGET(
            @PathVariable("patientID") Integer patientID,
            @PathVariable("pharmacotherapyID") Integer pharmacotherapyID, Locale locale, Model model) {

        /*pharmacotherapyService.delete(pharmacotherapyService.findByID(
                PharmacotherapyEntity.class, pharmacotherapyID));*/
        return "redirect:/patient/" + patientID + "/pharmacotherapy/list";
    }

    /**
     * Handles the GET request to hide pharmacotherapy.
     *
     * @param patientId   the id of a patient whom we are creating an pharmacotherapy.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/pharmacotherapy/{pharmacotherapyId}/hide", method = RequestMethod.GET)
    public String pharmacotherapyHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("pharmacotherapyId") Integer pharmacotherapyId,
            Locale locale, Model model) {

        pharmacotherapyService.hide(pharmacotherapyId);
        return "redirect:/patient/" + patientId + "/pharmacotherapy/list";
    }

    /**
     * Handles the GET request to unhide pharmacotherapy.
     *
     * @param patientId   the id of a patient whom we are creating an pharmacotherapy.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/pharmacotherapy/{anamnesisId}/unhide", method = RequestMethod.GET)
    public String pharmacotherapyUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("pharmacotherapyId") Integer pharmacotherapyId,
            Locale locale, Model model) {

        pharmacotherapyService.unhide(pharmacotherapyId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/pharmacotherapy/list";
    }

    @RequestMapping(value = "/patient/{patientID}/pharmacotherapy/{pharmacotherapyID}/export", method = RequestMethod.GET)
    public String pharmacotherapyExportGET(Locale locale, Model model,
                                           @PathVariable("patientID") Integer patientID,
                                           @PathVariable("pharmacotherapyID") Integer pharmacotherapyID) {
        return "redirect:/patient/" + patientID + "/pharmacotherapy/list";
    }

    @RequestMapping(value = "/patient/{patientID}/pharmacotherapy/list", method = RequestMethod.GET)
    public String pharmacotherapyListGET(
            @PathVariable("patientID") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithPharmacotherapyList(patientId));
        return "patient/pharmacotherapy/listView";
    }
}
