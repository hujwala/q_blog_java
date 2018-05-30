package com.blog.blogProject;

import com.blog.blogProject.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
     UserService userService;
    @CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public void addUser(@RequestBody User aUser){

        userService.addUser(aUser);

    }
    @CrossOrigin(origins = {"http://localhost:3000"})
    @RequestMapping("/users")
    public List<User> getAllUser(){
        return userService.getAlluser();
    }
}
