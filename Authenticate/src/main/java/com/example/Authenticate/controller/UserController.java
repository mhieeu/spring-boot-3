package com.example.Authenticate.controller;

import com.example.Authenticate.model.User;
import com.example.Authenticate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String run(){
        return "running...";
    }

    @GetMapping("/auth")
    public String runAuth(){
        return "running with auth...";
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }
}
