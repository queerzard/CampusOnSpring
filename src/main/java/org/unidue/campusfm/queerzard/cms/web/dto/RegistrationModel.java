package org.unidue.campusfm.queerzard.cms.web.dto;

import lombok.Data;
import lombok.Getter;
import org.unidue.campusfm.queerzard.cms.utils.validators.DisallowedCharacters;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class RegistrationModel implements Serializable {

    @NotBlank(message = "Username is a mandatory field!")
    @DisallowedCharacters(message = "This field cannot contain special characters!")
    @Size(min = 5, max = 16, message = "Your username must have a length of 5 to 16 characters!")
    private String username;

    @NotBlank(message = "Email is a mandatory field!")
    @Email(message = "Please enter a valid email!")
    private String email;

    @NotBlank(message = "Password is a mandatory field!")
    @Size(min = 8, max = 32, message = "Your password must have a length of 8 to 32 characters!")
    private String password;

    @Override
    public String toString() {
        return "RegistrationModel{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
