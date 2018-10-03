package com.myapp.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myapp.persistence.UserEntity;
import com.myapp.service.UserService;


@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;
    
    
    @Autowired
    private EmailValidator emailvalidator;

    @Autowired
    private PasswordValidator passwordvalidator;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserEntity user = (UserEntity) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        
        if (!emailvalidator.valid(user.getUsername()))
        {
        	errors.rejectValue("username", "email.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 7 || user.getPassword().length() > 20) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if (!passwordvalidator.valid(user.getPassword()))
        {
        	errors.rejectValue("password", "format.userForm.password");
        }
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        
        if ( user.getBirthDate()== null || user.getBirthDate().after(new Date()))
        {
        	 errors.rejectValue("birthDate", "valid.userForm.birthDate");
        }
    }
}