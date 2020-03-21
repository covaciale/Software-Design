package com.example.demo.controller;
import java.util.List;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    /**
     *
     * @return usernameList
     */
    @GetMapping(path="getusername")
    public List<String> getAllUserNames(){

        return userRepository.getAllUserNames();
    }

    /**
     *
     * @return userEmail
     */
    @GetMapping(path="getuseremail")
    public List<String> getAllUserEmail(){
        return userRepository.getAllUserEmail();
    }

}
