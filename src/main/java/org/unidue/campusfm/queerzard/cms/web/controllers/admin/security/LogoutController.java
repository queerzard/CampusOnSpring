
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.controllers.admin.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The LogoutController class handles the logout functionality in the application.
 * It is responsible for redirecting the user to the home page ("/") after logging out.
 */
@Controller
public class LogoutController {

    @GetMapping("/logout")
    @PostMapping("/logout")
    public String onLogout() {
        return "redirect:/login";
    }

}
