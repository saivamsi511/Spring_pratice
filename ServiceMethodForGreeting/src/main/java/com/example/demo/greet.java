package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class greet {
	
	
	public String greett(String name) {
		return "Hello " + name;
	}
}
