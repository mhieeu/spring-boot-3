package com.example.Authenticate.service;

import com.example.Authenticate.model.User;
import com.example.Authenticate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    public UserServiceImpl(UserRepository theUserRepository) {
//        userRepository = theUserRepository;
//    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

//    @Override
//    public User findById(String username) {
//        Optional<User> result = userRepository.findById(username);
//        User userFound = null;
//        if(result.isPresent()){
//            userFound = result.get();
//        }else {
//            throw new RuntimeException("Cannot find user with id - " + id);
//        }
//        return userFound;
//    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

//    @Override
//    public void deleteById(int id) {
//        userRepository.deleteById(id);
//    }
}
