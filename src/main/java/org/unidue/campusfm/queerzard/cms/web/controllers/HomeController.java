package org.unidue.campusfm.queerzard.cms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;

@Controller
public class HomeController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public String onAccess(Model model, @RequestParam(defaultValue = "0") int page){

        model.addAttribute("articleEntitiesList", articleService
                .findAllPublishedArticles((page > 0 ? (page -1) : (page < 0 ? 0 : page)), 9));
        return "home";
    }


}
