package com.example.Authenticate.service;

import com.example.Authenticate.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> getUserByUsername(String username);

    User save(User user);

//    void deleteById(int id);
}
