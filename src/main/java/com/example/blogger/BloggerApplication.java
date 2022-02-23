package com.example.blogger;

import com.example.blogger.model.AuthorProperties;
import com.example.blogger.service.CommentService;
import com.example.blogger.service.PostService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.metrics.ApplicationStartup;

@SpringBootApplication
@EnableConfigurationProperties(AuthorProperties.class)
public class BloggerApplication {

    public static void main(String[] args) {
        //SpringApplication.run(BloggerApplication.class, args);
        SpringApplication springApplication = new SpringApplication(BloggerApplication.class);
        springApplication.setApplicationStartup(new BufferingApplicationStartup(10000));
        springApplication.run(args);
    }

}
