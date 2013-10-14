package cz.cvut.fit.genepi.controller;

import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.entity.NewsMessageEntity;
import cz.cvut.fit.genepi.service.NewsMessageService;

// TODO: Auto-generated Javadoc
/**
 * Handles requests for the application home page.
 */
@Scope("session")
@Controller
public class HomeController {

	/** The news message service. */
	@Autowired
	private NewsMessageService newsMessageService;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGET(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		// TODO: overide findAll rto return reverted news list
		List<NewsMessageEntity> newsMessages = newsMessageService
				.findAll(NewsMessageEntity.class);
		Collections.reverse(newsMessages);
		model.addAttribute("newsMessages", newsMessages);
		model.addAttribute("patientList",
				newsMessageService.findAll(NewsMessageEntity.class));
		model.addAttribute("emptyMessage", new NewsMessageEntity());
		return "homeView";
	}

	@RequestMapping(value = "/news/create", method = RequestMethod.POST)
	public String newsMessageCreatePOST(
			Locale locale,
			Model model,
			@ModelAttribute("newsMessage") @Valid NewsMessageEntity newsMessage,
			BindingResult result) {
		if (result.hasErrors()) {
			// TODO: overide findAll rto return reverted news list
			List<NewsMessageEntity> newsMessages = newsMessageService
					.findAll(NewsMessageEntity.class);
			Collections.reverse(newsMessages);
			model.addAttribute("newsMessages", newsMessages);
			return "homeView";
		}
		newsMessageService.save(newsMessage);
		return "redirect:/";
	}

	@RequestMapping(value = "/news/{newsMessageID}/edit", method = RequestMethod.POST)
	public String newsMessageEditPOST(
			Locale locale,
			Model model,
			@PathVariable("newsMessageID") Integer newsMessageID,
			@ModelAttribute("formNewsMessage") @Valid NewsMessageEntity formNewsMessage,
			BindingResult result) {

		if (result.hasErrors()) {
			// TODO: overide findAll rto return reverted news list
			List<NewsMessageEntity> newsMessages = newsMessageService
					.findAll(NewsMessageEntity.class);
			Collections.reverse(newsMessages);
			model.addAttribute("newsMessages", newsMessages);
			return "homeView";
		}
		
		NewsMessageEntity realNewsMessage = newsMessageService.findByID(
				NewsMessageEntity.class, newsMessageID);
		realNewsMessage.setMessage(formNewsMessage.getMessage());
		newsMessageService.save(realNewsMessage);
		return "redirect:/";
	}

	@RequestMapping(value = "/news/{newsMessageID}/delete", method = RequestMethod.GET)
	public String newsMessageDeleteGET(Locale locale, Model model,
			@PathVariable("newsMessageID") Integer newsMessageID) {
		newsMessageService.delete(newsMessageService.findByID(
				NewsMessageEntity.class, newsMessageID));
		return "redirect:/";
	}
}
