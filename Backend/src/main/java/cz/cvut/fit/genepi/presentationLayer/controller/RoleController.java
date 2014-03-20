package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//TODO: this controller doesnt do anything right now
//@Scope("session")
@Controller
public class RoleController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    /**
     * The role service.
     */
   /* @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/role/create", method = RequestMethod.GET)
    public String roleCreateGET(Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("role", new RoleEntity());
        return "role/createView";
    }

    @RequestMapping(value = "/role/create", method = RequestMethod.POST)
    public String roleCreatePOST(
            @ModelAttribute("role") @Valid RoleEntity role,
            BindingResult result, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }


        if (result.hasErrors()) {
            return "role/createView";
        } else {
            return "redirect:/role/" + Integer.toString(role.getId())
                    + "/overview";
        }
    }

    @RequestMapping(value = "/role/{roleID}/overview", method = RequestMethod.GET)
    public String roleOverviewGET(Locale locale, Model model,
                                  @PathVariable("roleID") Integer roleID, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        RoleEntity role = roleService.findByID(RoleEntity.class, roleID);
        model.addAttribute("role", role);
        return "role/overviewView";
    }


    @RequestMapping(value = "/role/edit", method = RequestMethod.GET)
    public String roleEditGET(Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("role", new RoleEntity());
        return "role/editView";
    }

    @RequestMapping(value = "/role/edit", method = RequestMethod.POST)
    public String roleEditPOST(@ModelAttribute("role") @Valid RoleEntity role,
                               BindingResult result, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        if (result.hasErrors()) {
            return "role/editView";
        }
        return "redirect:/role/" + Integer.toString(role.getId()) + "/overview";
    }


    @RequestMapping(value = "/role/delete", method = RequestMethod.GET)
    public String roleDeleteGET(Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("role", new RoleEntity());
        return "role/deleteView";
    }

    @RequestMapping(value = "/role/{roleID}/delete", method = RequestMethod.GET)
    public String roleDeleteGET(Locale locale, Model model,
                                @PathVariable("roleID") Integer roleID, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        roleService.delete(roleService.findByID(RoleEntity.class,
                roleID));
        return "redirect:/role/list";
    }*/
}
