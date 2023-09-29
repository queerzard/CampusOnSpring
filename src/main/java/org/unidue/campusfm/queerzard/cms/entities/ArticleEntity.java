package org.unidue.campusfm.queerzard.cms.entities;

import lombok.Getter;
import lombok.Setter;
import org.unidue.campusfm.queerzard.cms.utils.UtilitiesCollection;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class ArticleEntity {

    @Id
    @GeneratedValue
    @Getter
    private long id;

    @Column(unique = true)
    @Getter private String postId;

    @ManyToOne
    @Getter private UserEntity userEntity;

    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String base64preview;
    @Getter @Setter @Column(columnDefinition = "LONGTEXT") private String contents;
    @Getter @Setter private String tags;
    @Getter @Setter private String category;
    @Getter @Setter private String title;
    @Getter private long creationMillis;
    @Getter private long publishedMillis;
    @Getter private boolean editable;
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
        this.base64preview = base64preview;
        this.creationMillis = System.currentTimeMillis();
        this.publishedMillis = 0L;
        this.editable = true;
        this.published = false;
        this.views = 0;

        this.postId = UtilitiesCollection.randomUUID();

    }


}
