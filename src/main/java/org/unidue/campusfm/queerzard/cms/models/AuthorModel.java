package org.unidue.campusfm.queerzard.cms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.unidue.campusfm.queerzard.cms.utils.UtilitiesCollection;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "authors")
public class AuthorModel {

    @Id
    @GeneratedValue
    @Getter private Long id;

    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String username;

    @Getter @Setter private String email;
    @Getter private String password;

    @Getter @Setter private String description;
    @Getter @Setter private String note;


    @Column(columnDefinition = "LONGTEXT")
    @JsonIgnore
    private String base64Avatar;

    @Getter @Setter private boolean enabled;
    @Getter @Setter private int connectionCount;

    @Getter private long creationTimeStamp;




    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore @Getter @Setter private List<ArticleModel> articleModels = new ArrayList<>();

    //establish ManyToMany relationship between Tables.
    @Getter @Setter private String role;

    public AuthorModel(){}
    public AuthorModel(long id, String firstName, String lastName, String email, String password, String description,
                       String note, String avatar, boolean enabled){}

    public AuthorModel(long id, String firstName, String lastName, String email, String password, String description,
                       String note, boolean enabled){}


    public void setPassword(String password, boolean hash){
        this.password = (hash ? UtilitiesCollection.sha256(password) : password);
    }

}
