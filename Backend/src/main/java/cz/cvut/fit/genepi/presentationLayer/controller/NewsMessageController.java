package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.VO.form.NewsMessageVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.GenericService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.NewsMessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@SessionAttributes({"newsMessageVo"})
public class NewsMessageController {

    private AuthorizationChecker authorizationChecker;

    private GenericService<NewsMessageVO, NewsMessageEntity> genericService;

    @Autowired
    public NewsMessageController(AuthorizationChecker authorizationChecker,
                                 @Qualifier("genericServiceImpl")
                                 GenericService<NewsMessageVO, NewsMessageEntity> genericService) {

        this.authorizationChecker = authorizationChecker;
        this.genericService = genericService;
    }

    @RequestMapping(value = "/news/create", method = RequestMethod.GET)
    public String newsMessageCreateGET(
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("newsMessageVo", new NewsMessageVO());
        return "newsMessage/createView";
    }

    /**
     * Handles the request to create new news message.
     *
     * @param newsMessageVo the news message which was filled in form at front-end. It is
     * grabbed from POST string and validated.
     * @param result the result of binding form from front-end to an
     * NewsMessageEntity. It is used to determine if there were some
     * errors during binding.
     * @return the string of a view to be rendered if the binding has errors
     * otherwise, the string of an address to which the user will be
     * redirected.
     */
    @RequestMapping(value = "/news/create", method = RequestMethod.POST)
    public String newsMessageCreatePOST(
            @ModelAttribute("newsMessageVo") @Valid NewsMessageVO newsMessageVo, BindingResult result,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors()) {
            return "newsMessage/createView";
        }
        genericService.save(newsMessageVo, NewsMessageEntity.class);
        return "redirect:/";
    }

    @RequestMapping(value = "/news/{newsMessageId}/edit", method = RequestMethod.GET)
    public String newsMessageEditGET(
            @PathVariable("newsMessageId") int newsMessageId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        NewsMessageVO newsMessageVo = genericService.getById(newsMessageId, NewsMessageVO.class, NewsMessageEntity.class);
        model.addAttribute("newsMessageVo", newsMessageVo);
        return "newsMessage/editView";
    }

    /**
     * Handles the request to edit a news message.
     *
     * @param newsMessageId the id of a news message to be edited.
     * @param result the result of binding form from front-end to an
     * NewsMessageEntity. It is used to determine if there were some
     * errors during binding.
     * @return the string of a view to be rendered if the binding has errors
     * otherwise, the string of an address to which the user will be
     * redirected.
     */
    @RequestMapping(value = "/news/{newsMessageId}/edit", method = RequestMethod.POST)
    public String newsMessageEditPOST(
            @PathVariable("newsMessageId") int newsMessageId,
            @ModelAttribute("newsMessageVo") @Valid NewsMessageVO newsMessageVo, BindingResult result,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        if (result.hasErrors()) {
            return "newsMessage/editView";
        }

        genericService.update(newsMessageVo, NewsMessageEntity.class);
        return "redirect:/";
    }

    /**
     * Handles the request to delete a news message.
     *
     * @return the string of an address to to which the user will be redirected.
     */
    @RequestMapping(value = "/news/{newsMessageId}/delete", method = RequestMethod.GET)
    public String newsMessageDeleteGET(
            @PathVariable("newsMessageId") int newsMessageId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericService.delete(newsMessageId, NewsMessageEntity.class);
        return "redirect:/";
    }
}