package com.example.demo.service;

/*
* Service layer interface with base methods
* */

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void save(User user); //save User method

    List<User> findAll(); //find all users method

    User findUserById(int id); //find one user by given id
}
