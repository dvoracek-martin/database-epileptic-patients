package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.NeurologicalFindingVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.NeurologicalFindingService;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.card.NeurologicalFindingDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes({"neurologicalFinding"})
public class NeurologicalFindingController {

    private PatientService patientService;

    private NeurologicalFindingService neurologicalFindingService;

    @Autowired
    public NeurologicalFindingController(PatientService patientService,
                                         NeurologicalFindingService neurologicalFindingService) {
        this.patientService = patientService;
        this.neurologicalFindingService = neurologicalFindingService;
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/create", method = RequestMethod.GET)
    public String neurologicalFindingCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neurologicalFinding", new NeurologicalFindingVO());
        return "patient/neurologicalFinding/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/{neurologicalFindingId}/edit", method = RequestMethod.GET)
    public String neurologicalFindingEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("neurologicalFindingId") Integer neurologicalFindingId,
            Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neurologicalFinding", neurologicalFindingService.getById(NeurologicalFindingVO.class,NeurologicalFindingEntity.class, neurologicalFindingId));
        return "patient/neurologicalFinding/formView";
    }

    /**
     * Adds the neurologicalFinding.
     *
     * @param neurologicalFinding the neurologicalFinding
     * @param result              the result
     * @param patientId           the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/neurological-finding/save", method = RequestMethod.POST)
    public String neurologicalFindingSavePOST(
            @ModelAttribute("neurologicalFinding") @Valid NeurologicalFindingVO neurologicalFinding,
            @PathVariable("patientId") Integer patientId,
            BindingResult result, Locale locale, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/neurologicalFinding/formView";
        } else {
            neurologicalFinding.setPatientId(patientId);
            neurologicalFindingService.save(NeurologicalFindingEntity.class, neurologicalFinding);
            return "redirect:/patient/" + patientId + "/neurological-finding/list";
        }
    }

    @RequestMapping(value = "/patient/{patientID}/neurological-finding/{neurologicalFindingID}/delete", method = RequestMethod.GET)
    public String neurologicalFindingDeleteGET(
            @PathVariable("patientID") Integer patientID,
            @PathVariable("neurologicalFindingID") Integer neurologicalFindingID, Locale locale, Model model) {

        /*neurologicalFindingService.delete(neurologicalFindingService.findByID(
                NeurologicalFindingVO.class, neurologicalFindingID));*/
        return "redirect:/patient/" + patientID + "/neurological-finding/list";
    }

    /**
     * Handles the GET request to hide neurologicalFinding.
     *
     * @param patientId             the id of a patient whom we are creating an
     *                              neurologicalFinding.
     * @param neurologicalFindingId
     * @param locale                the user's locale.
     * @param model                 the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neurological-finding/{neurologicalFindingId}/hide", method = RequestMethod.GET)
    public String neurologicalFindingHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("neurologicalFindingId") Integer neurologicalFindingId,
            Locale locale, Model model) {

        neurologicalFindingService.hide(neurologicalFindingId);
        return "redirect:/patient/" + patientId + "/neurological-finding/list";
    }

    /**
     * Handles the GET request to unhide neurologicalFinding.
     *
     * @param patientId             the id of a patient whom we are creating an
     *                              neurologicalFinding.
     * @param neurologicalFindingId
     * @param locale                the user's locale.
     * @param model                 the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neurological-finding/{anamnesisId}/unhide", method = RequestMethod.GET)
    public String neurologicalFindingGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("neurologicalFindingId") Integer neurologicalFindingId,
            Locale locale, Model model) {

        neurologicalFindingService.unhide(neurologicalFindingId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/neurological-finding/list";
    }

    /*@RequestMapping(value = "/patient/{patientID}/neurological-finding/{neurologicalFindingID}/export", method = RequestMethod.GET)
    public String neurologicalFindingExportGET(Locale locale, Model model,
                                               @PathVariable("patientID") Integer patientID,
                                               @PathVariable("neurologicalFindingID") Integer neurologicalFindingID) {

        return "redirect:/patient/" + patientID + "/neurological-finding/list";
    }*/

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/list", method = RequestMethod.GET)
    public String neurologicalFindingListGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithNeurologicalFindingList(patientId));
        return "patient/neurologicalFinding/listView";
    }
}
