package com.blog.blogProject.model;

public class SignUpStatus {
    private String email;
    private String statusMessage;

    public SignUpStatus() {
    }

    public SignUpStatus(String email, String statusMessage) {
        this.email = email;
        this.statusMessage = statusMessage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
