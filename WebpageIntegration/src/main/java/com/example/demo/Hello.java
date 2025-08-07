package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class Hello {
	@GetMapping("/greet")
	// for passing text here to html page we use model
	public String func(Model m ) {
		m.addAttribute("message", "Hello Bro i Am from Hello.java Now in Html page....");
		return "index";
	}
	
}
