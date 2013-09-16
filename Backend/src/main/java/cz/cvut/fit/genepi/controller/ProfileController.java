package cz.cvut.fit.genepi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.entity.UserRoleEntity;
import cz.cvut.fit.genepi.service.ContactService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.UserRoleService;
import cz.cvut.fit.genepi.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class MyProfileController.
 */
@Controller
public class ProfileController {

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
	 * My profile post.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String myProfilePOST(Locale locale, Model model) {
		return "profileView";
	}

	/**
	 * Login get.
	 * 
	 * @param user
	 *            the user
	 * @param result
	 *            the result
	 * @return the string
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String myProfileGET(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		UserEntity user = userService.findUserByUsername(auth.getName());
		List<UserRoleEntity> listOfAssignedUserRoles = userRoleService
				.findAllUserRolesByUserID(user.getId());
		List<RoleEntity> listOfAssignedRoles = new ArrayList<RoleEntity>();
		List<RoleEntity> listOfPossibleRoles = roleService
				.findAll(RoleEntity.class);

		for (UserRoleEntity userRole : listOfAssignedUserRoles) {
			for (RoleEntity role : listOfPossibleRoles) {
				if (userRole.getRole_id() == role.getId()) {
					listOfAssignedRoles.add(role);
				}
			}
		}
		model.addAttribute("user", user);
		model.addAttribute("listOfAssignedRoles", listOfAssignedRoles);
		return "profileView";
	}
}
