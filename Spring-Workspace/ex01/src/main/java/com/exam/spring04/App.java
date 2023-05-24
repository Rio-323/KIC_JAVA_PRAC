package com.exam.spring04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/exam/spring04/context.xml");
		
		// HelloBean1 helloBean1 = (HelloBean1)ctx.getBean("helloBean1");
		// 다형성에 입각한 호출
		Hello hello = (Hello)ctx.getBean("helloBean1");
		hello.sayHello("홍길동");
		
		ctx.close();
	}

}
