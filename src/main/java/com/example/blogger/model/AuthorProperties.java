package com.example.blogger.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("blogger.author")
@ConstructorBinding
public record AuthorProperties(String firstName, String lastName, String email) {

}
