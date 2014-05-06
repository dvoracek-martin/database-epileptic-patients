package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.BO.form.ExportInfoWrapperFormBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.ExportParamsFormBO;
import cz.cvut.fit.genepi.businessLayer.service.*;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Controller
@SessionAttributes({"exportParams", "exportInfoWrapperFormBO"})
public class ExportController {

    private final AuthorizationChecker authorizationChecker;

    private final ExportService exportService;

    private final GenericService<ExportParamsFormBO, ExportParamsEntity> genericServiceExportParams;

    private final ExportParamsService exportParamsService;

    private final UserService userService;

    @Autowired
    public ExportController(AuthorizationChecker authorizationChecker,
                            ExportService exportService,
                            @Qualifier("genericServiceImpl")
                            GenericService<ExportParamsFormBO, ExportParamsEntity> genericServiceExportParams,
                            ExportParamsService exportParamsService,
                            UserService userService) {

        this.authorizationChecker = authorizationChecker;
        this.exportService = exportService;
        this.genericServiceExportParams = genericServiceExportParams;
        this.exportParamsService = exportParamsService;
        this.userService = userService;
    }

    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public String exportPOST(
            @RequestParam("patientId") int[] patientIds,
            @RequestParam("source") String source,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        ExportInfoWrapperFormBO exportInfoWrapperFormBO = new ExportInfoWrapperFormBO();

        for (int id : patientIds) {
            exportInfoWrapperFormBO.addPatientId(id);
        }

        exportInfoWrapperFormBO.setSource(source);

        model.addAttribute("exportInfoWrapperFormBO", exportInfoWrapperFormBO);
        model.addAttribute("exportParams", new ExportParamsFormBO());
        return "redirect:/export";
    }

    @ExceptionHandler(HttpSessionRequiredException.class)
    public String handleException() {

        return "deniedView";
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public String exportGET(
            @ModelAttribute("exportInfoWrapperFormBO") ExportInfoWrapperFormBO exportInfoWrapperFormBO,
            @ModelAttribute("exportParams") @Valid ExportParamsFormBO exportParams,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        model.addAttribute("genericConfigurations", exportParamsService.getGenericConfigurations());
        model.addAttribute("userConfigurations", exportParamsService.getConfigurationsByUsername(username));

        model.addAttribute("exportInfoWrapperFormBO", exportInfoWrapperFormBO);
        model.addAttribute("exportParams", exportParams);
        return "exportView";
    }

    @RequestMapping(value = "/perform-export", method = RequestMethod.POST)
    public String performExportPOST(
            @ModelAttribute("exportParams") @Valid ExportParamsFormBO exportParams, BindingResult result,
            @ModelAttribute("exportInfoWrapperFormBO") ExportInfoWrapperFormBO exportInfoWrapperFormBO,
            @RequestParam("exportType") String exportType,
            @RequestParam(value = "toTable", defaultValue = "false") boolean toTable,
            Locale locale, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        boolean anonymize = exportParams.isAnonymize();

        if (authorizationChecker.onlyResearcher()) {
            anonymize = true;
        }

        String url = exportService.performExport(exportParams, locale, exportType, anonymize, exportInfoWrapperFormBO.getPatientIds(), toTable);

        return "redirect:/resources/downloads/" + url;
    }

    @RequestMapping(value = "/export/save", method = RequestMethod.POST)
    public String exportSavePOST(
            @ModelAttribute("exportParams") @Valid ExportParamsFormBO exportParams, BindingResult result) {

        if (!authorizationChecker.isSuperDoctor()) {
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

        model.addAttribute("exportParams", genericServiceExportParams.getById(exportId, ExportParamsFormBO.class, ExportParamsEntity.class));

        return "redirect:/export";
    }

    @RequestMapping(value = "/export/delete", method = RequestMethod.POST)
    public String exportDeletePOST(
            @RequestParam("exportId") int exportId) {

        genericServiceExportParams.delete(exportId, ExportParamsEntity.class);

        return "redirect:/export";
    }
}
