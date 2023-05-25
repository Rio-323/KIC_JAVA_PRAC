package com.exam.spring03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.spring04.model.BoardTO;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(com.exam.spring03.config.BeanConfig.class);
		
		BoardTO to = (BoardTO)ctx.getBean("boardTO");
		System.out.println(to.getSeq());
		System.out.println(to.getSubject());
		
		ctx.close();

	}

}
