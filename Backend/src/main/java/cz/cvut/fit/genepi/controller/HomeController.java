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

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);

		List<NewsMessageEntity> newsMessages = newsMessageService
				.findAll(NewsMessageEntity.class);
		Collections.reverse(newsMessages);
		model.addAttribute("newsMessages", newsMessages);
		/*
		 * next line allows you to access property formattedDate within your
		 * home.jsp page. you can access it with writting ${serverTime} just to
		 * your html code
		 */
		model.addAttribute("patientList",
				newsMessageService.findAll(NewsMessageEntity.class));
		model.addAttribute("serverTime", formattedDate);
		return "homeView";
	}

	@RequestMapping(value = "/news/create", method = RequestMethod.POST)
	public String newsMessageCreatePOST(
			Locale locale,
			Model model,
			@ModelAttribute("newsMessage") @Valid NewsMessageEntity newsMessage,
			BindingResult result) {
		if (result.hasErrors()) {
			return "homeView";
		}
		newsMessageService.save(newsMessage);
		return "redirect:/";
	}

	@RequestMapping(value = "/news/{newsMessageID}/edit", method = RequestMethod.POST)
	public String newsMessageEditPOST(
			Locale locale,
			Model model,
			@ModelAttribute("newsMessage") @Valid NewsMessageEntity newsMessage,
			BindingResult result) {

		if (result.hasErrors()) {
			return "homeView";
		}
		newsMessageService.save(newsMessage);
		return "redirect:/";
	}

	@RequestMapping(value = "/news/{newsMessageID}/delete", method = RequestMethod.POST)
	public String newsMessageDeletePOST(Locale locale, Model model,
			@PathVariable("newsMessageID") Integer newsMessageID) {
		newsMessageService.delete(newsMessageService.findByID(
				NewsMessageEntity.class, newsMessageID));
		return "redirect:/";
	}
}
