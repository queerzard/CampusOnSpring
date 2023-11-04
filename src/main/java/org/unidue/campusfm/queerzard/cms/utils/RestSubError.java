package org.unidue.campusfm.queerzard.cms.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

abstract class RestSubError { }
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
class ValidationError extends RestSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}