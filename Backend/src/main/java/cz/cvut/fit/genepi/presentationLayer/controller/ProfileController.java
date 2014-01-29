package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * This class is a controller class which handles requests connected with a
 * user's profile page.
 */
@Controller
public class ProfileController {

    /**
     * The user service.
     */
    @Autowired
    private UserService userService;

    /**
     * Handles the request to access user's profile page.
     *
     * @param locale the user's locale.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profileGET(Locale locale, Model model) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();

        model.addAttribute("user",
                userService.findUserByUsername(auth.getName()));
        return "profileView";
    }
}
