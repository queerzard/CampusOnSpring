package org.unidue.campusfm.queerzard.cms.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ComposeController {

    @GetMapping("/compose")
    public String getComposer(@RequestParam("article") String articleId){

        return "admin/compose";
    }

    @PostMapping("/compose")
    public String postComposer(@RequestParam("article") String articleId,
                               @RequestParam String title, @RequestParam String content,
                               @RequestParam String category, @RequestParam String tags,
                               @RequestParam String base64preview, @RequestParam String base64banner){
        return "redirect: /article?a=" + articleId;
    }

    @PutMapping("/compose")
    public String putComposer(){
        return "";
    }

    @PatchMapping("/compose")
    public String patchComposer(){
        return "";
    }

    @DeleteMapping("/composer")
    public String deleteComposer(){
        return "";
    }


}
