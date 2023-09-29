package org.unidue.campusfm.queerzard.cms.services.interfaces;

import org.unidue.campusfm.queerzard.cms.entities.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.entities.UserEntity;

import java.util.List;

public interface ArticleService {

    List<ArticleEntity> findAll();
    ArticleEntity update(ArticleEntity article);
    ArticleEntity addArticle(ArticleEntity article);
    boolean articleExists(ArticleEntity article);

    ArticleEntity getArticleByPostId(String postId);
    List<ArticleEntity> getArticlesByAuthor(UserEntity user);
    List<ArticleEntity> getArticlesWithString(String regex);




    void delete(ArticleEntity article);

    long count();
}
