package org.unidue.campusfm.queerzard.cms.web.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class ProfileModel implements Serializable {
    private String username;

    @Size(min = 2, max = 16)
    private String firstName;

    @Size(min = 2, max = 16)
    private String lastName;

    @Email
    private String email;

    private String socialLink;

    private String position;

    private String base64Avatar;

}
