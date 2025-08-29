package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

	@Autowired
	CookieRepo repo;
	
	
	public boolean isvalid(String token) {
		JwtTokenverify jwt = repo.findByValue(token);
		if (jwt != null) {
			JwtTokenverify user = repo.findByValue(jwt.getValue());
			if(user != null) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
}
