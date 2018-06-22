package com.blog.blogProject.controller;

import com.blog.blogProject.model.User;
import com.blog.blogProject.service.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.blog.blogProject.service.UserService;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserController {

    private AmazonClient amazonClient;

    @Autowired
    UserService userService;

    @CrossOrigin(origins = {"*"})
    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAlluser();
    }


    /*@RequestMapping("/user/{id}")
    public User getLoginUser(@PathVariable Long id){
       return userService.getLoginUser(id);
    }*/


    @CrossOrigin(origins = {"*"})
    @PostMapping(value = "/getUser")
    public User getLoginData(@RequestBody User aUser){

        if(userService.getLogiData(aUser).getEmail()!=null){
            System.out.println("Not ----null--");
        }else{
            System.out.println(" ----null--");

        }
       return userService.getLogiData(aUser);
    }


    @CrossOrigin(origins = {"*"})
    @GetMapping("user/{userId}")
    public User getUserById(@PathVariable Long userId){
      return  userService.getUserById(userId);
    }


    @CrossOrigin(origins = {"*"})
    @DeleteMapping("user/deleteUserBy/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.removeUser(userId);
    }

    @CrossOrigin(origins = {"*"})
    @PutMapping(value = "user/updateUserBy/{userId}")
    public void updateUser(@Valid @PathVariable Long userId, @RequestBody User aUser){
        userService.updateUser(userId, aUser);
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping("/use")
    public String getTest(){

        return "sucess";
    }


    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }



}
