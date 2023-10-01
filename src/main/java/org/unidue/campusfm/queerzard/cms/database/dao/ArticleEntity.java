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

    @Id
    @GeneratedValue
    @Getter
    private long id;

    @Column(unique = true)
    @Getter private String postId;

    @ManyToOne
    @Getter private UserEntity userEntity;

    @Getter @Setter private String previewContent;

    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String base64preview;
    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String contents;
    @Getter @Setter private String tags;
    @Getter @Setter private String category;
    @Getter @Setter private String title;
    @Getter private long creationMillis;
    @Getter private long publishedMillis;
    @DateTimeFormat(pattern = "MMMM dd, yyyy")
    @Getter private Date date;
    @Getter @Setter private boolean editable;
    @Getter private boolean published;
    @Getter private int views;

    public ArticleEntity(){}
    public ArticleEntity(UserEntity authorEntity, String title, String contents, String category,
                         String tags, String base64preview){
        this.userEntity = authorEntity;
        this.title = title;
        this.contents = contents;
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
        this.date = new Date(publishedMillis);
        this.postId = UtilitiesCollection.randomUUID();
        this.previewContent = (contents.length() > 200 ? Jsoup.clean(contents, Safelist.basic()).substring(0, 200) : Jsoup.clean(contents, Safelist.basic()));
    }

    public void setPublished(boolean published) {
        this.published = published;
        if(published){
            publishedMillis = System.currentTimeMillis();
            this.editable = false;
            date = new Date(publishedMillis);
        } else {
            editable = true;
        }
    }

}
