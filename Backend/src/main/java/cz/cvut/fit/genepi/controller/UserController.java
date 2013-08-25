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

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.UserRoleService;
import cz.cvut.fit.genepi.service.UserService;

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
	private UserRoleService UserRoleService;

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
	 * @param user the user
	 * @param result the result
	 * @param model the model
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
		UserEntity user = userService.findByID(userID);
		model.addAttribute("user", user);
		return "userOverviewView";
	}
	
	@RequestMapping(value = "/userEdit/{userID}", method = RequestMethod.POST)
	public String userEditGET(Locale locale, Model model,
			@PathVariable("userID") Integer userID) {
		UserEntity user = userService.findByID(userID);
		
		List<RoleEntity> listOfRoles=new ArrayList<RoleEntity>();
		listOfRoles = roleService.findAll();		
		List<RoleEntity> listOfAssignedRoles=new ArrayList<RoleEntity>();		
		
		model.addAttribute("listOfRoles", listOfRoles);
		model.addAttribute("listOfAssignedRoles", listOfAssignedRoles);
		model.addAttribute("user", user);
		
		return "userEditView";
	}
	
	@RequestMapping(value = "/userEdit", method = RequestMethod.POST)
	public String userEdit(
			@ModelAttribute("user") @Valid UserEntity user,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/userEdit/{"+user.getId()+"}";
		} else {
			userService.save(user);
			return "redirect:/userOverview/"
					+ Integer.toString(user.getId());
		}
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
		model.addAttribute("userList", userService.findAll());
		return "userListView";
	}

}
