
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

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.List;

/**
 * This class is a controller for browsing and searching articles.
 */
@Controller
public class BrowseController {

    @Autowired
    private ArticleService articleService;

    /**
     * Handles the search query request.
     *
     * @param model The model to add attributes to.
     * @param query The search query string. Cannot be blank.
     * @param page The page number of the search results. Must be a positive integer.
     *             Defaults to 0 if not provided.
     * @return The name of the view to render, which is "search".
     */
    @RequestMapping("/search")
    public String query(Model model, @RequestParam("query") @NotBlank String query,
                        @RequestParam(defaultValue = "0") @Min(0) @Positive int page){
        model.addAttribute("searchQuery", URLDecoder.decode(query));
        List<ArticleEntity> articles = articleService.findAllArticlesByQuery(URLDecoder.decode(query));
        Collections.reverse(articles);
        model.addAttribute("searchResultCount", articles.size());
        model.addAttribute("articleEntitiesList", articles);

        return "search";
    }

}
