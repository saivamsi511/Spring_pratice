package com.example.demo;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class CookieController {
	
	private final SecretKey keyrayidi =Keys.hmacShaKeyFor("Saivamsiisverygoodboyandhiswifeisalsogood11234243497834824".getBytes());
	
	@GetMapping("/get")
	public String getcookie(@RequestParam("username") String username,@RequestParam("password") String password,HttpServletResponse response) {
		
		String token = gettoken(username, password);
		Cookie cookie = new Cookie("JwtToken", token);
		cookie.setHttpOnly(true);
		cookie.setSecure(false);
		cookie.setDomain("localhost");
		cookie.setMaxAge(3600);
		cookie.setPath("/");
		
		response.addCookie(cookie);
		
		//second method to add token
		response.addHeader("Cookie2",String.format("authToken=%s; HttpOnly; Path=/; Max-Age=3600;  SameSite=None;" ,token));
		
		return "Cookie added successfully check once in application of developertools of chrome";
	}
	
	public String gettoken(String username, String password) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(username);
		builder.claim("password",password);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date(System.currentTimeMillis() + 3600000));
		builder.signWith(keyrayidi);
		String token = builder.compact();
		return token;
	}
	
	@GetMapping("/display")
	public String getToken(HttpServletRequest req) {
		Cookie[] arr = req.getCookies();
		String token =  arr[0].getValue();
		return "This is your token " + token;
	}
	
	
}
