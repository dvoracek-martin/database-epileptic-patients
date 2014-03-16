package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.NeuropsychologyVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes({"neuropsychology"})
public class NeuropsychologyController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private NeuropsychologyService neuropsychologyService;


    @Autowired
    public NeuropsychologyController(PatientService patientService,
                                     NeuropsychologyService neuropsychologyService) {

        this.patientService = patientService;
        this.neuropsychologyService = neuropsychologyService;
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/create", method = RequestMethod.GET)
    public String neuropsychologyCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neuropsychology", new NeuropsychologyVO());
        return "patient/neuropsychology/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/edit", method = RequestMethod.GET)
    public String neuropsychologyEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyId") int neuropsychologyId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neuropsychology", neuropsychologyService.getById(neuropsychologyId, NeuropsychologyVO.class, NeuropsychologyEntity.class));
        return "patient/neuropsychology/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/save", method = RequestMethod.POST)
    public String neuropsychologySavePOST(
            @ModelAttribute("neuropsychology") @Valid NeuropsychologyVO neuropsychology, BindingResult result,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), neuropsychology.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/neuropsychology/formView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            neuropsychologyService.save(neuropsychology, NeuropsychologyEntity.class);
            return "redirect:/patient/" + patientId + "/neuropsychology/list";
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
        neuropsychologyService.delete(neuropsychologyId, NeuropsychologyEntity.class);
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
        neuropsychologyService.hide(neuropsychologyId, NeuropsychologyEntity.class);
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
        neuropsychologyService.unhide(neuropsychologyId, NeuropsychologyEntity.class);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/list", method = RequestMethod.GET)
    public String neuropsychologyListGET(
            @PathVariable("patientId") Integer patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithNeuropsychologyList(patientId);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/neuropsychology/listView";
    }
}
