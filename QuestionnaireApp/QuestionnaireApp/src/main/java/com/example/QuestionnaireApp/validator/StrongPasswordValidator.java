package com.example.QuestionnaireApp.validator;

import com.example.QuestionnaireApp.annotation.StrongPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.regex.Pattern;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {

    private static final String STRONG_PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    /**
     * Password Policy
     * a digit must occur at least once
     * a lower case letter must occur at least once
     * an upper case letter must occur at least once
     * a special character must occur at least once
     * no whitespace allowed in the entire string
     **/
    public static boolean isStrongPassword(String password) {
        return Pattern.matches(STRONG_PASSWORD_REGEX, password);
    }

    @Override
    public void initialize(StrongPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return Objects.isNull(password) || isStrongPassword(password);
    }
}
