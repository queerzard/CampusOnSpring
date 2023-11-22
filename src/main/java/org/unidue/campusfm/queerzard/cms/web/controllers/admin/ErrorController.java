
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }

    //TODO: ERROR HANDLING
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        int code = Integer.valueOf(status.toString());

        switch (code){
            case 404:
                return "statics/error/404";
            default:
                return request.getAttribute(RequestDispatcher.ERROR_MESSAGE).toString();
        }

    }


}
