package com.exam.spring02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App4 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring02/context.xml");
		
		WriteAction writeAction1 = (WriteAction)ctx.getBean("writeAction");
		writeAction1.execute();
		
		WriteAction writeAction2 = (WriteAction)ctx.getBean("writeAction2");
		writeAction2.execute();
		
		ListAction listAction1 = (ListAction)ctx.getBean("listAction1");
		listAction1.execute();
		
		ListAction listAction2 = (ListAction)ctx.getBean("listAction2");
		listAction2.execute();
		
		ctx.close();
	}

}