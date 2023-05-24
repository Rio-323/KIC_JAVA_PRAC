package com.exam.spring08;

import org.springframework.context.support.GenericXmlApplicationContext;


public class App {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring08/context.xml");
		
		ListAction listAction1 = (ListAction)ctx.getBean("listAction1");
		listAction1.execute();
		
		ctx.close();

	}

}
