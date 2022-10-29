package com.example.barbershopprogramming.annotation.password_validator;

import com.example.barbershopprogramming.dto.UserCreateDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserCreateDTO user = (UserCreateDTO) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
