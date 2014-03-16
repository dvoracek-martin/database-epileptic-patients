package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.OperationVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes({"operation"})
public class OperationController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private OperationService operationService;

    @Autowired
    public OperationController(PatientService patientService,
                               OperationService operationService) {

        this.patientService = patientService;
        this.operationService = operationService;
    }

    @RequestMapping(value = "/patient/{patientId}/operation/create", method = RequestMethod.GET)
    public String operationCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("operation", new OperationVO());
        return "patient/operation/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("operationId") int operationId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("operation", operationService.getById(operationId, OperationVO.class, OperationEntity.class));
        return "patient/operation/formView";
    }

    /**
     * Adds the operation.
     *
     * @param operation the operation
     * @param result    the result
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/operation/save", method = RequestMethod.POST)
    public String operationSavePOST(
            @ModelAttribute("operation") @Valid OperationVO operation, BindingResult result,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), operation.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/operation/formView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            operationService.save(operation, OperationEntity.class);
            return "redirect:/patient/" + patientId + "/operation/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/delete", method = RequestMethod.GET)
    public String operationDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("operationId") int operationId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        operationService.delete(operationId, OperationEntity.class);
        return "redirect:/patient/" + patientId + "/operation/list";
    }

    /**
     * Handles the GET request to hide operation.
     *
     * @param patientId the id of a patient whom we are creating an operation.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/hide", method = RequestMethod.GET)
    public String operationHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("operationId") int operationId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        operationService.hide(operationId, OperationEntity.class);
        return "redirect:/patient/" + patientId + "/operation/list";
    }

    /**
     * Handles the GET request to unhide operation.
     *
     * @param patientId the id of a patient whom we are creating an operation.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/unhide", method = RequestMethod.GET)
    public String operationUnhideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("operationId") int operationId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        operationService.unhide(operationId, OperationEntity.class);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/operation/list";
    }

    @RequestMapping(value = "/patient/{patientId}/operation/list", method = RequestMethod.GET)
    public String operationListGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithOperationList(patientId);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/operation/listView";
    }
}
