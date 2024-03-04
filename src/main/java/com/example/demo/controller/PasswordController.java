package com.example.demo.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordController
{
	@RequestMapping("/forgot")
	public String openEmail()
	{
		return "forgot";
	}

	@PostMapping("/send-otp")
	public String sendOTP(@RequestParam("email")String email)
	{
		System.out.println("Email "+email);
		Random random = new Random(1000);
		int otp =random.nextInt(999999);
		System.out.println("OTP "+otp);
		return "varify";
	}
}
