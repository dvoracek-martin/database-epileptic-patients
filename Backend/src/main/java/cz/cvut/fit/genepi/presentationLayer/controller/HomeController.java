package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.NewsMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is a controller class which handles requests connected with a home page.
 */
@Controller
public class HomeController {

    private AuthorizationChecker authorizationChecker;

    /**
     * The news message service.
     */
    private NewsMessageService newsMessageService;

    @Autowired
    public HomeController(AuthorizationChecker authorizationChecker,
                          NewsMessageService newsMessageService) {

        this.authorizationChecker = authorizationChecker;
        this.newsMessageService = newsMessageService;
    }

    /**
     * Handles the request to access home page.
     *
     * @param model the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeGET(Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("newsMessages", newsMessageService.getSortedNewsMessages());

        return "homeView";
    }
}