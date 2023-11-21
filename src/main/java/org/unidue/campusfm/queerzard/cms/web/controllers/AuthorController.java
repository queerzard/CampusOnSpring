package org.unidue.campusfm.queerzard.cms.web.controllers;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired private ArticleService articleService;
    @Autowired private UserService userService;

    @RequestMapping("/author/{username}")
    public String query(Model model, @PathVariable(value = "username", required = false) String username,
                        @RequestParam(defaultValue = "0") @Min(0) @Positive int page){

        if(username == null || username.isEmpty() || !userService.userExistsByName(username))
            return "redirect:/";

        UserEntity user = userService.getUserByUsername(username);
        List<ArticleEntity> articles = articleService.getArticlesByAuthor(user, PageRequest.of((page > 0 ? (page -1) : (page < 0 ? 0 : page)), 15));
        model.addAttribute("articleEntitiesList", articles);
        model.addAttribute("userEntity", user);

        return "author";
    }

}
