package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/greet")
    public String hello() {
        return "Hello World";
    }
    
    @GetMapping("/welcome")
    public String greet() {
        return "Heeloo man welome to my website";
    }
}
