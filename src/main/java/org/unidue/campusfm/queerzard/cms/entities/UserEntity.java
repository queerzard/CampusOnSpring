package org.unidue.campusfm.queerzard.cms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.unidue.campusfm.queerzard.cms.utils.UtilitiesCollection;
import org.unidue.campusfm.queerzard.cms.utils.validators.DisallowedCharacters;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends AbstractEntity{

    @Getter
    @Column(unique = true)
    private String userId;

    @NotBlank(message = "The Username is a mandatory field!")
    @DisallowedCharacters(message = "The Username cannot contain special characters!")
    @Getter @Setter
    @Column(unique = true)
    @Size(min = 3)
    private String username;

    @NotBlank(message = "The Email is a mandatory field!")
    @Getter @Setter
    @Email
    @Column(unique = true)
    private String email;


    @NotBlank(message = "The Firstname is a mandatory field!")
    @DisallowedCharacters(message = "The Firstname cannot contain special characters!")
    @Getter @Setter
    private String firstName;

    @NotBlank(message = "The Lastname is a mandatory field!")
    @DisallowedCharacters(message = "The Lastname cannot contain special characters!")
    @Getter @Setter
    private String lastName;


    @NotBlank(message = "The Password is a mandatory field!")
    @Getter
    @Size(min = 8)
    private String password;

    @Getter @Setter
    private String description;
    @Getter @Setter
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


    @OneToMany
    @JsonIgnore @Getter @Setter private List<ArticleEntity> articleEntities = new ArrayList<>();

    @NotNull
    @NotEmpty
    @ManyToMany
    @Getter @Setter private List<RoleEntity> roles = new ArrayList<>();


    public UserEntity(String firstName, String lastName, String email, String password, String description,
                      String note, String avatar, boolean enabled) {
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
        this.userId = UtilitiesCollection.randomUUID();
    }

    public UserEntity(String firstName, String lastName, String email, String password, String description,
                      String note, boolean enabled) {
        this(firstName, lastName, email, password, description, note, UtilitiesCollection
                .toBase64(UtilitiesCollection.getFileBytes(UtilitiesCollection.getDefaultAvatarFile())), enabled);

    }

    public UserEntity(String firstName, String lastName, String email, String password, boolean enabled) {
        this(firstName, lastName, email, password, "Linkstgruenversuffte*r bei CampusFM",
                "Redakteur*in", enabled);
    }

    public UserEntity() {}


    public void setPassword(String password, boolean hash) {
        this.password = (hash ? UtilitiesCollection.sha256(password) : password);
    }

    public void updateLastLogin() {
        this.lastLoginTimestamp = System.currentTimeMillis();
    }

}
