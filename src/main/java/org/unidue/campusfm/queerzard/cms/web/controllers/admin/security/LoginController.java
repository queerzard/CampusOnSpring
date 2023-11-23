
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.controllers.admin.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * This class represents a LoginController in a web application. It handles the login functionality
 * by redirecting the user to the appropriate page based on their login status.
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(Principal principal){
        if(principal != null)
            return "redirect:myprofile";
        return "security/login";
    }

}
