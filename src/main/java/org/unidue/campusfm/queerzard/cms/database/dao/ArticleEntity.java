package org.unidue.campusfm.queerzard.cms.database.dao;

import lombok.Getter;
import lombok.Setter;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.format.annotation.DateTimeFormat;
import org.unidue.campusfm.queerzard.cms.utils.UtilitiesCollection;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article")
public class ArticleEntity extends AbstractEntity{

    @ManyToOne
    @Getter private UserEntity userEntity;

    @Getter @Setter private String previewContent;

    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String base64preview;
    @Getter @Column(columnDefinition = "LONGTEXT") private String base64banner;
    @Getter @Column(columnDefinition = "LONGTEXT") private String contents;
    @Getter @Setter private String tags;
    @Getter @Setter private String category;
    @Getter @Setter private String title;
    @Getter private long creationMillis;
    @Getter private long publishedMillis;

    @Getter private String publishDayOfMonth;
    @Getter private String publishMonthName;
    @Getter private String publishYear;

    @Getter @Setter private boolean editable;
    @Getter private boolean published;
    @Getter @Setter private int views;

    public ArticleEntity(){}
    public ArticleEntity(UserEntity authorEntity, String title, String contents, String category,
                         String tags, String base64preview, String base64banner){
        this.userEntity = authorEntity;
        this.title = title;
        setContent(contents);
        this.category = category;
        this.tags = tags;
        this.base64preview = (base64preview != null ? base64preview : UtilitiesCollection
                .toBase64(UtilitiesCollection.getFileBytes(UtilitiesCollection
                        .getFileFromResource("articlePlaceholder.png"))));
        this.creationMillis = System.currentTimeMillis();
        this.publishedMillis = 0L;
        this.editable = true;
        this.published = false;
        this.views = 0;
        this.setBase64Banner(base64banner == null ? null : base64banner);
    }

    public void setContent(String contents){
        this.contents = contents;
        String sanitized = Jsoup.clean(contents, Safelist.basic());
        this.previewContent = (sanitized.length() > 200 ? sanitized.substring(0, 200) : sanitized + "...");

    }

    public void setBase64Banner(String banner){
        this.base64banner = (banner != null ? banner : UtilitiesCollection
                .toBase64(UtilitiesCollection.getFileBytes(UtilitiesCollection
                        .getFileFromResource("assets/img/banner.png"))));
    }

    public void setPublished(boolean published) {
        this.published = published;
        this.editable = !published;
        if(published){
            publishedMillis = System.currentTimeMillis();
            this.publishDayOfMonth = UtilitiesCollection.getDay(publishedMillis);
            this.publishMonthName = UtilitiesCollection.getMonth(publishedMillis);
            this.publishYear = UtilitiesCollection.getYear(publishedMillis);
        }
    }

}
