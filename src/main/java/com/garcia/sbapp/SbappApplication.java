package com.garcia.sbapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@ComponentScan(basePackages = "com.garcia.sbapp")
public class SbappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbappApplication.class, args);
	}
}
