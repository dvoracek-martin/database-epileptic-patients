package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.InvasiveTestEcogVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestEcogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes({"invasiveTestEcog"})
public class InvasiveTestEcogController {

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
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("invasiveTestEcog", new InvasiveTestEcogVO());
        return "patient/invasiveTestEcog/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-ecog/{invasiveTestEcogId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("invasiveTestEcogId") Integer invasiveTestEcogId,
            Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("invasiveTestEcog", invasiveTestEcogService.getById(InvasiveTestEcogVO.class, invasiveTestEcogId));
        return "patient/invasiveTestEcog/formView";
    }

    /**
     * Adds the invasiveTestECOG.
     *
     * @param invasiveTestECOG the invasiveTestECOG
     * @param result           the result
     * @param patientID        the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-ecog/save", method = RequestMethod.POST)
    public String invasiveTestEcogSavePOST(
            @ModelAttribute("invasiveTestEcog") @Valid InvasiveTestEcogVO invasiveTestEcog,
            @PathVariable("patientId") Integer patientId,
            BindingResult result, Locale locale, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/invasiveTestEcog/formView";
        } else {
            invasiveTestEcog.setPatientId(patientId);
            invasiveTestEcogService.save(invasiveTestEcog);
            return "redirect:/patient/" + patientId + "/invasive-test-ecog/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-ecog/{invasiveTestEcogId}/delete", method = RequestMethod.GET)
    public String invasiveTestEcogDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("invasiveTestEcogId") Integer invasiveTestEcogId,
            Locale locale, Model model) {

        invasiveTestEcogService.delete(invasiveTestEcogId);
        return "redirect:/patient/" + patientId + "/invasive-test-ecog/list";
    }

    /**
     * Handles the GET request to hide invasiveTestEcog.
     *
     * @param patientId   the id of a patient whom we are creating an invasiveTestEcog.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-ecog/{invasiveTestEcogId}/hide", method = RequestMethod.GET)
    public String invasiveTestEcogHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("invasiveTestEcogId") Integer invasiveTestEcogId,
            Locale locale, Model model) {

        invasiveTestEcogService.hide(invasiveTestEcogId);
        return "redirect:/patient/" + patientId + "/invasive-test-ecog/list";
    }

    /**
     * Handles the GET request to unhide invasiveTestEcog.
     *
     * @param patientId   the id of a patient whom we are creating an invasiveTestEcog.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-ecog/{invasiveTestEcogId}/unhide", method = RequestMethod.GET)
    public String invasiveTestEcogUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("invasiveTestEcogId") Integer invasiveTestEcogId,
            Locale locale, Model model) {

        invasiveTestEcogService.unhide(invasiveTestEcogId);
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
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithInvasiveTestEcogList(patientId));
        return "patient/invasiveTestEcog/listView";
    }
}
