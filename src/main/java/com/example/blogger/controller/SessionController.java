package com.example.blogger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.Instant;

@Controller
public class SessionController {

    private static final String NAME = "myattribute";

    @GetMapping("/home")
    @ResponseBody
    public String set(HttpSession session, HttpServletResponse response) {
        String value = (String) session.getAttribute(NAME);
        if( value == null) {
            value = String.valueOf(Instant.now());
            session.setAttribute(NAME, value);
        }
        response.addCookie(new Cookie("mycookie", value));
        return value;
    }

}
