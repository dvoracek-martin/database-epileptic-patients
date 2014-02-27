package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.InvasiveTestEegVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestEegService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEegEntity;
import cz.cvut.fit.genepi.util.AuthorizationChecker;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
public class InvasiveTestEegController {

    private PatientService patientService;

    private InvasiveTestEegService invasiveTestEegService;

    private UserService userService;

    @Autowired
    public InvasiveTestEegController(PatientService patientService,
                                     InvasiveTestEegService invasiveTestEegService) {

        this.patientService = patientService;
        this.invasiveTestEegService = invasiveTestEegService;
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/create", method = RequestMethod.GET)
    public String invasiveTestEegCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("invasiveTestEeg", new InvasiveTestEegVO());
        return "patient/invasiveTestEeg/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/{invasiveTestEegId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("invasiveTestEegId") Integer invasiveTestEegId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("invasiveTestEeg", invasiveTestEegService.getById(InvasiveTestEegVO.class, InvasiveTestEegEntity.class, invasiveTestEegId));
        return "patient/invasiveTestEeg/formView";
    }

    /**
     * Adds the invasiveTestEEG.
     *
     * @param result the result
     * @return the string
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/save", method = RequestMethod.POST)
    public String invasiveTestEegSavePOST(
            @ModelAttribute("invasiveTestEeg") @Valid InvasiveTestEegVO invasiveTestEeg, BindingResult result,
            @PathVariable("patientId") Integer patientId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), invasiveTestEeg.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/invasiveTestEeg/formView";
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
            invasiveTestEeg.setPatientId(patientId);
            invasiveTestEegService.save(InvasiveTestEegEntity.class, invasiveTestEeg);
            return "redirect:/patient/" + patientId + "/invasive-test-eeg/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/{invasiveTestEegId}/delete", method = RequestMethod.GET)
    public String invasiveTestEegDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("invasiveTestEegId") Integer invasiveTestEegId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        invasiveTestEegService.delete(InvasiveTestEegEntity.class, invasiveTestEegId);
        return "redirect:/patient/" + patientId + "/invasive-test-eeg/list";
    }

    /**
     * Handles the GET request to hide invasiveTestEeg.
     *
     * @param patientId the id of a patient whom we are creating an invasiveTestEeg.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/{invasiveTestEegId}/hide", method = RequestMethod.GET)
    public String invasiveTestEegHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("invasiveTestEegId") Integer invasiveTestEegId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        invasiveTestEegService.hide(invasiveTestEegId);
        return "redirect:/patient/" + patientId + "/invasive-test-eeg/list";
    }

    /**
     * Handles the GET request to unhide invasiveTestEeg.
     *
     * @param patientId the id of a patient whom we are creating an invasiveTestEeg.
     * @param locale    the user's locale.
     * @param model     the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/{invasiveTestEegId}/unhide", method = RequestMethod.GET)
    public String invasiveTestEegUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("invasiveTestEegId") Integer invasiveTestEegId,
            Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        invasiveTestEegService.unhide(invasiveTestEegId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/invasive-test-eeg/list";
    }

   /* @RequestMapping(value = "/patient/{patientID}/invasiveTestEEG/{invasiveTestEEGID}/export", method = RequestMethod.GET)
    public String invasiveTestEEGExportGET(Locale locale, Model model,
                                           @PathVariable("patientID") Integer patientID,
                                           @PathVariable("invasiveTestEEGID") Integer invasiveTestEEGID) {
        return "redirect:/patient/" + patientID + "/invasiveTestEEG/list";
    }*/

    @RequestMapping(value = "/patient/{patientId}/invasive-test-eeg/list", method = RequestMethod.GET)
    public String invasiveTestEegListGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model, HttpServletRequest request) {
        if (!AuthorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithInvasiveTestEegList(patientId);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
        model.addAttribute("patient", patient);
        return "patient/invasiveTestEeg/listView";
    }
}
