package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.SeizureDetailDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.SeizureDetailVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureDetailEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes({"seizureDetail", "patient"})
public class SeizureDetailController {

    private final AuthorizationChecker authorizationChecker;

    private final PatientService patientService;

    private final GenericCardService<SeizureDetailDisplayVO, SeizureDetailVO, SeizureDetailEntity> genericCardService;

    @Autowired
    public SeizureDetailController(AuthorizationChecker authorizationChecker,
                                   PatientService patientService,
                                   @Qualifier("genericCardServiceImpl")
                                   GenericCardService<SeizureDetailDisplayVO, SeizureDetailVO, SeizureDetailEntity> genericCardService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.genericCardService = genericCardService;
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/create", method = RequestMethod.GET)
    public String seizureDetailCreateGET(
            @PathVariable("patientId") int patientId, @PathVariable("seizureId") int seizureId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("seizureId", seizureId);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizureDetail", new SeizureDetailVO());
        return "patient/seizure/detail/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/create", method = RequestMethod.POST)
    public String seizureDetailCreatePOST(
            @ModelAttribute("seizureDetail") @Valid SeizureDetailVO seizureDetail, BindingResult result,
            @ModelAttribute("patient") PatientDisplayVO patientDisplayVo,
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayVo.getBirthday(), seizureDetail.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/seizure/detail/createView";
            } else {
                seizureDetail.setPatientId(patientId);
                seizureDetail.setSeizureId(seizureId);

                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.save(seizureDetail, SeizureDetailEntity.class);
                return "redirect:/patient/" + patientId + "/seizure/list";
            }
        }
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

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizureId", seizureId);
        model.addAttribute("seizureDetail", genericCardService.getById(seizureDetailId, SeizureDetailVO.class, SeizureDetailEntity.class));
        return "patient/seizure/detail/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/edit", method = RequestMethod.POST)
    public String seizureDetailEditPOST(
            @ModelAttribute("seizureDetail") @Valid SeizureDetailVO seizureDetail, BindingResult result,
            @ModelAttribute("patient") PatientDisplayVO patientDisplayVo,
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId,
            @PathVariable("seizureDetailId") Integer seizureDetailId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayVo.getBirthday(), seizureDetail.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/seizure/detail/editView";
            } else {
                seizureDetail.setPatientId(patientId);
                seizureDetail.setSeizureId(seizureId);

                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.makeHistory(seizureDetailId, SeizureDetailEntity.class);
                seizureDetail.setId(0);
                genericCardService.save(seizureDetail, SeizureDetailEntity.class);
                return "redirect:/patient/" + patientId + "/seizure/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/hide", method = RequestMethod.GET)
    public String seizureDetailHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureId") int seizureId,
            @PathVariable("seizureDetailId") Integer seizureDetailId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.hide(seizureDetailId, SeizureDetailEntity.class);
        return "redirect:/patient/" + patientId + "/seizure/list";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/unhide", method = RequestMethod.GET)
    public String seizureDetailUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureId") int seizureId,
            @PathVariable("seizureDetailId") Integer seizureDetailId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.unhide(seizureDetailId, SeizureDetailEntity.class);
        return "redirect:/patient/" + patientId + "/seizure/list";
    }
}
