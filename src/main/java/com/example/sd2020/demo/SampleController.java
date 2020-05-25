package com.example.sd2020.demo;

import model.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SampleController {

    private UserDAO userDAO = new UserDAO();
    private DancesDAO dancesDAO = new DancesDAO();
    private AntrenoriDAO antrenoriDAO = new AntrenoriDAO();

    public SampleController() {
    }

    @RequestMapping("/home") // localhost:8080/home
    public String getHelloWorld(Model model) {
        return "page2";
    }

    @RequestMapping("/allListUser") // localhost:8080/allListUser
    public String findAllUser(Model model) {
        model.addAttribute("users",userDAO.findAll());
        return "page3";
    }

    @RequestMapping("/allListDances") // localhost:8080/allListDances
    public String findAllDances(Model model) {
        model.addAttribute("dances", dancesDAO.findAll());
        return "page1";
    }

    @RequestMapping("/allListAntrenori") // localhost:8080/allListAntrenori
    public String findAllAntrenori(Model model) {
        model.addAttribute("antrenori", antrenoriDAO.findAll());
        return "page4";
    }

    @RequestMapping("/male") // localhost:8080/male
    public String male(Model model) {
        model.addAttribute("users",userDAO.findByGender("M"));
        System.out.println(userDAO.findByGender("M"));
        return "page3";
    }

    @RequestMapping("/female") // localhost:8080/female
    public String female(Model model) {
        model.addAttribute("users", userDAO.findByGender("F"));
        return "page3";
    }

    @RequestMapping("/first") // localhost:8080/first
    public String first(Model model) {
        model.addAttribute("users", userDAO.findById(1));
        System.out.println(userDAO.findById(1));
        return "page3";
    }

    @RequestMapping("/add") // localhost:8080/add
    public String addUser(Model model)
    {
        return "page5";
    }
    static int id = 4;
    @PostMapping("/insert") // localhost:8080/insert
    @ResponseBody
    public void insertItem(@RequestParam String fname, @RequestParam String lname,@RequestParam int varsta, @RequestParam String sex, @RequestParam String dans ) {

        User user = (new UserFactory()).createUser(id, fname, lname, varsta, sex, dans);
        if (user != null) {
            userDAO.add(user);
            id++;
        }

    }
}
