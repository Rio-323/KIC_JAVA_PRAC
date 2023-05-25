package com.exam.spring04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App4 {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring04/context.xml");
		
		BoardListTO listTO = (BoardListTO)ctx.getBean("mapTO");
		
		for(String value : listTO.getUserMaps().values()) {
			System.out.println(value);
		}
		
		ctx.close();
	}
}
