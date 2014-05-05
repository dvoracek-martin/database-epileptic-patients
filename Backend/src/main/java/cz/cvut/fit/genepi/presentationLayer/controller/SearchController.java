package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.AdvancedSearchVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.GenericService;
import cz.cvut.fit.genepi.businessLayer.service.RoleService;
import cz.cvut.fit.genepi.businessLayer.service.SearchService;
import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"advancedSearch", "patients"})
public class SearchController {

    private final AuthorizationChecker authorizationChecker;

    private final SearchService searchService;

    private final RoleService roleService;

    @Autowired
    @Qualifier("genericServiceImpl")
    private GenericService<AdvancedSearchVO, AdvancedSearchEntity> genericService;

    /**
     * Constructor which serves to autowire services.
     */
    @Autowired
    public SearchController(AuthorizationChecker authorizationChecker,
                            SearchService searchService,
                            RoleService roleService) {

        this.authorizationChecker = authorizationChecker;
        this.searchService = searchService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "/advanced-search", method = RequestMethod.GET)
    public String advancedSearchGET(Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("doctors", roleService.getAllDoctors());
        model.addAttribute("advancedSearch", new AdvancedSearchVO());
        model.addAttribute("toCheck", true);
        return "search/advancedSearchView";
    }

    @RequestMapping(value = "/advanced-search", method = RequestMethod.POST)
    public String advancedSearchPOST(
            @ModelAttribute("advancedSearch") @Valid AdvancedSearchVO advancedSearch, BindingResult result,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        if (result.hasErrors()) {
            return "search/advancedSearchView";
        } else {
            return "redirect:/advanced-search/result";
        }
    }

    @RequestMapping(value = "/advanced-search/result", method = RequestMethod.GET)
    public String advancedSearchResultGET(
            ModelMap model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        AdvancedSearchVO advancedSearch = (AdvancedSearchVO) model.get("advancedSearch");

        if (authorizationChecker.onlyResearcher()) {
            advancedSearch.setPatientFirstname("");
            advancedSearch.setPatientLastname("");
            advancedSearch.setPatientNin("");
        }

        List<List<PatientDisplayVO>> patients = searchService.performAdvancedSearch(advancedSearch);

        /* TODO hotfix START*/
        int patientCount = 0;
        for (List<PatientDisplayVO> patientDisplayVOList : patients) {
            patientCount += patientDisplayVOList.size();
        }

        model.addAttribute("patientCount",patientCount);

        /* hotfix END */
        model.addAttribute("patients", patients);
        model.addAttribute("pages", patients.size());
        return "search/searchResults";
    }

    @RequestMapping(value = "/advanced-search/save", method = RequestMethod.POST)
    public String advancedSearchSaveGET(
            @ModelAttribute("advancedSearch") @Valid AdvancedSearchVO advancedSearch, BindingResult result,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        if (result.hasErrors()) {
            return "search/advancedSearchView";
        } else {

            searchService.save(advancedSearch);

            return "redirect:/advanced-search/load";
        }
    }

    @RequestMapping(value = "/advanced-search/load", method = RequestMethod.GET)
    public String advancedSearchLoadGET(
            ModelMap model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("advancedSearchList", searchService.loadAll());
        return "search/loadView";
    }

    @RequestMapping(value = "/advanced-search/load/{adancedSearchId}", method = RequestMethod.GET)
    public String advancedSearchLoadParamsGET(
            @PathVariable("adancedSearchId") int adancedSearchId,
            ModelMap model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("advancedSearch", genericService.getById(adancedSearchId, AdvancedSearchVO.class, AdvancedSearchEntity.class));
        model.addAttribute("doctors", roleService.getAllDoctors());
        model.addAttribute("toCheck", false);
        return "search/advancedSearchView";
    }
}
