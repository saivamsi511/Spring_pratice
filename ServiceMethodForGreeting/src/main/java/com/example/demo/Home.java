package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
	
	private greet ref;
	
	public Home(greet ref) {
		super();
		this.ref = ref;
	}

	@GetMapping("/index")
	public String login() {
		return "index";
	}
	
	@GetMapping("/greet")
	public String greet(@RequestParam("un") String name, Model m) {
		String message = ref.greett(name);
		m.addAttribute("message", message);
		return "greeting";
	}
}
