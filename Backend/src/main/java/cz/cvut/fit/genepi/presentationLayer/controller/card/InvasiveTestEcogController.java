package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.InvasiveTestEcogVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestEcogService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEcogEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes({"invasiveTestEcog"})
public class InvasiveTestEcogController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private InvasiveTestEcogService invasiveTestEcogService;


    @Autowired
    public InvasiveTestEcogController(PatientService patientService,
                                      InvasiveTestEcogService invasiveTestEcogService) {

        this.patientService = patientService;
        this.invasiveTestEcogService = invasiveTestEcogService;
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-ecog/create", method = RequestMethod.GET)
    public String invasiveTestEcogCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("invasiveTestEcog", new InvasiveTestEcogVO());
        return "patient/invasiveTestEcog/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-ecog/{invasiveTestEcogId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestEcogId") int invasiveTestEcogId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("invasiveTestEcog", invasiveTestEcogService.getById(invasiveTestEcogId, InvasiveTestEcogVO.class, InvasiveTestEcogEntity.class));
        return "patient/invasiveTestEcog/formView";
    }

    /**
     * Adds the invasiveTestECOG.
     *
     * @param result the result
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-ecog/save", method = RequestMethod.POST)
    public String invasiveTestEcogSavePOST(
            @ModelAttribute("invasiveTestEcog") @Valid InvasiveTestEcogVO invasiveTestEcog, BindingResult result,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), invasiveTestEcog.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/invasiveTestEcog/formView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            invasiveTestEcogService.save(invasiveTestEcog, InvasiveTestEcogEntity.class);
            return "redirect:/patient/" + patientId + "/invasive-test-ecog/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-ecog/{invasiveTestEcogId}/delete", method = RequestMethod.GET)
    public String invasiveTestEcogDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestEcogId") int invasiveTestEcogId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        invasiveTestEcogService.delete(invasiveTestEcogId, InvasiveTestEcogEntity.class);
        return "redirect:/patient/" + patientId + "/invasive-test-ecog/list";
    }

    /**
     * Handles the GET request to hide invasiveTestEcog.
     *
     * @param patientId the id of a patient whom we are creating an invasiveTestEcog.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-ecog/{invasiveTestEcogId}/hide", method = RequestMethod.GET)
    public String invasiveTestEcogHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestEcogId") int invasiveTestEcogId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        invasiveTestEcogService.hide(invasiveTestEcogId, InvasiveTestEcogEntity.class);
        return "redirect:/patient/" + patientId + "/invasive-test-ecog/list";
    }

    /**
     * Handles the GET request to unhide invasiveTestEcog.
     *
     * @param patientId the id of a patient whom we are creating an invasiveTestEcog.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-ecog/{invasiveTestEcogId}/unhide", method = RequestMethod.GET)
    public String invasiveTestEcogUnhideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestEcogId") int invasiveTestEcogId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        invasiveTestEcogService.unhide(invasiveTestEcogId, InvasiveTestEcogEntity.class);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/invasive-test-ecog/list";
    }

   /* @RequestMapping(value = "/patient/{patientID}/invasive-test-ecog/{invasiveTestECOGID}/export", method = RequestMethod.GET)
    public String invasiveTestECOGExportGET(Locale locale, Model model,
                                            @PathVariable("patientID") Integer patientID,
                                            @PathVariable("invasiveTestECOGID") Integer invasiveTestECOGID) {
        return "redirect:/patient/" + patientID + "/invasive-test-ecog/list";
    }*/

    @RequestMapping(value = "/patient/{patientId}/invasive-test-ecog/list", method = RequestMethod.GET)
    public String invasiveTestEcogListGET(
            @PathVariable("patientId") Integer patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithInvasiveTestEcogList(patientId);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/invasiveTestEcog/listView";
    }
}
