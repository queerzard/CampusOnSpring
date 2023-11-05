package org.unidue.campusfm.queerzard.cms.web.controllers.rest.api.v1.profile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;

/*

HttpMethod | route | short explanation | logic
        response -> JSON-Content

 GET api/v1/profile/{id/username} Obtain a profile
        response ->


*/

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    @Autowired
    private UserService userService;




}
