package com.blog.blogProject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="genre")
public class Genre implements Serializable{

        @javax.persistence.Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE)
        private Long genreId;

    public List<BlogTable> getBlog() {
        return blog;
    }

    public void setBlog(List<BlogTable> blog) {
        this.blog = blog;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogTable> blog = new ArrayList<>();

    public Genre(){

    }

    public Genre(Long genreId, String name) {
        this.genreId = genreId;
        this.name = name;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
