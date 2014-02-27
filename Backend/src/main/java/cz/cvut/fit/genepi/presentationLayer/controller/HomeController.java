package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.service.NewsMessageService;
import cz.cvut.fit.genepi.dataLayer.entity.NewsMessageEntity;
import cz.cvut.fit.genepi.util.AuthorizationChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * This class is a controller class which handles requests connected with a home
 * and news pages.
 */
@Controller
public class HomeController {
    @Autowired
    AuthorizationChecker authorizationChecker;

    /**
     * The news message service.
     */
    @Autowired
    private NewsMessageService newsMessageService;

    /**
     * Handles the request to access home page.
     *
     * @param locale the user's locale.
     * @param model  the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeGET(Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        // TODO: overide findAll rto return reverted news list
        List<NewsMessageEntity> newsMessages = newsMessageService
                .findAll(NewsMessageEntity.class);
        Collections.reverse(newsMessages);
        model.addAttribute("newsMessages", newsMessages);
        model.addAttribute("patientList",
                newsMessageService.findAll(NewsMessageEntity.class));
        model.addAttribute("emptyMessage", new NewsMessageEntity());
        return "homeView";
    }

    /**
     * Handles the request to create new news message.
     *
     * @param newsMessage the news message which was filled in form at front-end. It is
     *                    grabbed from POST string and validated.
     * @param result      the result of binding form from front-end to an
     *                    NewsMessageEntity. It is used to determine if there were some
     *                    errors during binding.
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the string of a view to be rendered if the binding has errors
     * otherwise, the string of an address to which the user will be
     * redirected.
     */
    @RequestMapping(value = "/news/create", method = RequestMethod.POST)
    public String newsMessageCreatePOST(
            @ModelAttribute("newsMessage") @Valid NewsMessageEntity newsMessage,
            BindingResult result, Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors()) {
            // TODO: override findAll to return reverted news list
            List<NewsMessageEntity> newsMessages = newsMessageService
                    .findAll(NewsMessageEntity.class);
            Collections.reverse(newsMessages);
            model.addAttribute("newsMessages", newsMessages);
            return "homeView";
        }
        newsMessageService.save(newsMessage);
        return "redirect:/";
    }

    /**
     * Handles the request to edit a news message.
     *
     * @param newsMessageID   the id of a news message to be edited.
     * @param formNewsMessage the news message which was edited in form at front-end. It is
     *                        grabbed from POST string and validated.
     * @param result          the result of binding form from front-end to an
     *                        NewsMessageEntity. It is used to determine if there were some
     *                        errors during binding.
     * @param locale          the user's locale.
     * @param model           the model to be filled for view.
     * @return the string of a view to be rendered if the binding has errors
     * otherwise, the string of an address to which the user will be
     * redirected.
     */
    @RequestMapping(value = "/news/{newsMessageID}/edit", method = RequestMethod.POST)
    public String newsMessageEditPOST(
            @PathVariable("newsMessageID") Integer newsMessageID,
            @ModelAttribute("formNewsMessage") @Valid NewsMessageEntity formNewsMessage,
            BindingResult result, Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        if (result.hasErrors()) {
            // TODO: override findAll to return reverted news list
            List<NewsMessageEntity> newsMessages = newsMessageService
                    .findAll(NewsMessageEntity.class);
            Collections.reverse(newsMessages);
            model.addAttribute("newsMessages", newsMessages);
            return "homeView";
        }

        NewsMessageEntity realNewsMessage = newsMessageService.findByID(
                NewsMessageEntity.class, newsMessageID);
        realNewsMessage.setMessage(formNewsMessage.getMessage());
        newsMessageService.save(realNewsMessage);
        return "redirect:/";
    }

    /**
     * Handles the request to delete a news message.
     *
     * @param newsMessageID the id of a news message to be deleted.
     * @param locale        the user's locale.
     * @param model         the model to be filled for view.
     * @return the string of an address to to which the user will be redirected.
     */
    @RequestMapping(value = "/news/{newsMessageID}/delete", method = RequestMethod.GET)
    public String newsMessageDeleteGET(
            @PathVariable("newsMessageID") Integer newsMessageID,
            Locale locale, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        newsMessageService.delete(newsMessageService.findByID(
                NewsMessageEntity.class, newsMessageID));
        return "redirect:/";
    }
}
