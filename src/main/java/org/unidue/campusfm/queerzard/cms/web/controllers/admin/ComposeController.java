package org.unidue.campusfm.queerzard.cms.web.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;

import java.security.Principal;

@Controller
public class ComposeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/compose")
    public String getComposer(Principal principal, @RequestParam("article") String articleId){

        return "admin/compose";
    }

    @PostMapping("/compose")
    public String postComposer(Principal principal, @RequestParam("article") String articleId,
                               @RequestParam String title, @RequestParam String content,
                               @RequestParam String category, @RequestParam String tags,
                               @RequestParam String base64preview, @RequestParam String base64banner){
        return "redirect: /article?a=" + articleId;
    }

    @PutMapping("/compose")
    public String putComposer(Principal principal, @RequestParam("article") String articleId){
        return "";
    }

    @PatchMapping("/compose")
    public String patchComposer(Principal principal, @RequestParam("article") String articleId){
        return "";
    }

    @DeleteMapping("/composer")
    public String deleteComposer(Principal principal, @RequestParam("article") String articleId){
        return "";
    }


}
