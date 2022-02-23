package com.example.blogger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @GetMapping("/posts")
    public List<String> findAll() {
        return List.of("Post 1", "Post 2", "Post 3");
    }

    @GetMapping("/posts/{lastName}/{firstName}")
    public void findPostByAuthor(@PathVariable String lastName, @PathVariable String firstName) {
        System.out.println("lastName: " + lastName + " firstName: " + firstName);
    }

}
