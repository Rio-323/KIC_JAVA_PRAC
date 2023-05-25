package com.exam.spring03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App1 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring03/context.xml");
		
		BoardTO to1 = (BoardTO)ctx.getBean("to1");
		System.out.println(to1.getSeq());
		System.out.println(to1.getSubject());
		
		BoardTO to2 = (BoardTO)ctx.getBean("to2");
		System.out.println(to2.getSeq());
		System.out.println(to2.getSubject());
		
		ctx.close();
	}

}