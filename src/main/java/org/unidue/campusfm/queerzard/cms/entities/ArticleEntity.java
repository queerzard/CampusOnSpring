package org.unidue.campusfm.queerzard.cms.entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class ArticleEntity {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Getter private String postId;

    @ManyToOne
    @Getter private UserEntity userEntity;

}
