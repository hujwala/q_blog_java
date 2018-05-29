package com.blog.blogProject;

import com.blog.blogProject.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,String> {
}
