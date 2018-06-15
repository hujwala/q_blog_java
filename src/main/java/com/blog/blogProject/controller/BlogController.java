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
@RequestMapping("/rest")
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
    @CrossOrigin(origins = {"*"})
    @PostMapping(value = "/blog/{userId}")
    public BlogTable create(@PathVariable Long userId, @RequestBody BlogTable blog) {
       int storyCount= blogRepo.findByUserId(userId);//.size();
        User pbToAttachToThisBook = userRepo.findByUserId(userId);
        pbToAttachToThisBook.setWrittenStoryCount(++storyCount);
        blog.setUser(pbToAttachToThisBook);
        return blogRepo.save(blog);
    }

    @CrossOrigin(origins = {"*"})
    @DeleteMapping("/blog/deleteBlog/{blogId}")
    public void deleteBlog(@PathVariable Long blogId){
        blogService.removeBlog(blogId);
    }

    @CrossOrigin(origins = {"*"})
    @PutMapping(value = "user/updateBlogBy/{blogId}")
    public void updateBlog(@PathVariable Long blogId, @RequestBody BlogTable blog){
        blogService.updateBlog(blogId, blog);
    }


    @CrossOrigin(origins = {"*"})
    @GetMapping("/blogs")
    public List<BlogTable> getAllBlog() {
        return blogService.getAllblog();
    }
}