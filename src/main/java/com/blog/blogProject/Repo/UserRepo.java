package com.blog.blogProject.Repo;

import com.blog.blogProject.model.User;
import com.blog.blogProject.model.BlogTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepo extends CrudRepository<User,Long> {
    public User findByUserId(Long userid);


}

