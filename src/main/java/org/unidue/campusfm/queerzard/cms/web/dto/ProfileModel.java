package org.unidue.campusfm.queerzard.cms.web.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class ProfileModel implements Serializable {

    private String username;


    @Size(min = 2, max = 16)
    @NotBlank(message = "Firstname cannot be blank..")
    private String firstName;

    @Size(min = 2, max = 16)
    @NotBlank(message = "Lastname cannot be blank.")
    private String lastName;

    @Email
    private String email;

    private String socialLink;

    private String position;
    private String description;

    private String base64Avatar;

    @NotBlank
    private String enabled = "0";

    public String toString() {
        return "ProfileModel{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", socialLink='" + socialLink + '\'' +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                ", base64Avatar='" + base64Avatar + '\'' +
                ", enabled='" + enabled + '\'' +
                '}';
    }

}
