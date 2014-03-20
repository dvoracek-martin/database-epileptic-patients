package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.NeurologicalFindingDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.OperationDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.OperationVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;
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
@SessionAttributes({"operation"})
public class OperationController {

    private AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private OperationService operationService;

    private GenericCardService<OperationDisplayVO, OperationVO, OperationEntity> genericCardService;

    @Autowired
    public OperationController(AuthorizationChecker authorizationChecker,
                               PatientService patientService,
                               OperationService operationService,
                               @Qualifier("genericCardServiceImpl")
                               GenericCardService<OperationDisplayVO, OperationVO, OperationEntity> genericCardService) {

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
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("operation", new OperationVO());
        return "patient/operation/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/operation/create", method = RequestMethod.POST)
    public String operationCreatePOST(
            @ModelAttribute("operation") @Valid OperationVO operation, BindingResult result,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), operation.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/operation/createView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            genericCardService.save(operation, OperationEntity.class);
            return "redirect:/patient/" + patientId + "/operation/list";
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
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("operation", genericCardService.getById(operationId, OperationVO.class, OperationEntity.class));
        return "patient/operation/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/edit", method = RequestMethod.POST)
    public String operationSavePOST(
            @ModelAttribute("operation") @Valid OperationVO operation, BindingResult result,
            @PathVariable("patientId") int patientId,
            @PathVariable("operationId") int operationId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), operation.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
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
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<OperationDisplayVO> operationDisplayVoList = operationService.getOperationList(patientId);
        model.addAttribute("operationDisplayVoList", operationDisplayVoList);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("patient", patient);
        return "patient/operation/listView";
    }
}