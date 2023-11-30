
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.controllers.rest.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unidue.campusfm.queerzard.cms.utils.RestResponse;

@RestController
public class StatusRestController {

    @RequestMapping("/api/v1/status")
    public ResponseEntity<Object> onStatus() {
        return new ResponseEntity<>(new RestResponse(HttpStatus.OK, "Status: The CMS is online now!"), HttpStatus.OK);
    }

}
