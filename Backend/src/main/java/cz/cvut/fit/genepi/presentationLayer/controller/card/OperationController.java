package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.OperationVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class OperationController {

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
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("operation", new OperationVO());
        return "patient/operation/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("operationId") Integer operationId,
            Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("operation", operationService.getById(OperationVO.class, OperationEntity.class, operationId));
        return "patient/operation/formView";
    }

    /**
     * Adds the operation.
     *
     * @param operation the operation
     * @param result    the result
     * @param patientID the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/operation/save", method = RequestMethod.POST)
    public String operationSavePOST(
            @ModelAttribute("operation") @Valid OperationVO operation,
            @PathVariable("patientId") Integer patientId,
            BindingResult result, Locale locale, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/operation/formView";
        } else {
            operation.setPatientId(patientId);
            operationService.save(OperationEntity.class,operation);
            return "redirect:/patient/" + patientId + "/operation/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/delete", method = RequestMethod.GET)
    public String operationDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("operationId") Integer operationId,
            Locale locale, Model model) {

        operationService.delete(OperationEntity.class,operationId);
        return "redirect:/patient/" + patientId + "/operation/list";
    }

    /**
     * Handles the GET request to hide operation.
     *
     * @param patientId   the id of a patient whom we are creating an operation.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/operation/{operationId}/hide", method = RequestMethod.GET)
    public String operationHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("operationId") Integer operationId,
            Locale locale, Model model) {

        operationService.hide(operationId);
        return "redirect:/patient/" + patientId + "/operation/list";
    }

    /**
     * Handles the GET request to unhide operation.
     *
     * @param patientId   the id of a patient whom we are creating an operation.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/operation/{anamnesisId}/unhide", method = RequestMethod.GET)
    public String operationUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("operationId") Integer operationId,
            Locale locale, Model model) {

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
                                   @PathVariable("patientId") Integer patientId) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithOperationList(patientId));
        return "patient/operation/listView";
    }
}
