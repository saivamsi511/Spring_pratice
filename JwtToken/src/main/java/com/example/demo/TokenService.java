package com.example.demo;

import java.util.Date;
//import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {

	SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	public String getKey(String username, String password) {
		
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(username);
		builder.claim("password", password);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date(System.currentTimeMillis() + 3600000));
		builder.signWith(key);
		String token = builder.compact();
		return token;
	}

	
}
