package com.vamsi.FirstSpring;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{
	public void drive() {
		System.out.println("Student is driving bike");
	}
}
