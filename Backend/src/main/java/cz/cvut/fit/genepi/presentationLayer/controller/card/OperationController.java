package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
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

    @RequestMapping(value = "/patient/{patientID}/operation/create", method = RequestMethod.GET)
    public String operationCreateGET(Locale locale, Model model,
                                     @PathVariable("patientID") Integer patientID) {
        PatientEntity patient = patientService.findByID(PatientEntity.class,
                patientID);

        model.addAttribute("patient", patient);
        model.addAttribute("operation", new OperationEntity());
        return "patient/operation/createView";
    }

    /**
     * Adds the operation.
     *
     * @param operation the operation
     * @param result    the result
     * @param patientID the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientID}/operation/create", method = RequestMethod.POST)
    public String operationCreatePOST(
            @ModelAttribute("operation") @Valid OperationEntity operation,
            BindingResult result, @PathVariable("patientID") Integer patientID) {
        if (result.hasErrors()) {
            return "patient/operation/createView";
        } else {
            operation.setPatient(patientService.findByID(PatientEntity.class,
                    patientID));
            operationService.save(operation);
            return "redirect:/patient/" + patientID + "/operation/list";
        }
    }

    @RequestMapping(value = "/patient/{patientID}/operation/{operationID}/delete", method = RequestMethod.GET)
    public String operationDeleteGET(Locale locale, Model model,
                                     @PathVariable("patientID") Integer patientID,
                                     @PathVariable("operationID") Integer operationID) {

        operationService.delete(operationService.findByID(
                OperationEntity.class, operationID));
        return "redirect:/patient/" + patientID + "/operation/list";
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
            @PathVariable("operationId") Integer operationId, Locale locale,
            Model model) {

        operationService.hide(operationService.findByID(OperationEntity.class,
                operationId));
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
            @PathVariable("operationId") Integer operationId, Locale locale,
            Model model) {

        operationService.unhide(operationService.findByID(
                OperationEntity.class, operationId));
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/operation/list";
    }

    @RequestMapping(value = "/patient/{patientID}/operation/{operationID}/export", method = RequestMethod.GET)
    public String operationExportGET(Locale locale, Model model,
                                     @PathVariable("patientID") Integer patientID,
                                     @PathVariable("operationID") Integer operationID) {
        return "redirect:/patient/" + patientID + "/operation/list";
    }

    @RequestMapping(value = "/patient/{patientID}/operation/list", method = RequestMethod.GET)
    public String operationListGET(Locale locale, Model model,
                                   @PathVariable("patientID") Integer patientID) {
        PatientEntity patient = patientService
                .getPatientByIdWithOperationList(patientID);
        model.addAttribute("patient", patient);
        return "patient/operation/listView";
    }
}
