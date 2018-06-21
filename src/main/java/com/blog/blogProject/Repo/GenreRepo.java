package com.blog.blogProject.Repo;


import com.blog.blogProject.model.BlogTable;
import com.blog.blogProject.model.Genre;
import com.blog.blogProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepo extends JpaRepository<Genre,Long> {
    public Genre findByGenreId(Long genreId);

}

