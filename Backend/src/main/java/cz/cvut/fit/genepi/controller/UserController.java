package cz.cvut.fit.genepi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.UserRoleService;
import cz.cvut.fit.genepi.service.UserService;
import cz.cvut.fit.genepi.serviceImpl.MailServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@Controller
public class UserController {

	/** The user service. */
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private ContactService contactService;

	/**
	 * Creates the user get.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public String createUserGET(Locale locale, Model model) {
		model.addAttribute("user", new UserEntity());
		model.addAttribute("isUnique", "unique");
		return "createUserView";
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
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUserGET(@ModelAttribute("user") @Valid UserEntity user,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "createUserView";
		} else {
			if (userService.findUserByUsername(user.getUsername()) != null) {
				model.addAttribute("isUnique", "notUnique");
				return "createUserView";
			} else {
				user.setPassword(DigestUtils.sha256Hex(user.getPassword() + "{"
						+ user.getUsername() + "}"));
				userService.save(user);
				return "redirect:/userOverview/"
						+ Integer.toString(user.getId());
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
	@RequestMapping(value = "/userOverview/{userID}", method = RequestMethod.GET)
	public String userOverviewGET(Locale locale, Model model,
			@PathVariable("userID") Integer userID) {
		UserEntity user = userService.findByID(UserEntity.class, userID);
		model.addAttribute("user", user);
		return "userOverviewView";
	}

	@RequestMapping(value = "/userEdit/{userID}", method = RequestMethod.GET)
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

		System.out.println(user.getContact().getId());

		model.addAttribute("listOfRoles", listOfRoles);
		model.addAttribute("listOfAssignedRoles", listOfAssignedUserRoles);
		model.addAttribute("user", user);
		model.addAttribute("userTmp", userTmp);
		return "userEditView";
	}

	@RequestMapping(value = "/userEdit", method = RequestMethod.POST)
	public String editUserGET(@ModelAttribute("user") @Valid UserEntity user,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "userEditView";
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
		return "redirect:/userOverview/" + Integer.toString(user.getId());

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
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String usersListGET(Locale locale, Model model) {
		model.addAttribute("userList", userService.findAll(UserEntity.class));
		return "userListView";
	}

	@RequestMapping(value = "/userChangePassword/{userID}", method = RequestMethod.GET)
	public String userChangePasswordGET(Locale locale, Model model,			@PathVariable("userID") Integer userID) {
		UserEntity user = userService.findByID(UserEntity.class, userID);
		model.addAttribute("user", user);
		model.addAttribute("passwordChanged", false);
		return "userChangePassword";
	}

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String changePasswordPOST(@ModelAttribute("user") UserEntity user,
			@ModelAttribute("newPassword") String newPassword, Model model) {
		user.setPassword(DigestUtils.sha256Hex(newPassword + "{"
				+ user.getUsername() + "}"));
		userService.save(user);
		model.addAttribute("passwordChanged", true);
		MailServiceImpl mailService = new MailServiceImpl();
		try {
			mailService.send(null, user.getContact().getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/passwordChanged";
	}
}
