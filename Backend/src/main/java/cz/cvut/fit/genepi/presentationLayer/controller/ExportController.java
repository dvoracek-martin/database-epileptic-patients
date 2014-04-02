package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.PatientVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
//@SessionAttributes({"patientIds"})
public class ExportController {

//    @Autowired
//    private AuthorizationChecker authorizationChecker;
//
//    @RequestMapping(value = "/export", method = RequestMethod.POST)
//    public String exportPOST(
//           /* @ModelAttribute("patientId")*/ @RequestParam("patientId") int[] patientIds,
//            Model model, HttpServletRequest request) {
//
//        if (!authorizationChecker.checkAuthoritaion(request)) {
//            return "deniedView";
//        }
//
//        model.addAttribute("patientIds", patientIds);
//        return "";
//    }
//
//    @RequestMapping(value = "/perform-export", method = RequestMethod.POST)
//    public String performExportPOST(
//            @ModelAttribute("patientVO") @Valid PatientVO patientVO, BindingResult result,
//            @PathVariable("patientId") Integer patientId, Model model, HttpServletRequest request) {
//
//        if (!authorizationChecker.checkAuthoritaion(request)) {
//            return "deniedView";
//        }
//        if (result.hasErrors()) {
//            PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
//            model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
//            model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
//            return "patient/verifyView";
//        } else {
//            patientService.save(patientVO, PatientEntity.class);
//            return "redirect:/patient/" + patientId + "/overview";
//        }
//    }

}
