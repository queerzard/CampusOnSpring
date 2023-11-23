
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;
import org.unidue.campusfm.queerzard.cms.database.services.user.CampusUserDetails;

/**
 * The ComposeController class is a controller that handles requests related to creating or editing an article.
 * It is responsible for retrieving the composer view, validating user authentication, checking permissions,
 * and adding or updating articles.
 */
@Controller
public class ComposeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    /**
     * Retrieves the composer view for creating or editing an article.
     * If the user is not authenticated, redirects to the home page.
     *
     * @param model the model object to which attributes are added
     * @param authentication the authentication object representing the logged-in user
     * @param articleId the ID of the article to edit (optional)
     * @return the view name for the composer page
     */
    @GetMapping("/compose/{id}")
    public String getComposer(Model model, Authentication authentication, @PathVariable(value = "id", required = false) String articleId){

        if(authentication == null)
            return "redirect:/";

        CampusUserDetails userDetails = ((CampusUserDetails) authentication.getPrincipal());

        if(articleId == null || articleId.isEmpty() || !articleService.articleExistsById(articleId)){

            ArticleEntity article = new ArticleEntity(((CampusUserDetails) (authentication.getPrincipal())).getUserEntity(),
                    "Unnamed", "And the story began with...",
                    "allgemein", "",
                    null, null);
            articleService.addArticle(article);
            return "redirect:/compose/" + article.getId();
        }

        ArticleEntity articleEntity = articleService.getArticleByPostId(articleId);

        boolean notAdmin = !userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().contains("ADMIN"));
        boolean isAuthor = articleEntity.getUserEntity().getId()
                .equals(userDetails.getUserEntity().getId());
        if(!isAuthor && notAdmin || notAdmin && !articleEntity.isEditable())
            return "redirect:/";

        model.addAttribute("articleEntity", articleEntity);
        model.addAttribute("notAuthor", !isAuthor);

        return "admin/compose";
    }

    /**
     * Redirects to the composer view for creating or editing an article with default ID
     * when accessed without providing an article ID.
     *
     * @return the redirect URL to the composer page with the default article ID
     */
    @GetMapping("/compose")
    public String getComposer(){
        return "redirect:/compose/1";
    }

}
