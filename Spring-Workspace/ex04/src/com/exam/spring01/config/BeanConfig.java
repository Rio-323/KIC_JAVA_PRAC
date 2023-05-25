package com.exam.spring01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.exam.spring01.model.Hello;
import com.exam.spring01.model.HelloBean1;
import com.exam.spring01.model.HelloBean2;

@Configuration
public class BeanConfig {
	
	@Bean
	@Scope("prototype")
	public HelloBean1 helloBean1() {
		System.out.println("helloBean1() 호출");
		return new HelloBean1();
	}
	
	@Bean("helloBean")
	@Scope("prototype")
	public HelloBean2 helloBean2() {
		System.out.println("helloBean2() 호출");
		return new HelloBean2();
	}
	
	@Bean
	public Hello hello1() {
		return new HelloBean1();
	}
	
	@Bean
	public Hello hello2() {
		return new HelloBean2();
	}
}
