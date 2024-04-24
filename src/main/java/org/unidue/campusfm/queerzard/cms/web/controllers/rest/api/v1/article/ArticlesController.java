
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.controllers.rest.api.v1.article;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;
import org.unidue.campusfm.queerzard.cms.database.services.user.CampusUserDetails;
import org.unidue.campusfm.queerzard.cms.utils.RestResponse;
import org.unidue.campusfm.queerzard.cms.web.dto.ArticleModel;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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

/**
 * The ArticlesController class provides RESTful API endpoints for managing articles.
 * These endpoints allow users to access, create, update, and delete articles.
 *
 * The endpoints also handle authorization logic to ensure that only authorized users can perform certain actions.
 *
 * This class is annotated with the @RestController and @RequestMapping annotations to define the base URL for all article-related requests.
 */
@RestController
@RequestMapping("/api/v1/article") @Slf4j
public class ArticlesController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    /**
     * Obtain an article by its ID.
     * If article.published is false and the user is not the author or an admin, access is refused.
     * If the user is the author or an admin, access is granted.
     * If article.published is true, access is granted.
     *
     * @param authentication the authentication object containing the user details
     * @param articleId the ID of the article to obtain
     * @return a ResponseEntity object with the article details if access is granted, or an error message if access is refused
     */ //obtain an article by its ID (if article.published = false & user isnt author nor admin -> refuse |
    // elif author or admin -> grant | or if article.published = true -> grant)
    @GetMapping
    public ResponseEntity<Object> handleGetMapping(Authentication authentication, @RequestParam("article") String articleId,
                                                   HttpServletRequest request){

        ArticleEntity articleEntity;
        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);

        //check if article by that ID exists
        if(!articleService.articleExistsById(articleId)){
            log.warn( "{} attempted to access an unavailable resource. ({})", request.getRemoteAddr(), articleId);

            return new ResponseEntity<>(new RestResponse(HttpStatus.NOT_FOUND,
                    "[handleGetMapping] this resource couldn't be found. unavailable resource;"),
                    HttpStatus.NOT_FOUND);
        }
        //obtain article from DB
        articleEntity = articleService.getArticleByPostId(articleId);

        //check the articles availability and the authentication / return error if
        if(!articleEntity.isPublished() && (userDetails == null || !articleEntity.getUserEntity().getId()
                .equals(userDetails.getUserEntity().getId()) || !userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().contains("ADMIN")))){
            log.warn("{} attempted to access an unpublished, thus restricted resource " +
                    "and is neither an administrator, not the author ({})", request.getRemoteAddr(), articleId);
            return new ResponseEntity<>(new RestResponse(HttpStatus.UNAUTHORIZED,
                    "[handleGetMapping] access to an unpublished resource is restricted. not an administrator " +
                            "nor the author;"), HttpStatus.UNAUTHORIZED);
        }

        ArticleModel articleModel = new ArticleModel();
        articleModel.setBase64preview(articleEntity.getBase64preview());
        articleModel.setPreviewContent(articleEntity.getPreviewContent());
        articleModel.setContents(new String(Base64.decodeBase64(articleEntity.getContents()), StandardCharsets.UTF_8));
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
        log.info( "{} fetched a resource with the article id ({})", request.getRemoteAddr(),  articleId);
        return new ResponseEntity<>(articleModel, HttpStatus.OK);
    }

    /**
     * Generate a database entry for a new article.
     * If authenticated, create the article.
     * If not authenticated, refuse the creation of the article.
     *
     * @param authentication the authentication object containing the user details
     * @param articleId the ID of the article to modify (optional)
     * @param publishBool the publication status of the article (optional)
     * @return a ResponseEntity object with the modified article details if successful, or an error message if access is refused or if the article does not exist
     */ //Generate a database entry for a new article (if authenticated -> create | else -> refuse)
    @PostMapping()
    public ResponseEntity<Object> handlePostMapping(Authentication authentication,
                                                    @RequestParam(value = "article", required = false) String articleId,
                                                    @RequestParam(value = "pub", required = false) boolean publishBool,
                                                    HttpServletRequest request){

        if((articleId != null && !articleId.isEmpty())){
            ArticleEntity articleEntity;
            CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);
            //check if article by that ID exists
            if(!articleService.articleExistsById(articleId)){
                log.warn( "{} attempted to POST a resource with the article id ({}), but that resource does not exist.",
                        userDetails != null ? userDetails.getUsername() : request.getRemoteAddr(),  articleId);

                return new ResponseEntity<>(new RestResponse(HttpStatus.NOT_FOUND,
                        "[handlePostMapping] this resource couldn't be found. unavailable resource;"), HttpStatus.NOT_FOUND);
            }
            //obtain article from DB
            articleEntity = articleService.getArticleByPostId(articleId);

            //check the articles availability and the authentication / return error if
            if (userDetails == null || // Not authenticated
                    (articleEntity.isPublished() && // Article is published
                            (!userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().contains("ADMIN"))))){
                log.warn( "{} attempted to POST a resource with the article id ({}), but is missing the authorization to perform this action.",
                        userDetails != null ? userDetails.getUsername() : request.getRemoteAddr(),  articleId);

                return new ResponseEntity<>(new RestResponse(HttpStatus.UNAUTHORIZED,
                        "[handlePostMapping] access to an unpublished resource is restricted. not an administrator nor the author;"), HttpStatus.UNAUTHORIZED);
            }

            boolean admin = userDetails.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().contains("ADMIN"));

            if(articleEntity.isEditable() && !admin){
                articleEntity.setEditable(false);
                log.info( "{} has submitted a resource with the article id ({}) for review.",
                        userDetails.getUsername(),  articleId);
            } else if(admin){
                articleEntity.setPublished(publishBool);
                log.warn( "{} has reviewed and published a resource with the article id ({}).",
                        userDetails.getUsername(),  articleId);
            }


            articleService.update(articleEntity);
            log.info( "{} has updated the publication status of a resource with the article id ({})",
                    userDetails.getUsername(),  articleId);
            return new ResponseEntity<>(new RestResponse(HttpStatus.OK, "publication status modified!"), HttpStatus.OK);
        }

        if(authentication == null){
            log.warn( "{} attempted to POST a resource with the article id ({}), " +
                    "but is missing the authorization to perform this action. Authentication is null!",
                    request.getRemoteAddr(),  articleId);

            return new ResponseEntity<>(new RestResponse(HttpStatus.UNAUTHORIZED,
                    "[handlePostMapping] principal is null; creating and changing the publication state of " +
                            "articles is reserved to authenticated users!"), HttpStatus.UNAUTHORIZED);
        }

        ArticleEntity article = new ArticleEntity(((CampusUserDetails) (authentication.getPrincipal())).getUserEntity(),
                "Unnamed", "",
                "allgemein", "",
                null, null);
        articleService.addArticle(article);
        log.info( "{} has created a resource with the article id ({}).",
                article.getUserEntity().getUsername(),  articleId);
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    /**
     * Replace the content of an existing article.
     * If the user is the author or an administrator, the article will be deleted and replaced.
     * If the user is neither the author nor an administrator, the replacement will be refused.
     *
     * @param authentication the authentication object containing the user details
     * @param articleId the ID of the article to replace
     * @param articleModel the new article content
     * @return a ResponseEntity object with the modified article details if successful, or an error message if access is refused or if the article does not exist
     */ //replace article content (if user = author || user = admin then -> delete | else -> refuse)
    @PutMapping()
    public ResponseEntity<Object> handlePutMapping(Authentication authentication, @RequestParam("article") String articleId,
                                                   ArticleModel articleModel, HttpServletRequest request){
        ArticleEntity articleEntity;
        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);

        //check if article by that ID exists
        if(!articleService.articleExistsById(articleId)){
            log.warn( "{} attempted to PUT a resource with the article id ({}), but that resource does not exist.",
                    userDetails != null ? userDetails.getUsername() : request.getRemoteAddr(),  articleId);
            return new ResponseEntity<>(new RestResponse(HttpStatus.NOT_FOUND,
                    "[handlePutMapping] this resource couldn't be found. unavailable resource;"), HttpStatus.NOT_FOUND);
        }
        //obtain article from DB
        articleEntity = articleService.getArticleByPostId(articleId);

        //check the articles availability and the authentication / return error if
        if (userDetails == null || // Not authenticated
                (articleEntity.isPublished() && // Article is published
                        (!articleEntity.getUserEntity().getId().equals(userDetails.getUserEntity().getId())) && // User is not the owner
                        !userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().contains("ADMIN")))){
            log.warn( "{} attempted to PUT a published resource with the article id ({}), but is missing the authorization to perform this action.",
                    userDetails != null ? userDetails.getUsername() : request.getRemoteAddr(),  articleId);

            return new ResponseEntity<>(new RestResponse(HttpStatus.UNAUTHORIZED,
                    "[handlePutMapping] a published resource cannot be replaced and needs to be taken down first. not an administrator nor the author;"), HttpStatus.UNAUTHORIZED);
        }



        //put code...
        articleEntity.setTitle(articleModel.getTitle());
        articleEntity.setContent(articleModel.getContents());
        articleEntity.setTags(articleModel.getTags());
        articleEntity.setCategory(articleModel.getCategory());

        articleEntity.setBase64Banner(articleModel.getBase64banner());
        articleEntity.setBase64preview(articleModel.getBase64preview());
        articleEntity.setViews(articleModel.getViews());

        articleService.update(articleEntity);
        log.info( "{} has updated(PUT) a resource with the article id ({})",
                userDetails.getUsername(),  articleId);
        return new ResponseEntity<>(new RestResponse(HttpStatus.OK, "this article has been modified!")
                .addData("model", articleModel), HttpStatus.OK);
    }

    /**
     * Patch the content of an existing article.
     * If the user is the author or an administrator, the specified fields of the article will be updated.
     * If the user is neither the author nor an administrator, the patching will be refused.
     *
     * @param authentication the authentication object containing the user details
     * @param articleId the ID of the article to patch
     * @param title the new title of the article (optional)
     * @param content the new content of the article (optional)
     * @param tags the new tags of the article (optional)
     * @param category the new category of the article
     * @param multipartFile the new preview image of the article (optional)
     * @return a ResponseEntity object with the modified article details if successful, or an error message if access is refused or if the article does not exist
     * @throws IOException if there is an error reading the multipart file
     */ //patch article content (if user = author || user = admin then -> delete | else -> refuse)
    @SneakyThrows
    @PatchMapping()
    public ResponseEntity<Object> handlePatchMapping(Authentication authentication, @RequestParam("article") String articleId,
                                                     @RequestPart(value = "title", required = false) String title,
                                                     @RequestPart(value = "content", required = false) String content,
                                                     @RequestPart(value = "tags", required = false) String tags, @RequestPart("category") String category,
                                                     @RequestPart(value = "previewImage", required = false) MultipartFile multipartFile, HttpServletRequest request){

        ArticleEntity articleEntity;
        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);


        //check if article by that ID exists
        if(!articleService.articleExistsById(articleId)){
            log.warn( "{} attempted to PATCH a resource with the article id ({}), but that resource does not exist.",
                    userDetails != null ? userDetails.getUsername() : request.getRemoteAddr(),  articleId);
            return new ResponseEntity<>(new RestResponse(HttpStatus.NOT_FOUND,
                    "[handlePatchMapping] this resource couldn't be found. unavailable resource;"), HttpStatus.NOT_FOUND);
        }
        //obtain article from DB
        articleEntity = articleService.getArticleByPostId(articleId);

        //check the articles availability and the authentication / return error if
        if (userDetails == null || // Not authenticated
                (articleEntity.isPublished() && // Article is published
                        (!articleEntity.getUserEntity().getId().equals(userDetails.getUserEntity().getId())) && // User is not the owner
                        !userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().contains("ADMIN")))){
            log.warn( "{} attempted to PATCH a resource with the article id ({}), but is missing the authorization to perform this action.",
                    userDetails != null ? userDetails.getUsername() : request.getRemoteAddr(),  articleId);
            return new ResponseEntity<>(new RestResponse(HttpStatus.UNAUTHORIZED,
                    "[handlePatchMapping] access to this resource is restricted. not an administrator nor the author;"), HttpStatus.UNAUTHORIZED);
        }

        //handlerCode...
        if(title != null && !title.isEmpty())
            articleEntity.setTitle(title);
        if(content != null && !content.isEmpty() && Base64.isBase64(content))
            articleEntity.setContent(content);
        if(tags != null && !tags.isEmpty())
            articleEntity.setTags(tags);
        if(category != null && !category.isEmpty())
            articleEntity.setCategory(category);

        if(multipartFile != null && !multipartFile.isEmpty() && multipartFile.getContentType().contains("image/png"))
            articleEntity.setBase64preview(Base64.encodeBase64String(multipartFile.getBytes()));

        articleService.update(articleEntity);
        log.info( "{} has updated(PATCH) a resource with the article id ({})",
                userDetails.getUsername(),  articleId);
        return new ResponseEntity<>(new RestResponse(HttpStatus.OK, "this article has been modified!")
                .addData("model", articleEntity), HttpStatus.OK);
    }

    /**
     * Delete an article entry from the database.
     * If the user is the author or an administrator, the article will be deleted.
     * If the user is neither the author nor an administrator, the deletion will be refused.
     *
     * @param authentication the authentication object containing the user details
     * @param articleId the ID of the article to delete
     * @return a ResponseEntity object with a success message if the article is deleted successfully,
     *         or an error message if access is refused or if the article does not exist
     */ //delete an article entry from DB (if user = author || user = admin then -> delete | else -> refuse)
    @DeleteMapping()
    public ResponseEntity<Object> handleDeleteMapping(Authentication authentication, @RequestParam("article") String articleId, HttpServletRequest request){

        ArticleEntity articleEntity;
        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);

        //check if article by that ID exists
        if(!articleService.articleExistsById(articleId)){
            log.warn( "{} attempted to DELETE a resource with the article id ({}), but that resource does not exist.",
                    userDetails != null ? userDetails.getUsername() : request.getRemoteAddr(),  articleId);
            return new ResponseEntity<>(new RestResponse(HttpStatus.NOT_FOUND,
                    "[handleDeleteMapping] this resource couldn't be found. unavailable resource;"), HttpStatus.NOT_FOUND);
        }
        //obtain article from DB
        articleEntity = articleService.getArticleByPostId(articleId);
