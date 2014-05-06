package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.card.NeurologicalFindingDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.NeurologicalFindingFormBO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"neurologicalFinding", "patient"})
public class NeurologicalFindingController {

    private final AuthorizationChecker authorizationChecker;

    private final PatientService patientService;

    private final GenericCardService<NeurologicalFindingDisplayBO, NeurologicalFindingFormBO, NeurologicalFindingEntity> genericCardService;

    @Autowired
    public NeurologicalFindingController(AuthorizationChecker authorizationChecker,
                                         PatientService patientService,
                                         @Qualifier("genericCardServiceImpl")
                                         GenericCardService<NeurologicalFindingDisplayBO, NeurologicalFindingFormBO, NeurologicalFindingEntity> genericCardService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.genericCardService = genericCardService;
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/create", method = RequestMethod.GET)
    public String neurologicalFindingCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neurologicalFinding", new NeurologicalFindingFormBO());
        return "patient/neurologicalFinding/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/create", method = RequestMethod.POST)
    public String neurologicalFindingCreatePOST(
            @ModelAttribute("neurologicalFinding") @Valid NeurologicalFindingFormBO neurologicalFinding, BindingResult result,
            @ModelAttribute("patient") PatientDisplayBO patientDisplayBO,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayBO.getBirthday(), neurologicalFinding.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/neurologicalFinding/createView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.save(neurologicalFinding, NeurologicalFindingEntity.class);
                return "redirect:/patient/" + patientId + "/neurological-finding/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/{neurologicalFindingId}/edit", method = RequestMethod.GET)
    public String neurologicalFindingEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neurologicalFindingId") int neurologicalFindingId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        NeurologicalFindingFormBO vo = genericCardService.getById(neurologicalFindingId, NeurologicalFindingFormBO.class, NeurologicalFindingEntity.class);
        model.addAttribute("neurologicalFinding", vo);
        return "patient/neurologicalFinding/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/{neurologicalFindingId}/edit", method = RequestMethod.POST)
    public String neurologicalFindingEditPOST(
            @ModelAttribute("neurologicalFinding") @Valid NeurologicalFindingFormBO neurologicalFinding, BindingResult result,
            @ModelAttribute("patient") PatientDisplayBO patientDisplayBO,
            @PathVariable("patientId") int patientId,
            @PathVariable("neurologicalFindingId") int neurologicalFindingId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayBO.getBirthday(), neurologicalFinding.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/neurologicalFinding/editView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.makeHistory(neurologicalFindingId, NeurologicalFindingEntity.class);
                neurologicalFinding.setId(0);
                genericCardService.save(neurologicalFinding, NeurologicalFindingEntity.class);
                return "redirect:/patient/" + patientId + "/neurological-finding/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/{neurologicalFindingId}/delete", method = RequestMethod.GET)
    public String neurologicalFindingDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neurologicalFindingId") int neurologicalFindingId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.delete(neurologicalFindingId, NeurologicalFindingEntity.class);
        return "redirect:/patient/" + patientId + "/neurological-finding/list";
    }

    /**
     * Handles the GET request to hide neurologicalFinding.
     *
     * @param patientId the id of a patient whom we are creating an
     *                  neurologicalFinding.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neurological-finding/{neurologicalFindingId}/hide", method = RequestMethod.GET)
    public String neurologicalFindingHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neurologicalFindingId") int neurologicalFindingId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.hide(neurologicalFindingId, NeurologicalFindingEntity.class);
        return "redirect:/patient/" + patientId + "/neurological-finding/list";
    }

    /**
     * Handles the GET request to unhide neurologicalFinding.
     *
     * @param patientId the id of a patient whom we are creating an
     *                  neurologicalFinding.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neurological-finding/{neurologicalFindingId}/unhide", method = RequestMethod.GET)
    public String neurologicalFindingGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neurologicalFindingId") int neurologicalFindingId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.unhide(neurologicalFindingId, NeurologicalFindingEntity.class);
        return "redirect:/patient/" + patientId + "/neurological-finding/list";
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/list", method = RequestMethod.GET)
    public String neurologicalFindingListGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayBO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<NeurologicalFindingDisplayBO> neurologicalFindingDisplayBO = genericCardService.getRecordsByPatientId(patientId, NeurologicalFindingDisplayBO.class, NeurologicalFindingEntity.class);
        model.addAttribute("neurologicalFindingDisplayBOList", neurologicalFindingDisplayBO);
        model.addAttribute("patient", patient);
        return "patient/neurologicalFinding/listView";
    }
}
