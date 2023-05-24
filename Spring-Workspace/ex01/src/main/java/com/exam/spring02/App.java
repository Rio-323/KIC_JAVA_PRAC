package com.exam.spring02;

public class App {

	public static void main(String[] args) {
		// HelloBean1 helloBean1 = new HelloBean1();
		
		// 다형성
		Hello hello = new HelloBean1();
		hello.sayHello("홍길동");
		
		System.out.println(hello);
		
		hello = new HelloBean2();
		hello.sayHello("박문수");
		
		System.out.println(hello);
		
	}
}
