package org.geeksword.springboot.util.validation;

import lombok.NonNull;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.io.Serializable;

/**
 * @wenliujie
 */
public class EntityValidation implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
         return Serializable.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"firstName","first name is empty");
    }
}
