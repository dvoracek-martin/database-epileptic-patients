package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.AnamnesisService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

/**
 * This class is a controller class which handles requests connected with
 * anamnesis.
 */
@Controller
@SessionAttributes({"anamnesis"})
public class AnamnesisController {

    /**
     * The patient service.
     */
    private PatientService patientService;

    /**
     * The anamnesis service.
     */
    private AnamnesisService anamnesisService;

    /**
     * Constructor which serves to autowire services.
     *
     * @param patientService   the patientService to be autowired.
     * @param anamnesisService the anamnesisService to be autowired.
     */
    @Autowired
    public AnamnesisController(PatientService patientService,
                               AnamnesisService anamnesisService) {
        this.patientService = patientService;
        this.anamnesisService = anamnesisService;
    }

    /**
     * Handles the GET request to access page for creating new anamnesis.
     *
     * @param patientId the id of a patient whom we are creating an anamnesis.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/create", method = RequestMethod.GET)
    public String anamnesisCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale,
            Model model) {

        model.addAttribute("patient",
                patientService.getPatientByIdWithDoctor(patientId));
        model.addAttribute("anamnesis", new AnamnesisEntity());
        return "patient/anamnesis/createView";
    }

    /**
     * Handles the POST request to create new anamnesis.
     *
     * @param anamnesis the anamnesis which was filled in form at front-end. It is
     *                  grabbed from POST string and validated.
     * @param result    the result of binding form from front-end to an
     *                  AnamnesisEntity. It is used to determine if there were some
     *                  errors during binding.
     * @param patientId the id of a patient whom we are creating an anamnesis.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered if the binding has errors
     * otherwise, the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/create", method = RequestMethod.POST)
    public String anamnesisCreatePOST(
            @ModelAttribute("anamnesis") @Valid AnamnesisEntity anamnesis,
            BindingResult result, @PathVariable("patientId") Integer patientId,
            Locale locale, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("patient",
                    patientService.getPatientByIdWithDoctor(patientId));
            return "patient/anamnesis/createView";
        } else {
            anamnesis.setPatient(patientService.findByID(PatientEntity.class,
                    patientId));
            anamnesisService.save(anamnesis);
            return "redirect:/patient/" + patientId + "/anamnesis/list";
        }
    }

    @RequestMapping(value = "/patient/{patientID}/anamnesis/{anamnesisId}/delete", method = RequestMethod.GET)
    public String anamnesisDeleteGET(
            @PathVariable("patientID") Integer patientID,
            @PathVariable("anamnesisId") Integer anamnesisId, Locale locale,
            Model model) {

        anamnesisService.delete(anamnesisService.findByID(
                AnamnesisEntity.class, anamnesisId));
        return "redirect:/hidden";
    }

    /**
     * Handles the GET request to access page for editing anamnesis.
     *
     * @param patientId the id of a patient whom we are editing an anamnesis.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/{anamnesisId}/edit", method = RequestMethod.GET)
    public String anamnesisEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("anamnesisId") Integer anamnesisId, Locale locale,
            Model model) {

        model.addAttribute("patient",
                patientService.getPatientByIdWithDoctor(patientId));
        model.addAttribute("anamnesis",
                anamnesisService.findByID(AnamnesisEntity.class, anamnesisId));
        return "patient/anamnesis/editView";
    }

    /**
     * Handles the POST request to edit anamnesis.
     *
     * @param anamnesis the anamnesis which was filled in form at front-end. It is
     *                  grabbed from POST string and validated.
     * @param result    the result of binding form from front-end to an
     *                  AnamnesisEntity. It is used to determine if there were some
     *                  errors during binding.
     * @param patientId the id of a patient whom we are creating an anamnesis.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered if the binding has errors
     * otherwise, the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/{anamnesisId}/edit", method = RequestMethod.POST)
    public String anamnesisEditPOST(
            @ModelAttribute("anamnesis") @Valid AnamnesisEntity anamnesis,
            BindingResult result, @PathVariable("patientId") Integer patientId,
            Locale locale, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("patient",
                    patientService.getPatientByIdWithDoctor(patientId));
            return "patient/anamnesis/editView";
        } else {
            anamnesis.setPatient(patientService.findByID(PatientEntity.class,
                    patientId));
            anamnesisService.save(anamnesis);
            return "redirect:/patient/" + patientId + "/anamnesis/list";
        }
    }

    /**
     * Handles the GET request to hide anamnesis.
     *
     * @param patientId   the id of a patient whom we are creating an anamnesis.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/{anamnesisId}/hide", method = RequestMethod.GET)
    public String anamnesisHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("anamnesisId") Integer anamnesisId, Locale locale,
            Model model) {

        anamnesisService.hide(anamnesisService.findByID(AnamnesisEntity.class,
                anamnesisId));
        return "redirect:/patient/" + patientId + "/anamnesis/list";
    }

    /**
     * Handles the GET request to unhide anamnesis.
     *
     * @param patientId   the id of a patient whom we are creating an anamnesis.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/{anamnesisId}/unhide", method = RequestMethod.GET)
    public String anamnesisUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("anamnesisId") Integer anamnesisId, Locale locale,
            Model model) {

        anamnesisService.unhide(anamnesisService.findByID(
                AnamnesisEntity.class, anamnesisId));
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/hidden";
    }

    // TODO: not used now, is not present in original App
    /*
	 * @RequestMapping(value =
	 * "/patient/{patientID}/anamnesis/{anamnesisID}/export", method =
	 * RequestMethod.GET) public String anamnesisExportGET(Locale locale, Model
	 * model,
	 * 
	 * @PathVariable("patientID") Integer patientID,
	 * 
	 * @PathVariable("anamnesisID") Integer anamnesisID) { return
	 * "redirect:/patient/" + patientID + "/anamnesis/list"; }
	 */

    /**
     * Handles the GET request to access page for listing anamnesis.
     *
     * @param patientId the id of a patient whose anamnesis we are listing.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/list", method = RequestMethod.GET)
    public String anamnesisListGET(
            @PathVariable("patientId") Integer patientId, Locale locale,
            Model model) {
        model.addAttribute("patient",
                patientService.getPatientByIdWithAnamnesisList(patientId));
        return "patient/anamnesis/listView";
    }
}