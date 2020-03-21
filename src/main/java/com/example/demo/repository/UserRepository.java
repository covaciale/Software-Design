package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    //autowire cu proprietatile configurate in application.properties
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<String> getAllUserNames() {
        List<String> usernameList =new ArrayList<>();
        usernameList.addAll(jdbcTemplate.queryForList("select Nume from users;", String.class));
        return usernameList;
    }

    public List<String> getAllUserEmail() {
        List<String> userEmail =new ArrayList<>();
        userEmail.addAll(jdbcTemplate.queryForList("select Email from users;", String.class));
        return userEmail;
    }
}
