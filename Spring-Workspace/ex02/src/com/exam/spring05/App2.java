package com.exam.spring05;

import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;


public class App2 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring05/context.xml");
		
		BoardPropertiesTO to = (BoardPropertiesTO)ctx.getBean("configTO");
		
		System.out.println(to.getConfigs());
		
		ctx.close();
	}

}
