package com.blog.blogProject.controller;

import com.blog.blogProject.Repo.BlogRepo;
import com.blog.blogProject.Repo.UserRepo;
import com.blog.blogProject.model.BlogTable;
import com.blog.blogProject.model.User;
import com.blog.blogProject.service.BlogService;
import com.blog.blogProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    private BlogRepo blogRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    BlogService blogService;

    @Autowired
    public BlogController(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }
    @RequestMapping(value = "/blog/{userId}", method = RequestMethod.POST)
    public BlogTable create(@PathVariable Long userId, @RequestBody BlogTable blog) {
        User pbToAttachToThisBook = userRepo.findByUserId(userId);
        blog.setUser(pbToAttachToThisBook);
        return blogRepo.save(blog);
    }

    @RequestMapping("/blogs")
    public List<BlogTable> getAllBlog() {
        return blogService.getAllblog();
    }
}