package com.example.my.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.my.model.UserDetail;

public interface UserRepo extends JpaRepository<UserDetail, Integer> {

    UserDetail findByEmail(String email);
    
}
