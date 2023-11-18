package org.unidue.campusfm.queerzard.cms;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unidue.campusfm.queerzard.cms.database.dao.ArticleEntity;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.ArticleService;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;

import javax.annotation.PostConstruct;

@Service
public class ExampleData {

    // STOPSHIP: 04.10.2023  
    
    @Autowired
    private ArticleService articleService;


    @Autowired
    private UserService userService;

    @PostConstruct
    public void init(){
        if(userService.count() == 0){
            UserEntity user = userService.addUserIfNotExists(new UserEntity(
                    "Ozan", "Aslan", "ozan0.aslan5@gmail.com",
                    "default", "https://github.com/queerzard","Web-Admin",
                    "Leftie","ROLE_ADMIN", "*", true));

            for(int i = 0; i < 12; i++){
                ArticleEntity article = articleService.addArticle(new ArticleEntity(
                        user, "This Is A Test Article", "This is lorem ipsum test content for a test article",
                        "allgemein", "news, trump", null, null));
                article.setPublished(true);
                articleService.update(article);
            }

        }


    }

}
