package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class Controller1 {
	
	@RequestMapping("/res1")
	@ResponseBody
	public String fun(@RequestParam("name") String name) {
		return "Hello" + name;
	}
}
