package com.blog.blogProject.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long userId;
    private String email;
    private String name;
    @NotNull
    private String password;
    private String profileImage;
    private int writtenStoryCount;
    @CreationTimestamp
    private Date createedAt;
    @UpdateTimestamp
    private Date updatedAt;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BlogTable> blog = new ArrayList<>();

    public User() {
    }



    public User(Long userId, String name, String email, String password, String profileImage, int writtenStoryCount, Date createedAt, Date updatedAt, Long id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
        this.writtenStoryCount = writtenStoryCount;
        this.createedAt = createedAt;
        this.updatedAt = updatedAt;
        this.userId=userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getWrittenStoryCount() {
        return writtenStoryCount;
    }

    public void setWrittenStoryCount(int writtenStoryCount) {
        this.writtenStoryCount = writtenStoryCount;
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

    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public List<BlogTable> getBlog() {
        return blog;
    }

    public void setBlog(List<BlogTable> blog) {
        this.blog = blog;
    }

    public User(List<BlogTable> blog) {
        this.blog = blog;
    }
}
