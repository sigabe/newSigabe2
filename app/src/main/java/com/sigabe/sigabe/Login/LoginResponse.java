package com.sigabe.sigabe.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    private User user;

    @SerializedName("key")
    @Expose
    private String key;

    public String getKey() {

        return key;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
