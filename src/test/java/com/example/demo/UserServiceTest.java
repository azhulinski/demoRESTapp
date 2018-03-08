package com.example.demo;

import com.example.demo.DAO.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestConfiguration {
        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }


    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @Test
    public void userDaoTest() {

        User user = userDao.save(new User(1, "neo", "42", "Thomas", "Anderson"));
        User found = userDao.findOne(user.getId());

        assertNotNull(found);
        assertEquals(user.getLogin(), found.getLogin());
        assertEquals(user.getFirstName(), found.getFirstName());
        assertEquals(user.getLastName(), found.getLastName());
        assertEquals(user.getId(), found.getId());
    }

    @Test
    public void userServiceTest() {
        User user = new User(1, "neo", "42", "Thomas", "Anderson");

        userDao.save(user);

        User found = userService.findUserById(user.getId());
        List<User> foundList = userService.findAll();
        assertNotNull(found);
        assertNotNull(foundList);

    }
}
