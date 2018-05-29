package com.blog.blogProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void addUser(User aUser) {

        userRepo.save(aUser);

    }

    public List<User> getAlluser() {

        List<User> user=new ArrayList<>();
        userRepo.findAll().forEach(user::add);

        return user;
    }
}