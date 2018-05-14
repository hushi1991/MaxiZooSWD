package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.User;

import java.util.ArrayList;

public interface IUserRepo {

    public User login(String username, String password);

    public ArrayList<User> readAll();
}
