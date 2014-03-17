package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.NeurologicalFindingDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.NeurologicalFindingVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.NeurologicalFindingService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"neurologicalFinding"})
public class NeurologicalFindingController {

    private AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private NeurologicalFindingService neurologicalFindingService;

    @Autowired
    public NeurologicalFindingController(AuthorizationChecker authorizationChecker,
                                         PatientService patientService,
                                         NeurologicalFindingService neurologicalFindingService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.neurologicalFindingService = neurologicalFindingService;
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/create", method = RequestMethod.GET)
    public String neurologicalFindingCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neurologicalFinding", new NeurologicalFindingVO());
        return "patient/neurologicalFinding/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/create", method = RequestMethod.POST)
    public String neurologicalFindingCreatePOST(
            @ModelAttribute("neurologicalFinding") @Valid NeurologicalFindingVO neurologicalFinding, BindingResult result,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), neurologicalFinding.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/neurologicalFinding/createView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            neurologicalFindingService.save(neurologicalFinding, NeurologicalFindingEntity.class);
            return "redirect:/patient/" + patientId + "/neurological-finding/list";
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
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        NeurologicalFindingVO vo = neurologicalFindingService.getById(neurologicalFindingId, NeurologicalFindingVO.class, NeurologicalFindingEntity.class);
        model.addAttribute("neurologicalFinding", vo);
        return "patient/neurologicalFinding/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/{neurologicalFindingId}/edit", method = RequestMethod.POST)
    public String neurologicalFindingEditPOST(
            @ModelAttribute("neurologicalFinding") @Valid NeurologicalFindingVO neurologicalFinding, BindingResult result,
            @PathVariable("patientId") int patientId,
            @PathVariable("neurologicalFindingId") int neurologicalFindingId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), neurologicalFinding.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/neurologicalFinding/editView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            neurologicalFindingService.makeHistory(neurologicalFindingId, NeurologicalFindingEntity.class);
            neurologicalFinding.setId(0);
            neurologicalFindingService.save(neurologicalFinding, NeurologicalFindingEntity.class);
            return "redirect:/patient/" + patientId + "/neurological-finding/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/{neurologicalFindingId}/delete", method = RequestMethod.GET)
    public String neurologicalFindingDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neurologicalFindingId") int neurologicalFindingId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        neurologicalFindingService.delete(neurologicalFindingId, NeurologicalFindingEntity.class);
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
        neurologicalFindingService.hide(neurologicalFindingId, NeurologicalFindingEntity.class);
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
        neurologicalFindingService.unhide(neurologicalFindingId, NeurologicalFindingEntity.class);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/neurological-finding/list";
    }

    @RequestMapping(value = "/patient/{patientId}/neurological-finding/list", method = RequestMethod.GET)
    public String neurologicalFindingListGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<NeurologicalFindingDisplayVO> neurologicalFindingDisplayVO = neurologicalFindingService.getRecordsByPatientId(patientId, NeurologicalFindingDisplayVO.class, NeurologicalFindingEntity.class);
        model.addAttribute("neurologicalFindingList", neurologicalFindingDisplayVO);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("patient", patient);
        return "patient/neurologicalFinding/listView";
    }
}