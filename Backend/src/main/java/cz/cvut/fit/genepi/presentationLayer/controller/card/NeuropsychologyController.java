package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.NeuropsychologyVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;
import cz.cvut.fit.genepi.util.AuthorizationChecker;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes({"neuropsychology"})
public class NeuropsychologyController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private NeuropsychologyService neuropsychologyService;

    private UserService userService;

    @Autowired
    public NeuropsychologyController(PatientService patientService,
                                     NeuropsychologyService neuropsychologyService) {

        this.patientService = patientService;
        this.neuropsychologyService = neuropsychologyService;
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/create", method = RequestMethod.GET)
    public String neuropsychologyCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neuropsychology", new NeuropsychologyVO());
        return "patient/neuropsychology/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/edit", method = RequestMethod.GET)
    public String neuropsychologyEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("neuropsychologyId") Integer neuropsychologyId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neuropsychology", neuropsychologyService.getById(NeuropsychologyVO.class, NeuropsychologyEntity.class, neuropsychologyId));
        return "patient/neuropsychology/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/save", method = RequestMethod.POST)
    public String neuropsychologySavePOST(
            @ModelAttribute("neuropsychology") @Valid NeuropsychologyVO neuropsychology, BindingResult result,
            @PathVariable("patientId") Integer patientId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), neuropsychology.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/neuropsychology/formView";
        } else {
            Authentication auth = SecurityContextHolder.getContext()
                    .getAuthentication();
            List<GrantedAuthority> roles = (List<GrantedAuthority>) auth.getAuthorities();
            boolean isSuperdoctor = false;
            for (GrantedAuthority r : roles) {
                if (r.getAuthority().equals("ROLE_SUPER_DOCTOR")) {
                    isSuperdoctor = true;
                    break;
                }
            }
            if (!isSuperdoctor)
                patientService.findByID(PatientEntity.class, patientId).setVerified(false);
            neuropsychology.setPatientId(patientId);
            neuropsychologyService.save(NeuropsychologyEntity.class, neuropsychology);
            return "redirect:/patient/" + patientId + "/neuropsychology/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/delete", method = RequestMethod.GET)
    public String neuropsychologyDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("neuropsychologyId") Integer neuropsychologyId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        neuropsychologyService.delete(NeuropsychologyEntity.class, neuropsychologyId);
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    /**
     * Handles the GET request to hide neuropsychology.
     *
     * @param patientId the id of a patient whom we are creating an neuropsychology.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{anamnesisId}/hide", method = RequestMethod.GET)
    public String neuropsychologyHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("neuropsychologyId") Integer neuropsychologyId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        neuropsychologyService.hide(neuropsychologyId);
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    /**
     * Handles the GET request to unhide neuropsychology.
     *
     * @param patientId the id of a patient whom we are creating an neuropsychology.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/unhide", method = RequestMethod.GET)
    public String neuropsychologyUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("neuropsychologyId") Integer neuropsychologyId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        neuropsychologyService.unhide(neuropsychologyId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    /*@RequestMapping(value = "/patient/{patientID}/neuropsychology/{neuropsychologyID}/export", method = RequestMethod.GET)
    public String neuropsychologyExportGET(Locale locale, Model model,
                                           @PathVariable("patientID") Integer patientID,
                                           @PathVariable("neuropsychologyID") Integer neuropsychologyID) {
        return "redirect:/patient/" + patientID + "/neuropsychology/list";
    }*/

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/list", method = RequestMethod.GET)
    public String neuropsychologyListGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
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