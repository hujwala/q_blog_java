package com.blog.blogProject.controller;

import com.blog.blogProject.model.User;
import com.blog.blogProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/rest")
public class TestController {

    @Autowired
    UserService userService;
    @CrossOrigin(origins = {"*"})
    @GetMapping("/hello")
    public String hello(){
        return "hello work";
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/user")
    public List<User> getAllUser(){
        return userService.getAlluser();
    }

    @CrossOrigin(origins = {"*"})
    @RequestMapping("/use")
    public String getTest(){
        return "sucess";
    }


}
