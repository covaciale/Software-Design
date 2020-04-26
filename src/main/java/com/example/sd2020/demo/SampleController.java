package com.example.sd2020.demo;

import model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SampleController {

    private UserDAO userDAO = new UserDAO();
    private DancesDAO dancesDAO = new DancesDAO();
    private AntrenoriDAO antrenoriDAO = new AntrenoriDAO();

    public SampleController() {
    }

    @GetMapping("/hello") // localhost:8080/
    public String getHelloWorld() {
        return "Hello SD 2020";
    }

    @GetMapping("/allListUser") // localhost:8080/allListUser
    public List<User> findAllUser() {
        List<User> list = userDAO.findAll();
        return list;
    }

    @GetMapping("/allListDances") // localhost:8080/allListDances
    public List<Dances> findAllDances() {
        List<Dances> list = dancesDAO.findAll();
        return list;
    }

    @GetMapping("/allListAntrenori") // localhost:8080/allListAntrenori
    public List<User> findAllAntrenori() {
        List<User> list = antrenoriDAO.findAll();
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
        User user = (new UserFactory()).createUser(item.idUser, item.firstName, item.secondName, item.age, item.gender, item.dance);
        if (user != null) {
            userDAO.add(user);
        }
    }
}
