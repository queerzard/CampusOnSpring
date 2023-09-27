package org.unidue.campusfm.queerzard.cms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.unidue.campusfm.queerzard.cms.utils.UtilitiesCollection;
import org.unidue.campusfm.queerzard.cms.utils.validators.DisallowedCharacters;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "authors")
public class AuthorModel {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @NotBlank(message = "The Firstname is a mandatory field!")
    @DisallowedCharacters(message = "The Firstname cannot contain special characters!")
    @Getter
    @Setter
    private String firstName;

    @NotBlank(message = "The Lastname is a mandatory field!")
    @DisallowedCharacters(message = "The Lastname cannot contain special characters!")
    @Getter
    @Setter
    private String lastName;

    @NotBlank(message = "The Username is a mandatory field!")
    @DisallowedCharacters(message = "The Username cannot contain special characters!")
    @Getter
    @Setter
    private String username;

    @NotBlank(message = "The Email is a mandatory field!")
    @Getter
    @Setter
    private String email;

    @NotBlank(message = "The Password is a mandatory field!")
    @Getter
    private String password;

    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String note;


    @Column(columnDefinition = "LONGTEXT")
    @JsonIgnore
    @Getter
    private String base64Avatar;

    @Getter @Setter private boolean enabled;

    @Getter
    private long creationTimeStamp;
    @Getter
    private long lastLoginTimestamp;




    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore @Getter @Setter private List<ArticleModel> articleModels = new ArrayList<>();

    //establish ManyToMany relationship between Tables.
    @Getter @Setter private String role;

    public AuthorModel() {
    }

    public AuthorModel(long id, String firstName, String lastName, String email, String password, String description,
                       String note, String avatar, boolean enabled) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = email.split("@")[0];
        this.password = password;
        this.description = description;
        this.note = note;
        this.base64Avatar = avatar;
        this.enabled = enabled;
        this.creationTimeStamp = System.currentTimeMillis();
        this.lastLoginTimestamp = 0L;
    }

    public AuthorModel(long id, String firstName, String lastName, String email, String password, String description,
                       String note, boolean enabled) {
        this(id, firstName, lastName, email, password, description, note, UtilitiesCollection
                .toBase64(UtilitiesCollection.getFileBytes(UtilitiesCollection.getDefaultAvatarFile())), enabled);

    }

    public AuthorModel(long id, String firstName, String lastName, String email, String password, boolean enabled) {
        this(id, firstName, lastName, email, password, "Linkstgruenversuffte*r bei CampusFM",
                "Redakteur*in", enabled);
    }


    public void setPassword(String password, boolean hash) {
        this.password = (hash ? UtilitiesCollection.sha256(password) : password);
    }

    public void updateLastLogin() {
        this.lastLoginTimestamp = System.currentTimeMillis();
    }

}
