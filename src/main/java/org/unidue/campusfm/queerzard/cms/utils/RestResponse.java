
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public class RestResponse {

    @Getter private HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Getter private LocalDateTime timestamp;
    @Getter private HashMap<String, Object> data;
    @Getter private String message;

    public RestResponse() {
        this.data = new HashMap<>();
        this.timestamp = LocalDateTime.now();
    }

    public RestResponse(HttpStatus httpStatus) {
        this();
        this.httpStatus = httpStatus;
    }

    public RestResponse(HttpStatus httpStatus, String message) {
        this();
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public RestResponse addData(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public RestResponse removeData(String key){
        this.data.remove(key);
        return this;
    }
}

