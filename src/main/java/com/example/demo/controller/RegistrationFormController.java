package com.example.demo.controller;

/*
* nonREST controller of registration page*
* */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class RegistrationFormController {

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


}
