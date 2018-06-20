package com.blog.blogProject.controller;

import com.blog.blogProject.model.SignUpStatus;
import com.blog.blogProject.model.User;
import com.blog.blogProject.service.UserService;
import com.blog.blogProject.utils.StringResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserSignUp {

    @Autowired
    UserService userService;

    //Signup API
    @CrossOrigin(origins = {"*"})
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST,value = "/userSignup")
    public SignUpStatus userSignUp(@Valid @RequestBody User aUser) throws ConstraintViolationException {
        SignUpStatus signupStatus=new SignUpStatus();
        if(aUser.getEmail()!=null&&aUser.getPassword()!=null&&aUser.getName()!=null){

            User lUser=null;
            try{

                 lUser = userService.addUser(aUser);
                signupStatus.setEmail(lUser.getEmail());
                signupStatus.setStatusMessage(StringResource.SIGNUP_SUCESSFULL);

            }catch (Exception ex){
                signupStatus.setStatusMessage(StringResource.SIGNUP_USER_EXIT);

            }
            return signupStatus;

        }else{
            signupStatus.setStatusMessage(StringResource.SIGNUP_FAIL);
            signupStatus.setEmail("null");
            return signupStatus;
        }
    }

    //test

}
