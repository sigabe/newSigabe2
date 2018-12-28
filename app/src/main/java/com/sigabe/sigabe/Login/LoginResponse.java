package com.sigabe.sigabe.Login;

public class LoginResponse {
    private String auth;
    private User user;

    public LoginResponse(String auth, User user) {
        this.auth = auth;
        this.user = user;
    }

    public String getAuth() {
        return auth;
    }

    public User getUser() {
        return user;
    }

}
