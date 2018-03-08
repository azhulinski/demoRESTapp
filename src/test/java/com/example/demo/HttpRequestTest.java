package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void defaultPageTest() {
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("index");
    }

    @Test
    public void registrationPageTest() {
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .contains("registration");
    }

}
