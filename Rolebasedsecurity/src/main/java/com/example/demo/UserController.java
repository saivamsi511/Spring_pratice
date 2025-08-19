package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/getresource")
	String getmethod(@RequestBody UserRequest req) {
		String name = req.name;
		String pass = req.password;
		User user = service.findbyName(name);
		
		if(user != null) {
			if (user.name.equals(name) && user.password.equals(pass)) {
				if (user.role.equals("admin")) {
					return "admin";
				} else {
					return "user";
				}
			}
		}
		return "Invalid";
	}
}
