package org.unidue.campusfm.queerzard.cms.web.controllers.admin;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;
import org.unidue.campusfm.queerzard.cms.database.services.user.CampusUserDetails;

import java.util.List;

@Controller
public class MyProfileController {


    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;
    @RequestMapping("/myprofile")
    public String myProfile(Authentication authentication){

        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);
        if(userDetails == null)
            return "redirect:/";
        return "redirect:/profile/" + userDetails.getUsername().toLowerCase();
    }

    @RequestMapping("/profile/{username}")
    public String userProfile(Authentication authentication, Model model, @PathVariable("username") String username){
        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);
        if(userDetails == null)
            return "redirect:/";
        boolean notAdmin = false;
        boolean notSelf = true;
        if(!userService.userExistsByName(username) ||
                (notSelf = !username.equalsIgnoreCase(userDetails.getUsername())) && (notAdmin = !userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().contains("ADMIN"))))
            return "redirect:/myprofile";

        UserEntity userEntity = userService.getUserByUsername(username);


        List<ArticleEntity> draftEntitiesList;

        model.addAttribute("userEntity", userEntity);

        if(!notSelf && !notAdmin){
            draftEntitiesList = articleService.findAllUnpublishedArticles();
        } else {
            draftEntitiesList = articleService.findAllUnpublishedByAuthor(userEntity);
        }

        model.addAttribute("draftEntitiesList", draftEntitiesList);
        return "admin/myprofile";
    }

}
