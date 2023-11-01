package com.example.Authenticate.repository;

import com.example.Authenticate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