/*
        boolean admin = userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().contains("ADMIN"));
        boolean author = articleEntity.getUserEntity().getId().equals(userDetails.getUserEntity().getId());*/

      /*  wenn der nutzer nicht authentifiziert ist, soll er keinen Zugriff erhalten.
        Wenn er aber authentifiziert ist, sein artikel bearbeitbar und nicht publiziert ist und er der autor oder ein admin ist, dann soll er zugriff erhalten.
        Wenn er authentifiziert ist, sein artikel aber nicht bearbeitbar oder publiziert ist, er aber admin ist, soll er zugriff haben. In allen anderen Fällen nicht.
        */

        if (userDetails == null || // Not authenticated
                (articleEntity.isPublished() && // Article is published
                        (!articleEntity.getUserEntity().getId().equals(userDetails.getUserEntity().getId())) && // User is not the owner
                        !userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().contains("ADMIN")))){
            log.warn( "{} attempted to DELETE a resource with the article id ({}), but is missing the authorization to perform this action.",
                    userDetails != null ? userDetails.getUsername() : request.getRemoteAddr(),  articleId);
            return new ResponseEntity<>(new RestResponse(HttpStatus.UNAUTHORIZED,
                    "[handleDeleteMapping] resources can only be deleted by their author or an administrator!"), HttpStatus.UNAUTHORIZED);
        }

        articleService.delete(articleEntity);
        log.info( "{} has deleted a resource with the article id ({})",
                userDetails.getUsername(),  articleId);
        return new ResponseEntity<>(new RestResponse(HttpStatus.OK, "article deleted successfully"), HttpStatus.OK);
    }

}
