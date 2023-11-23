
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.database.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.unidue.campusfm.queerzard.cms.utils.UtilitiesCollection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a UserEntity object.
 * This class is an entity that maps to a 'user' table in the database.
 * It extends the AbstractEntity class.
 */
@Entity
@Table(name = "user")
public class UserEntity extends AbstractEntity {

    @Getter
    @Setter
    @JsonIgnore
    @Column(unique = true, nullable = false)
    private String username;

    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    @JsonIgnore
    private String email;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @JsonIgnore
    @Getter
    private String password;

    @Getter
    @Setter
    private String social;
    @Getter
    @Setter
    private String position;
    @Getter
    @Setter
    private String description;


    @Column(columnDefinition = "LONGTEXT")
    @JsonIgnore
    @Getter
    @Setter
    private String base64Avatar;

    @Getter
    @Setter
    private boolean enabled;

    @Getter
    private long creationTimeStamp;
    @Getter
    private long lastLoginTimestamp;


    @OneToMany
    @JsonIgnore
    @Getter
    @Setter
    private List<ArticleEntity> articleEntities = new ArrayList<>();

    /* @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    @Getter private List<Role> roles;*/
    @JsonIgnore
    private String roles;


    @JsonIgnore
    @Setter
    private String permissions;

    public UserEntity(String firstName, String lastName, String email, String password, String social,
                      String position, String description, String avatar, String roles, String permissions, boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = email.split("@")[0];
        setPassword(password);
        this.social = social;
        this.position = position;
        this.base64Avatar = avatar;
        this.enabled = enabled;
        this.creationTimeStamp = System.currentTimeMillis();
        this.lastLoginTimestamp = 0L;
        this.roles = roles;
        this.permissions = permissions;
        this.description = description;
    }

    public UserEntity(String firstName, String lastName, String email, String password, String social,
                      String position, String description, String roles, String permissions, boolean enabled) {
        this(firstName, lastName, email, password, social, position, description, UtilitiesCollection.base64avatar(), roles, permissions, enabled);

    }

    public UserEntity(String firstName, String lastName, String email, String password, String roles, String permissions, boolean enabled) {
        this(firstName, lastName, email, password, "",
                "Redakteur*in", "", roles, permissions, enabled);
    }

    public UserEntity(String email, String password) {
        this("", "", email, password, "USER", "*", true);
    }

    public UserEntity() {
    }


    /**
     * Updates the last login timestamp.
     * Sets the last login timestamp to the current system time in milliseconds.
     */
    public void updateLastLogin() {
        this.lastLoginTimestamp = System.currentTimeMillis();
    }

    /**
     * Sets the password for the user.
     *
     * @param password the new password to be set
     */
    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    /**
     * Returns a list of permissions.
     * <p>
     * This method splits the permissions string using the delimiter ";" and
     * returns a list of individual permissions as strings. If the permissions
     * string is empty, it returns an empty list.
     *
     * @return a list of permissions
     */
    public List<String> getPermissions() {
        if (this.permissions.length() > 0)
            return Arrays.asList(this.permissions.split(";"));
        return new ArrayList<>();
    }

    /**
     * Returns a list of roles for this user.
     *
     * @return A list of roles as strings.
     */
    public List<String> getRoles() {
        if (this.roles.length() > 0)
            return Arrays.asList(this.roles.split(";"));
        return new ArrayList<>();
    }

}
