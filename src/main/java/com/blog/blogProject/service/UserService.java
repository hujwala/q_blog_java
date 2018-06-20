package com.blog.blogProject.service;

import com.blog.blogProject.Repo.UserRepo;
import com.blog.blogProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User addUser(User aUser) {
           User  saveUser = userRepo.save(aUser);
        return saveUser;
    }

    public List<User> getAlluser() {

        List<User> user=new ArrayList<>();
        userRepo.findAll().forEach(user::add);
        return user;

    }

    public User getLogiData(User aUser) {

        List<User> user=new ArrayList<>();
        userRepo.findAll().forEach(user::add);

        for(int i=0;i<user.size();i++){
            User lUser=user.get(i);
            if(lUser.getEmail().equalsIgnoreCase(aUser.getEmail()) && lUser.getPassword().equals(aUser.getPassword()))
                return user.get(i);

        }

         return null;
    }


    public void removeUser(Long userId) {
        userRepo.delete(userRepo.findById(userId).get());
    }

    public void updateUser(Long userId, User aUser) {
      Optional<User> lUser= userRepo.findById(userId);
        lUser.get().setName(aUser.getName());
        lUser.get().setEmail(aUser.getEmail());
        lUser.get().setPassword(aUser.getPassword());
        lUser.get().setProfileImage(aUser.getProfileImage());
        userRepo.save(lUser.get());
    }


    public boolean getExistUser(String userName, String role) {

        List<User> user=new ArrayList<>();
        userRepo.findAll().forEach(user::add);
        System.out.println(user.size());

        for(int i=0;i<user.size();i++){
            User lUser=user.get(i);
            if(lUser.getEmail().equalsIgnoreCase(userName) && lUser.getPassword().equals(role))
                return true;
        }
        return false;
    }

}

