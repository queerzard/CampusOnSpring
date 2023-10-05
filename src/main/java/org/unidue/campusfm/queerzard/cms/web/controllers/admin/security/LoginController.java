package org.unidue.campusfm.queerzard.cms.web.controllers.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    //TODO: AUTHENTICATION STILL NOT WORKING. RETURNS 403 & HANDLE VALIDATION

    @RequestMapping("/login")
    public String getLogin(Model model){

        return "security/login";
    }

}
