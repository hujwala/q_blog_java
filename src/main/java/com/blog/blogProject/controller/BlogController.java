package com.blog.blogProject.controller;

import com.blog.blogProject.Repo.BlogRepo;
import com.blog.blogProject.Repo.GenreRepo;
import com.blog.blogProject.Repo.UserRepo;
import com.blog.blogProject.model.BlogTable;
import com.blog.blogProject.model.Genre;
import com.blog.blogProject.model.User;
import com.blog.blogProject.service.BlogService;
import com.blog.blogProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest")
public class BlogController {

    private BlogRepo blogRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private GenreRepo genreRepo;

    @Autowired
    BlogService blogService;

    @Autowired
    public BlogController(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }
    @CrossOrigin(origins = {"*"})
    @PostMapping(value = "/blog/{userId}/{genreId}")
    public BlogTable create(@PathVariable Long userId, @PathVariable Long genreId, @Valid @RequestBody BlogTable blog) {
       int storyCount= blogRepo.findByUserId(userId);
        User pbToAttachToThisBook = userRepo.findByUserId(userId);
        Genre genreRepoByGenreId = genreRepo.findByGenreId(genreId);
        pbToAttachToThisBook.setWrittenStoryCount(++storyCount);
        blog.setUser(pbToAttachToThisBook);
        blog.setGenre(genreRepoByGenreId);
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


    @CrossOrigin(origins = {"*"}, allowedHeaders = {"Authorisation"})
    @GetMapping("/blogs")
    public List<BlogTable> getAllBlog() {
        return blogService.getAllblog();
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping("blog/{blogId}")
    public BlogTable getBlogById(@PathVariable Long blogId){
        return  blogService.getBlogById(blogId);
    }

}