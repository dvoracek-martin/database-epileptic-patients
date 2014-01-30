package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.SeizureVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureDetailService;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes({"seizure"})
public class SeizureController {

    private PatientService patientService;

    private SeizureService seizureService;

    private SeizureDetailService seizureDetailService;

    @Autowired
    public SeizureController(PatientService patientService,
                             SeizureService seizureService, SeizureDetailService seizureDetailService) {
        this.patientService = patientService;
        this.seizureService = seizureService;
        this.seizureDetailService = seizureDetailService;
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/create", method = RequestMethod.GET)
    public String seizureCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizure", new SeizureVO());
        return "patient/seizure/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/edit", method = RequestMethod.GET)
    public String seizureEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureId") Integer seizureId, Locale locale,
            Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizure", seizureService.getById(SeizureVO.class, SeizureEntity.class, seizureId));

        return "patient/seizure/formView";
    }

    /**
     * Adds the seizure.
     *
     * @param seizure   the seizure
     * @param result    the result
     * @param patientID the patient id
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/seizure/save", method = RequestMethod.POST)
    public String seizureSavePOST(
            @ModelAttribute("seizure") @Valid SeizureVO seizure, BindingResult result,
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("patient", patientService.getPatientByIdWithDoctor(patientId));
            return "patient/seizure/formView";
        } else {
            seizure.setPatientId(patientId);
            seizureService.save(SeizureEntity.class, seizure);
            return "redirect:/patient/" + patientId + "/seizure/list";
        }
    }

    @RequestMapping(value = "/patient/{patientID}/seizure/{seizureID}/delete", method = RequestMethod.GET)
    public String seizureDeleteGET(Locale locale, Model model,
                                   @PathVariable("patientID") Integer patientID,
                                   @PathVariable("seizureID") Integer seizureID) {

		/*seizureService.delete(seizureService.findByID(SeizureEntity.class,
                seizureID));*/
        return "redirect:/patient/" + patientID + "/seizure/list";
    }

    /**
     * Handles the GET request to hide seizure.
     *
     * @param patientId   the id of a patient whom we are creating an seizure.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/hide", method = RequestMethod.GET)
    public String anamnesisDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureId") Integer seizureId, Locale locale,
            Model model) {

        seizureService.hide(seizureId);
        return "redirect:/patient/" + patientId + "/seizure/list";
    }

    /**
     * Handles the GET request to unhide seizure.
     *
     * @param patientId   the id of a patient whom we are creating an seizure.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/unhide", method = RequestMethod.GET)
    public String anamnesisUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureId") Integer seizureId, Locale locale,
            Model model) {

        seizureService.unhide(seizureId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/seizure/list";
    }

    @RequestMapping(value = "/patient/{patientID}/seizure/{seizureID}/export", method = RequestMethod.GET)
    public String seizureExportGET(Locale locale, Model model,
                                   @PathVariable("patientID") Integer patientID,
                                   @PathVariable("seizureID") Integer seizureID) {
        return "redirect:/patient/" + patientID + "/seizure/list";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/list", method = RequestMethod.GET)
    public String seizureListGET(Locale locale, Model model,
                                 @PathVariable("patientId") Integer patientId) {

        PatientDisplayVO patient = patientService
                .getPatientDisplayByIdWithSeizureList(patientId);
        model.addAttribute("patient", patient);

       /* PatientEntity patient = patientService
                .getPatientByIdWithSeizureList(patientID);
        model.addAttribute("patient", patient);*/
        return "patient/seizure/listView";
    }
}
