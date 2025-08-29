package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public interface LoginService {

	boolean validate(String username,String password);
}
