package com.blog.blogProject.service;

import com.blog.blogProject.Repo.BlogRepo;
import com.blog.blogProject.Repo.UserRepo;
import com.blog.blogProject.model.BlogTable;
import com.blog.blogProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    BlogRepo blogRepo;
    @Autowired
    UserRepo userRepo;


    public List<BlogTable> getAllblog() {
        List<BlogTable> blog=new ArrayList<>();
        blogRepo.findAll().forEach(blog::add);
        return blog;
    }

    public void removeBlog(Long blogId) {

       Optional<BlogTable> blogTable= blogRepo.findById(blogId);
        blogRepo.delete(blogTable.get());
    }

    // @RequestMapping(value = "/getStoryCount/{userId}", method = RequestMethod.GET)
   // public int getStoryCount(@PathVariable Long userId) {
     //   User user = userRepo.findByUserId(userId);

        //  blog.setUser(pbToAttachToThisBook);
       // return user.getWrittenStoryCount();
   // }
}
