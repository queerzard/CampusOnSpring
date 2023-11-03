package org.unidue.campusfm.queerzard.cms.web.controllers.rest.api.v1.article;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;
import org.unidue.campusfm.queerzard.cms.database.services.user.CampusUserDetails;
import org.unidue.campusfm.queerzard.cms.web.dto.ArticleModel;

import java.security.Principal;

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

    //obtain an article by its ID (if article.published = false & user isnt author nor admin -> refuse |
    // elif author or admin -> grant | or if article.published = true -> grant)
    @GetMapping
    public ArticleModel handleGetMapping(Principal principal, @RequestParam("article") String articleId){

        ArticleEntity articleEntity;
        CampusUserDetails userDetails = (principal != null ? (CampusUserDetails) principal : null);

        //check if article by that ID exists
        if(!articleService.articleExistsById(articleId))
            return null;
        //obtain article from DB
        articleEntity = articleService.getArticleByPostId(articleId);

        //check the articles availability and the authentication / return error if
        if(!articleEntity.isPublished() && (userDetails == null || !articleEntity.getUserEntity().getId()
                .equals(userDetails.getUserEntity().getId()) || !userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN"))))
            return null;

        ArticleModel articleModel = new ArticleModel();
        articleModel.setBase64preview(articleEntity.getBase64preview());
        articleModel.setPreviewContent(articleEntity.getPreviewContent());
        articleModel.setContents(articleEntity.getContents());
        articleModel.setTags(articleEntity.getTags());
        articleModel.setTitle(articleEntity.getTitle());
        articleModel.setEditable(articleEntity.isEditable());
        articleModel.setCategory(articleEntity.getCategory());
        articleModel.setViews(articleEntity.getViews());
        articleModel.setBase64banner(articleEntity.getBase64banner());
        articleModel.setCreationMillis(articleEntity.getCreationMillis());
        articleModel.setPublishYear(articleEntity.getPublishYear());
        articleModel.setPublishDayOfMonth(articleEntity.getPublishDayOfMonth());
        articleModel.setPublishMonthName(articleEntity.getPublishMonthName());
        articleModel.setUserEntity(articleEntity.getUserEntity());

        return articleModel;
    }

    //Generate a database entry for a new article (if authenticated -> create | else -> refuse)
    @PostMapping
    public ArticleModel handlePostMapping(Principal principal){
        if(principal != null)
            return null;
        return null;
    }

    //replace article content (if user = author || user = admin then -> delete | else -> refuse)
    @PutMapping
    public ArticleModel handlePutMapping(Principal principal, @RequestParam("article") String articleId){
        return null;
    }

    //patch article content (if user = author || user = admin then -> delete | else -> refuse)
    @PatchMapping
    public ArticleModel handlePatchMapping(Principal principal, @RequestParam("article") String articleId){
        return null;
    }

    //delete an article entry from DB (if user = author || user = admin then -> delete | else -> refuse)
    @DeleteMapping
    public ArticleModel handleDeleteMapping(Principal principal, @RequestParam("article") String articleId){

        ArticleEntity articleEntity;
        CampusUserDetails userDetails = (principal != null ? (CampusUserDetails) principal : null);

        //check if article by that ID exists
        if(!articleService.articleExistsById(articleId))
            return null;
        //obtain article from DB
        articleEntity = articleService.getArticleByPostId(articleId);

        if(userDetails == null || !articleEntity.getUserEntity().getId()
                .equals(userDetails.getUserEntity().getId()) || userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN")))
            return null;

        articleService.delete(articleEntity);

        return null;
    }


}
