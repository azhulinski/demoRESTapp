package com.example.demo;

import com.example.demo.controller.REST.ViewAllUsersController;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ViewAllUsersController.class)
public class RestControllerViewUsersTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void viewAllUsersTest() throws Exception {

        User userOne = User.builder()
                .id(1)
                .login("neo")
                .password("42")
                .firstName("Thomas")
                .lastName("Anderson")
                .build();

        User userTwo = User.builder()
                .id(2)
                .login("jedi")
                .password("last")
                .firstName("Luke")
                .lastName("Skywalker")
                .build();

        given(this.userService.findAll()).willReturn(Arrays.asList(userOne, userTwo));

        this.mockMvc.perform(get("/viewUsers").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].login", is("neo")))
                .andExpect(jsonPath("$[1].login", is("jedi")));

    }

}
