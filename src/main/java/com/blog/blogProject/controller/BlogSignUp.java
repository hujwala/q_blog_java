package com.blog.blogProject.controller;

import com.blog.blogProject.model.SignUpStatus;
import com.blog.blogProject.model.User;
import com.blog.blogProject.service.UserService;
import com.blog.blogProject.utils.StringResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogSignUp {

    @Autowired
    UserService userService;

    //Signup API
    @CrossOrigin(origins = {"*"})
    @RequestMapping(method = RequestMethod.POST,value = "/userSignup")
    public SignUpStatus userSignUp(@RequestBody User aUser){
        SignUpStatus signupStatus=new SignUpStatus();
        if(aUser.getEmail()!=null&&aUser.getPassword()!=null&&aUser.getName()!=null){
            User lUser = userService.addUser(aUser);
            signupStatus.setEmail(lUser.getEmail());
            signupStatus.setStatusMessage(StringResource.SIGNUP_SUCESSFULL);
            return signupStatus;

        }else{
            signupStatus.setStatusMessage(StringResource.SIGNUP_FAIL);
            signupStatus.setEmail("null");
            return signupStatus;
        }
    }
}
