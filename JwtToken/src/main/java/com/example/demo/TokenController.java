package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TokenController {
	
	@Autowired
	TokenService token;
	
	@GetMapping("/gettoken")
	public String getToken(@RequestParam("username") String username, @RequestParam("password") String password) {
		
		String tokenn = token.getKey(username,password);
		return "Your Token is : " + tokenn;
	}
}
