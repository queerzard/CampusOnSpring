package org.unidue.campusfm.queerzard.cms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CampusConfig implements WebMvcConfigurer {


/*
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/login");
    }
*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/assets/");
    }

}
