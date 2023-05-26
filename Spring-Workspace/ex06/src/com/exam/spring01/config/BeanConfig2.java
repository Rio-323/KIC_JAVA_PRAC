package com.exam.spring01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.exam.spring01.model.HelloBean2;

@Configuration
@Scope("prototype")
public class BeanConfig2 {
	
	@Bean
	public HelloBean2 helloBean2() {
		return new HelloBean2();
	}
}
