package com.blog.blogProject.customexception;

import com.blog.blogProject.model.User;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.HashSet;
import java.util.Set;

public class CustomViolationException {

/*
    private void validateMember(User member) throws ConstraintViolationException, ValidationException {
        Set<ConstraintViolation<User>> violations=validator.validate(member);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
        if (emailAlreadyExists(member.getEmail())) {
            throw new ValidationException("Unique Email Violation");
        }

        */

    }

