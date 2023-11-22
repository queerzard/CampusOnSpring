
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.controllers;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;

@Controller
public class ReaderController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/article")
    public String onRead(Model model, @RequestParam("a") @NotBlank String articleId){
        if(!articleService.articleExistsById(articleId))
            return "redirect:/";
        ArticleEntity article = articleService.getArticleByPostId(articleId);
        if(!article.isPublished())
            return "redirect:/";

        article.setViews(article.getViews() + 1);
        this.articleService.update(article);
        model.addAttribute("article", article);
        return "articleReader";
    }


}
