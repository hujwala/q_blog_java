package com.blog.blogProject.model;

import com.blog.blogProject.utils.StringResource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="blog_table")
public class BlogTable implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long Id;
    @NotNull(message = "{blog_table.title.notnull}")
    @Size(min=3, message = "{blog_table.title.size}")
    private String title;
    @NotNull(message = "{blog_table.description.notnull}")
    @Size(min=10, message = "{blog_table.description.size}")
    private String description;
    private String content;
    private String image;
    private String readingDuration;
    @CreationTimestamp
    private Date createedAt;
    @UpdateTimestamp
    private Date updatedAt;


    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name="genreId", referencedColumnName="genreId")
    private Genre genre;

    public BlogTable(Genre genre) {
        this.genre = genre;
    }

    public Genre getGenre() {

        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public BlogTable() {

    }
    public BlogTable(String title, String description, String content, String image, String readingDuration, Date createedAt, Date updatedAt) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.image = image;
        this.readingDuration = readingDuration;
        this.createedAt = createedAt;
        this.updatedAt = updatedAt;
    }



    public String getTitle() {

        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReadingDuration() {
        return readingDuration;
    }

    public void setReadingDuration(String readingDuration) {
        this.readingDuration = readingDuration;
    }

    public Date getCreateedAt() {
        return createedAt;
    }

    public void setCreateedAt(Date createedAt) {
        this.createedAt = createedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
