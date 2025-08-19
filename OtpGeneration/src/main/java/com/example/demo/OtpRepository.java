package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OtpRepository extends JpaRepository<Otpclass, Integer>{
	Otpclass findByOtp(String otp);
}
