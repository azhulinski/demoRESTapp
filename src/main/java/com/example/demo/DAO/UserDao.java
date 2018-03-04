package com.example.demo.DAO;

/*
* Data Access Object interface
* */

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {



}
