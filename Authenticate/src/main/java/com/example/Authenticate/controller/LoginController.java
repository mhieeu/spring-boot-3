package com.example.Authenticate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showMyLoginPage(){
        return "login";
    }

    @GetMapping("/")
    public String run(){
        return "index";
    }
}
