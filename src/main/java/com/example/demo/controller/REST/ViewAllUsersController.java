package com.example.demo.controller.REST;

/*
* REST Controller for getting data from database
* */

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewAllUsersController {

    //creating userService bean
    @Autowired
    UserService userService;

    @GetMapping("/viewUsers") //This GET methods reacts to 'get' type from $.ajax
    public List<User> viewAllUsers() {
        return userService.findAll(); //receiving List of all users from database
    }
}
