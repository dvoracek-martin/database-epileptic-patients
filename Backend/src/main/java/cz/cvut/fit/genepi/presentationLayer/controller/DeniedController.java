package cz.cvut.fit.genepi.presentationLayer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class is a controller class which handles requests connected with a
 * denied page.
 */
@Controller
public class DeniedController {

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
