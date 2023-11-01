package com.example.Authenticate.service;

import com.example.Authenticate.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

//    User findById(String id);

    User save(User user);

//    void deleteById(int id);
}
