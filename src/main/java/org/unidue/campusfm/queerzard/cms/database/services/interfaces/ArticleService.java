package org.unidue.campusfm.queerzard.cms.database.services.interfaces;

import org.springframework.data.domain.Pageable;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;

import java.util.List;
import java.util.UUID;

public interface ArticleService {

    List<ArticleEntity> findAll();

    List<ArticleEntity> findAll(int pageNumber, int pageSize);
    ArticleEntity update(ArticleEntity article);
    ArticleEntity addArticle(ArticleEntity article);
    boolean articleExists(ArticleEntity article);

    boolean articleExistsById(String id);
    ArticleEntity getArticleByPostId(String postId);
    List<ArticleEntity> getArticlesByAuthor(UserEntity user);
    List<ArticleEntity> getArticlesWithString(String regex);

    List<ArticleEntity> findAllPublishedArticles(int page, int pageSize);


    void delete(ArticleEntity article);

    long count();
}
