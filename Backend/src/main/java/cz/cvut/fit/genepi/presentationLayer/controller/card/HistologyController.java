package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.HistologyVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.HistologyService;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes({"histology"})
public class HistologyController {
    @Autowired
    AuthorizationChecker authorizationChecker;

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
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("histology", new HistologyVO());
        return "patient/histology/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("histologyId") int histologyId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("histology", histologyService.getById(histologyId, HistologyVO.class, HistologyEntity.class));
        return "patient/histology/formView";
    }

    /**
     * Adds the histology.
     *
     * @param histology the histology
     * @param result    the result
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/histology/save", method = RequestMethod.POST)
    public String histologySavePOST(
            @ModelAttribute("histology") @Valid HistologyVO histology, BindingResult result,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), histology.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/histology/formView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            histologyService.save(histology, HistologyEntity.class);
            return "redirect:/patient/" + patientId + "/histology/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/delete", method = RequestMethod.GET)
    public String histologyDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("histologyId") int histologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        histologyService.delete(histologyId, HistologyEntity.class);
        return "redirect:/patient/" + patientId + "/histology/list";
    }

    /**
     * Handles the GET request to hide histology.
     *
     * @param patientId the id of a patient whom we are creating an histology.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/hide", method = RequestMethod.GET)
    public String histologyHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("histologyId") int histologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        histologyService.hide(histologyId, HistologyEntity.class);
        return "redirect:/patient/" + patientId + "/histology/list";
    }

    /**
     * Handles the GET request to unhide histology.
     *
     * @param patientId the id of a patient whom we are creating an histology.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/unhide", method = RequestMethod.GET)
    public String histologyUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("histologyId") Integer histologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        histologyService.unhide(histologyId, HistologyEntity.class);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/histology/list";
    }

    @RequestMapping(value = "/patient/{patientId}/histology/list", method = RequestMethod.GET)
    public String histologyListGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithHistologyList(patientId);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/histology/listView";
    }
}
