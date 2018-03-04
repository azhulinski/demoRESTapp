package com.example.demo.entity;

/*
* An entity class with Lombok library
*
* */

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    private String login;

    private String password;

    private String firstName;

    private String lastName;
}
