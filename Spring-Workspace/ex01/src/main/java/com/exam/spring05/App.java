package com.exam.spring05;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring05/context.xml");
		
//		HelloBean1 helloBean1 = (HelloBean1)ctx.getBean("helloBean1");
//		helloBean1.sayHello("홍길동1 : " + helloBean1);
//		
//		HelloBean2 helloBean2 = (HelloBean2)ctx.getBean("helloBean2");
//		helloBean2.sayHello("박문수 : " + helloBean2);
//		
//		HelloBean1 helloBean3 = (HelloBean1)ctx.getBean("helloBean1");
//		helloBean3.sayHello("홍길동2 : " + helloBean3);
		
		HelloBean1 helloBean1 = (HelloBean1)ctx.getBean("helloBean1");
		helloBean1.sayHello("홍길동1 : " + helloBean1);
		
		HelloBean1 helloBean3 = (HelloBean1)ctx.getBean("helloBean1");
		helloBean3.sayHello("홍길동2 : " + helloBean3);
		
		ctx.close();
	}

}
