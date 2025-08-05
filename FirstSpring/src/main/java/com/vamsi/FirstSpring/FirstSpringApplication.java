package com.vamsi.FirstSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(FirstSpringApplication.class, args);
		Student s = ac.getBean(Student.class);
		s.greet();
		s.drivebike();
	}

}
