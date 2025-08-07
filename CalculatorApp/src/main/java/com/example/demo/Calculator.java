package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
	
	@Autowired
	private CalculatorService ref;
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@PostMapping("/calculate")
	public String Calci(@RequestParam("num1") double n1,@RequestParam("num2") double n2,@RequestParam("operation") String op ,Model m) {
		double result = 0;
		
		switch(op) {
			case "add": 
				result = ref.add(n1, n2);
				break;
			case "sub": 
				result = ref.sub(n1, n2);
				break;
			case "mul": 
				result = ref.mul(n1, n2);
				break;
			case "div": 
				if (n2 != 0) {
					result = ref.div(n1, n2);
				} else {
					m.addAttribute("error", "Division by Zero is not allowed");
					m.addAttribute("num1", n1);
					m.addAttribute("num2", n2);
					return "result";
				}
				break;
			default:
				m.addAttribute("error", "Invalid Operation");
				break;
		}
		m.addAttribute("num1", n1);
		m.addAttribute("num2", n2);
		m.addAttribute("operation", op);
		m.addAttribute("result", result);
		return "result";
	}
}
