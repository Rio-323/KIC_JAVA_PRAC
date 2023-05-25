package com.exam.spring01.model;

public class HelloBean2 implements Hello{
	public HelloBean2() {
		System.out.println("HelloBean2() 호출");
	}

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}
}
