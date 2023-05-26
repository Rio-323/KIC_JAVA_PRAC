package com.exam.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.exam.spring.model.WriteAction;

public class App {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring/context.xml");
		
		WriteAction action = (WriteAction)ctx.getBean("action1");
		
		action.execute1();
		action.execute2();
		
		
		ctx.close();

	}

}
