package com.exam.spring02;

import org.springframework.context.support.GenericXmlApplicationContext;


public class App2 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring02/context.xml");
		
		BoardTO to = (BoardTO)ctx.getBean("to");
		System.out.println(to.getSeq());
		System.out.println(to.getSubject());
		
		to.setSeq(2);
		to.setSubject("제목2");
		System.out.println(to.getSeq());
		System.out.println(to.getSubject());
		
		ctx.close();
	}

}
