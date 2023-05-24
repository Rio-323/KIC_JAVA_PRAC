package com.exam.spring06;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring06/context.xml");
		
		HelloBean helloBean1 = (HelloBean)ctx.getBean("helloBean1");
		helloBean1.sayHello();
		
		HelloBean helloBean2 = (HelloBean)ctx.getBean("helloBean2");
		helloBean2.sayHello();
		
		HelloBean helloBean3 = (HelloBean)ctx.getBean("helloBean3");
		helloBean3.sayHello();
		
		ctx.close();
	}

}
