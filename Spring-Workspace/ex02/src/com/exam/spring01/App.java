package com.exam.spring01;

import org.springframework.context.support.GenericXmlApplicationContext;



public class App {

	public static void main(String[] args) {
		System.out.println("Hello Maven");
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring01/context.xml");
		HelloBean helloBean = (HelloBean)ctx.getBean("helloBean");
		
		helloBean.sayHello("홍길동");
		
		
		ctx.close();
	}

}
