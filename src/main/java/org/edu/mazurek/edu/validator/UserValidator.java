package org.edu.mazurek.edu.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.edu.mazurek.edu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import lombok.*;


public class UserValidator implements Validator {
    @Setter
    @Getter

    private int minPasswordLength;
    private int maxPasswordLength;
    private static String loginRegex = "[a-zA-Z]*";
    private static String digitsRegex = ".*\\p{Digit}.*";
    private static String specialCharactersRegex = ".*[!£$#%^&*@?<>+_].*";


    EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //
    }

    public void validate(User user, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstname", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "lastname", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "telephone", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.field.required");

        if (errors.getErrorCount() == 0) {
            if (StringUtils.hasText(user.getEmail()) && emailValidator.isValid(user.getEmail()) == false) {
                errors.rejectValue("email", "error.email.invalid");
            }
        }
    }
}
