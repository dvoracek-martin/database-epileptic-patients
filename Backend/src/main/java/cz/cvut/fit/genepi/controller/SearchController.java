package cz.cvut.fit.genepi.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.service.PatientService;
import cz.cvut.fit.genepi.service.SearchService;
import cz.cvut.fit.genepi.service.card.AnamnesisService;
import cz.cvut.fit.genepi.util.LoggingService;

//This controller is not doing anything right now
@Controller
public class SearchController {

	private LoggingService logger = new LoggingService();

	@Autowired
	private MessageSource messageSource;

	/** The anamnesis service. */
	private SearchService searchService;

	/**
	 * Constructor which serves to autowire services.
	 * 
	 * 
	 * @param patientService
	 *            the patientService to be autowired.
	 * @param anamnesisService
	 *            the anamnesisService to be autowired.
	 */
	@Autowired
	public SearchController(SearchService searchService) {
		this.searchService = searchService;
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

		model.addAttribute("advancedSearch", new AdvancedSearchEntity());
		return "advancedSearchView";
	}

	@RequestMapping(value = "/advanced-search", method = RequestMethod.POST)
	public String advancedSearchPOST(
			@ModelAttribute("advancedSearch") @Valid AdvancedSearchEntity advancedSearch,
			BindingResult result, Locale locale, Model model) {
		model.addAttribute("patients", searchService.performAdvancedSearch(advancedSearch));
		return "searchResults";
	}
}
