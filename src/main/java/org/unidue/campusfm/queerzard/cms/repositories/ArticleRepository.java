package org.unidue.campusfm.queerzard.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unidue.campusfm.queerzard.cms.entities.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.entities.UserEntity;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    List<ArticleEntity> findArticleEntitiesByUserEntity(UserEntity user);
    ArticleEntity findArticleEntityByPostId(String postId);

    @Query("SELECT a FROM ArticleEntity a WHERE a.published = true AND a.views >= :minViews")
    List<ArticleEntity> findPopularArticlesWithMinViews(int minViews);

    @Query("SELECT a FROM ArticleEntity a WHERE a.published = true")
    List<ArticleEntity> findAllPublishedArticles();

    @Query("SELECT a FROM ArticleEntity a WHERE a.published = false")
    List<ArticleEntity> findAllUnpublishedArticles();

    @Query("SELECT a FROM ArticleEntity a WHERE a.published = false AND a.userEntity = :user")
    List<ArticleEntity> findAllUnpublishedByAuthor(UserEntity user);

    @Query("SELECT a FROM ArticleEntity a WHERE a.published = true AND a.userEntity = :user")
    List<ArticleEntity> findAllPublishedByAuthor(UserEntity user);

    boolean existsArticleEntityByPostId(String postId);

}
