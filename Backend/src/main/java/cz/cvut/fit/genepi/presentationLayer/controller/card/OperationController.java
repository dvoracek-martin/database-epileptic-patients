package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.card.OperationDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.OperationFormBO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
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
@SessionAttributes({"operation", "patient"})
public class OperationController {

    private final AuthorizationChecker authorizationChecker;

    private final PatientService patientService;

    private final OperationService operationService;

    private final GenericCardService<OperationDisplayBO, OperationFormBO, OperationEntity> genericCardService;

    @Autowired
    public OperationController(AuthorizationChecker authorizationChecker,
                               PatientService patientService,
                               OperationService operationService,
                               @Qualifier("genericCardServiceImpl")
                               GenericCardService<OperationDisplayBO, OperationFormBO, OperationEntity> genericCardService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.operationService = operationService;
        this.genericCardService = genericCardService;
    }

    @RequestMapping(value = "/patient/{patientId}/operation/create", method = RequestMethod.GET)
    public String operationCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("operation", new OperationFormBO());
        return "patient/operation/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/operation/create", method = RequestMethod.POST)
    public String operationCreatePOST(
            @ModelAttribute("operation") @Valid OperationFormBO operation, BindingResult result,
            @ModelAttribute("patient") PatientDisplayBO patientDisplayBO,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayBO.getBirthday(), operation.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/operation/createView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.save(operation, OperationEntity.class);
                return "redirect:/patient/" + patientId + "/operation/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("operationId") int operationId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("operation", genericCardService.getById(operationId, OperationFormBO.class, OperationEntity.class));
        return "patient/operation/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/edit", method = RequestMethod.POST)
    public String operationSavePOST(
            @ModelAttribute("operation") @Valid OperationFormBO operation, BindingResult result,
            @ModelAttribute("patient") PatientDisplayBO patientDisplayBO,
            @PathVariable("patientId") int patientId,
            @PathVariable("operationId") int operationId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayBO.getBirthday(), operation.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/operation/editView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.makeHistory(operationId, OperationEntity.class);
                operation.setId(0);
                genericCardService.save(operation, OperationEntity.class);
                return "redirect:/patient/" + patientId + "/operation/list";
            }
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
        genericCardService.delete(operationId, OperationEntity.class);
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
        genericCardService.hide(operationId, OperationEntity.class);
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
        genericCardService.unhide(operationId, OperationEntity.class);
        return "redirect:/patient/" + patientId + "/operation/list";
    }

    @RequestMapping(value = "/patient/{patientId}/operation/list", method = RequestMethod.GET)
    public String operationListGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayBO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<OperationDisplayBO> operationDisplayBOList = operationService.getOperationList(patientId);
        model.addAttribute("operationDisplayBOList", operationDisplayBOList);
        model.addAttribute("patient", patient);
        return "patient/operation/listView";
    }
}
