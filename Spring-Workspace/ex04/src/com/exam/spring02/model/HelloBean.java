package com.exam.spring02.model;

public class HelloBean {
	private String name;
	
	public HelloBean() {
		System.out.println("HelloBean() 호출");
		this.name = "홍길동";
	}
	
	public HelloBean(String name) {
		System.out.println("HelloBean(String name) 호출");
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println(name + " 님 안녕하세요.");
	}
}
