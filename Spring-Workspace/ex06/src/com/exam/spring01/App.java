package com.exam.spring01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.spring01.config.BeanConfig1;
import com.exam.spring01.config.BeanConfig2;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig1.class, BeanConfig2.class);
		
		
		
		ctx.close();

	}

}
