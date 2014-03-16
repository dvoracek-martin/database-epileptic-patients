package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * This class is a controller class which handles requests connected with a
 * denied page.
 */
@Controller
public class DeniedController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    /**
     * Handles the request to access denied page.
     *

     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String deniedGET() {
        return "deniedView";
    }
}
