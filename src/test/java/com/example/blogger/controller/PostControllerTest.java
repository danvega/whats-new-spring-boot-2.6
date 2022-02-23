package com.example.blogger.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(PostController.class)
class PostControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void findAll() {
        webTestClient.get()
                .uri("/posts")
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("$.size", Matchers.is(3));
    }
}