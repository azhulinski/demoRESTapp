package com.example.demo.service;

/*
* Implementation of Service layer interface
* */

import com.example.demo.DAO.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    //creating userDAO bean
    @Autowired
    UserDao userDao;

    @Override
    public void save(User user) {

        userDao.save(user);

    } //method which takes User and save it in database using DAO layer

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    } //method which returns List of all Users in database using DAO layer

    @Override
    public User findUserById(int id) {
        return userDao.findOne(id);
    } //method which takes int number as 'id' and returns certain entity from database with this id

}
