package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.SeizureDetailVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureDetailService;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureDetailEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes({"seizureDetail"})
public class SeizureDetailController {

    @Autowired
    AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private SeizureDetailService seizureDetailService;

    @Autowired
    public SeizureDetailController(PatientService patientService,
                                   SeizureDetailService seizureDetailService, SeizureService seizureService) {
        this.patientService = patientService;
        this.seizureDetailService = seizureDetailService;
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/create", method = RequestMethod.GET)
    public String seizureDetailCreateGET(
            @PathVariable("patientId") int patientId, @PathVariable("seizureId") int seizureId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizureDetail", new SeizureDetailVO());
        return "patient/seizure/detail/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/edit", method = RequestMethod.GET)
    public String seizureDetailEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId,
            @PathVariable("seizureDetailId") Integer seizureDetailId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizureId", seizureId);
        model.addAttribute("seizureDetail", seizureDetailService.getById(seizureDetailId, SeizureDetailVO.class, SeizureDetailEntity.class));
        return "patient/seizure/detail/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/save", method = RequestMethod.POST)
    public String seizureDetailSavePOST(
            @ModelAttribute("seizureDetail") @Valid SeizureDetailVO seizureDetail, BindingResult result,
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), seizureDetail.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/seizure/detail/formView";
        } else {
            seizureDetail.setPatientId(patientId);
            seizureDetail.setSeizureId(seizureId);

            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            seizureDetailService.save(seizureDetail, SeizureDetailEntity.class);
            return "redirect:/patient/" + patientId + "/seizure/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/hide", method = RequestMethod.GET)
    public String seizureDetailHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureDetailId") Integer seizureDetailId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        seizureDetailService.hide(seizureDetailId, SeizureDetailEntity.class);
        return "redirect:/patient/" + patientId + "/seizure/list";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/unhide", method = RequestMethod.GET)
    public String seizureDetailUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureDetailId") Integer seizureDetailId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        seizureDetailService.unhide(seizureDetailId, SeizureDetailEntity.class);
        //TODO: address to get back to admin module where is list of hidden records.
        return "redirect:/patient/" + patientId + "/seizure/list";
    }
}
