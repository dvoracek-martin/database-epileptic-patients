package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.PharmacotherapyVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.businessLayer.service.card.PharmacotherapyService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes({"pharmacotherapy"})
public class PharmacotherapyController {

    private PatientService patientService;

    private PharmacotherapyService pharmacotherapyService;

    private UserService userService;

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
        model.addAttribute("pharmacotherapy", pharmacotherapyService.getById(PharmacotherapyVO.class, PharmacotherapyEntity.class, pharmacotherapyId));
        return "patient/pharmacotherapy/formView";
    }

    /**
     * Adds the pharmacotherapy.
     *
     * @param pharmacotherapy the pharmacotherapy
     * @param result          the result
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/pharmacotherapy/save", method = RequestMethod.POST)
    public String pharmacotherapySavePOST(
            @ModelAttribute("pharmacotherapy") @Valid PharmacotherapyVO pharmacotherapy, BindingResult result,
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), pharmacotherapy.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/pharmacotherapy/formView";
        } else {
            Authentication auth = SecurityContextHolder.getContext()
                    .getAuthentication();
            List<GrantedAuthority> roles = (List<GrantedAuthority>) auth.getAuthorities();
            boolean isSuperdoctor = false;
            for (GrantedAuthority r : roles) {
                if (r.getAuthority().equals("ROLE_SUPER_DOCTOR")) {
                    isSuperdoctor = true;
                    break;
                }
            }
            if (!isSuperdoctor)
                patientService.findByID(PatientEntity.class,patientId).setVerified(false);
            pharmacotherapy.setPatientId(patientId);
            pharmacotherapyService.save(PharmacotherapyEntity.class, pharmacotherapy);
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
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithPharmacotherapyList(patientId);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/pharmacotherapy/listView";
    }
}
