
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.web.controllers.rest;

import org.apache.logging.log4j.core.config.Order;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.unidue.campusfm.queerzard.cms.utils.RestResponse;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles the HttpMessageNotReadableException by returning a ResponseEntity with a customized error message
     *
     * @param ex      the HttpMessageNotReadableException that occurred
     * @param headers the HttpHeaders of the request
     * @param status  the HttpStatus of the response
     * @param request the WebRequest of the request
     * @return a ResponseEntity with a customized error message in response
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        RestResponse restResponse = new RestResponse(HttpStatus.BAD_REQUEST, error);
        return new ResponseEntity<>(restResponse, restResponse.getHttpStatus());
    }


}
