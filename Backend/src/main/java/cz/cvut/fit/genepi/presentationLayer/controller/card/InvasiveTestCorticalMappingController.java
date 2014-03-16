package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.InvasiveTestCorticalMappingVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestCorticalMappingService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestCorticalMappingEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class InvasiveTestCorticalMappingController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    /**
     * The patient service.
     */
    private PatientService patientService;

    private InvasiveTestCorticalMappingService invasiveTestCorticalMappingService;


    /**
     * Constructor which serves to autowire services.
     *
     * @param patientService                     the patientService to be autowired.
     * @param invasiveTestCorticalMappingService the invasiveTestCorticalMappingService to be autowired.
     */
    @Autowired
    public InvasiveTestCorticalMappingController(PatientService patientService,
                                                 InvasiveTestCorticalMappingService invasiveTestCorticalMappingService) {

        this.patientService = patientService;
        this.invasiveTestCorticalMappingService = invasiveTestCorticalMappingService;
    }

    /**
     * Handles the GET request to access page for creating new
     * invasiveTestCorticalMapping.
     *
     * @param patientId the id of a patient whom we are creating an
     *                  invasiveTestCorticalMapping.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/create", method = RequestMethod.GET)
    public String invasiveTestCorticalMappingCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("invasiveTestCorticalMapping", new InvasiveTestCorticalMappingVO());
        return "patient/invasiveTestCorticalMapping/formView";
    }

    /**
     * Handles the GET request to access page for editing
     * invasiveTestCorticalMapping.
     *
     * @param patientId the id of a patient whom we are editing an
     *                  invasiveTestCorticalMapping.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/{invasiveTestCorticalMappingId}/edit", method = RequestMethod.GET)
    public String invasiveTestCorticalMappingEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestCorticalMappingId") int invasiveTestCorticalMappingId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("invasiveTestCorticalMapping", invasiveTestCorticalMappingService.getById(invasiveTestCorticalMappingId, InvasiveTestCorticalMappingVO.class, InvasiveTestCorticalMappingEntity.class));
        return "patient/invasiveTestCorticalMapping/formView";
    }

    /**
     * Handles the POST request to create new invasiveTestCorticalMapping.
     * front-end. It is grabbed from POST string and validated.
     *
     * @param result    the result of binding form from front-end to an
     *                  AnamnesisEntity. It is used to determine if there were some
     *                  errors during binding.
     * @param patientId the id of a patient whom we are creating an
     *                  invasiveTestCorticalMapping.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered if the binding has errors
     * otherwise, the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/save", method = RequestMethod.POST)
    public String invasiveTestCorticalMappingSavePOST(
            @ModelAttribute("invasiveTestCorticalMapping") @Valid InvasiveTestCorticalMappingVO invasiveTestCorticalMapping, BindingResult result,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), invasiveTestCorticalMapping.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/invasiveTestCorticalMapping/formView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            invasiveTestCorticalMappingService.save(invasiveTestCorticalMapping, InvasiveTestCorticalMappingEntity.class);
            return "redirect:/patient/" + patientId + "/invasive-test-cortical-mapping/list";
        }
    }

    /**
     * Handles the GET request to hide invasiveTestCorticalMapping.
     *
     * @param patientId the id of a patient whom we are creating an
     *                  invasiveTestCorticalMapping.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/{invasiveTestCorticalMappingId}/hide", method = RequestMethod.GET)
    public String invasiveTestCorticalMappingHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestCorticalMappingId") int invasiveTestCorticalMappingId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        invasiveTestCorticalMappingService.hide(invasiveTestCorticalMappingId, InvasiveTestCorticalMappingEntity.class);
        return "redirect:/patient/" + patientId + "/invasive-test-cortical-mapping/list";
    }

    /**
     * Handles the GET request to unhide invasiveTestCorticalMapping.
     *
     * @param patientId the id of a patient whom we are creating an
     *                  invasiveTestCorticalMapping.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/{invasiveTestCorticalMappingId}/unhide", method = RequestMethod.GET)
    public String invasiveTestCorticalMappingUnhideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestCorticalMappingId") int invasiveTestCorticalMappingId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        invasiveTestCorticalMappingService.unhide(invasiveTestCorticalMappingId, InvasiveTestCorticalMappingEntity.class);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/invasive-test-cortical-mapping/list";
    }

    /**
     * Handles the GET request to access page for listing anamnesis.
     *
     * @param patientId the id of a patient whose anamnesis we are listing.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/list", method = RequestMethod.GET)
    public String invasiveTestCorticalMappingListGET(
            @PathVariable("patientId") Integer patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithInvasiveTestCorticalMappingList(patientId);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/invasiveTestCorticalMapping/listView";
    }
}
