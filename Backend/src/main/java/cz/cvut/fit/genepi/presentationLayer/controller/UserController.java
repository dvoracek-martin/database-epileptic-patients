package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.service.*;
import cz.cvut.fit.genepi.dataLayer.entity.ContactEntity;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.util.LoggingService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
public class UserController {

    /**
     * The user service.
     */
    @Autowired
    private UserService userService;

    /**
     * The role service.
     */
    @Autowired
    private RoleService roleService;

    /**
     * The user role service.
     */
    @Autowired
    private UserRoleService userRoleService;

    /**
     * The contact service.
     */
    @Autowired
    private ContactService contactService;

    /**
     * The mail service.
     */
    @Autowired
    private MailService mailService;

    /**
     * The Constant logger.
     */
    private LoggingService logger = new LoggingService();

    /**
     * Handles the request to access page for creating new user.
     *
     * @param locale the user's locale.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public String userCreateGET(Locale locale, Model model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("isUnique", "unique");
        model.addAttribute("isMailUnique", "unique");
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
            @ModelAttribute("user") @Valid UserEntity user,
            BindingResult result, Locale locale, Model model) {
        boolean unique = true;
        boolean mailUnique = true;

        if (userService.findUserByUsername(user.getUsername()) != null)
            unique = false;
        if (userService.findUserByEmail(user.getContact().getEmail()) != null)
            mailUnique = false;
        if (result.hasErrors() || !unique || !mailUnique) {
            if (!unique)
                model.addAttribute("isUnique", "notUnique");
            if (!mailUnique)
                model.addAttribute("isMailUnique", "notUnique");
            return "user/createView";
        } else {
            // TODO: maybe userSrvice.create should do this IF and return
            // boolean
            if (userService.findUserByUsername(user.getUsername()) != null) {
                model.addAttribute("isUnique", "notUnique");
                return "user/createView";
            } else {
                userService.create(user, locale);
                if (logger.getLogger() == null)
                    logger.setLogger(UserController.class);
                logger.logInfo("New user successfuly created.");
                return "redirect:/user/" + Integer.toString(user.getId())
                        + "/overview";
            }
        }
    }

    /**
     * Handles the request to access page with user's overview.
     *
     * @param userID the id of a user for whom the overview is to be rendered.
     * @param locale the user's locale.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/user/{userID}/overview", method = RequestMethod.GET)
    public String userOverviewGET(@PathVariable("userID") Integer userID,
                                  Locale locale, Model model) {
        model.addAttribute("user",
                userService.findByID(UserEntity.class, userID));
        return "user/overviewView";
    }

    @RequestMapping(value = "/user/{userID}/delete", method = RequestMethod.GET)
    public String userDeleteGET(Locale locale, Model model,
                                @PathVariable("userID") Integer userID) {
        userService.delete(userService.findByID(UserEntity.class, userID));
        return "redirect:/user/list";
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
                              Locale locale, Model model) {
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
                               BindingResult result, Locale locale, Model model) {

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
     * @param locale the user's locale.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String userListGET(Locale locale, Model model) {
        model.addAttribute("userList", userService.findAll(UserEntity.class));
        return "user/listView";
    }

    /**
     * Handles the request to access page where user's password is changed.
     *
     * @param userID the id of a user whose password is edited.
     * @param locale the user's locale.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/user/{userID}/change-password", method = RequestMethod.GET)
    public String userChangePasswordGET(@PathVariable("userID") Integer userID,
                                        Locale locale, Model model) {

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
     * @param formUser the user whose password was edited in form at front-end. It is grabbed
     *                 from POST string and validated.
     * @param result   the result of binding form from front-end to an UserEntity. It
     *                 is used to determine if there were some errors during binding.
     * @param userID   the id of a user whose password is edited.
     * @param locale   the user's locale.
     * @param model    the model to be filled for view.
     * @return the string of a view to be rendered if the binding has errors,
     * otherwise, the string of an address to which the user will be
     * redirected.
     */
    @RequestMapping(value = "/user/{userID}/change-password", method = RequestMethod.POST)
    public String userChangePasswordPOST(
            @ModelAttribute("user") @Valid UserEntity formUser,
            BindingResult result, @PathVariable("userID") Integer userID,
            Locale locale, Model model) {
        UserEntity realUser = userService.findByID(UserEntity.class, userID);
        if (result.hasErrors()) {
            return "user/" + realUser.getId() + "/change-password";
        } else {
            // TODO: transfer to Service
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

    // TODO: revision
    @RequestMapping(value = "/user/{userID}/edit-roles", method = RequestMethod.GET)
    public String userEditRolesGET(Locale locale, Model model,
                                   @PathVariable("userID") Integer userID) {
        if (logger.getLogger() == null)
            logger.setLogger(UserController.class);

        UserEntity user = userService.findByID(UserEntity.class, userID);

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
            @RequestParam(value = "role") int[] paramValues) {

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
        return "redirect:/user/" + realUser.getId() + "/edit-roles";
    }
}
