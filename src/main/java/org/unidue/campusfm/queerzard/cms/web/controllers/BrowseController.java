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

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BrowseController {

    //TODO: SEARCH CONTENTS, AUTHORS, TAGS, CATEGORIES & HANDLE VALIDATION

    @RequestMapping("/search")
    public String query(Model model, @RequestParam("query") @NotBlank String query){
        model.addAttribute("searchQuery", URLDecoder.decode(query));
        List<ArticleEntity> articles = new ArrayList<>();
        model.addAttribute("searchResultCount", articles.size());
        return "search";
    }

}
