package org.unidue.campusfm.queerzard.cms.web.controllers.admin.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String onLogout(){
        return "redirect:/";
    }

}
