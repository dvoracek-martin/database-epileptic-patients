package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.VO.form.UserVO;
import cz.cvut.fit.genepi.businessLayer.service.*;
import cz.cvut.fit.genepi.dataLayer.entity.ContactEntity;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * This class is a controller class which handles requests connected with a
 * user.
 */
@Controller
@SessionAttributes({"user"})
public class UserController {

    private AuthorizationChecker authorizationChecker;

    /**
     * The user service.
     */
    private UserService userService;

    /**
     * The role service.
     */
    private RoleService roleService;

    /**
     * The user role service.
     */
    private UserRoleService userRoleService;

    /**
     * The contact service.
     */
    private ContactService contactService;

    /**
     * The mail service.
     */
    private MailService mailService;

    /**
     * The Constant logger.
     */
    // private LoggingService logger = new LoggingService();
    @Autowired
    public UserController(AuthorizationChecker authorizationChecker,
                          UserService userService,
                          RoleService roleService,
                          UserRoleService userRoleService,
                          ContactService contactService,
                          MailService mailService) {
        this.authorizationChecker = authorizationChecker;
        this.userService = userService;
        this.roleService = roleService;
        this.userRoleService = userRoleService;
        this.contactService = contactService;
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
        model.addAttribute("user", new UserVO());
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
            @ModelAttribute("user") @Valid UserVO user,
            BindingResult result, Locale locale, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        boolean uniqueUsername = userService.isUniqueUsername(user.getUsername());
        boolean uniqueEmail = userService.isUniqueEmail(user.getContact().getEmail());

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

        model.addAttribute("user", userService.findByID(UserEntity.class, userId));

        return "user/overviewView";
    }

    @RequestMapping(value = "/user/{userId}/hide", method = RequestMethod.GET)
    public String userHideGET(@PathVariable("userId") Integer userId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        userService.hide(userId);
        return "redirect:/user/list?maxResults=20";
    }

    /**
     * Handles the request to page where the user can be edited.
     *
     * @param userID the id of a user to be edited.
     * @param locale the user's locale.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/user/{userID}/edit", method = RequestMethod.GET)
    public String userEditGET(@PathVariable("userID") Integer userID,
                              Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String name = auth.getName();
        List<UserRoleEntity> roles = userRoleService.findAllUserRolesByUserID((userService.findUserByUsername(name)).getId());
        boolean isAuthorized = false;
        for (UserRoleEntity r : roles) {
            if (r.getRole_id() == (5)) {
                isAuthorized = true;
                break;
            }
        }
        if (!isAuthorized && (userService.findUserByUsername(name).getId() != userID)) {
            return "deniedView";
        }
        model.addAttribute("user",
                userService.findByID(UserEntity.class, userID));
        model.addAttribute("isMailUnique", "unique");
        return "user/editView";
    }

    /**
     * Handles the request to submit edited user.
     *
     * @param user   the user which was edited in form at front-end. It is grabbed
     *               from POST string and validated.
     * @param result the result of binding form from front-end to an UserEntity. It
     *               is used to determine if there were some errors during binding.
     * @param locale the user's locale.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered if the binding has errors,
     * otherwise, the string of an address to which the user will be
     * redirected.
     */
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String userEditPOST(@Valid @ModelAttribute("user") UserEntity user,
                               BindingResult result, Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String name = auth.getName();
        List<UserRoleEntity> roles = userRoleService.findAllUserRolesByUserID((userService.findUserByUsername(name)).getId());
        boolean isAuthorized = false;
        for (UserRoleEntity r : roles) {
            if (r.getRole_id() == (5)) {
                isAuthorized = true;
                break;
            }
        }
        if (!isAuthorized && (userService.findUserByUsername(name).getId() != user.getId())) {
            return "deniedView";
        }


        boolean mailUnique = true;

        if (userService.findUserByEmail(user.getContact().getEmail()) != null)
            mailUnique = false;
        if (result.hasErrors() || !mailUnique) {

            if (!mailUnique)
                model.addAttribute("isMailUnique", "notUnique");
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
        }

        if (!authorizationChecker.isAdmin() && !authorizationChecker.isUserFromUrl(userId)) {
            return "deniedView";
        }


      /*  if (logger.getLogger() == null)
            logger.setLogger(UserController.class);
        logger.logInfo("Changing password");*/

        UserVO user = userService.findById(userId);
        user.setPassword("");
        model.addAttribute("user", user);
        model.addAttribute("samePasswords", true);
        return "user/changePassword";
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
            @ModelAttribute("user") @Valid UserVO user, BindingResult result,
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
            }
            return "user/changePassword";
        } else {
            userService.changePassword(user);
            mailService.notifyChangedPassword(user,passwordAgain,locale);
            return "redirect:/user/" + userId + "/overview";
        }
    }

    // TODO: revision
    @RequestMapping(value = "/user/{userId}/edit-roles", method = RequestMethod.GET)
    public String userEditRolesGET(@PathVariable("userId") Integer userId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        /*
        if (logger.getLogger() == null)
            logger.setLogger(UserController.class);*/

        UserEntity user = userService.findByID(UserEntity.class, userId);

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
            @RequestParam(value = "role") int[] paramValues, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String name = auth.getName();
        List<UserRoleEntity> roles = userRoleService.findAllUserRolesByUserID((userService.findUserByUsername(name)).getId());
        boolean isAuthorized = false;
        for (UserRoleEntity r : roles) {
            if (r.getRole_id() == (5)) {
                isAuthorized = true;
                break;
            }
        }
        if (!isAuthorized && (userService.findUserByUsername(name).getId() != formUser.getId())) {
            return "deniedView";
        }

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
        return "redirect:/user/list?maxResults=20&pageNumber=1";
    }
}