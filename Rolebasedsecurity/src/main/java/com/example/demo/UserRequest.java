package com.example.demo;

public class UserRequest {
	String name;
	String password;
	
	public UserRequest() {
		// TODO Auto-generated constructor stub
	}

	public UserRequest(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

