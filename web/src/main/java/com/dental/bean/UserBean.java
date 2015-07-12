package com.dental.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by light on 5/3/2015.
 */
public class UserBean {

    @NotNull
    @Size(min = 5, max = 50)
    private String username;

    @NotNull
    @Size(min = 8, max = 50)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
