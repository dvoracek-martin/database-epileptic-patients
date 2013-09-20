package cz.cvut.fit.genepi.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@Autowired
	private NewsMessageService newsMessageService;
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
		String formattedDate = dateFormat.format(date);		
		
		/* next line allows you to access property formattedDate
		 * within your home.jsp page.
		 * you can access it with writting ${serverTime} just to your
		 * html code
		 */
		model.addAttribute("patientList",
				newsMessageService.findAll(NewsMessageEntity.class));
		model.addAttribute("serverTime", formattedDate );
		return "homeView";
	}	
}
