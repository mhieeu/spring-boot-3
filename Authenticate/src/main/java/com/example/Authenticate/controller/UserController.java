package com.example.Authenticate.controller;

import com.example.Authenticate.model.User;
import com.example.Authenticate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{username}")
    public Optional<User> getUser(@PathVariable String username){
        Optional<User> foundUser = userService.getUserByUsername(username);
        if (foundUser.isEmpty()){
            throw new RuntimeException("User " + username + " not found!");
        }
        return foundUser;
    }
}
