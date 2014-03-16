package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.ComplicationVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.ComplicationService;
import cz.cvut.fit.genepi.dataLayer.entity.card.ComplicationEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes({"complication"})
public class ComplicationController {

    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private ComplicationService complicationService;

    @Autowired
    public ComplicationController(PatientService patientService,
                                  ComplicationService complicationService) {

        this.patientService = patientService;
        this.complicationService = complicationService;
    }

    @RequestMapping(value = "/patient/{patientId}/complication/create", method = RequestMethod.GET)
    public String complicationCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("complication", new ComplicationVO());
        return "patient/complication/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/complication/{complicationId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("complicationId") int complicationId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("complication", complicationService.getById(complicationId, ComplicationVO.class, ComplicationEntity.class));
        return "patient/complication/formView";
    }

    /**
     * Adds the complication.
     *
     * @param complication the complication
     * @param result       the result
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/complication/save", method = RequestMethod.POST)
    public String complicationSavePOST(
            @ModelAttribute("complication") @Valid ComplicationVO complication, BindingResult result,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), complication.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/complication/formView";
        } else {

            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            complicationService.save(complication, ComplicationEntity.class);
            return "redirect:/patient/" + patientId + "/complication/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/complication/{complicationId}/delete", method = RequestMethod.GET)
    public String complicationDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("complicationId") int complicationId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        complicationService.delete(complicationId, ComplicationEntity.class);
        return "redirect:/patient/" + patientId + "/complication/list";
    }

    /**
     * Handles the GET request to hide complication.
     *
     * @param patientId the id of a patient whom we are creating an complication.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/complication/{complicationId}/hide", method = RequestMethod.GET)
    public String complicationHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("complicationId") int complicationId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        complicationService.hide(complicationId, ComplicationEntity.class);
        return "redirect:/patient/" + patientId + "/complication/list";
    }

    /**
     * Handles the GET request to unhide complication.
     *
     * @param patientId the id of a patient whom we are creating an complication.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/complication/{complicationId}/unhide", method = RequestMethod.GET)
    public String complicationUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("complicationId") Integer complicationId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        complicationService.unhide(complicationId, ComplicationEntity.class);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/complication/list";
    }

   /* @RequestMapping(value = "/patient/{patientID}/complication/{complicationID}/export", method = RequestMethod.GET)
    public String complicationExportGET(Locale locale, Model model,
                                        @PathVariable("patientID") Integer patientID,
                                        @PathVariable("complicationID") Integer complicationID) {

        return "redirect:/patient/" + patientID + "/complication/list";
    }*/

    @RequestMapping(value = "/patient/{patientId}/complication/list", method = RequestMethod.GET)
    public String complicationListGET(
            @PathVariable("patientId") Integer patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithComplicationList(patientId);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/complication/listView";
    }
}
