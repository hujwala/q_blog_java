package com.blog.blogProject.service;

import com.blog.blogProject.Repo.GenreRepo;
import com.blog.blogProject.model.BlogTable;
import com.blog.blogProject.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GenreService {


    @Autowired
    GenreRepo genreRepo;


    public Genre addGenre(Genre genre) {
        Genre saveGenre = genreRepo.save(genre);
        return saveGenre;
    }

    public List<Genre> getAllGenre() {
        List<Genre> genre = new ArrayList<>();
        genreRepo.findAll().forEach(genre::add);
        return genre;
    }
}