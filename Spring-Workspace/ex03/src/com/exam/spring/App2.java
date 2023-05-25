package com.exam.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.exam.spring.model2.Action;

public class App2 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring/context.xml");
		Action action = (Action)ctx.getBean("action");
		action.execute();
		
		ctx.close();
	}

}
