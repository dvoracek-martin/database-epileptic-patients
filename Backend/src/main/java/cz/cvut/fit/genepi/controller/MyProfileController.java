package cz.cvut.fit.genepi.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class MyProfileController.
 */
@Controller
public class MyProfileController {

	/** Selects the profile view to render by returning its name. */

	@Autowired
	private UserService userService;

	/**
	 * My profile post.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/myProfile", method = RequestMethod.POST)
	public String myProfilePOST(Locale locale, Model model) {
		return "myProfileView";
	}

	/**
	 * Login get.
	 *
	 * @param user the user
	 * @param result the result
	 * @return the string
	 */
	@RequestMapping(value = "/myProfile", method = RequestMethod.GET)
	public String myProfileGET(@ModelAttribute("user") @Valid UserEntity user,
			BindingResult result){
		return "myProfileView";
	}
}
