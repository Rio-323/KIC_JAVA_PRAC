package com.example.boottemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controller"})
public class BootTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootTemplateApplication.class, args);
	}

}
