package com.example.blogger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping("/posts/{name}/{name}")
    public void findPostByAuthor(@PathVariable String name) {
        System.out.println("name: " + name);
    }

}
