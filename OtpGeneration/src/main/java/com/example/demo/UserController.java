package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping("/")
	String home() {
		return "Registration";
	}
	
	@RequestMapping("/login")
	String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	String registerUser(@RequestParam("un") String username, @RequestParam("ue") String email,@RequestParam("up") String password , @RequestParam("ua") int age,@RequestParam("ul") String location) {
		AppUser user = new AppUser(username,email,password,age,location);
		AppUser saveduser = service.getUser(user);
		if(saveduser != null) {
			return "login";
		}
		return "Registration";
	}
	
	@RequestMapping("/loginuser")
	String loginUser(@RequestParam("user") String username,@RequestParam("password") String password) {
		boolean user = service.loginuser(username, password);
		if(user) {
			return "otp";
		} else {
			return "login";
		}
	}
	
	@RequestMapping("/verifyotp")
	String verify(@RequestParam("otp") String otp) {
		boolean user = service.verify(otp);
		if(user) {
			return "dashbord";
		} else {
			return "login";
		}
	}
}
