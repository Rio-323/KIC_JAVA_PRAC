package com.exam.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.exam.spring.model.WriteAction;

public class App {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring/context.xml");
		
		WriteAction action = (WriteAction)ctx.getBean("proxy");
		// 전처리
		action.execute();
		
		// 후처리
		
		ctx.close();
	}
	
}
