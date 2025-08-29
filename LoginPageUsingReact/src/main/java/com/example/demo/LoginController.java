package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoginController {

	LoginService loginService;

	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	@PostMapping("/login")
	public Map<String, String> userlogin(@RequestBody Map<String, String> data) {
		String username = data.get("username");
		String password = data.get("password");
		
		Map<String,String> response = new HashMap<>();
		boolean result = loginService.validate(username, password);
		
		if(result == false) {
			response.put("Error", "Invalid Username or Password");
		}
		else {
			response.put("Success", "Login suceessful Enjoy");
			response.put("username", username);
		}
		return response;
	}
}
