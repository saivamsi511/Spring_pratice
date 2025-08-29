package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplementation  implements LoginService{

	LoginRepo loginRepo;
	
	public LoginServiceImplementation(LoginRepo loginRepo) {
		super();
		this.loginRepo = loginRepo;
	}

	@Override
	public boolean validate(String username, String password) {
		User user = loginRepo.findByUsername(username);
		if(user == null) {
			return false;
		}
		else {
			if(user.password.equals(password)) {
				return true;
			}
			return false;
		}
	}

}
