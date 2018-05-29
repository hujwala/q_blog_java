package com.blog.blogProject;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {


    private String name;
    @Id
    private String email;
    private String password;
    private String profileImage;
    private int writtenStoryCount;
    private Date createedAt;
    private Date updatedAt;

    public User() {
    }

    public User(String name, String email, String password, String profileImage, int writtenStoryCount, Date createedAt, Date updatedAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
        this.writtenStoryCount = writtenStoryCount;
        this.createedAt = createedAt;
        this.updatedAt = updatedAt;
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
}
