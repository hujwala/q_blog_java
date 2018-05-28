package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public void addUser(@RequestBody User aUser){

        userService.addUser(aUser);

    }


/*
    public List<User> getAllUser(){
        userService.getAlluser();
    }
*/

}
