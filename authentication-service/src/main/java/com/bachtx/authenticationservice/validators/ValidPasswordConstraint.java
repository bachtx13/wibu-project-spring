package com.bachtx.authenticationservice.validators;

import com.bachtx.authenticationservice.constants.RegexConstants;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class ValidPasswordConstraint implements ConstraintValidator<ValidPassword, String> {
    private final Pattern pattern = Pattern.compile(RegexConstants.VALID_PASSWORD_REGEX);

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return pattern.matcher(value).matches();
    }
}
