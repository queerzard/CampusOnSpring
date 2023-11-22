
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticsController {

    @RequestMapping("/imprint")
    public String getImprint(){
        return "statics/imprint";
    }

    @RequestMapping("/program")
    public String getProgram(){
        return "statics/program";
    }

    @RequestMapping("/listen")
    public String getListen(){
        return "statics/listen";
    }

    @RequestMapping("/contact")
    public String getContact(){
        return "statics/contact";
    }

    @RequestMapping("/contribute")
    public String getContribute(){
        return "statics/contribute";
    }


}
