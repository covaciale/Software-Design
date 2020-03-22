package com.example.sd2020.demo;

import model.AbstractDAO;
import model.User;
import model.UserDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SampleController {

    private UserDAO userDAO = new UserDAO();


    public SampleController() {
    }

    @GetMapping("/hello") // localhost:8080/
    public String getHelloWorld() {
        return "Hello SD 2020";
    }

    @GetMapping("/allList") // localhost:8080/allList
    public List<User> findAll() {
        List<User> list = userDAO.findAll();
        return list;
    }

    @GetMapping("/male") // localhost:8080/male
    public List<User> male() {
        List<User> list = userDAO.findByGender("M");
        return list;
    }

    @GetMapping("/female") // localhost:8080/female
    public List<User> female() {
        List<User> list = userDAO.findByGender("F");
        return list;
    }

    @GetMapping("/first") // localhost:8080/first
    public User first() {
        User list = userDAO.findById(1);
        return list;
    }

    @PostMapping("/insertItem") // localhost:8080/insertItem
    public void insertItem(User item) {
        userDAO.add(item);
    }
}
