package com.exam.spring07;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App2 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring07/context.xml");
		
		// WriteAction writeAction1 = (WriteAction)ctx.getBean("writeAction1");
		// writeAction1.execute();
		
		WriteAction writeAction2 = (WriteAction)ctx.getBean("writeAction2");
		writeAction2.execute();
		
		ctx.close();
	}
}
