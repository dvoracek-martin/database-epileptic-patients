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

	/** The role service. */
	@Autowired
	private RoleService roleService;

	/** The user role service. */
	@Autowired
	private UserRoleService userRoleService;

	/** The contact service. */
	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profileGET(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		model.addAttribute("user",
				userService.findUserByUsername(auth.getName()));
		return "profileView";
	}
}
