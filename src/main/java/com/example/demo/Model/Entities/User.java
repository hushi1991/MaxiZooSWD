package com.example.demo.Model.Entities;

public class User {

    private int id;
    private boolean admin;
    private String username;
    private String password;

    public User(int id, boolean admin, String username, String password) {
        this.id = id;
        this.admin = admin;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

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
