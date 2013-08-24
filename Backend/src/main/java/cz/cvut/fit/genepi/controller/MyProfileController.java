package cz.cvut.fit.genepi.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.entity.ContactEntity;
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

		ContactEntity c = new ContactEntity();

		c.setAddressCity("ADs");
		c.setAddressCountry("CZ");
		c.setAddressHn("23524535");
		c.setAddressPostalcode("23425");
		c.setAddressStreet("ASDFA");
		c.setEmail("ASFD@safas.cs");
		c.setFirstName("ADF");
		c.setLastName("ADF");
		c.setPhoneNumber("43255");

		user.setId(0);
		user.setLogin("sue");
		user.setPassword(DigestUtils.sha256Hex("suepassword" + "{"
				+ c.getLastName() + "}"));
		user.setContact(c);

		userService.save(user);
		return "myProfileView";

	}
}
