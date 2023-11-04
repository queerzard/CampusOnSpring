package org.unidue.campusfm.queerzard.cms.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class RestError {

    @Getter private HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Getter private LocalDateTime timestamp;
    @Getter private String message;
    @Getter private String debugMessage;
    @Getter private List<RestSubError> subErrors;


    public RestError() {
        timestamp = LocalDateTime.now();
    }

    public RestError(HttpStatus httpStatus) {
        this();
        this.httpStatus = httpStatus;
    }

    public RestError(HttpStatus httpStatus, Throwable ex) {
        this();
        this.httpStatus = httpStatus;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    public RestError(HttpStatus httpStatus, String message, Throwable ex) {
        this();
        this.httpStatus = httpStatus;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}

