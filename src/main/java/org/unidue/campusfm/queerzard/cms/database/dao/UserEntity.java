package org.unidue.campusfm.queerzard.cms.database.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.unidue.campusfm.queerzard.cms.utils.UtilitiesCollection;
import org.unidue.campusfm.queerzard.cms.utils.validators.DisallowedCharacters;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends AbstractEntity{

    @NotBlank(message = "The Username is a mandatory field!")
    @DisallowedCharacters(message = "The Username cannot contain special characters!")
    @Getter @Setter @Column(unique = true, nullable = false) @Size(min = 3)
    private String username;

    @NotBlank(message = "The Email is a mandatory field!")
    @Getter @Setter @Email @Column(unique = true, nullable = false)
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
    @Getter @Setter @Size(min = 8) @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Getter @Setter
    private String description;
    @Getter @Setter
    private String note;


    @Column(columnDefinition = "LONGTEXT")
    @JsonIgnore @Getter
    private String base64Avatar;

    @Getter @Setter private boolean enabled;

    @Getter
    private long creationTimeStamp;
    @Getter
    private long lastLoginTimestamp;



    @OneToMany
    @JsonIgnore @Getter @Setter private List<ArticleEntity> articleEntities = new ArrayList<>();

    @Setter private String roles;
    @Setter private String permissions;


    public UserEntity(String firstName, String lastName, String email, String password, String description,
                      String note, String avatar, String roles, String permissions, boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = email.split("@")[0];
        setPassword(password);
        this.description = description;
        this.note = note;
        this.base64Avatar = avatar;
        this.enabled = enabled;
        this.creationTimeStamp = System.currentTimeMillis();
        this.lastLoginTimestamp = 0L;
        this.roles = roles;
        this.permissions = permissions;
    }

    public UserEntity(String firstName, String lastName, String email, String password, String description,
                      String note, String roles, String permissions, boolean enabled) {
        this(firstName, lastName, email, password, description, note, UtilitiesCollection
                .toBase64(UtilitiesCollection.getFileBytes(UtilitiesCollection.getDefaultAvatarFile())), roles, permissions, enabled);

    }

    public UserEntity(String firstName, String lastName, String email, String password, String roles, String permissions, boolean enabled) {
        this(firstName, lastName, email, password, "Linkstgrünversiffte*r bei CampusFM",
                "Redakteur*in", roles, password, enabled);
    }

    public UserEntity() {}



    public void updateLastLogin() {
        this.lastLoginTimestamp = System.currentTimeMillis();
    }

    public void setPassword(String password){
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public List<String> getPermissions(){
        if(this.permissions.length() > 0)
            return Arrays.asList(this.permissions.split(";"));
        return new ArrayList<>();
    }

    public List<String> getRoles(){
        if(this.roles.length() > 0)
            return Arrays.asList(this.roles.split(";"));
        return new ArrayList<>();
    }

}
