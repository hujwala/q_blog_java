package com.blog.blogProject.service;

import com.blog.blogProject.Repo.BlogRepo;
import com.blog.blogProject.model.BlogTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepo blogRepo;

    public void addBlog(BlogTable aUser) {
        blogRepo.save(aUser);

    }

    public List<BlogTable> getAllblog() {

        List<BlogTable> blog=new ArrayList<>();
        blogRepo.findAll().forEach(blog::add);

        return blog;
    }
}
