package cz.cvut.fit.genepi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.cvut.fit.genepi.entity.ContactEntity;
import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.entity.UserRoleEntity;
import cz.cvut.fit.genepi.service.ContactService;
import cz.cvut.fit.genepi.service.LoggingService;
import cz.cvut.fit.genepi.service.MailService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.UserRoleService;
import cz.cvut.fit.genepi.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@Scope("session")
@Controller
public class UserController {

	/** The user service. */
	@Autowired
	private UserService userService;

	/** The role service. */
	@Autowired
	private RoleService roleService;

	/** The user role service. */
	@Autowired
	private UserRoleService userRoleService;

	/** The contact service. */
	@Autowired
	private ContactService contactService;

	/** The mail service. */
	@Autowired
	private MailService mailService;

	/** The Constant logger. */
	private LoggingService logger = new LoggingService();

	/**
	 * Creates the user get.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public String userCreateGET(Model model) {
		model.addAttribute("user", new UserEntity());
		model.addAttribute("isUnique", "unique");
		return "user/createView";
	}

	/**
	 * Adds the user get.
	 * 
	 * @param user
	 *            the user
	 * @param result
	 *            the result
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String userCreatePOST(Model model, Locale locale,
			@ModelAttribute("user") @Valid UserEntity user, BindingResult result) {
		if (result.hasErrors()) {
			return "user/createView";
		} else {
			// TODO: maybe userSrvice.create should do this IF and return
			// boolean
			if (userService.findUserByUsername(user.getUsername()) != null) {
				model.addAttribute("isUnique", "notUnique");
				return "user/createView";
			} else {
				userService.create(user, locale);
				if (logger.getLogger() == null)
					logger.setLogger(UserController.class);
				logger.logInfo("New user successfuly created.");
				return "redirect:/user/" + Integer.toString(user.getId())
						+ "/overview";
			}
		}
	}

	/**
	 * User overview get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param userID
	 *            the user id
	 * @return the string
	 */
	@RequestMapping(value = "/user/{userID}/overview", method = RequestMethod.GET)
	public String userOverviewGET(Locale locale, Model model,
			@PathVariable("userID") Integer userID) {
		model.addAttribute("user",
				userService.findByID(UserEntity.class, userID));
		return "user/overviewView";
	}

	@RequestMapping(value = "/user/{userID}/delete", method = RequestMethod.GET)
	public String userDeleteGET(Locale locale, Model model,
			@PathVariable("userID") Integer userID) {
		userService.delete(userService.findByID(UserEntity.class, userID));
		return "redirect:/user/list";
	}

	/**
	 * User edit get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param userID
	 *            the user id
	 * @return the string
	 */
	@RequestMapping(value = "/user/{userID}/edit", method = RequestMethod.GET)
	public String userEditGET(Locale locale, Model model,
			@PathVariable("userID") Integer userID) {
		model.addAttribute("user",
				userService.findByID(UserEntity.class, userID));
		return "user/editView";
	}

	/**
	 * Edits the user get.
	 * 
	 * @param user
	 *            the user
	 * @param result
	 *            the result
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/user/edit", method = RequestMethod.POST)
	public String userEditPOST(Locale locale, Model model,
			@Valid @ModelAttribute("user") UserEntity user, BindingResult result) {
		if (result.hasErrors()) {
			return "user/editView";
		}
		// TODO:veird sequence. is there a better solution??
		ContactEntity contact = new ContactEntity();
		contact.setId(userService.findByID(UserEntity.class, user.getId())
				.getContact().getId());

		contact.setFirstName(user.getContact().getFirstName());
		contact.setLastName(user.getContact().getLastName());
		contact.setAddressStreet(user.getContact().getAddressStreet());
		contact.setAddressHn(user.getContact().getAddressHn());
		contact.setAddressCity(user.getContact().getAddressCity());
		contact.setAddressPostalcode(user.getContact().getAddressPostalcode());
		contact.setAddressCountry(user.getContact().getAddressCountry());
		contact.setPhoneNumber(user.getContact().getPhoneNumber());
		contact.setEmail(user.getContact().getEmail());

		contactService.merge(contact);
		return "redirect:/user/" + Integer.toString(user.getId()) + "/overview";

	}

	/**
	 * Users list get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public String userListGET(Locale locale, Model model) {
		model.addAttribute("userList", userService.findAll(UserEntity.class));
		return "user/listView";
	}

	/**
	 * User change password get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param userID
	 *            the user id
	 * @return the string
	 */
	@RequestMapping(value = "/user/{userID}/change-password", method = RequestMethod.GET)
	public String userChangePasswordGET(Locale locale, Model model,
			@PathVariable("userID") Integer userID) {

		if (logger.getLogger() == null)
			logger.setLogger(UserController.class);
		logger.logInfo("Changing password");

		UserEntity user = userService.findByID(UserEntity.class, userID);
		user.setPassword("");
		model.addAttribute("user", user);
		model.addAttribute("passwordChanged", false);
		return "user/changePassword";
	}

