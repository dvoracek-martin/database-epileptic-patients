package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.BO.form.RoleFormBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.UserFormBO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.MailService;
import cz.cvut.fit.genepi.businessLayer.service.RoleService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * This class is a controller class which handles requests connected with a
 * user.
 */
@Controller
@SessionAttributes({"user"})
public class UserController {

    private final AuthorizationChecker authorizationChecker;

    /**
     * The user service.
     */
    private final UserService userService;

    /**
     * The role service.
     */
    private final RoleService roleService;

    /**
     * The mail service.
     */
    private final MailService mailService;

    @Autowired
    public UserController(AuthorizationChecker authorizationChecker,
                          UserService userService,
                          RoleService roleService,
                          MailService mailService) {

        this.authorizationChecker = authorizationChecker;
        this.userService = userService;
        this.roleService = roleService;
        this.mailService = mailService;
    }

    /**
     * Handles the request to access page for creating new user.
     *
     * @param model the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String userCreateGET(Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("uniqueUsername", true);
        model.addAttribute("uniqueEmail", true);
        model.addAttribute("user", new UserFormBO());
        return "user/createView";
    }

    /**
     * Handles the request to submit a new user.
     *
     * @param user   the user which was filled in form at front-end. It is grabbed
     *               from POST string and validated.
     * @param result the result of binding form from front-end to an UserEntity. It
     *               is used to determine if there were some errors during binding.
     * @param locale the user's locale.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered if the binding has errors and
     * if there is a duplication of username otherwise, the string of an
     * address to which the user will be redirected.
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String userCreatePOST(
            @ModelAttribute("user") @Valid UserFormBO user,
            BindingResult result, Locale locale, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        boolean uniqueUsername = userService.isUniqueUsername(user.getUsername());
        boolean uniqueEmail = true;

        if (!user.getContact().getEmail().equals("")) {
            uniqueEmail = userService.isUniqueEmail(user.getContact().getEmail());
        }

        if (result.hasErrors() || !uniqueUsername || !uniqueEmail) {
            model.addAttribute("uniqueUsername", uniqueUsername);
            model.addAttribute("uniqueEmail", uniqueEmail);
            return "user/createView";
        } else {
            int userId = userService.create(user, locale);
            return "redirect:/user/" + Integer.toString(userId) + "/overview";
        }
    }

    /**
     * Handles the request to access page with user's overview.
     *
     * @param userId the id of a user for whom the overview is to be rendered.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/user/{userId}/overview", method = RequestMethod.GET)
    public String userOverviewGET(@PathVariable("userId") Integer userId,
                                  Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("user", userService.getById(userId, UserFormBO.class, UserEntity.class));

        return "user/overviewView";
    }

    @RequestMapping(value = "/user/{userId}/hide", method = RequestMethod.GET)
    public String userHideGET(@PathVariable("userId") Integer userId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        userService.hide(userId);
        userService.revokeRoles(userId);
        return "redirect:/user/list?maxResults=20";
    }

    /**
     * Handles the request to page where the user can be edited.
     *
     * @param userId the id of a user to be edited.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/user/{userId}/edit", method = RequestMethod.GET)
    public String userEditGET(@PathVariable("userId") int userId,
                              Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (!authorizationChecker.isAdmin() && !authorizationChecker.isUserFromUrl(userId)) {
            return "deniedView";
        } else {

            model.addAttribute("user", userService.getById(userId, UserFormBO.class, UserEntity.class));
            model.addAttribute("uniqueUsername", true);
            model.addAttribute("uniqueEmail", true);
            model.addAttribute("isAdmin", authorizationChecker.isAdmin());
            return "user/editView";
        }
    }

    /**
     * Handles the request to submit edited user.
     *
     * @param user   the user which was edited in form at front-end. It is grabbed
     *               from POST string and validated.
     * @param result the result of binding form from front-end to an UserEntity. It
     *               is used to determine if there were some errors during binding.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered if the binding has errors,
     * otherwise, the string of an address to which the user will be
     * redirected.
     */
    @RequestMapping(value = "/user/{userId}/edit", method = RequestMethod.POST)
    public String userEditPOST(@ModelAttribute("user") @Valid UserFormBO user, BindingResult result,
                               @PathVariable("userId") int userId,
                               Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (!authorizationChecker.isAdmin() && !authorizationChecker.isUserFromUrl(userId)) {
            return "deniedView";
        } else {

            boolean uniqueUsername = userService.isMineOrUniqueUsername(user.getId(), user.getUsername());
            boolean uniqueEmail = userService.isMineOrUniqueEmail(user.getId(), user.getContact().getEmail());

            if (result.hasErrors() || !uniqueUsername || !uniqueEmail) {
                model.addAttribute("uniqueUsername", uniqueUsername);
                model.addAttribute("uniqueEmail", uniqueEmail);
                model.addAttribute("isAdmin", authorizationChecker.isAdmin());
                return "user/editView";
            } else {
                userService.update(user, UserEntity.class);
            }
            if (!authorizationChecker.isAdmin()) {
                return "redirect:/profile";
            } else {
                return "redirect:/user/" + userId + "/overview";
            }
        }
    }

