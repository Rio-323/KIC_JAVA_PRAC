package com.example.ex01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex01Application implements CommandLineRunner {

	// window application
	public static void main(String[] args) {
		SpringApplication.run(Ex01Application.class, args);
		
		System.out.println("Hello Spring Boot 1");
	}

	// 시작점
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Spring Boot 2");
		
		for(String arg : args) {
			System.out.println("arg : " + arg);
		}
	}

}
