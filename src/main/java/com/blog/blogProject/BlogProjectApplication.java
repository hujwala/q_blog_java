package com.blog.blogProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BlogProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogProjectApplication.class, args);
	}

	public static class UserService {

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
}
