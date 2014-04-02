package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.AdvancedSearchVO;
import cz.cvut.fit.genepi.businessLayer.service.*;
import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

//This controller is not doing anything right now
@Controller
@SessionAttributes({"advancedSearch", "patients"})
public class SearchController {

    @Autowired
    private AuthorizationChecker authorizationChecker;

    @Autowired
    private MessageSource messageSource;

    private SearchService searchService;

    private RoleService roleService;
    @Autowired
    UserService userService;

    @Autowired
    @Qualifier("genericServiceImpl")
    private GenericService<AdvancedSearchVO, AdvancedSearchEntity> genericService;

    /**
     * Constructor which serves to autowire services.
     */
    @Autowired
    public SearchController(SearchService searchService, RoleService roleService) {
        this.searchService = searchService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchGET(Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPost(Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        return "searchResults";
    }

    @RequestMapping(value = "/advanced-search", method = RequestMethod.GET)
    public String advancedSearchGET(Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("doctors", roleService.getAllDoctors());
        model.addAttribute("advancedSearch", new AdvancedSearchVO());
        return "advancedSearchView";
    }

    @RequestMapping(value = "/advanced-search", method = RequestMethod.POST)
    public String advancedSearchPOST(
            @ModelAttribute("advancedSearch") @Valid AdvancedSearchVO advancedSearch, BindingResult result,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        if (result.hasErrors()) {
            return "advancedSearchView";
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

        List<List<PatientDisplayVO>> patients = searchService.performAdvancedSearch((AdvancedSearchVO) model.get("advancedSearch"));
        model.addAttribute("patients", patients);
        model.addAttribute("pages", patients.size());
        return "searchResults";
    }

    @RequestMapping(value = "/advanced-search/save", method = RequestMethod.POST)
    public String advancedSearchSaveGET(
            @ModelAttribute("advancedSearch") @Valid AdvancedSearchVO advancedSearch, BindingResult result,
            ModelMap model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        if (result.hasErrors()) {
            return "advancedSearchView";
        } else {
            Authentication auth = SecurityContextHolder.getContext()
                    .getAuthentication();
            String name = auth.getName();
//TODO transfer to service
            advancedSearch.setUserId(userService.getUserByUsername(name).getId());
            genericService.save(advancedSearch, AdvancedSearchEntity.class);

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
        return "loadView";
    }

    @RequestMapping(value = "/advanced-search/load/{adancedSearchId}", method = RequestMethod.GET)
    public String advancedSearchLoadParamsGET(
            @PathVariable("adancedSearchId") int adancedSearchId,
            ModelMap model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("advancedSearch", genericService.getById(adancedSearchId, AdvancedSearchVO.class, AdvancedSearchEntity.class));
        return "advancedSearchView";
    }

}
