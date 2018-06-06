package com.blog.blogProject.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class BlogTable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    @NotNull
    private Long userId;
    private String title;
    private String description;
    private String content;
    private String image;
    private String readingDuration;
    @CreationTimestamp
    private Date createedAt;
    @UpdateTimestamp
    private Date updatedAt;

    public BlogTable() {

    }
    public BlogTable(Long userId, String title, String description, String content, String image, String readingDuration, Date createedAt, Date updatedAt) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.image = image;
        this.readingDuration = readingDuration;
        this.createedAt = createedAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
