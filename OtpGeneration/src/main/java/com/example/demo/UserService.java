package com.example.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	MailSender mail;
	
	@Autowired
	OtpRepository repo1;
	
	AppUser getUser(AppUser user) {
		return repo.save(user);
	}
	
	
	public boolean loginuser(String username, String password) {
		AppUser user = repo.findByUsername(username);
	
		if (user != null) {
			if (user.password.equals(password)) {
				int otp = new Random().nextInt(100000,999999);
				
				Otpclass otpobj = new Otpclass(String.valueOf(otp), user.getId());
				repo1.save(otpobj);
				
				SimpleMailMessage msg = new SimpleMailMessage();
				msg.setTo(user.getEmail());
				msg.setSubject("Otp vachindi chudu ra niku.....");
				msg.setText("Otp code: " + otp);
				mail.send(msg);
				return true;
			}
			return false;
		}
		return false;
	}
	
	boolean verify(String otp) {
		Otpclass otpobj = repo1.findByOtp(otp);
		if (otpobj != null) {
			AppUser user = repo.findById(otpobj.getUserid()).orElse(null);
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
