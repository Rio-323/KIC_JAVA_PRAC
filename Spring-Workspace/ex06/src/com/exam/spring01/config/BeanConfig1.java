package com.exam.spring01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.exam.spring01.model.HelloBean1;

@Configuration
@Scope("prototype")
public class BeanConfig1 {
	
	@Bean
	public HelloBean1 helloBean1() {
		return new HelloBean1();
	}
}
