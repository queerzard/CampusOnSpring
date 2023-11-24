
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.database.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.unidue.campusfm.queerzard.cms.utils.UtilitiesCollection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents an article entity.
 * An article consists of various properties such as the author, title, content,
 * category, tags, preview, banner, creation date, publication date, etc.
 * <p>
 * The ArticleEntity class is an entity class that maps to the "article" table in the database.
 * It extends the AbstractEntity class which provides common properties like id, createdBy, createdAt, etc.
 * <p>
 * An instance of the ArticleEntity class represents a single article.
 * It can be used to create, update, and retrieve articles from the database.
 */
@Entity
@Table(name = "article")
public class ArticleEntity extends AbstractEntity {

    @ManyToOne
    @Getter
    private UserEntity userEntity;

    @Getter
    @Setter
    private String previewContent;

    @Getter
    @Setter
    @Column(columnDefinition = "LONGTEXT")
    private String base64preview;
    @Getter
    @Column(columnDefinition = "LONGTEXT")
    private String base64banner;
    @Getter
    @Column(columnDefinition = "LONGTEXT")
    private String contents;
    @Getter
    @Setter
    private String tags;
    @Getter
    @Setter
    private String category;
    @Getter
    @Setter
    private String title;
    @Getter
    private long creationMillis;
    @Getter
    private long publishedMillis;

    @Getter
    private String publishDayOfMonth;
    @Getter
    private String publishMonthName;
    @Getter
    private String publishYear;

    @Getter
    @Setter
    private boolean editable;
    @Getter
    private boolean published;
    @Getter
    @Setter
    private int views;

    public ArticleEntity() {
    }

    @SneakyThrows
    public ArticleEntity(UserEntity authorEntity, String title, String contents, String category,
                         String tags, String base64preview, String base64banner) {
        this.userEntity = authorEntity;
        this.title = title;
        setContent(contents);
        this.category = category;
        this.tags = tags;
        this.base64preview = (base64preview != null ? base64preview : UtilitiesCollection.base64preview());
        this.creationMillis = System.currentTimeMillis();
        this.publishedMillis = 0L;
        this.editable = true;
        this.published = false;
        this.views = 0;
        this.setBase64Banner(base64banner == null ? null : base64banner);
    }

    /**
     * Sets the content of the object.
     *
     * @param contents the content to be set
     */
    public void setContent(String contents) {
        this.contents = contents;
        String sanitized = Jsoup.clean(contents, Safelist.basic());
        this.previewContent = Jsoup.clean((sanitized.length() > 200 ? sanitized.substring(0, 200) : sanitized).replaceAll("\n", ""), Safelist.none());

    }

    /**
     * Sets the base64 representation of the banner image.
     *
     * @param banner The base64 representation of the banner image. If null, a default banner image
     *               will be used.
     */
    public void setBase64Banner(String banner) {
        this.base64banner = (banner != null ? banner : UtilitiesCollection
                .base64preview()/*toBase64(UtilitiesCollection.getFileBytes(UtilitiesCollection
                        .getFileFromResource("assets/img/banner.png")))*/);
    }

    /**
     * Updates the published status of an item.
     * Sets the published flag and updates related fields accordingly.
     *
     * @param published the new published status of the item
     */
    public void setPublished(boolean published) {
        this.published = published;
        this.editable = !published;
        if (published) {
            publishedMillis = System.currentTimeMillis();
            this.publishDayOfMonth = UtilitiesCollection.getDay(publishedMillis);
            this.publishMonthName = UtilitiesCollection.getMonth(publishedMillis);
            this.publishYear = UtilitiesCollection.getYear(publishedMillis);
        }
    }

}
