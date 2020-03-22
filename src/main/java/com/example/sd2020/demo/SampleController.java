package com.example.sd2020.demo;

import model.AbstractDAO;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SampleController {

    private AbstractDAO<User> abs;


    public SampleController() {
    }

    @GetMapping("/hello") // localhost:8080/
    public String getHelloWorld() {
        return "Hello SD 2020";
    }

    @GetMapping("/allList") // localhost:8080/allList
    public User findAll() {
        User list = (User) AbstractDAO.findAll();
        return list;
    }

    @GetMapping("/findById") // localhost:8080/findById
    public User findById() {
        User list = (User) AbstractDAO.findById(1);
        return list;
    }

    @PostMapping("/insertItem") // localhost:8080/insertItem
    public void insertItem(User item) {
        AbstractDAO.add(item);
    }
}
