package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String username;
	@Column
	String email;
	@Column
	String password;
	@Column
	int age;
	@Column
	String location;
	
	public AppUser() {
		// TODO Auto-generated constructor stub
	}

	public AppUser(int id, String username, String email, String password, int age, String location) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public AppUser(String username, String email, String password, int age, String location) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.location = location;
	}
}
