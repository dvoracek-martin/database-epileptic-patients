package cz.cvut.fit.genepi.presentationLayer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class is a controller class which handles requests connected with a
 * login page.
 */
@Controller
public class LoginController {

    /**
     * Handles the request to access login page.
     *
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET() {
        return "loginView";
    }
}