    /**
     * Handles the request to access list of users page.
     *
     * @param model the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String userListGET(@RequestParam(value = "maxResults", defaultValue = "20", required = false) int maxResults,
                              Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("userList", userService.findAllNonHidden());
        model.addAttribute("maxResults", maxResults);
        return "user/listView";
    }

    /**
     * Handles the request to access page where user's password is changed.
     *
     * @param userId the id of a user whose password is edited.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/user/{userId}/change-password", method = RequestMethod.GET)
    public String userChangePasswordGET(@PathVariable("userId") Integer userId,
                                        Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (!authorizationChecker.isAdmin() && !authorizationChecker.isUserFromUrl(userId)) {
            return "deniedView";
        } else {
            UserFormBO user = userService.getById(userId, UserFormBO.class, UserEntity.class);
            user.setPassword("");
            model.addAttribute("user", user);
            model.addAttribute("samePasswords", true);
            model.addAttribute("isAdmin", authorizationChecker.isAdmin());
            return "user/changePassword";
        }
    }

    /**
     * @param user   the user whose password was edited in form at front-end. It is grabbed
     *               from POST string and validated.
     * @param result the result of binding form from front-end to an UserEntity. It
     *               is used to determine if there were some errors during binding.
     * @param userId the id of a user whose password is edited.
     * @param locale the user's locale.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered if the binding has errors,
     * otherwise, the string of an address to which the user will be
     * redirected.
     */
    @RequestMapping(value = "/user/{userId}/change-password", method = RequestMethod.POST)
    public String userChangePasswordPOST(
            @ModelAttribute("user") @Valid UserFormBO user, BindingResult result,
            @PathVariable("userId") int userId,
            @RequestParam("passwordAgain") String passwordAgain,
            Locale locale, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (!authorizationChecker.isAdmin() && !authorizationChecker.isUserFromUrl(userId)) {
            return "deniedView";
        } else if (result.hasErrors() || !user.getPassword().equals(passwordAgain)) {
            if (!user.getPassword().equals(passwordAgain)) {
                model.addAttribute("samePasswords", false);
                model.addAttribute("isAdmin", authorizationChecker.isAdmin());
            }
            return "user/changePassword";
        } else {
            userService.changePassword(user);
            mailService.notifyChangedPassword(user, passwordAgain, locale);
            if (!authorizationChecker.isAdmin()) {
                return "redirect:/profile";
            } else {
                return "redirect:/user/" + userId + "/overview";
            }
        }
    }

    @RequestMapping(value = "/user/{userId}/edit-roles", method = RequestMethod.GET)
    public String userEditRolesGET(@PathVariable("userId") Integer userId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {

            UserFormBO user = userService.getById(userId, UserFormBO.class, UserEntity.class);
            List<RoleFormBO> possibleRoles = roleService.getPossibleRoles(userId);
            model.addAttribute("user", user);
            model.addAttribute("possibleRoles", possibleRoles);
            return "user/editRoles";
        }
    }

    @RequestMapping(value = "/user/{userId}/edit-roles", method = RequestMethod.POST)
    public String userEditRolesPOST(
            @PathVariable("userId") Integer userId,
            @RequestParam(value = "role", defaultValue = "0") int[] roleIds, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {

            //TODO transfer to service
            List<RoleFormBO> newRoles = new ArrayList<>();

            if (roleIds.length > 0 && roleIds[0] != 0) {
                for (int id : roleIds) {
                    newRoles.add(roleService.getById(id, RoleFormBO.class, RoleEntity.class));
                }
            }
            UserFormBO userFormBO = userService.getById(userId, UserFormBO.class, UserEntity.class);
            userFormBO.setRoles(newRoles);

            userService.update(userFormBO, UserEntity.class);
            return "redirect:/user/" + userId + "/overview";
        }
    }
}
