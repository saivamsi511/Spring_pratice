package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	UserRepository repo;

	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}
	
	public User findbyName(String name) {
		return repo.findByName(name);
	}
}
