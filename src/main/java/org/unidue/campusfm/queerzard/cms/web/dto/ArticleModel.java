
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;

public class ArticleModel {

    @Getter @Setter private UserEntity userEntity;

    @Getter @Setter private String previewContent;
    @Getter @Setter private String base64preview;
    @Getter @Setter private String base64banner;

    @Getter @Setter private String contents;
    @Getter @Setter private String tags;
    @Getter @Setter private String category;
    @Getter @Setter private String title;

    @Getter @Setter private long creationMillis;
    @Getter @Setter private long publishedMillis;

    @Getter @Setter private String publishDayOfMonth;
    @Getter @Setter private String publishMonthName;
    @Getter @Setter private String publishYear;

    @Getter @Setter private boolean editable;
    @Getter @Setter private boolean published;
    @Getter @Setter private int views;

}
