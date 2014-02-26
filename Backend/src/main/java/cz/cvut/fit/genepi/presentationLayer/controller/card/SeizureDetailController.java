package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.SeizureDetailVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureDetailService;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureDetailEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes({"seizureDetail"})
public class SeizureDetailController {

    private PatientService patientService;

    private SeizureDetailService seizureDetailService;

    private SeizureService seizureService;

    private UserService userService;

    @Autowired
    public SeizureDetailController(PatientService patientService,
                                   SeizureDetailService seizureDetailService, SeizureService seizureService) {
        this.patientService = patientService;
        this.seizureDetailService = seizureDetailService;
        this.seizureService = seizureService;
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/create", method = RequestMethod.GET)
    public String seizureDetailCreateGET(
            @PathVariable("patientId") Integer patientId, @PathVariable("seizureId") Integer seizureId, Locale locale,
            Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizureDetail", new SeizureDetailVO());
        return "patient/seizure/detail/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/edit", method = RequestMethod.GET)
    public String seizureDetailEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureId") Integer seizureId,
            @PathVariable("seizureDetailId") Integer seizureDetailId, Locale locale,
            Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizureId", seizureId);
        model.addAttribute("seizureDetail", seizureDetailService.getById(SeizureDetailVO.class, SeizureDetailEntity.class, seizureDetailId));
        return "patient/seizure/detail/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/save", method = RequestMethod.POST)
    public String seizureDetailSavePOST(
            @ModelAttribute("seizureDetail") @Valid SeizureDetailVO seizureDetail, BindingResult result,
            @PathVariable("patientId") Integer patientId, @PathVariable("seizureId") Integer seizureId,
            Locale locale, Model model) {

        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), seizureDetail.getDate()) ){
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/seizure/detail/formView";
        } else {
            seizureDetail.setPatientId(patientId);
            seizureDetail.setSeizureId(seizureId);
            Authentication auth = SecurityContextHolder.getContext()
                    .getAuthentication();
            List<RoleEntity> roles = userService.findUserByUsername(auth.getName()).getRoles();
            boolean isSuperdoctor = false;
            for (RoleEntity r : roles) {
                if (r.getAuthority().equals("ROLE_SUPER_DOCTOR"))
                    isSuperdoctor = true;
            }
            if (!isSuperdoctor)
                patientService.findByID(PatientEntity.class,patientId).setVerified(false);
            seizureDetailService.save(SeizureDetailEntity.class, seizureDetail);
            return "redirect:/patient/" + patientId + "/seizure/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/hide", method = RequestMethod.GET)
    public String seizureDetailHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureDetailId") Integer seizureDetailId, Locale locale,
            Model model) {

        seizureDetailService.hide(seizureDetailId);
        return "redirect:/patient/" + patientId + "/seizure/list";
    }


    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/unhide", method = RequestMethod.GET)
    public String seizureDetailUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureDetailId") Integer seizureDetailId, Locale locale,
            Model model) {

        seizureDetailService.unhide(seizureDetailId);
        //TODO: address to get back to admin module where is list of hidden records.
        return "redirect:/patient/" + patientId + "/seizure/list";
    }
}
