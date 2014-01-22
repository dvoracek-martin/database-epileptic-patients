package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.SeizureDetailVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureDetailService;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes({"seizureDetail"})
public class SeizureDetailController {

    private PatientService patientService;

    private SeizureDetailService seizureDetailService;

    private SeizureService seizureService;

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
        return "patient/seizure/detail/createEditView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/edit", method = RequestMethod.GET)
    public String seizureDetailEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("seizureId") Integer seizureId,
            @PathVariable("seizureDetailId") Integer seizureDetailId, Locale locale,
            Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizureId", seizureId);
        model.addAttribute("seizureDetail", seizureDetailService.getById(seizureDetailId));
        return "patient/seizure/detail/createEditView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/save", method = RequestMethod.POST)
    public String seizureDetailSavePOST(
            @ModelAttribute("seizureDetail") @Valid SeizureDetailVO seizureDetail,
            BindingResult result, @PathVariable("patientId") Integer patientId, @PathVariable("seizureId") Integer seizureId,
            Locale locale, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/seizure/detail/createEditView";
        } else {
            seizureDetail.setPatientId(patientId);
            seizureDetail.setSeizureId(seizureId);
            seizureDetailService.save(seizureDetail);
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
