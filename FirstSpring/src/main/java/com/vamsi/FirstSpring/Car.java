package com.vamsi.FirstSpring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // makes this executes
public class Car implements Vehicle {

	public void drive() {
		System.out.println("Car is Driving by Student..");
	}

}
