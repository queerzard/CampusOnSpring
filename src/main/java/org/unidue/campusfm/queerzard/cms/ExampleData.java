
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
public class ExampleData {

    // STOPSHIP: 04.10.2023  

    @Autowired
    private ArticleService articleService;


    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        if (userService.count() == 0) {
            String generatedPassword = UUID.randomUUID().toString();
            UserEntity user = userService.addUserIfNotExists(new UserEntity(
                    "admin", "istrator", "admin@existing.email",
                    generatedPassword, "https://github.com/queerzard/campusonspring", "Master User",
                    "Master User", "ADMIN", "*", true));

            System.out.println(
                    "+++++++++++++++++++++++++++++\n" +
                            "IMPORTANT! THESE ARE THE GENERATED ADMIN CREDENTIALS! NOTE THIS PASSWORD AS IT CANNOT BE CHANGED\n" +
                            "username: admin\n" +
                            "password:" + generatedPassword + "\n" +
                            "+++++++++++++++++++++++++++++\n"
            );
        }


    }

}
