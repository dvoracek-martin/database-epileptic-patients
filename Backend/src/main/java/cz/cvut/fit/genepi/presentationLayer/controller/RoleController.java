package cz.cvut.fit.genepi.presentationLayer.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.businessLayer.service.RoleService;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;

//TODO: this controller doesnt do anything right now
//@Scope("session")
@Controller
public class RoleController {

	/** The role service. */
	@Autowired
	private RoleService roleService;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(RoleController.class);

	@RequestMapping(value = "/role/create", method = RequestMethod.GET)
	public String roleCreateGET(Model model) {
		model.addAttribute("role", new RoleEntity());
		return "role/createView";
	}

	@RequestMapping(value = "/role/create", method = RequestMethod.POST)
	public String roleCreatePOST(
			@ModelAttribute("role") @Valid RoleEntity role,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "role/createView";
		} else {
			return "redirect:/role/" + Integer.toString(role.getId())
					+ "/overview";
		}
	}
	
	@RequestMapping(value = "/role/{roleID}/overview", method = RequestMethod.GET)
	public String roleOverviewGET(Locale locale, Model model,
			@PathVariable("roleID") Integer roleID) {
		RoleEntity role = roleService.findByID(RoleEntity.class, roleID);
		model.addAttribute("role", role);
		return "role/overviewView";
	}

	
	@RequestMapping(value = "/role/edit", method = RequestMethod.GET)
	public String roleEditGET(Model model) {
		model.addAttribute("role", new RoleEntity());
		return "role/editView";
	}
	
	@RequestMapping(value = "/role/edit", method = RequestMethod.POST)
	public String roleEditPOST(@ModelAttribute("role") @Valid RoleEntity role,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "role/editView";
		}		
		return "redirect:/role/" + Integer.toString(role.getId()) + "/overview";
	}


	@RequestMapping(value = "/role/delete", method = RequestMethod.GET)
	public String roleDeleteGET(Model model) {
		model.addAttribute("role", new RoleEntity());
		return "role/deleteView";
	}
	
	@RequestMapping(value = "/role/{roleID}/delete", method = RequestMethod.GET)
	public String roleDeleteGET(Locale locale, Model model,
			@PathVariable("roleID") Integer roleID) {
		roleService.delete(roleService.findByID(RoleEntity.class,
				roleID));
		return "redirect:/role/list";
	}
}
