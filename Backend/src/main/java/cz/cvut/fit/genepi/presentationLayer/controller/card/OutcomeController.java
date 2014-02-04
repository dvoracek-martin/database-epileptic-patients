package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.OutcomeVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.businessLayer.service.card.OutcomeService;
import cz.cvut.fit.genepi.dataLayer.entity.card.OutcomeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes({"outcome", "operation"})
public class OutcomeController {

    private PatientService patientService;

    private OutcomeService outcomeService;

    private OperationService operationService;

    @Autowired
    public OutcomeController(PatientService patientService,
                             OutcomeService outcomeService, OperationService operationService) {
        this.patientService = patientService;
        this.outcomeService = outcomeService;
        this.operationService = operationService;
    }

    @RequestMapping(value = "/patient/{patientId}/outcome/create", method = RequestMethod.GET)
    public String outcomeCreateGET(
            @PathVariable("patientId") Integer patientId,
            @RequestParam("distance") Integer distance,
            @RequestParam("operation") Integer operation,
            Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("distance", distance);
        model.addAttribute("operation", operation);
        model.addAttribute("outcome", new OutcomeVO());
        return "patient/outcome/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/outcome/{outcomeId}/edit", method = RequestMethod.GET)
    public String outcomeEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("outcomeId") Integer outcomeId,
            Locale locale, Model model) {

        OutcomeVO outcomeVO=outcomeService.getById(OutcomeVO.class, OutcomeEntity.class, outcomeId);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("outcome", outcomeVO);
        model.addAttribute("distance", outcomeVO.getDistance());
        model.addAttribute("operation", outcomeVO.getOperationId());
        return "patient/outcome/formView";
    }

    /**
     * Adds the outcome.
     *
     * @param outcome   the outcome
     * @param result    the result
     * @param patientID the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/outcome/save", method = RequestMethod.POST)
    public String outcomeSavePOST(
            @ModelAttribute("outcome") @Valid OutcomeVO outcome, BindingResult result,
            @PathVariable("patientId") Integer patientId,
            @RequestParam("distance") Integer distance,
            @RequestParam("operationId") Integer operationId,
            Locale locale, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            model.addAttribute("distance", distance);
            return "patient/outcome/formView";
        } else {
            outcome.setDistance(distance);
            outcome.setPatientId(patientId);
            outcomeService.save(OutcomeEntity.class, outcome);
            return "redirect:/patient/" + patientId + "/outcome/list";
        }
    }
/*
    @RequestMapping(value = "/patient/{patientID}/outcome/{outcomeID}/delete", method = RequestMethod.GET)
    public String outcomeDeleteGET(Locale locale, Model model,
                                   @PathVariable("patientID") Integer patientID,
                                   @PathVariable("outcomeID") Integer outcomeID) {

        outcomeService.delete(outcomeService.findByID(OutcomeEntity.class,outcomeID));
        return "redirect:/patient/" + patientID + "/outcome/list";
    }*/

    /**
     * Handles the GET request to hide outcome.
     *
     * @param patientId   the id of a patient whom we are creating an outcome.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     *//*
    @RequestMapping(value = "/patient/{patientId}/outcome/{outcomeId}/hide", method = RequestMethod.GET)
    public String outcomeHideGET(@PathVariable("patientId") Integer patientId,
                                 @PathVariable("outcomeId") Integer outcomeId, Locale locale,
                                 Model model) {

        //outcomeService.hide(outcomeService.findByID(OutcomeEntity.class, outcomeId));
        return "redirect:/patient/" + patientId + "/outcome/list";
    }*/

    /**
     * Handles the GET request to unhide outcome.
     *
     * @param patientId   the id of a patient whom we are creating an outcome.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     *//*
    @RequestMapping(value = "/patient/{patientId}/outcome/{anamnesisId}/unhide", method = RequestMethod.GET)
    public String outcomeUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("outcomeId") Integer outcomeId, Locale locale,
            Model model) {

        // outcomeService.unhide(outcomeService.findByID(OutcomeEntity.class,outcomeId));
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/outcome/list";
    }*/
/*
    @RequestMapping(value = "/patient/{patientID}/outcome/{outcomeID}/export", method = RequestMethod.GET)
    public String outcomeExportGET(Locale locale, Model model,
                                   @PathVariable("patientID") Integer patientID,
                                   @PathVariable("outcomeID") Integer outcomeID) {
        return "redirect:/patient/" + patientID + "/outcome/list";
    }*/
    @RequestMapping(value = "/patient/{patientId}/outcome/list", method = RequestMethod.GET)
    public String outcomeListGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithOperationWithOutcomeList(patientId));
        /*
        PatientEntity patient = patientService
                .getPatientByIdWithOperationList(patientID);
        model.addAttribute("patient", patient);
        List<OperationEntity> list = patient.getOperationList();
        System.out.println("sss");
        for (Iterator<OperationEntity> i = list.iterator(); i.hasNext(); ) {
            System.out.println("sssIN");
            OperationEntity o = i.next();
            System.out.println(o.getId());
            List<OutcomeEntity> ou = o.getOutcomeList();
            System.out.println(ou.size());
            for (Iterator<OutcomeEntity> j = ou.iterator(); j.hasNext(); ) {
                System.out.println("sssIN2");
                OutcomeEntity out = j.next();
                System.out.println(out.getDistance());
            }

        }
        System.out.println("sss2");*/
        return "patient/outcome/listView";
    }
}
