package com.example.demo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class JwtTokenverify {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String username;
	@Column
	String value;
	@Column
	LocalDateTime currtime;
	
	public JwtTokenverify() {
		// TODO Auto-generated constructor stub
	}

	public JwtTokenverify(int id, String username, String value, LocalDateTime currtime) {
		super();
		this.id = id;
		this.username = username;
		this.value = value;
		this.currtime = currtime;
	}

	public JwtTokenverify(String username, String value, LocalDateTime currtime) {
		super();
		this.username = username;
		this.value = value;
		this.currtime = currtime;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public LocalDateTime getCurrtime() {
		return currtime;
	}

	public void setCurrtime(LocalDateTime currtime) {
		this.currtime = currtime;
	}

	
	
}
