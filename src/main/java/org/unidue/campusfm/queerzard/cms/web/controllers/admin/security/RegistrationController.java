package org.unidue.campusfm.queerzard.cms.web.controllers.admin.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @RequestMapping("/register")
    public String registerNewUser(Authentication authentication, Model model){
        return "admin/register";
    }

}