	/**
	 * Change password post.
	 * 
	 * @param user
	 *            the user
	 * @param model
	 *            the model
	 * @param result
	 *            the result
	 * @return the string
	 */
	@RequestMapping(value = "/user/{userID}/change-password", method = RequestMethod.POST)
	public String userChangePasswordPOST(
			@ModelAttribute("user") @Valid UserEntity formUser, Model model,
			BindingResult result, Locale locale,
			@PathVariable("userID") Integer userID) {
		UserEntity realUser = userService.findByID(UserEntity.class, userID);
		if (result.hasErrors()) {
			return "user/" + realUser.getId() + "/change-password";
		} else {
			// TODO: transfer to Service
			String password = formUser.getPassword();
			realUser.setPassword(DigestUtils.sha256Hex(formUser.getPassword()
					+ "{" + realUser.getUsername() + "}"));
			userService.save(realUser);
			model.addAttribute("passwordChanged", true);
			/* send mail to user about cahnge of password */
			try {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("subject", "changeOfThePassword");
				map.put("user", realUser);
				map.put("password", password);
				mailService.sendMail("test", map, locale);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/user/" + realUser.getId() + "/change-password";
	}

	// TODO: revision
	@RequestMapping(value = "/user/{userID}/edit-roles", method = RequestMethod.GET)
	public String userEditRolesGET(Locale locale, Model model,
			@PathVariable("userID") Integer userID) {
		if (logger.getLogger() == null)
			logger.setLogger(UserController.class);

		UserEntity user = userService.findByID(UserEntity.class, userID);

		List<RoleEntity> listOfPossibleRoles = new ArrayList<RoleEntity>();

		boolean found = false;
		for (RoleEntity possibleRole : roleService.findAll(RoleEntity.class)) {
			found = false;
			for (RoleEntity role : user.getRoles())
				if (role.getId() == possibleRole.getId()) {
					found = true;
					continue;
				}
			if (!found) {
				listOfPossibleRoles.add(possibleRole);
			}
		}

		model.addAttribute("listOfPossibleRoles", listOfPossibleRoles);
		model.addAttribute("user", user);
		return "user/editRoles";
	}

	// TODO: revision
	@RequestMapping(value = "/user/{userID}/edit-roles", method = RequestMethod.POST)
	public String userEditRolesPOST(
			@ModelAttribute("user") @Valid UserEntity formUser, Model model,
			BindingResult result, Locale locale,
			@PathVariable("userID") Integer userID,
			@RequestParam(value = "role") int[] paramValues) {

		List<RoleEntity> newRoles = new ArrayList<RoleEntity>();

		for (int id : paramValues) {
			newRoles.add(roleService.findByID(RoleEntity.class, id));
		}

		UserEntity realUser = userService.findByID(UserEntity.class, userID);

		if (result.hasErrors()) {
			return "user/" + realUser.getId() + "/edit-roles";
		} else {
			realUser.setRoles(newRoles);
			userService.save(realUser);
		}
		return "redirect:/user/" + realUser.getId() + "/edit-roles";
	}

}
