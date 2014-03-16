package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.AnamnesisVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.AnamnesisService;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * This class is a controller class which handles requests connected with
 * anamnesis.
 */
@Controller
@SessionAttributes({"anamnesis"})
public class AnamnesisController {

    @Autowired
    AuthorizationChecker authorizationChecker;

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
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/create", method = RequestMethod.GET)
    public String anamnesisCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithAnamnesisList(patientId);

        model.addAttribute("patient", patient);
        if (patient.getAnamnesisList().size() == 0) {
            model.addAttribute("anamnesis", new AnamnesisVO());
            return "patient/anamnesis/formView";
        } else if (patient.getAnamnesisList().size() > 0) {
            return "redirect:/patient/" + patientId + "/anamnesis/list";
        } else {
            return null; // exception
        }

    }

    /**
     * Handles the GET request to access page for editing anamnesis.
     *
     * @param patientId the id of a patient whom we are editing an anamnesis.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/{anamnesisId}/edit", method = RequestMethod.GET)
    public String anamnesisEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("anamnesisId") Integer anamnesisId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("anamnesis", anamnesisService.getById(anamnesisId, AnamnesisVO.class, AnamnesisEntity.class));
        return "patient/anamnesis/formView";
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
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered if the binding has errors
     * otherwise, the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/save", method = RequestMethod.POST)
    public String anamnesisSavePOST(
            @ModelAttribute("anamnesis") @Valid AnamnesisVO anamnesis, BindingResult result,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), anamnesis.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/anamnesis/formView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            anamnesisService.save(anamnesis, AnamnesisEntity.class);
            return "redirect:/patient/" + patientId + "/anamnesis/list";
        }
    }

  /*  @RequestMapping(value = "/patient/{patientID}/anamnesis/{anamnesisId}/delete", method = RequestMethod.GET)
    public String anamnesisDeleteGET(
            @PathVariable("patientID") Integer patientID,
            @PathVariable("anamnesisId") Integer anamnesisId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        anamnesisService.delete(AnamnesisEntity.class, anamnesisId);
        return "redirect:/hidden";
    }*/

    /**
     * Handles the GET request to hide anamnesis.
     *
     * @param patientId   the id of a patient whom we are creating an anamnesis.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
   /* @RequestMapping(value = "/patient/{patientId}/anamnesis/{anamnesisId}/hide", method = RequestMethod.GET)
    public String anamnesisHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("anamnesisId") Integer anamnesisId, Locale locale,
            Model model) {

        anamnesisService.hide(anamnesisId);
        return "redirect:/patient/" + patientId + "/anamnesis/list";
    }*/

    /**
     * Handles the GET request to unhide anamnesis.
     *
     * @param patientId   the id of a patient whom we are creating an anamnesis.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
   /* @RequestMapping(value = "/patient/{patientId}/anamnesis/{anamnesisId}/unhide", method = RequestMethod.GET)
    public String anamnesisUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("anamnesisId") Integer anamnesisId, Locale locale,
            Model model) {

        anamnesisService.unhide(anamnesisId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/hidden";
    }*/

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
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/anamnesis/list", method = RequestMethod.GET)
    public String anamnesisListGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithAnamnesisList(patientId);
        if (patient.getAnamnesisList().size() == 0) {
            model.addAttribute("displayAnamnesisCreate", true);
        } else {
            model.addAttribute("displayAnamnesisCreate", false);
        }
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/anamnesis/listView";
    }
}
