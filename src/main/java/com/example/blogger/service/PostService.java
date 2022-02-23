package com.example.blogger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final CommentService commentService;

    public PostService(@Lazy CommentService commentService) {
        this.commentService = commentService;
    }

}
