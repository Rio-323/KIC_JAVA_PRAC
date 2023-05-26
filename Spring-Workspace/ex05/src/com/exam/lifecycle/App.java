package com.exam.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.exam.lifecycle.model.WriteAction;

public class App {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/lifecycle/context.xml");
		WriteAction action = (WriteAction)ctx.getBean("action");
		action.execute();
		
		ctx.close();
	}
}
