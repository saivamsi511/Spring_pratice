package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class Controller3 {
	
	@RequestMapping("/res3")
	public String fun(HttpServletRequest req) {
		String res = (String) req.getAttribute("checked");
		
		if ("TRUE".equals(res)) {
			return "Hello2";
		} else {
			return "HACKER....BE CAREFUL";
		}
	}
}