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
		List<RoleEntity> listOfPossibleRoles = roleService
				.findAll(RoleEntity.class);
		model.addAttribute("listOfPossibleRoles", listOfPossibleRoles);
		model.addAttribute("listOfSelectedRoles", new ArrayList<RoleEntity>());
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
	public String userCreatePOST(
			@ModelAttribute("user") @Valid UserEntity user,
			BindingResult result, Model model, Locale locale) {

		if (result.hasErrors()) {
			return "user/createView";
		} else {
			if (userService.findUserByUsername(user.getUsername()) != null) {
				model.addAttribute("isUnique", "notUnique");
				return "user/createView";
			} else {
				String password = RandomStringUtils.randomAlphanumeric(10);
				if (logger.getLogger() == null)
					logger.setLogger(UserController.class);
				logger.logInfo("New password " + password + " for new user id "
						+ user.getId() + " generated.");
				user.setPassword(DigestUtils.sha256Hex(password + "{"
						+ user.getUsername() + "}"));

				/* assigning roles to user */
				ArrayList<RoleEntity> roles = new ArrayList<RoleEntity>();
				roles.add(roleService.findByID(RoleEntity.class, 1));
				user.setRoles(roles);
				userService.save(user);

				/*
				 * List<Integer> listOfRoles = new ArrayList<Integer>();
				 * listOfRoles.add(1); List<UserRoleEntity> listOfUserRoles =
				 * new ArrayList<UserRoleEntity>(); for (int i : listOfRoles) {
				 * UserRoleEntity userRole = new UserRoleEntity();
				 * userRole.setUser_id(user.getId()); userRole.setRole_id(i);
				 * listOfUserRoles.add(userRole); } for (UserRoleEntity userRole
				 * : listOfUserRoles) { userRoleService.save(userRole); }
				 */

				/* sending email to user about account creation */
				try {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("subject", "creationOfANewUser");
					map.put("user", user);
					map.put("password", password);
					mailService.sendMail("test", map, locale);
					logger.logInfo("Email to new user sent");

				} catch (Exception e) {
					logger.logError(
							"Error when trying to send email after creating new user.",
							e);
				}
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
		UserEntity user = userService.findByID(UserEntity.class, userID);
		model.addAttribute("user", user);
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
		UserEntity user = userService.findByID(UserEntity.class, userID);

		List<RoleEntity> listOfRoles = new ArrayList<RoleEntity>();
		listOfRoles = roleService.findAll(RoleEntity.class);
		List<UserRoleEntity> listOfAssignedUserRoles = new ArrayList<UserRoleEntity>();
		List<RoleEntity> listOfAssignedRoles = new ArrayList<RoleEntity>();

		listOfAssignedUserRoles = userRoleService
				.findAllUserRolesByUserID(userID);

		for (UserRoleEntity i : listOfAssignedUserRoles) {
			listOfAssignedRoles.add((roleService.findByID(RoleEntity.class,
					i.getRole_id())));
		}

		UserEntity userTmp = new UserEntity();
		userTmp.setContact(user.getContact());

		model.addAttribute("listOfRoles", listOfRoles);
		model.addAttribute("listOfAssignedRoles", listOfAssignedUserRoles);
		model.addAttribute("user", user);
		model.addAttribute("userTmp", userTmp);
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
	public String userEditPOST(@ModelAttribute("user") @Valid UserEntity user,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user/editView";
		}

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

	@RequestMapping(value = "/user/{userID}/edit-roles", method = RequestMethod.GET)
	public String userEditRolesGET(Locale locale, Model model,
			@PathVariable("userID") Integer userID) {
		if (logger.getLogger() == null)
			logger.setLogger(UserController.class);

		UserEntity user = userService.findByID(UserEntity.class, userID);
		
		List<RoleEntity> listOfAllRoles = roleService
				.findAll(RoleEntity.class);

		List<RoleEntity> listOfPossibleRoles = new ArrayList<RoleEntity>();
		
		for (RoleEntity role : listOfAllRoles) {
			for (RoleEntity userRole : user.getRoles()) {
				if (role.getId() != userRole.getId()) {
					listOfPossibleRoles.add(role);
				}
			}
		}


		model.addAttribute("listOfPossibleRoles", listOfPossibleRoles);
		model.addAttribute("user", user);
		return "user/editRoles";
	}

	@RequestMapping(value = "/user/{userID}/edit-roles", method = RequestMethod.POST)
	public String userEditRolesPOST(
			@ModelAttribute("user") @Valid UserEntity formUser, Model model,
			BindingResult result, Locale locale,
			@PathVariable("userID") Integer userID,
			@RequestParam(value = "role") String[] paramValues) {

		for (String a : paramValues) {
			System.out.println(a);
		}

		UserEntity realUser = userService.findByID(UserEntity.class, userID);
		if (result.hasErrors()) {
			return "user/" + realUser.getId() + "/edit-roles";
		} else {
			/*
			 * ArrayList<RoleEntity> roles = new ArrayList<RoleEntity>(); for
			 * (RoleEntity r : formUser.getRoles()) { roles.add(r); }
			 * realUser.setRoles(roles); userService.save(realUser);
			 */
		}
		return "redirect:/user/" + realUser.getId() + "/edit-roles";
	}

}
