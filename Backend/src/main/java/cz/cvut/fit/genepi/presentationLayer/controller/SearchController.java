package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.AdvancedSearchVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.RoleService;
import cz.cvut.fit.genepi.businessLayer.service.SearchService;
import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

//This controller is not doing anything right now
@Controller
@SessionAttributes({"advancedSearch"})
public class SearchController {

    @Autowired
    private AuthorizationChecker authorizationChecker;

    @Autowired
    private MessageSource messageSource;

    private SearchService searchService;

    private RoleService roleService;

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
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        if (result.hasErrors()) {
            return "advancedSearchView";
        } else {
             List<PatientDisplayVO> patients = searchService.performAdvancedSearch(advancedSearch);
             model.addAttribute("patients", patients);
            return "searchResults";
        }
    }
}
