package com.example.demo.Model.Repositories;

import com.example.demo.Model.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepo implements IUserRepo{

    @Autowired
    private JdbcTemplate jdbc;


    public User login(String username, String password) {

        ArrayList<User> users = readAll();

        for(User u : users) {
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }

        return null;
    }

    @Override
    public ArrayList<User> readAll() {

        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM maxi_zoo.user");
        ArrayList<User> users = new ArrayList<>();

        while(sqlRowSet.next()) {
            users.add(new User(sqlRowSet.getInt("id"), sqlRowSet.getBoolean("admin"), sqlRowSet.getString("username"), sqlRowSet.getString("password")));
        }

        return users;
    }
}
