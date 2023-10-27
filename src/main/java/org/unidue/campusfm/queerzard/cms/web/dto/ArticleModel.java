package org.unidue.campusfm.queerzard.cms.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class ArticleModel {

    @Getter private UserEntity userEntity;

    @Getter @Setter private String previewContent;
    @Getter @Setter private String base64preview;
    @Getter private String base64banner;

    @Getter @Setter private String contents;
    @Getter @Setter private String tags;
    @Getter private String category;
    @Getter @Setter private String title;

    @Getter private long creationMillis;
    @Getter private long publishedMillis;

    @Getter private String publishDayOfMonth;
    @Getter private String publishMonthName;
    @Getter private String publishYear;

    @Getter @Setter private boolean editable;
    @Getter private boolean published;
    @Getter private int views;

}
