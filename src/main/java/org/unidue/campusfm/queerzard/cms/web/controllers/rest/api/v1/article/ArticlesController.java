package org.unidue.campusfm.queerzard.cms.web.controllers.rest.api.v1.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;
import org.unidue.campusfm.queerzard.cms.web.dto.ArticleModel;

/*

HttpMethod | route | short explanation | logic
        response -> JSON-Content

 GET api/v1/article/{id} Obtain an article    (if !logged on && availability = false -> refuse | else -> return article)
        response -> title, category, tags, content, previewImg, bannerImg, viewCount,
                        availability(published and editable), authorId, creationTimestamp, publishedTimestamp

 POST api/v1/article  Create a database entry (if logged on -> create | else -> nope.)
        response -> article ID & creation timestamp

 DELETE api/v1/article/{id} Delete an article (if logged on & admin = delete | else -> no.)
        response -> boolean if succeeded & timestamp

 PUT api/v1/article/{id}?<requestParams>       (if logged on & admin or article author & article unavailable -> exercise | else -> no.)
        response -> edited Article & timestamp

 PATCH api/v1/article/{id}?<object>             (if logged on & admin or article author & article unavailable -> exercise | else -> no.)
        response -> edited Article & timestamp

*/

@RestController
@RequestMapping("/api/v1/article")
public class ArticlesController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ArticleModel handleGetMapping(@RequestParam("article") String articleId){
        return null;
    }

    @PostMapping
    public ArticleModel handlePostMapping(){
        return null;
    }

    @PutMapping
    public ArticleModel handlePutMapping(){
        return null;
    }

    @PatchMapping
    public ArticleModel handlePatchMapping(){
        return null;
    }

    @DeleteMapping
    public ArticleModel handleDeleteMapping(){
        return null;
    }


}
