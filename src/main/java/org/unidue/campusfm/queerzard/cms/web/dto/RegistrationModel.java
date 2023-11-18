package org.unidue.campusfm.queerzard.cms.web.dto;

import lombok.Data;
import org.unidue.campusfm.queerzard.cms.utils.validators.DisallowedCharacters;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class RegistrationModel{

    @Size(min = 0, max = 16, message = "Role must have a length of 0 to 16 characters!")
    @NotBlank(message = "role is a mandatory field!")
    @DisallowedCharacters(message = "This field cannot contain special characters!")
    private String role;

    @Size(min = 0, max = 16, message = "Position must have a length of 0 to 16 characters!")
    @NotBlank(message = "role is a mandatory field!")
    @DisallowedCharacters(message = "This field cannot contain special characters!")
    private String position;


    @Email(message = "Please enter a valid email!")
    @NotBlank(message = "Email is a mandatory field!")
    private String email;

    @Size(min = 8, max = 32, message = "Your password must have a length of 8 to 32 characters!")
    @NotBlank(message = "Password is a mandatory field!")
    private String password;

    @Override
    public String toString() {
        return "RegistrationModel{" +
                "role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
