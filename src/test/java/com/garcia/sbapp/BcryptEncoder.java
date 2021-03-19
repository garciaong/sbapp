package com.garcia.sbapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoder {

	public static void main(String [] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(String.format("Encoded password is %s", passwordEncoder.encode("pass123")));
	}
	
}
