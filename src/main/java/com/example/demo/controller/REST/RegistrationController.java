package com.example.demo.controller.REST;

/*
 * REST Controller of registration form.
 * */

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    //creating userService bean
    @Autowired
    UserService userService;

    @PostMapping("/saveUser") // this POST method reacts to post type from $.ajax
    public void saveUser(@RequestBody User user) {

        //saving user to database with save method from Service layer
        userService.save(user);
    }
}
