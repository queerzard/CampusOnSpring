package org.unidue.campusfm.queerzard.cms.web.controllers.admin.security;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;
import org.unidue.campusfm.queerzard.cms.database.services.user.CampusUserDetails;
import org.unidue.campusfm.queerzard.cms.web.dto.RegistrationModel;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public String registerNewUser(Authentication authentication, Model model, @RequestParam(value = "error", required = false) String message){
        CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);
        boolean admin = false;
        if(userDetails == null || !(admin = userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().contains("ADMIN"))))
            return "redirect:/myprofile";

        RegistrationModel registrationModel = new RegistrationModel();
        model.addAttribute("registrationModel", registrationModel);
        return "admin/register";
    }

    @PostMapping("/register")
    public String registerNewUser(Authentication authentication,
                                  @ModelAttribute("registrationModel") @Valid RegistrationModel registrationModel,
                                  BindingResult result, Model model){

    /*    ValidationUtils.invokeValidator(validator, registrationModel, result);*/

                CampusUserDetails userDetails = (authentication != null ? (CampusUserDetails) authentication.getPrincipal() : null);
        boolean admin = false;
        if(userDetails == null || !(admin = userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().contains("ADMIN"))))
            return "redirect:/myprofile";

        if(result.hasErrors()) {
            System.out.println("HAHAHAH KAKA2");
            return "admin/register";
        }

        System.out.println("kaka 3 :c");
        return "admin/register";
    }

}
