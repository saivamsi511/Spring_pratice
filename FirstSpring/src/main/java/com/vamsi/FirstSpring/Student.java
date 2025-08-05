package com.vamsi.FirstSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Autowired // - This is a field injection
	private Vehicle ref;
	void greet() {
		System.out.println("Welcome STudent..");
	}
	void drivebike() {
		ref.drive();
	}
	
	// This is using constructor field
	public Student(Vehicle ref) {
		this.ref =ref;
	}

//	@Autowired
	// This is a setter injection
//	public void setref(Bike ref) {
//		this.ref = ref;
//	}
}
