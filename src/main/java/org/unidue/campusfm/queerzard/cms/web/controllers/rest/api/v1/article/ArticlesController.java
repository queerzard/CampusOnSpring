package org.unidue.campusfm.queerzard.cms.web.controllers.rest.api.v1.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;
import org.unidue.campusfm.queerzard.cms.database.services.user.CampusUserDetails;
import org.unidue.campusfm.queerzard.cms.utils.RestResponse;
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
    public ResponseEntity<Object> handleGetMapping(Authentication authentication, @RequestParam("article") String articleId){

        ArticleEntity articleEntity;
        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);

        //check if article by that ID exists
        if(!articleService.articleExistsById(articleId))
            return new ResponseEntity<>(new RestResponse(HttpStatus.NOT_FOUND,
                    "[handleGetMapping] this resource couldn't be found. unavailable resource;"), HttpStatus.NOT_FOUND);;
        //obtain article from DB
        articleEntity = articleService.getArticleByPostId(articleId);

        //check the articles availability and the authentication / return error if
        if(!articleEntity.isPublished() && (userDetails == null || !articleEntity.getUserEntity().getId()
                .equals(userDetails.getUserEntity().getId()) || !userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().contains("ADMIN"))))
            return new ResponseEntity<>(new RestResponse(HttpStatus.UNAUTHORIZED,
                    "[handleGetMapping] access to an unpublished resource is restricted. not an administrator nor the author;"), HttpStatus.UNAUTHORIZED);

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

        return new ResponseEntity<>(articleModel, HttpStatus.OK);
    }

    //Generate a database entry for a new article (if authenticated -> create | else -> refuse)
    @PostMapping()
    public ResponseEntity<Object> handlePostMapping(Authentication authentication, @RequestParam(value = "article", required = false) String articleId,
                                                    @RequestParam(value = "publish", required = false) boolean publishBool){

        if((articleId != null && !articleId.isBlank())){
            ArticleEntity articleEntity;
            CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);
            //check if article by that ID exists
            if(!articleService.articleExistsById(articleId))
                return new ResponseEntity<>(new RestResponse(HttpStatus.NOT_FOUND,
                        "[handleGetMapping] this resource couldn't be found. unavailable resource;"), HttpStatus.NOT_FOUND);;
            //obtain article from DB
            articleEntity = articleService.getArticleByPostId(articleId);

            //check the articles availability and the authentication / return error if
            if(/*!articleEntity.isPublished() && */(userDetails == null || !articleEntity.getUserEntity().getId()
                    .equals(userDetails.getUserEntity().getId()) || !userDetails.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().contains("ADMIN"))))
                return new ResponseEntity<>(new RestResponse(HttpStatus.UNAUTHORIZED,
                        "[handleGetMapping] access to an unpublished resource is restricted. not an administrator nor the author;"), HttpStatus.UNAUTHORIZED);

            articleEntity.setPublished(publishBool);
            articleService.update(articleEntity);

            return new ResponseEntity<>(new RestResponse(HttpStatus.OK, "publication status modified!"), HttpStatus.OK);
        }

        if(authentication == null)
            return new ResponseEntity<>(new RestResponse(HttpStatus.UNAUTHORIZED,
                    "[handlePostMapping] principal is null; creating and changing the publication state of " +
                            "articles is reserved to authenticated users!"), HttpStatus.UNAUTHORIZED);

        ArticleEntity article = new ArticleEntity(((CampusUserDetails) (authentication.getPrincipal())).getUserEntity(),
                "Unnamed", "",
                "allgemein", "",
                null, null);
        articleService.addArticle(article);
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    //replace article content (if user = author || user = admin then -> delete | else -> refuse)
    @PutMapping()
    public ResponseEntity<Object> handlePutMapping(Authentication authentication, @RequestParam("article") String articleId, ArticleModel articleModel){
        ArticleEntity articleEntity;
        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);

        //check if article by that ID exists
        if(!articleService.articleExistsById(articleId))
            return new ResponseEntity<>(new RestResponse(HttpStatus.NOT_FOUND,
                    "[handlePutMapping] this resource couldn't be found. unavailable resource;"), HttpStatus.NOT_FOUND);;
        //obtain article from DB
        articleEntity = articleService.getArticleByPostId(articleId);

        //check the articles availability and the authentication / return error if
        if((userDetails == null || articleEntity.isPublished() || !articleEntity.getUserEntity().getId()
                .equals(userDetails.getUserEntity().getId()) || !userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().contains("ADMIN"))))
            return new ResponseEntity<>(new RestResponse(HttpStatus.UNAUTHORIZED,
                    "[handlePutMapping] a published resource cannot be replaced and needs to be taken down first. not an administrator nor the author;"), HttpStatus.UNAUTHORIZED);

        //put code...
        articleEntity.setTitle(articleModel.getTitle());
        articleEntity.setContent(articleModel.getContents());
        articleEntity.setTags(articleModel.getTags());
        articleEntity.setCategory(articleModel.getCategory());

        articleEntity.setBase64Banner(articleModel.getBase64banner());
        articleEntity.setBase64preview(articleModel.getBase64preview());
        articleEntity.setViews(articleModel.getViews());

        articleService.update(articleEntity);

        return new ResponseEntity<>(new RestResponse(HttpStatus.OK, "this article has been modified!")
                .addData("model", articleModel), HttpStatus.OK);
    }

    //patch article content (if user = author || user = admin then -> delete | else -> refuse)
    @PatchMapping()
    public ResponseEntity<Object> handlePatchMapping(Authentication authentication, @RequestParam("article") String articleId, ArticleModel articleModel){

        ArticleEntity articleEntity;
        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);


        //check if article by that ID exists
        if(!articleService.articleExistsById(articleId))
            return new ResponseEntity<>(new RestResponse(HttpStatus.NOT_FOUND,
                    "[handlePatchMapping] this resource couldn't be found. unavailable resource;"), HttpStatus.NOT_FOUND);;
        //obtain article from DB
        articleEntity = articleService.getArticleByPostId(articleId);

        //check the articles availability and the authentication / return error if
        if((userDetails == null || !articleEntity.getUserEntity().getId()
                .equals(userDetails.getUserEntity().getId()) || !userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().contains("ADMIN"))))
            return new ResponseEntity<>(new RestResponse(HttpStatus.UNAUTHORIZED,
                    "[handlePatchMapping] access to this resource is restricted. not an administrator nor the author;"), HttpStatus.UNAUTHORIZED);

        //handlerCode...
        articleEntity.setTitle(articleModel.getTitle());
        articleEntity.setContent(articleModel.getContents());
        articleEntity.setTags(articleModel.getTags());
        articleEntity.setCategory(articleModel.getCategory());

        articleEntity.setBase64Banner(articleModel.getBase64banner());
        articleEntity.setBase64preview(articleModel.getBase64preview());

        articleService.update(articleEntity);

        return new ResponseEntity<>(new RestResponse(HttpStatus.OK, "this article has been modified!")
                .addData("model", articleModel), HttpStatus.OK);
    }

    //delete an article entry from DB (if user = author || user = admin then -> delete | else -> refuse)
    @DeleteMapping()
    public ResponseEntity<Object> handleDeleteMapping(Authentication authentication, @RequestParam("article") String articleId){

        ArticleEntity articleEntity;
        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);

        //check if article by that ID exists
        if(!articleService.articleExistsById(articleId))
            return new ResponseEntity<>(new RestResponse(HttpStatus.NOT_FOUND,
                    "[handleDeleteMapping] this resource couldn't be found. unavailable resource;"), HttpStatus.NOT_FOUND);
        //obtain article from DB
        articleEntity = articleService.getArticleByPostId(articleId);

        if(userDetails == null || (!articleEntity.getUserEntity().getId()
                .equals(userDetails.getUserEntity().getId()) || userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().contains("ADMIN"))))
            return new ResponseEntity<>(new RestResponse(HttpStatus.UNAUTHORIZED,
                    "[handleDeleteMapping] resources can only be deleted by their author or an administrator!"), HttpStatus.UNAUTHORIZED);

        articleService.delete(articleEntity);
        return new ResponseEntity<>(new RestResponse(HttpStatus.OK, "article deleted successfully"), HttpStatus.OK);
    }


}
