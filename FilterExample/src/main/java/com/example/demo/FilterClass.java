package com.example.demo;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/api")
@Component
public class FilterClass implements Filter {
	public FilterClass() {
		System.out.println("OUR FILTER IS READY TO ACCEPT REQUESTS");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
	IOException, ServletException {
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse res =(HttpServletResponse) response;
		if (!res.isCommitted()) {
			String requestUri = req.getRequestURI();
			if (requestUri.equals("/api/res1")) {
				System.out.println("Request Allowed without any checks");
				chain.doFilter(request, response);
			} else {
				System.out.println("Performing validation and passing the request.");
				req.setAttribute("checked", "TRUE");
				chain.doFilter(request, response);
			}
		}
	}
}