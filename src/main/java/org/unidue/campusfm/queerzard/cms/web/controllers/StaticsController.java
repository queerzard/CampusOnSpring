
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class is a controller class that handles requests for static pages.
 */
@Controller
public class StaticsController {

    /**
     * Retrieves the URL for the imprint page.
     *
     * @return the URL for the imprint page
     */
    @RequestMapping("/imprint")
    public String getImprint(){
        return "statics/imprint";
    }

    /**
     * Retrieves the URL for the program page.
     *
     * @return the URL for the program page
     */
    @RequestMapping("/program")
    public String getProgram(){
        return "statics/program";
    }

    /**
     * Retrieves the URL for the listen page.
     *
     * @return the URL for the listen page
     */
    @RequestMapping("/listen")
    public String getListen(){
        return "statics/listen";
    }

    /**
     * Retrieves the URL for the contact page.
     *
     * @return the URL for the contact page
     */
    @RequestMapping("/contact")
    public String getContact(){
        return "statics/contact";
    }

    /**
     * Retrieves the URL for the contribute page.
     *
     * @return the URL for the contribute page
     */
    @RequestMapping("/contribute")
    public String getContribute(){
        return "statics/contribute";
    }


}
