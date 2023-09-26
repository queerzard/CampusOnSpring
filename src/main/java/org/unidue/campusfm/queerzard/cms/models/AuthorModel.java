package org.unidue.campusfm.queerzard.cms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "authors")
public class AuthorModel {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String username;

    private String email;
    private String password;

    private String description;
    private String note;


    private String base64Avatar;
    private boolean enabled;
    private boolean connectionCount;

    private boolean creationTimeStamp;




    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore @Getter @Setter private List<ArticleModel> articleModels = new ArrayList<>();

    //establish ManyToMany relationship between Tables.
    private String role;
}
