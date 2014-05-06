package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.card.NeuropsychologyDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.NeuropsychologyFormBO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;
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
@SessionAttributes({"neuropsychology", "patient"})
public class NeuropsychologyController {

    private final AuthorizationChecker authorizationChecker;

    private final PatientService patientService;

    private final GenericCardService<NeuropsychologyDisplayBO, NeuropsychologyFormBO, NeuropsychologyEntity> genericCardService;

    @Autowired
    public NeuropsychologyController(AuthorizationChecker authorizationChecker,
                                     PatientService patientService,
                                     @Qualifier("genericCardServiceImpl")
                                     GenericCardService<NeuropsychologyDisplayBO, NeuropsychologyFormBO, NeuropsychologyEntity> genericCardService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.genericCardService = genericCardService;
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/create", method = RequestMethod.GET)
    public String neuropsychologyCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neuropsychology", new NeuropsychologyFormBO());
        return "patient/neuropsychology/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/create", method = RequestMethod.POST)
    public String neuropsychologyCreatePOST(
            @ModelAttribute("neuropsychology") @Valid NeuropsychologyFormBO neuropsychology, BindingResult result,
            @ModelAttribute("patient") PatientDisplayBO patientDisplayBO,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayBO.getBirthday(), neuropsychology.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/neuropsychology/createView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.save(neuropsychology, NeuropsychologyEntity.class);
                return "redirect:/patient/" + patientId + "/neuropsychology/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/edit", method = RequestMethod.GET)
    public String neuropsychologyEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyId") int neuropsychologyId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neuropsychology", genericCardService.getById(neuropsychologyId, NeuropsychologyFormBO.class, NeuropsychologyEntity.class));
        return "patient/neuropsychology/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/edit", method = RequestMethod.POST)
    public String neuropsychologySavePOST(
            @ModelAttribute("neuropsychology") @Valid NeuropsychologyFormBO neuropsychology, BindingResult result,
            @ModelAttribute("patient") PatientDisplayBO patientDisplayBO,
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyId") int neuropsychologyId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayBO.getBirthday(), neuropsychology.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/neuropsychology/editView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.makeHistory(neuropsychologyId, NeuropsychologyEntity.class);
                neuropsychology.setId(0);
                genericCardService.save(neuropsychology, NeuropsychologyEntity.class);
                return "redirect:/patient/" + patientId + "/neuropsychology/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/delete", method = RequestMethod.GET)
    public String neuropsychologyDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyId") int neuropsychologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.delete(neuropsychologyId, NeuropsychologyEntity.class);
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    /**
     * Handles the GET request to hide neuropsychology.
     *
     * @param patientId the id of a patient whom we are creating an neuropsychology.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/hide", method = RequestMethod.GET)
    public String neuropsychologyHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyId") int neuropsychologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.hide(neuropsychologyId, NeuropsychologyEntity.class);
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    /**
     * Handles the GET request to unhide neuropsychology.
     *
     * @param patientId the id of a patient whom we are creating an neuropsychology.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/unhide", method = RequestMethod.GET)
    public String neuropsychologyUnhideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyId") int neuropsychologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.unhide(neuropsychologyId, NeuropsychologyEntity.class);
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/list", method = RequestMethod.GET)
    public String neuropsychologyListGET(
            @PathVariable("patientId") Integer patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayBO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<NeuropsychologyDisplayBO> neuropsychologyDisplayBOList = genericCardService.getRecordsByPatientId(patientId, NeuropsychologyDisplayBO.class, NeuropsychologyEntity.class);
        model.addAttribute("neuropsychologyDisplayBOList", neuropsychologyDisplayBOList);
        model.addAttribute("patient", patient);
        return "patient/neuropsychology/listView";
    }
}
