package cz.cvut.fit.genepi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
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

import cz.cvut.fit.genepi.entity.ContactEntity;
import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.entity.UserRoleEntity;
import cz.cvut.fit.genepi.service.ContactService;
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
	private MailService mailService;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	/**
	 * Creates the user get.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public String createUserGET(Model model) {
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
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUserGET(@ModelAttribute("user") @Valid UserEntity user,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "user/createView";
		} else {
			if (userService.findUserByUsername(user.getUsername()) != null) {
				model.addAttribute("isUnique", "notUnique");
				return "user/createView";
			} else {
				user.setPassword(DigestUtils.sha256Hex(user.getPassword() + "{"
						+ user.getUsername() + "}"));

				userService.save(user);
				List<Integer> listOfRoles = new ArrayList<Integer>();
				listOfRoles.add(1);
				List<UserRoleEntity> listOfUserRoles = new ArrayList<UserRoleEntity>();
				for (int i : listOfRoles) {
					UserRoleEntity userRole = new UserRoleEntity();
					userRole.setUser_id(user.getId());
					userRole.setRole_id(i);
					listOfUserRoles.add(userRole);
				}
				for (UserRoleEntity userRole : listOfUserRoles) {
					userRoleService.save(userRole);
				}
				try {
					mailService = new MailService();
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("subject", "creationOfANewUser");
					map.put("user", user);
					map.put("password", user.getPassword());
					mailService.sendMail("test", map);
				} catch (Exception e) {
					e.printStackTrace();
				}
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

	/**
	 * User edit get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @param userID the user id
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
	 * @param user the user
	 * @param result the result
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/user/edit", method = RequestMethod.POST)
	public String editUserGET(@ModelAttribute("user") @Valid UserEntity user,
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
	public String usersListGET(Locale locale, Model model) {
		model.addAttribute("userList", userService.findAll(UserEntity.class));
		return "user/listView";
	}

	/**
	 * User change password get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @param userID the user id
	 * @return the string
	 */
	@RequestMapping(value = "/user/{userID}/change-password", method = RequestMethod.GET)
	public String userChangePasswordGET(Locale locale, Model model,
			@PathVariable("userID") Integer userID) {
		logger.info("Changing password");
		UserEntity user = userService.findByID(UserEntity.class, userID);
		user.setPassword("");
		model.addAttribute("user", user);
		model.addAttribute("passwordChanged", false);
		return "user/changePassword";
	}

	/**
	 * Change password post.
	 *
	 * @param user the user
	 * @param model the model
	 * @param result the result
	 * @return the string
	 */
	@RequestMapping(value = "/user/change-password", method = RequestMethod.POST)
	public String changePasswordPOST(@ModelAttribute("user") @Valid UserEntity user,
			Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "user/"+user.getId()+"change-password";
		} else {
		String password = user.getPassword();
		user.setPassword(DigestUtils.sha256Hex(user.getPassword() + "{"
				+ user.getUsername() + "}"));
		userService.save(user);
		model.addAttribute("passwordChanged", true);
		try {
			mailService = new MailService();
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("subject", "changeOfThePassword");
			map.put("user", user);
			map.put("password", password);
			mailService.sendMail("test", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return "redirect:/user/" + user.getId() + "/change-password";
	}
}
