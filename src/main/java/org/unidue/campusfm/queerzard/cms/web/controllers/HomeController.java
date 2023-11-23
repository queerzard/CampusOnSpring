
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * This class is a controller for the home page of the application.
 * It handles requests for the home page and returns the appropriate view.
 */
@Controller
public class HomeController {

    @Autowired
    private ArticleService articleService;

    /**
     * This method is invoked when accessing the home page. It retrieves a list
     * of published articles from the articleService, based on the specified page number.
     *
     * @param model the Model object used to pass data to the view
     * @param page the page number to retrieve the articles from (default value: 1)
     * @return the name of the view to be rendered
     */
    @RequestMapping(value = {"/", "/home"})
    public String onAccess(Model model, @RequestParam(defaultValue = "1") @Min(1) @Positive int page){
        List<ArticleEntity> entities = articleService
                .findAllPublishedArticles((page > 0 ? (page -1) : (page < 0 ? 0 : page)), 9);
        model.addAttribute("articleEntitiesList", entities);
        return "home";
    }


}
