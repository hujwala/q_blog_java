package com.blog.blogProject.controller;

import com.blog.blogProject.Repo.BlogRepo;
import com.blog.blogProject.Repo.GenreRepo;
import com.blog.blogProject.model.BlogTable;
import com.blog.blogProject.model.Genre;
import com.blog.blogProject.model.User;
import com.blog.blogProject.service.BlogService;
import com.blog.blogProject.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class GenreController {

    @Autowired
    GenreService genreService;

    @CrossOrigin(origins = {"*"}, allowedHeaders = {"Authorisation"})
    @PostMapping("/genre")
    public void addGenre(@RequestBody Genre genre  ){
        genreService.addGenre(genre);
    }

    @CrossOrigin(origins = {"*"}, allowedHeaders = {"Authorisation"})
    @GetMapping("/genres")
    public List<Genre> getAllGenre() {
        return genreService.getAllGenre();
    }



}
