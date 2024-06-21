package com.sparta.jsonvoorhees.springapi.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sparta.jsonvoorhees.springapi.SpringapiApplication;
import com.sparta.jsonvoorhees.springapi.controller.MovieApiController;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
    classes = SpringapiApplication.class, 
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = "spring.main.lazy-initialization=true"
    )
public class MoviesControllerIT {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate("user", "password");

    HttpHeaders headers = new HttpHeaders();

    @Test
    @Disabled("Not yet working")
    public void GetAllMoviesReturns200(){
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/movies"),
                HttpMethod.GET, entity, String.class);
        assertEquals(200, response.getStatusCode());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
