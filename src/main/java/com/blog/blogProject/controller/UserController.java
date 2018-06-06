package com.blog.blogProject.controller;

import com.blog.blogProject.model.SignUpStatus;
import com.blog.blogProject.model.User;
import com.blog.blogProject.utils.StringResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blog.blogProject.service.UserService;

import java.util.List;

@RestController
public class UserController {



    @Autowired
    UserService userService;

    //Signup API
    @CrossOrigin(origins = {"*"})
    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public SignUpStatus addUser(@RequestBody User aUser){
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





    @RequestMapping("/user")
    public List<User> getAllUser(){
       return userService.getAlluser();
    }
    @CrossOrigin(origins = {"*"})
    @RequestMapping("/use")
    public String getTest(){
        return "sucess";
    }

    @RequestMapping("/user/{id}")
    public User getLoginUser(@PathVariable Long id){
       return userService.getLoginUser(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/getUser")
    public User getLoginData(@RequestBody User aUser){

        if(userService.getLogiData(aUser).getEmail()!=null){
            System.out.println("Not ----null--");
        }else{
            System.out.println(" ----null--");

        }

       return userService.getLogiData(aUser);

    }


  //  Token eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJQcmFkZWVwIiwidXNlcklkIjoxMjMsInJvbGUiOiJhZG1pbiJ9.O8yxCVm86Q452KvxwXHWZuLhJdsV-4k1f3EKk6ofcFPAh9Z3H8F__vI7AmwNRkoWstf1wHJjf0jEZG5uQ2hJ_Q
           //eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJxd2luaXgiLCJ1c2VySWQiOjEyMzQsInJvbGUiOiJhZG1pbiJ9.oK3xf5Ns6xsLn3p0qkIRb9PKfiJWtGhz9WCDsh_Vbwj9SIa2qgA5IzmoCLRAutYnwh8v3m0_Q_OeAFOmfeUvyA

}
