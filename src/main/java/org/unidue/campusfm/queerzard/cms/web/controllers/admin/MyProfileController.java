package org.unidue.campusfm.queerzard.cms.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyProfileController {

    @RequestMapping("/myprofile")
    public String myProfile(Model model){
        return "admin/myprofile";
    }

}
