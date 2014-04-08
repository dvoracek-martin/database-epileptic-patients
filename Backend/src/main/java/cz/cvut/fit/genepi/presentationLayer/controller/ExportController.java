package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.VO.form.ExportParamsVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.ExportService;
import cz.cvut.fit.genepi.businessLayer.service.GenericService;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes({"exportParams"})
public class ExportController {

    @Autowired
    private AuthorizationChecker authorizationChecker;

    @Autowired
    private ExportService exportService;

    @Autowired
    @Qualifier("genericServiceImpl")
    private GenericService<ExportParamsVO, ExportParamsEntity> genericServiceExportParams;

    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public String exportPOST(
            @RequestParam("patientId") int[] patientIds,
            @RequestParam("source") String source,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("source", source);
        model.addAttribute("patientIds", patientIds);
        model.addAttribute("exportParams", new ExportParamsVO());
        return "exportView";
    }

    @RequestMapping(value = "/perform-export", method = RequestMethod.POST)
    public String performExportPOST(
            @ModelAttribute("exportParams") @Valid ExportParamsVO exportParams, BindingResult result,
            @RequestParam("patientId") int[] patientIds,
            @RequestParam("exportType") String exportType,
            Model model, Locale locale, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        boolean anonymize = exportParams.isAnonymize();

        if (authorizationChecker.onlyResearcher()) {
            anonymize = true;
        }

        String url = exportService.performExport(exportParams, locale, exportType, anonymize, patientIds, false);


//        if (result.hasErrors()) {
//            PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
//            model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
//            model.addAttribute("currentAge", TimeConverter.getCurrentAge(patient));
//            return "patient/verifyView";
//        } else {
//            patientService.save(patientVO, PatientEntity.class);
//            return "redirect:/patient/" + patientId + "/overview";
//        }

        return "redirect:/resources/downloads/" + url;
    }

    @RequestMapping(value = "/export/save", method = RequestMethod.POST)
    public String exportSavePOST(
            @ModelAttribute("exportParams") @Valid ExportParamsVO exportParams, BindingResult result,
            @RequestParam("patientId") int[] patientIds,
            @RequestParam("source") String source,
            Model model) {

        genericServiceExportParams.save(exportParams, ExportParamsEntity.class);

        model.addAttribute("source", source);
        model.addAttribute("patientIds", patientIds);

        exportParams.setName("");

        model.addAttribute("exportParams", exportParams);
        return "exportView";
    }

    @RequestMapping(value = "/export/load", method = RequestMethod.POST)
    public String exportLoadPOST() {
        return "";
    }

}
