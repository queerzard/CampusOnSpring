package org.unidue.campusfm.queerzard.cms.web.controllers;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class BrowseController {

    //TODO: SEARCH CONTENTS, AUTHORS, TAGS, CATEGORIES & HANDLE VALIDATION

    @Autowired
    private ArticleService articleService;

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
