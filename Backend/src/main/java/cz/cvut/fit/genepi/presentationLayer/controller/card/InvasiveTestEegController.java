package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.card.InvasiveTestEegDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.InvasiveTestEegFormBO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEegEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"invasiveTestEeg", "patient"})
public class InvasiveTestEegController {

    private final AuthorizationChecker authorizationChecker;

    private final PatientService patientService;

    private final GenericCardService<InvasiveTestEegDisplayBO, InvasiveTestEegFormBO, InvasiveTestEegEntity> genericCardService;

    @Autowired
    public InvasiveTestEegController(AuthorizationChecker authorizationChecker,
                                     PatientService patientService,
                                     @Qualifier("genericCardServiceImpl")
                                     GenericCardService<InvasiveTestEegDisplayBO, InvasiveTestEegFormBO, InvasiveTestEegEntity> genericCardService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.genericCardService = genericCardService;
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/create", method = RequestMethod.GET)
    public String invasiveTestEegCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("invasiveTestEeg", new InvasiveTestEegFormBO());
        return "patient/invasiveTestEeg/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/create", method = RequestMethod.POST)
    public String invasiveTestEegCreatePOST(
            @ModelAttribute("invasiveTestEeg") @Valid InvasiveTestEegFormBO invasiveTestEeg, BindingResult result,
            @ModelAttribute("patient") PatientDisplayBO patientDisplayBO,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayBO.getBirthday(), invasiveTestEeg.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/invasiveTestEeg/createView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.save(invasiveTestEeg, InvasiveTestEegEntity.class);
                return "redirect:/patient/" + patientId + "/invasive-test-eeg/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/{invasiveTestEegId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestEegId") int invasiveTestEegId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("invasiveTestEeg", genericCardService.getById(invasiveTestEegId, InvasiveTestEegFormBO.class, InvasiveTestEegEntity.class));
        return "patient/invasiveTestEeg/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/{invasiveTestEegId}/edit", method = RequestMethod.POST)
    public String invasiveTestEegSavePOST(
            @ModelAttribute("invasiveTestEeg") @Valid InvasiveTestEegFormBO invasiveTestEeg, BindingResult result,
            @ModelAttribute("patient") PatientDisplayBO patientDisplayBO,
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestEegId") int invasiveTestEegId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayBO.getBirthday(), invasiveTestEeg.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/invasiveTestEeg/formView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.makeHistory(invasiveTestEegId, InvasiveTestEegEntity.class);
                invasiveTestEeg.setId(0);
                genericCardService.save(invasiveTestEeg, InvasiveTestEegEntity.class);
                return "redirect:/patient/" + patientId + "/invasive-test-eeg/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/{invasiveTestEegId}/delete", method = RequestMethod.GET)
    public String invasiveTestEegDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestEegId") int invasiveTestEegId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.delete(invasiveTestEegId, InvasiveTestEegEntity.class);
        return "redirect:/patient/" + patientId + "/invasive-test-eeg/list";
    }

    /**
     * Handles the GET request to hide invasiveTestEeg.
     *
     * @param patientId the id of a patient whom we are creating an invasiveTestEeg.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/{invasiveTestEegId}/hide", method = RequestMethod.GET)
    public String invasiveTestEegHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("invasiveTestEegId") Integer invasiveTestEegId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.hide(invasiveTestEegId, InvasiveTestEegEntity.class);
        return "redirect:/patient/" + patientId + "/invasive-test-eeg/list";
    }

    /**
     * Handles the GET request to unhide invasiveTestEeg.
     *
     * @param patientId the id of a patient whom we are creating an invasiveTestEeg.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/{invasiveTestEegId}/unhide", method = RequestMethod.GET)
    public String invasiveTestEegUnhideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestEegId") int invasiveTestEegId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.unhide(invasiveTestEegId, InvasiveTestEegEntity.class);
        return "redirect:/patient/" + patientId + "/invasive-test-eeg/list";
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/list", method = RequestMethod.GET)
    public String invasiveTestEegListGET(
            @PathVariable("patientId") Integer patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayBO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<InvasiveTestEegDisplayBO> invasiveTestEegDisplayBOList = genericCardService.getRecordsByPatientId(patientId, InvasiveTestEegDisplayBO.class, InvasiveTestEegEntity.class);
        model.addAttribute("invasiveTestEegDisplayBOList", invasiveTestEegDisplayBOList);
        model.addAttribute("patient", patient);
        return "patient/invasiveTestEeg/listView";
    }
}
