package com.blog.blogProject.model;

public class JwtUser {

    private String userName;
    private Long id;
    private String role;

    public void setUserName(String subject) {
        this.userName=subject;
    }

    public void setId(long userId) {
        this.id=userId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }

    public Long getId() {
        return id;
    }

}
