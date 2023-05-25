package com.exam.spring01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.spring01.model.Hello;
import com.exam.spring01.model.HelloBean1;
import com.exam.spring01.model.HelloBean2;
import com.exam.spring02.config.BeanConfig;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		HelloBean1 helloBean1 = (HelloBean1)ctx.getBean("helloBean1");
		helloBean1.sayHello("홍길동");
		
		Hello hello = (Hello)ctx.getBean("helloBean1");
		hello.sayHello("홍길동");
		
		HelloBean2 helloBean2 = (HelloBean2)ctx.getBean("helloBean");
		helloBean2.sayHello("박문수");
		
		Hello hello2 = (Hello)ctx.getBean("hello1");
		hello2.sayHello("이몽룡");
		
		hello2 = (Hello)ctx.getBean("hello2");
		hello2.sayHello("세종대왕");
		
		ctx.close();
	}

}
