package com.blog.blogProject.Repo;

import com.blog.blogProject.model.User;
import com.blog.blogProject.model.BlogTable;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Long> {


}
