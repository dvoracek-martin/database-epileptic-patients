package cz.cvut.fit.genepi.presentationLayer.controller;

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

import javax.validation.Valid;
import java.util.Locale;

//This controller is not doing anything right now
@Controller
public class SearchController {
    @Autowired
    private MessageSource messageSource;

    /**
     * The anamnesis service.
     */
    private SearchService searchService;

    private RoleService roleService;

    /**
     * Constructor which serves to autowire services.
     *
     */
    @Autowired
    public SearchController(SearchService searchService, RoleService roleService) {
        this.searchService = searchService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchGET(Locale locale, Model model) {
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPost(Locale locale, Model model) {
        return "searchResults";
    }

    @RequestMapping(value = "/advanced-search", method = RequestMethod.GET)
    public String advancedSearchGET(Locale locale, Model model) {
        model.addAttribute("doctors", roleService.getAllDoctors());
        model.addAttribute("advancedSearch", new AdvancedSearchEntity());
        return "advancedSearchView";
    }

    @RequestMapping(value = "/advanced-search", method = RequestMethod.POST)
    public String advancedSearchPOST(
            @ModelAttribute("advancedSearch") @Valid AdvancedSearchEntity advancedSearch,
            BindingResult result, Locale locale, Model model) {
        model.addAttribute("patients",
                searchService.performAdvancedSearch(advancedSearch));
        return "searchResults";
    }
}
