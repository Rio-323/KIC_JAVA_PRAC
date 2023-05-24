package com.exam.spring04;

public class HelloBean2 implements Hello {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello" + name);

	}

}
