
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.utils.validators;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Ozan A. Aslan
 * @version 1.0
 * @since 2022-01-10
 * <p>
 * This class is used to validate user input.
 * It checks if the string passed is either null or blank and
 * if the user is only using predefined characters. (by default: from A-Z in both lower and uppercase);
 * It also checks if the user used numbers.
 * </p>
 */

public class DisallowedCharactersValidator implements ConstraintValidator<DisallowedCharacters, String> {


    private String regex;

    @Override
    public void initialize(DisallowedCharacters constraintAnnotation) {
        regex = constraintAnnotation.whitelist();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.matches("[" + this.regex + "]+");
    }
}
