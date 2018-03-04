package com.example.demo.controller.REST;

/*
* REST controller for getting certain user by given id
* */

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchUserController {

    //creating userService bean
    @Autowired
    UserService userService;

    @GetMapping("/searchUser/{data}") //GET methods reacts to 'get' typ from $.ajax with 'data' which is id in input field
    public User search(@PathVariable("data") String request) {

        return userService.findUserById(Integer.parseInt(request)); //getting user with parsed number from request string
    }
}