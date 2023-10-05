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
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ArticleService articleService;

    //TODO: HANDLE VALIDATION

    @RequestMapping("/")
    public String onAccess(Model model, @RequestParam(defaultValue = "1") @Min(1) @Positive int page){
        List<ArticleEntity> entities = articleService
                .findAllPublishedArticles((page > 0 ? (page -1) : (page < 0 ? 0 : page)), 9);
        Collections.reverse(entities);
        model.addAttribute("articleEntitiesList", entities);
        return "home";
    }


}
