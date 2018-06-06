package com.blog.blogProject.controller;

import com.blog.blogProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blog.blogProject.service.UserService;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public void addUser(@RequestBody User aUser){
        userService.addUser(aUser);
    }


    @RequestMapping("/users")
    public List<User> getAllUser(){
       return userService.getAlluser();
    }


    @RequestMapping(method = RequestMethod.POST,value = "/getUser")
    public User getLoginData(@RequestBody User aUser){
       return userService.getLogiData(aUser);
    }


}
