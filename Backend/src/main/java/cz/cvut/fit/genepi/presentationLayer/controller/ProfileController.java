package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is a controller class which handles requests connected with a
 * user's profile page.
 */
@Controller
public class ProfileController {

    @Autowired
    AuthorizationChecker authorizationChecker;

    /**
     * The user service.
     */
    @Autowired
    private UserService userService;

    /**
     * Handles the request to access user's profile page.
     *
     * @param model the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profileGET(Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();

        model.addAttribute("user", userService.getUserByUsername(auth.getName()));
        return "profileView";
    }
}