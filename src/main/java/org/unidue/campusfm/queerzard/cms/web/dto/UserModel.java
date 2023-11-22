
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.dto;


import lombok.Getter;
import lombok.Setter;
import org.unidue.campusfm.queerzard.cms.utils.validators.DisallowedCharacters;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

//Keep it POJO
public class UserModel implements Serializable {

    @NotBlank(message = "Username is a mandatory field!")
    @DisallowedCharacters(message = "This field cannot contain special characters!")
    @Getter @Setter private String username;

    @NotBlank(message = "Firstname is a mandatory field!")
    @DisallowedCharacters(message = "This field cannot contain special characters!")
    @Getter @Setter private String firstName;

    @NotBlank(message = "Lastname is a mandatory field!")
    @DisallowedCharacters(message = "This field cannot contain special characters!")
    @Getter @Setter private String lastName;

    @NotBlank(message = "Email is a mandatory field!")
    @DisallowedCharacters(message = "This field cannot contain special characters!")
    @Email
    @Getter @Setter private String email;

    @NotBlank(message = "The Password is a mandatory field!")
    @Getter @Setter private String password;

    @Getter @Setter private String base64avatar;

}
