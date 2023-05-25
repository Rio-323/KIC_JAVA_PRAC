package com.exam.spring02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.spring02.model.HelloBean;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(com.exam.spring02.config.BeanConfig.class);
		
		HelloBean helloBean = (HelloBean)ctx.getBean("helloBean2");
		helloBean.sayHello();
		
		ctx.close();
	}

}
