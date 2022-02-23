package com.example.blogger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final PostService postService;

    public CommentService(PostService postService) {
        this.postService = postService;
    }
}
