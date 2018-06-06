package com.blog.blogProject.controller;

import com.blog.blogProject.model.BlogTable;
import com.blog.blogProject.model.User;
import com.blog.blogProject.service.BlogService;
import com.blog.blogProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @RequestMapping(method = RequestMethod.POST, value = "/blog")
    public void addBlog(@RequestBody BlogTable aBlog) {
        blogService.addBlog(aBlog);
    }

    @RequestMapping("/blogs")
    public List<BlogTable> getAllBlog() {
        return blogService.getAllblog();
    }

}