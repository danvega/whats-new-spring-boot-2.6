package com.example.blogger;

import com.example.blogger.model.AuthorProperties;
import com.example.blogger.service.CommentService;
import com.example.blogger.service.PostService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.SanitizableData;
import org.springframework.boot.actuate.endpoint.SanitizingFunction;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.server.CookieSameSiteSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.CommandLinePropertySource;
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

    @Bean
    public CookieSameSiteSupplier cookieSameSiteSupplier() {
        return CookieSameSiteSupplier.ofStrict().whenHasName("mycookie");
    }

    @Bean
    public SanitizingFunction sanitizingFunction() {
        return data -> {
            return data.getPropertySource().getName().equals(CommandLinePropertySource.COMMAND_LINE_PROPERTY_SOURCE_NAME)
                    ? data.withValue("this is top secret!") : data;
        };
    }
}
