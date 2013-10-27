package cz.cvut.fit.genepi.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.service.LoggingService;

//This controller is not doing anything right now
@Controller
public class SearchController {

	private LoggingService logger = new LoggingService();

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchGET(Locale locale, Model model) {
		
		return "search";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String postGET(Locale locale, Model model) {
		
		return "searchResults";
	}
}
