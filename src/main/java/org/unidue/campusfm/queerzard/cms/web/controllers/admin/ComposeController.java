package org.unidue.campusfm.queerzard.cms.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;
import org.unidue.campusfm.queerzard.cms.database.services.user.CampusUserDetails;
import org.unidue.campusfm.queerzard.cms.utils.RestResponse;

import java.security.Principal;

@Controller
public class ComposeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

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

    @GetMapping("/compose")
    public String getComposer(){
        return "redirect:/compose/1";
    }

}
