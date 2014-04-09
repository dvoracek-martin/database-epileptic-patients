package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.VO.form.ExportInfoWrapperVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.ExportParamsVO;
import cz.cvut.fit.genepi.businessLayer.service.*;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes({"exportParams", "exportInfoWrapperVo"})
public class ExportController {


    @Autowired
    private AuthorizationChecker authorizationChecker;

    @Autowired
    private ExportService exportService;

    @Autowired
    @Qualifier("genericServiceImpl")
    private GenericService<ExportParamsVO, ExportParamsEntity> genericServiceExportParams;

    @Autowired
    private ExportParamsService exportParamsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public String exportPOST(
            @RequestParam("patientId") int[] patientIds,
            @RequestParam("source") String source,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        ExportInfoWrapperVO exportInfoWrapperVo = new ExportInfoWrapperVO();

        for (int id : patientIds) {
            exportInfoWrapperVo.addPatientId(id);
        }

        exportInfoWrapperVo.setSource(source);

        model.addAttribute("exportInfoWrapperVo", exportInfoWrapperVo);
        model.addAttribute("exportParams", new ExportParamsVO());
        return "redirect:/export";
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public String exportGET(
            @ModelAttribute("exportInfoWrapperVo") ExportInfoWrapperVO exportInfoWrapperVo,
            @ModelAttribute("exportParams") @Valid ExportParamsVO exportParams,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        model.addAttribute("genericConfigurations", exportParamsService.getGenericConfigurations());
        model.addAttribute("userConfigurations", exportParamsService.getConfigurationsByUsername(username));

        model.addAttribute("exportInfoWrapperVo", exportInfoWrapperVo);
        model.addAttribute("exportParams", exportParams);
        return "exportView";
    }

    @RequestMapping(value = "/perform-export", method = RequestMethod.POST)
    public String performExportPOST(
            @ModelAttribute("exportParams") @Valid ExportParamsVO exportParams, BindingResult result,
            @ModelAttribute("exportInfoWrapperVo") ExportInfoWrapperVO exportInfoWrapperVo,
            @RequestParam("exportType") String exportType,
           Locale locale, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        boolean anonymize = exportParams.isAnonymize();

        if (authorizationChecker.onlyResearcher()) {
            anonymize = true;
        }

        String url = exportService.performExport(exportParams, locale, exportType, anonymize, exportInfoWrapperVo.getPatientIds(), false);

        return "redirect:/resources/downloads/" + url;
    }

    @RequestMapping(value = "/export/save", method = RequestMethod.POST)
    public String exportSavePOST(
            @ModelAttribute("exportParams") @Valid ExportParamsVO exportParams, BindingResult result) {

        if(!authorizationChecker.isSuperDoctor() && !authorizationChecker.isAdmin()){
            exportParams.setGeneric(false);
        }

        int userId = userService.getLoggedUserId();
        exportParams.setUserID(userId);
        genericServiceExportParams.save(exportParams, ExportParamsEntity.class);

        return "redirect:/export";
    }

    @RequestMapping(value = "/export/load", method = RequestMethod.POST)
    public String exportLoadPOST(
            @RequestParam("exportId") int exportId,
            Model model) {

        model.addAttribute("exportParams", genericServiceExportParams.getById(exportId, ExportParamsVO.class, ExportParamsEntity.class));

        return "redirect:/export";
    }

    @RequestMapping(value = "/export/delete", method = RequestMethod.POST)
    public String exportDeletePOST(
            @RequestParam("exportId") int exportId) {

        genericServiceExportParams.delete(exportId, ExportParamsEntity.class);

        return "redirect:/export";
    }

}
