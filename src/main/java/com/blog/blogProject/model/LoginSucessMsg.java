package com.blog.blogProject.model;

public class LoginSucessMsg {

    private String authToken;
    private String Message;
    private String statusCode;
    private Long userId;


    public LoginSucessMsg() {
    }

    public LoginSucessMsg(Long userId, String authToken, String message, String statusCode) {
        this.authToken = authToken;
        Message = message;
        this.statusCode = statusCode;
        this.userId = userId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
