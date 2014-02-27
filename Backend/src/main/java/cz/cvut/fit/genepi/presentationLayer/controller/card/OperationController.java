package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.OperationVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes({"operation"})
public class OperationController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private OperationService operationService;

    private UserService userService;

    @Autowired
    public OperationController(PatientService patientService,
                               OperationService operationService) {

        this.patientService = patientService;
        this.operationService = operationService;
    }

    @RequestMapping(value = "/patient/{patientId}/operation/create", method = RequestMethod.GET)
    public String operationCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("operation", new OperationVO());
        return "patient/operation/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("operationId") Integer operationId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("operation", operationService.getById(OperationVO.class, OperationEntity.class, operationId));
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
            @PathVariable("patientId") Integer patientId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), operation.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/operation/formView";
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
                patientService.findByID(PatientEntity.class, patientId).setVerified(false);
            operation.setPatientId(patientId);
            operationService.save(OperationEntity.class, operation);
            return "redirect:/patient/" + patientId + "/operation/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/delete", method = RequestMethod.GET)
    public String operationDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("operationId") Integer operationId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        operationService.delete(OperationEntity.class, operationId);
        return "redirect:/patient/" + patientId + "/operation/list";
    }

    /**
     * Handles the GET request to hide operation.
     *
     * @param patientId the id of a patient whom we are creating an operation.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/hide", method = RequestMethod.GET)
    public String operationHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("operationId") Integer operationId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        operationService.hide(operationId);
        return "redirect:/patient/" + patientId + "/operation/list";
    }

    /**
     * Handles the GET request to unhide operation.
     *
     * @param patientId the id of a patient whom we are creating an operation.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/operation/{anamnesisId}/unhide", method = RequestMethod.GET)
    public String operationUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("operationId") Integer operationId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        operationService.unhide(operationId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/operation/list";
    }

   /* @RequestMapping(value = "/patient/{patientID}/operation/{operationID}/export", method = RequestMethod.GET)
    public String operationExportGET(Locale locale, Model model,
                                     @PathVariable("patientID") Integer patientID,
                                     @PathVariable("operationID") Integer operationID) {
        return "redirect:/patient/" + patientID + "/operation/list";
    }*/

    @RequestMapping(value = "/patient/{patientId}/operation/list", method = RequestMethod.GET)
    public String operationListGET(Locale locale, Model model,
                                   @PathVariable("patientId") Integer patientId, HttpServletRequest request) {
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
