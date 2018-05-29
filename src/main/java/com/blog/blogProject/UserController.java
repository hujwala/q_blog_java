package com.blog.blogProject;

import com.blog.blogProject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
