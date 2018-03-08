package com.example.demo;

import com.example.demo.DAO.UserDao;
import com.example.demo.controller.REST.RegistrationController;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(RegistrationController.class)
public class RestControllerRegisterUserTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserDao userDao;

    @Test
    public void RegistrationControllerTest() throws Exception {

        User userOne = User.builder()
                .id(1)
                .login("neo")
                .password("42")
                .firstName("Thomas")
                .lastName("Anderson")
                .build();

        when(userDao.save(any(User.class))).thenReturn(userOne);

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/saveUser")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(userOne))
        )
                .andExpect(status().isOk());


    }

}
