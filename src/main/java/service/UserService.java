package service;

import Repo.UserRepo;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    UserRepo userRepo;

    public void addUser(User aUser) {

        userRepo.save(aUser);

    }

    public void getAlluser() {



    }
}
