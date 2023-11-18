package org.unidue.campusfm.queerzard.cms.web.controllers.admin;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;
import org.unidue.campusfm.queerzard.cms.database.services.user.CampusUserDetails;
import org.unidue.campusfm.queerzard.cms.web.dto.ProfileModel;

import javax.validation.Valid;
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

    @GetMapping("/profile/{username}")
    public String userProfile(Authentication authentication, Model model, @PathVariable("username") String username){
        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);
        if(userDetails == null)
            return "redirect:/";
        boolean admin = (admin = userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().contains("ADMIN")));
        boolean notSelf = true;
        if(!userService.userExistsByName(username) ||
                (notSelf = !username.equalsIgnoreCase(userDetails.getUsername())) && !admin)
            return "redirect:/myprofile";

        UserEntity userEntity = userService.getUserByUsername(username);


        List<ArticleEntity> draftEntitiesList;
        List<ArticleEntity> articleEntitiesList;

        model.addAttribute("userEntity", userEntity);

        articleEntitiesList = articleService.getArticlesByAuthor(userEntity, null);

        if(!notSelf && admin){
            draftEntitiesList = articleService.findAllUnpublishedArticles();
        } else {
            draftEntitiesList = articleService.findAllUnpublishedByAuthor(userEntity);
        }

        model.addAttribute("draftEntitiesList", draftEntitiesList);
        model.addAttribute("articleEntitiesList", articleEntitiesList);
        model.addAttribute("profileModel", new ProfileModel());
        return "admin/myprofile";
    }

    @PostMapping("/profile/{username}")
    public String patchUserProfile(Authentication authentication, Model model, @PathVariable("username") String username,
                                   @ModelAttribute("profileModel") @Valid ProfileModel profileModel){

        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);
        if(userDetails == null)
            return "redirect:/";
        boolean admin = (admin = userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().contains("ADMIN")));
        boolean notSelf = true;
        if(!userService.userExistsByName(username) ||
                (notSelf = !username.equalsIgnoreCase(userDetails.getUsername())) && !admin)
            return "redirect:/myprofile";

        UserEntity userEntity = userService.getUserByUsername(username);

        if(admin){
            if(profileModel.getEnabled() != null && !profileModel.getEnabled().isBlank())
                userEntity.setEnabled(profileModel.getEnabled().equalsIgnoreCase("1") ||
                        profileModel.getEnabled().equalsIgnoreCase("true") ||
                        profileModel.getEnabled().equalsIgnoreCase("on"));
            if(profileModel.getPosition() != null && !profileModel.getPosition().isBlank())
                userEntity.setPosition(profileModel.getPosition());
        }

        if(profileModel.getEmail() != null && !profileModel.getEmail().isBlank() && !userService.userExistsByEmail(profileModel.getEmail()))
            userEntity.setEmail(profileModel.getEmail());

        if(profileModel.getFirstName() != null && !profileModel.getFirstName().isBlank())
            userEntity.setFirstName(profileModel.getFirstName());
        if(profileModel.getLastName() != null && !profileModel.getLastName().isBlank())
            userEntity.setLastName(profileModel.getLastName());
        if(profileModel.getSocialLink() != null && !profileModel.getSocialLink().isBlank())
            userEntity.setSocial(profileModel.getSocialLink());
        if(profileModel.getDescription() != null && !profileModel.getDescription().isBlank())
            userEntity.setDescription(profileModel.getDescription());
        if(profileModel.getBase64Avatar() != null && !profileModel.getBase64Avatar().isBlank())
            userEntity.setBase64Avatar(profileModel.getBase64Avatar().contains(",") ?
                    profileModel.getBase64Avatar().split(",")[1] : profileModel.getBase64Avatar());

        userService.update(userEntity);

        System.out.println(profileModel);

        return "redirect:/profile/" + username;
    }

}
