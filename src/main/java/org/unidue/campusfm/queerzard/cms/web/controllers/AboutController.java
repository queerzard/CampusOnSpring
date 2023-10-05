package org.unidue.campusfm.queerzard.cms.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;
import org.unidue.campusfm.queerzard.cms.database.repositories.UserRepository;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;

import java.util.List;

@Controller
public class AboutController {

    @Autowired
    private UserService userService;

    @RequestMapping("/about")
    public String getAbout(Model model){
        List<UserEntity> team = userService.findAll();
        model.addAttribute("userEntityList", team);
        return "about";
    }

}
