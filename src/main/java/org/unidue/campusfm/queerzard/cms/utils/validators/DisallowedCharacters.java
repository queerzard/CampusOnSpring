
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.utils.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DisallowedCharactersValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DisallowedCharacters {

    String message() default "Invalid user input; Some characters may not be allowed!";

    String whitelist() default "a-zA-Z0-9_ÄäÖöÜüß ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
